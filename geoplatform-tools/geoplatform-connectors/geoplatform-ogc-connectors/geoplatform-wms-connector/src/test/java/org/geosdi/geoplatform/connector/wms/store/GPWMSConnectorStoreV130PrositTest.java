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
package org.geosdi.geoplatform.connector.wms.store;

import org.geosdi.geoplatform.connector.server.request.GPWMSBoundingBox;
import org.geosdi.geoplatform.connector.server.request.GPWMSGetMapBaseRequest;
import org.geosdi.geoplatform.connector.server.request.WMSBoundingBox;
import org.geosdi.geoplatform.connector.server.request.WMSGetMapBaseRequest;
import org.geosdi.geoplatform.connector.server.v130.GPWMSGetFeatureInfoV130Request;
import org.geosdi.geoplatform.connector.server.v130.IGPWMSConnectorStoreV130;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;
import static org.geosdi.geoplatform.connector.server.config.GPPooledConnectorConfigBuilder.PooledConnectorConfigBuilder.pooledConnectorConfigBuilder;
import static org.geosdi.geoplatform.connector.server.request.WMSFeatureInfoFormat.GML2;
import static org.geosdi.geoplatform.connector.server.request.WMSFeatureInfoFormat.GML3;
import static org.geosdi.geoplatform.connector.server.store.GPWMSConnectorBuilder.WMSConnectorBuilder.wmsConnectorBuilder;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class GPWMSConnectorStoreV130PrositTest {

    private static final Logger logger = LoggerFactory.getLogger(GPWMSConnectorStoreV130PrositTest.class);
    //
    private static IGPWMSConnectorStoreV130 wmsServerConnector;

    @BeforeClass
    public static void beforeClass() throws Exception {
        wmsServerConnector = wmsConnectorBuilder()
                .wmsConnectorBuilderV130()
                .withServerUrl(new URI("https://prosit.geosdi.org/geoserver/wms").toURL())
                .withPooledConnectorConfig(pooledConnectorConfigBuilder()
                        .withMaxTotalConnections(20)
                        .withDefaultMaxPerRoute(8)
                        .withMaxRedirect(5)
                        .build())
                .build();
    }

    @Test
    public void a_wmsGetFeatureInfoV130Test() throws Exception {
        GPWMSGetFeatureInfoV130Request<Object> wmsGetFeatureInfoRequest = wmsServerConnector.createGetFeatureInfoRequest();
        GPWMSBoundingBox wmsBoundinBox = new WMSBoundingBox(40.97210836426291, 15.824662897187245, 40.98109151703362, 15.836561468047133);
        GPWMSGetMapBaseRequest wmsGetMapBaseRequest = new WMSGetMapBaseRequest(wmsBoundinBox, of("admin:admin_shp_vigneti_catastali", "admin:admin_shp_oliveti_catastali").collect(toSet()),
                "EPSG:4326", "256", "256");
        logger.info("##################################WMS_GET_FEATURE_INFO_V111_RESPONSE : {}\n", wmsGetFeatureInfoRequest.withQueryLayers("admin:admin_shp_vigneti_catastali", "admin:admin_shp_oliveti_catastali")
                .withWMSGetMapRequest(wmsGetMapBaseRequest)
                .withFeatureCount(8)
                .withInfoFormat(GML2).withX(154).withY(230).getResponse());
    }

    @Test
    public void b_wmsGetFeatureInfoV130Test() throws Exception {
        GPWMSGetFeatureInfoV130Request<Object> wmsGetFeatureInfoRequest = wmsServerConnector.createGetFeatureInfoRequest();
        GPWMSBoundingBox wmsBoundinBox = new WMSBoundingBox(40.97210836426291, 15.824662897187245, 40.98109151703362, 15.836561468047133);
        GPWMSGetMapBaseRequest wmsGetMapBaseRequest = new WMSGetMapBaseRequest(wmsBoundinBox, of("admin:admin_shp_vigneti_catastali", "admin:admin_shp_oliveti_catastali").collect(toSet()),
                "EPSG:4326", "256", "256");
        logger.info("##################################WMS_GET_FEATURE_INFO_V111_RESPONSE : {}\n", wmsGetFeatureInfoRequest.withQueryLayers("admin:admin_shp_vigneti_catastali", "admin:admin_shp_oliveti_catastali")
                .withWMSGetMapRequest(wmsGetMapBaseRequest)
                .withFeatureCount(8)
                .withInfoFormat(GML3).withX(154).withY(230).getResponse());
    }
}