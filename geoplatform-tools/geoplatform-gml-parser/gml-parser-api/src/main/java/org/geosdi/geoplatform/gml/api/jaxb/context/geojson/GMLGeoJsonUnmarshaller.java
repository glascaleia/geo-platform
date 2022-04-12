/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2022 geoSDI Group (CNR IMAA - Potenza - ITALY).
 * <p>
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see http://www.gnu.org/licenses/
 * <p>
 * ====================================================================
 * <p>
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole combination.
 * <p>
 * As a special exception, the copyright holders of this library give you permission
 * to link this library with independent modules to produce an executable, regardless
 * of the license terms of these independent modules, and to copy and distribute
 * the resulting executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the license of
 * that module. An independent module is a module which is not derived from or
 * based on this library. If you modify this library, you may extend this exception
 * to your version of the library, but you are not obligated to do so. If you do not
 * wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.gml.api.jaxb.context.geojson;

import org.geojson.GeoJsonObject;
import org.geosdi.geoplatform.gml.api.AbstractGeometry;
import org.geosdi.geoplatform.gml.api.PropertyType;
import org.geosdi.geoplatform.gml.api.parser.base.geometry.sextante.GMLBaseSextanteParser;
import org.geosdi.geoplatform.gml.api.parser.base.parameter.GMLBaseParametersRepo;
import org.geosdi.geoplatform.gml.api.parser.exception.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class GMLGeoJsonUnmarshaller implements IGMLGeoJsonUnmarshaller {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected GMLBaseSextanteParser sextanteParser = GMLBaseParametersRepo.getDefaultSextanteParser();

    /**
     * @param element
     * @return {@link GeoJsonObject}
     * @throws ParserException
     */
    protected GeoJsonObject parseElementAsGeoJson(Object element) throws ParserException {
        Object value = JAXBIntrospector.getValue(element);
        if (value instanceof PropertyType) {
            logger.trace("############Called parseElementAsGeoJson#PropertyType\n.");
            return sextanteParser.parseGeometryAsGeoJson((PropertyType) value);
        } else if (value instanceof AbstractGeometry) {
            logger.debug("############Called parseElementAsGeoJson#AbstractGeometry\n.");
            return sextanteParser.parseGeometryAsGeoJson((AbstractGeometry) value);
        }
        throw new ParserException("The Object must be an instance of PropertyType or AbstractGeometry Class.");
    }

    /**
     * @param element
     * @param type
     * @param <G>
     * @return {@link JAXBElement<G>}
     * @throws ParserException
     */
    protected <G extends GeoJsonObject> JAXBElement<G> parseElementAsGeoJson(Object element, Class<G> type) throws ParserException {
        checkNotNull(element, "The Object Element must not be null.");
        if (element instanceof JAXBElement) {
            GeoJsonObject geom = parseElementAsGeoJson(element);
            if (type.isAssignableFrom(geom.getClass())) {
                G value = (G) geom;
                return new JAXBElement(((JAXBElement<?>) element).getName(), type, value);
            } else {
                throw new ParserException("GeoJson Geometry class " + geom.getClass().getName() + " not match " + type.getName());
            }
        } else {
            throw new ParserException("The Object element is not an instance of JAXBElement class");
        }
    }
}