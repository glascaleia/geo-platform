/*
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2025 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.connector.jackson;

import org.geosdi.geoplatform.connector.geoserver.model.settings.GPGeoserverGlobalSettings;
import org.geosdi.geoplatform.connector.geoserver.model.settings.service.version.GPGeoserverGeotoolsVersion;
import org.geosdi.geoplatform.connector.geoserver.model.settings.service.wms.GPGeoserverWMSWatermark;
import org.geosdi.geoplatform.connector.geoserver.model.settings.service.wms.GeoserverWMSWatermark;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.StringReader;

import static java.io.File.separator;
import static java.lang.Boolean.TRUE;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;
import static org.geosdi.geoplatform.connector.geoserver.model.settings.service.wms.WatermarkPosition.BOT_LEFT;
import static org.geosdi.geoplatform.connector.geoserver.styles.sld.GeoserverStyleSLDV100Request.JACKSON_JAXB_XML_SUPPORT;
import static org.geosdi.geoplatform.connector.jackson.GPGeoserverJacksonTest.jacksonSupport;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class GPGeoserverSettingsJacksonTest {

    private static final Logger logger = LoggerFactory.getLogger(GPGeoserverSettingsJacksonTest.class);

    @Test
    public void a_unmarshallGPGeoserverGlobalSettingsTest() throws Exception {
        GPGeoserverGlobalSettings geoserverGlobalSettings = jacksonSupport.getDefaultMapper()
                .readValue(new StringReader("{  \n" +
                        "   \"global\":{  \n" +
                        "      \"settings\":{  \n" +
                        "         \"id\":\"SettingsInfoImpl-68f6c583:154ca420c47:-8000\",\n" +
                        "         \"contact\":{  \n" +
                        "            \"addressCity\":\"Alexandria\",\n" +
                        "            \"addressCountry\":\"Egypt\",\n" +
                        "            \"addressType\":\"Work\",\n" +
                        "            \"contactEmail\":\"claudius.ptolomaeus@gmail.com\",\n" +
                        "            \"contactOrganization\":\"The Ancient Geographers\",\n" +
                        "            \"contactPerson\":\"Claudius Ptolomaeus\",\n" +
                        "            \"contactPosition\":\"Chief Geographer\"\n" +
                        "         },\n" +
                        "         \"charset\":\"UTF-8\",\n" +
                        "         \"numDecimals\":8,\n" +
                        "         \"onlineResource\":\"http://geoserver.org\",\n" +
                        "         \"verbose\":false,\n" +
                        "         \"verboseExceptions\":false,\n" +
                        "         \"localWorkspaceIncludesPrefix\":false\n" +
                        "      },\n" +
                        "      \"jai\":{  \n" +
                        "         \"allowInterpolation\":false,\n" +
                        "         \"recycling\":false,\n" +
                        "         \"tilePriority\":5,\n" +
                        "         \"tileThreads\":7,\n" +
                        "         \"memoryCapacity\":0.5,\n" +
                        "         \"memoryThreshold\":0.75,\n" +
                        "         \"imageIOCache\":false,\n" +
                        "         \"pngAcceleration\":true,\n" +
                        "         \"jpegAcceleration\":true,\n" +
                        "         \"allowNativeMosaic\":false,\n" +
                        "         \"allowNativeWarp\":false\n" +
                        "      },\n" +
                        "      \"coverageAccess\":{  \n" +
                        "         \"maxPoolSize\":10,\n" +
                        "         \"corePoolSize\":5,\n" +
                        "         \"keepAliveTime\":30000,\n" +
                        "         \"queueType\":\"UNBOUNDED\",\n" +
                        "         \"imageIOCacheThreshold\":10240\n" +
                        "      },\n" +
                        "      \"updateSequence\":180,\n" +
                        "      \"featureTypeCacheSize\":0,\n" +
                        "      \"globalServices\":true,\n" +
                        "      \"xmlPostRequestLogBufferSize\":1024\n" +
                        "   }\n" +
                        "}"), GPGeoserverGlobalSettings.class);
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@GEOSERVER_GLOBAL_SETTINGS : {}\n", geoserverGlobalSettings);
    }

    @Test
    public void b_unmarshallGeoserverGlobalSettingsFromFileTest() throws Exception {
        GPGeoserverGlobalSettings geoserverGlobalSettings = jacksonSupport.getDefaultMapper()
                .readValue(new File(of(new File(".").getCanonicalPath(), "src", "test", "resources",
                        "GeoserverGlobalSettings.json")
                        .collect(joining(separator, "", separator))), GPGeoserverGlobalSettings.class);
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@GEOSERVER_GLOBAL_SETTINGS : {}\n", geoserverGlobalSettings);
    }

    @Test
    public void c_unmarshallGeoserverGeotoolsVersionFromXmlStringTest() throws Exception {
        GPGeoserverGeotoolsVersion geotoolsVersion = JACKSON_JAXB_XML_SUPPORT.getDefaultMapper().readValue(new StringReader("<versions>\n"
                + "    <org.geotools.util.Version>\n"
                + "      <version>1.1.1</version>\n"
                + "    </org.geotools.util.Version>\n"
                + "    <org.geotools.util.Version>\n"
                + "      <version>1.3.0</version>\n"
                + "    </org.geotools.util.Version>\n"
                + "  </versions>"), GPGeoserverGeotoolsVersion.class);
        logger.info("#######################GP_GEOSERVER_GEOTOOLS_VERSION : {}\n", geotoolsVersion);
        logger.info("\n{}\n", jacksonSupport.getDefaultMapper().writeValueAsString(geotoolsVersion));
    }

    @Test
    public void d_unmarshallGeoserverGeotoolsVersionFromJsonStringTest() throws Exception {
        GPGeoserverGeotoolsVersion geotoolsVersion = jacksonSupport.getDefaultMapper().readValue(new StringReader("{\n" +
                "" + "  \"versions\" : {\n"
                + "    \"org.geotools.util.Version\" : [ {\n"
                + "      \"version\" : \"1.1.1\"\n"
                + "    }, {\n"
                + "      \"version\" : \"1.3.0\"\n"
                + "    } ]\n"
                + "  }\n"
                + "}"), GPGeoserverGeotoolsVersion.class);
        logger.info("#######################GP_GEOSERVER_GEOTOOLS_VERSION : {}\n", geotoolsVersion);
    }

    @Test
    public void e_unmarshallGeoserverWMSWatermarkFromXmlStringTest() throws Exception {
        GPGeoserverWMSWatermark watermark = JACKSON_JAXB_XML_SUPPORT.getDefaultMapper()
                .readValue(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                        + "<watermark>\n"
                        + "   <enabled>false</enabled>\n"
                        + "   <position>BOT_RIGHT</position>\n"
                        + "   <transparency>100</transparency>\n"
                        + "</watermark>"), GPGeoserverWMSWatermark.class);
        logger.info("@@@@@@@@@@@@@@@@@@@GP_GEOSERVER_WMS_WATERMARK : {}\n", watermark);
    }

    @Test
    public void f_unmarshallGeoserverWMSWatermarkFromJsonStringTest() throws Exception {
        GeoserverWMSWatermark watermark = jacksonSupport.getDefaultMapper().readValue(new StringReader("{\n"
                + "  \"watermark\" : {\n"
                + "    \"enabled\" : false,\n"
                + "    \"position\" : \"MID_CENTER\",\n"
                + "    \"transparency\" : 100\n"
                + "  }\n"
                + "}"), GeoserverWMSWatermark.class);
        logger.info("@@@@@@@@@@@@@@@@@@@GP_GEOSERVER_WMS_WATERMARK : {}\n", watermark);
    }

    /**
     * @return {@link GeoserverWMSWatermark}
     */
    public static GeoserverWMSWatermark toWMSWatermark() {
        GeoserverWMSWatermark wmsWatermark = new GPGeoserverWMSWatermark();
        wmsWatermark.setEnabled(TRUE);
        wmsWatermark.setPosition(BOT_LEFT);
        wmsWatermark.setTransparency(100);
        return wmsWatermark;
    }
}