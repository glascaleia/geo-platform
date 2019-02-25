package org.geosdi.geoplatform.connector.reader.stax;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geosdi.geoplatform.connector.parser.GPWMSGml2GeoJsonParser;
import org.geosdi.geoplatform.connector.parser.WMSGml2GeoJsonParser;
import org.geosdi.geoplatform.connector.reader.featuretype.GPWMSFeatureType;
import org.geosdi.geoplatform.connector.reader.featuretype.GPWMSFeatureTypeReader;
import org.geosdi.geoplatform.connector.reader.featuretype.WMSFeatureType;
import org.geosdi.geoplatform.stax.reader.AbstractStaxStreamReader;

import javax.annotation.Nonnull;
import javax.xml.stream.events.XMLEvent;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.ThreadLocal.withInitial;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.function.Function.identity;
import static java.util.regex.Pattern.compile;
import static java.util.stream.Collectors.toMap;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class WMSGetFeatureInfoStaxReader extends AbstractStaxStreamReader<FeatureCollection> {

    private static final String SCHEMA_LOCATION_KEY = "schemaLocation";
    public static final String TYPE_NAME_KEY = "typeName=";
    private static final String TYPES_NAME_SEPARATOR = ",";
    private static final String TYPE_NAME_SEPARATOR = ":";
    private static final GPWMSGml2GeoJsonParser GML2_GEO_JSON_PARSER = new WMSGml2GeoJsonParser();
    private static final GPWMSFeatureTypeReader featureTypeReader = new GPWMSFeatureTypeReader() {

        /**
         *
         * @param value
         * @return {@link Map<String, GPWMSFeatureType>}
         * @throws Exception
         */
        @Override
        public Map<String, GPWMSFeatureType> read(@Nonnull(when = NEVER) String value) throws Exception {
            checkArgument((value != null) && !(value.trim().isEmpty()), "The Parameter value must not be null or an empty string.");
            return compile(TYPES_NAME_SEPARATOR).splitAsStream(value)
                    .map(v -> v.split(TYPE_NAME_SEPARATOR))
                    .filter(values -> ((values[0] != null) && !(values[0].trim().isEmpty()) && (values[1] != null) && !(values[1].trim().isEmpty())))
                    .map(values -> new WMSFeatureType(values[0], values[1]))
                    .collect(toMap(k -> k.getName(), identity(), (oldVal, newVal) -> oldVal));
        }
    };
    //
    private final ThreadLocal<Map<String, GPWMSFeatureType>> typeNames = withInitial(() -> null);

    /**
     * @throws Exception
     */
    protected void loadTypeNames() throws Exception {
        String schemaLocation = xmlStreamReader().getAttributeValue(null, SCHEMA_LOCATION_KEY);
        if ((schemaLocation != null) && !(schemaLocation.trim().isEmpty())) {
            schemaLocation = URLDecoder.decode(schemaLocation, UTF_8.name());
            int index = schemaLocation.indexOf(TYPE_NAME_KEY);
            if (index != -1) {
                String typeName = schemaLocation.substring(index + TYPE_NAME_KEY.length());
                index = typeName.indexOf(" ");
                if (index != -1) {
                    typeName = typeName.substring(0, index);
                    this.typeNames.set(featureTypeReader.read(typeName));
                } else {
                    this.typeNames.set(featureTypeReader.read(typeName));
                }
                logger.debug("########################TYPES_NAME : {}", this.typeNames.get());
            }
        }
    }

    /**
     * @throws Exception
     */
    protected void readFeatures(Feature feature) throws Exception {
        int eventType = xmlStreamReader().nextTag();
        if (eventType == XMLEvent.START_ELEMENT) {
            logger.debug("################TRYING TO READ XML.");
            Map<String, GPWMSFeatureType> featureTypes = this.typeNames.get();
            checkArgument((featureTypes != null) && !(featureTypes.isEmpty()), "Impossible Read XML featureTypes is null or empty.");
            readFeatureID(featureTypes, feature);
            super.goToEndTag("featureMember");
        }
    }

    /**
     * @throws Exception
     */
    void readFeatureID(Map<String, GPWMSFeatureType> featureTypes, Feature feature) throws Exception {
        if (super.isTagName("gml", "featureMember")) {
            xmlStreamReader().nextTag();
        }
        String prefix = xmlStreamReader().getPrefix();
        String name = xmlStreamReader().getLocalName();
        logger.trace("##############################PREFIX : {} - NAME : {}\n", prefix, name);
        GPWMSFeatureType featureType = featureTypes.get(name);
        if ((featureType != null) && (super.isTagName(prefix, name))) {
            String featureID = xmlStreamReader().getAttributeValue(null, "fid");
            feature.setId(featureID);
            logger.trace("#####################FEATURE_ID : {}", featureID);
            readInternal(featureType, feature);
        }
    }

    /**
     * @param featureType
     * @throws Exception
     */
    void readInternal(GPWMSFeatureType featureType, Feature feature) throws Exception {
        logger.trace("#######################TRY TO READ ATTRIBUTES OF : {}\n", featureType.getName());
        Map<String, Object> featureProperties = new LinkedHashMap<>();
        int eventType = xmlStreamReader().nextTag();
        while (xmlStreamReader().hasNext()) {
            if (eventType == XMLEvent.END_ELEMENT) {
                String localName = xmlStreamReader().getLocalName();
                if (localName.equals(featureType.getName())) {
                    break;
                }
            } else if (eventType == XMLEvent.START_ELEMENT) {
                String localName = xmlStreamReader().getLocalName();
                if ((featureType != null) && (super.isTagPrefix(featureType.getPrefix()))) {
                    eventType = xmlStreamReader().next();
                    if ((eventType == XMLEvent.CHARACTERS) && !(localName.equalsIgnoreCase("the_geom"))) {
                        String attributeValue = xmlStreamReader().getText();
                        featureProperties.put(localName, attributeValue);
                        logger.trace("##########################ATTRIBUTE_NAME : {} - ATTRIBUTE_VALUE : {}\n", localName, attributeValue);
                    } else if (eventType == XMLEvent.END_ELEMENT) {
                        featureProperties.put(localName, null);
                    } else if (super.isTagPrefix("gml")) {
                        this.readGeometry(feature);
                    }
                } else if (super.isTagPrefix("gml")) {
                    this.readGeometry(feature);
                }
            }
            eventType = xmlStreamReader().next();
        }
        feature.setProperties(featureProperties);
    }

    /**
     * @param feature
     * @throws Exception
     */
    void readGeometry(Feature feature) throws Exception {
        String localName = xmlStreamReader().getLocalName();
        logger.trace("@@@@@@@@@@@@@@@@@@@@FOUND GEOMETRY : {}\n", localName);
        feature.setGeometry(GML2_GEO_JSON_PARSER.parse(xmlStreamReader()));
    }
}