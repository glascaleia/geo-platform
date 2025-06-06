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
import org.geosdi.geoplatform.connector.server.v111.GPWMSDescribeLayerV111Request;
import org.geosdi.geoplatform.connector.server.v111.GPWMSGetCapabilitiesV111Request;
import org.geosdi.geoplatform.connector.server.v111.GPWMSGetFeatureInfoV111Request;
import org.geosdi.geoplatform.connector.server.v111.IGPWMSConnectorStoreV111;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.UnmarshalException;
import java.net.URI;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;
import static org.apache.hc.core5.util.Timeout.of;
import static org.geosdi.geoplatform.connector.server.config.GPPooledConnectorConfigBuilder.PooledConnectorConfigBuilder.pooledConnectorConfigBuilder;
import static org.geosdi.geoplatform.connector.server.request.WMSFeatureInfoFormat.GML2_AS_STRING;
import static org.geosdi.geoplatform.connector.server.store.GPWMSConnectorBuilder.WMSConnectorBuilder.wmsConnectorBuilder;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class GPWMSConnectorStoreV111MappeDPCTest {

    private static final Logger logger = LoggerFactory.getLogger(GPWMSConnectorStoreV111MappeDPCTest.class);
    //
    private static IGPWMSConnectorStoreV111 wmsServerConnector;

    @BeforeClass
    public static void beforeClass() throws Exception {
        wmsServerConnector = wmsConnectorBuilder()
                .wmsConnectorBuilderV111()
                .withServerUrl(new URI("http://mappe-dpc.protezionecivile.it/gssitdpc/wms").toURL())
                .withPooledConnectorConfig(pooledConnectorConfigBuilder()
                        .withMaxTotalConnections(12)
                        .withConnectionTimeout(of(15L, SECONDS))
                        .withRequestConnectionTimeout(of(5L, SECONDS))
                        .withResponseConnectionTimeout(of(3L, SECONDS))
                        .withConnectionKeepAlive(of(3L, MINUTES))
                        .withDefaultMaxPerRoute(8)
                        .withMaxRedirect(5)
                        .build())
                .build();
    }

    @Ignore(value = "Server is Down")
    @Test
    public void a_wmsGetCapabilitiesV111Test() throws Exception {
        GPWMSGetCapabilitiesV111Request wmsGetCapabilitiesRequest = wmsServerConnector.createGetCapabilitiesRequest();
        logger.info("###############################WMS_GET_CAPABILITIES_V111_RESPONSE : {}\n", wmsGetCapabilitiesRequest.getResponseAsString());
    }

    @Ignore(value = "Server is Down")
    @Test(expected = UnmarshalException.class)
    public void b_wmsDescribeLayerV111Test() throws Exception {
        GPWMSDescribeLayerV111Request wmsDescribeLayerRequest = wmsServerConnector.createDescribeLayerRequest();
        logger.info("##########################WMS_DESCRIBE_LAYER_RESPONSE_V111 : {}\n", wmsDescribeLayerRequest
                .withLayers("PianoCampiFlegrei:CF_AreeIncontro", "PianoCampiFlegrei:CF_CentriCoordinamento").getResponse());
    }

    @Ignore(value = "Server is Down")
    @Test
    public void c_wmsGetFeatureInfoV111Test() throws Exception {
        GPWMSGetFeatureInfoV111Request<Object> wmsGetFeatureInfoRequest = wmsServerConnector.createGetFeatureInfoRequest();
        GPWMSBoundingBox wmsBoundinBox = new WMSBoundingBox(13.815994262695314, 40.72332345541451, 15.088348388671877, 40.99389273551914);
        GPWMSGetMapBaseRequest wmsGetMapBaseRequest = new WMSGetMapBaseRequest(wmsBoundinBox, of("PianoCampiFlegrei:CF_AreeIncontro", "PianoCampiFlegrei:CF_CentriCoordinamento").collect(toSet()),
                "EPSG:4326", "1853", "521");
        logger.info("##################################WMS_GET_FEATURE_INFO_V111_RESPONSE : {}\n", wmsGetFeatureInfoRequest.withQueryLayers("PianoCampiFlegrei:CF_AreeIncontro", "PianoCampiFlegrei:CF_CentriCoordinamento")
                .withWMSGetMapRequest(wmsGetMapBaseRequest)
                .withFeatureCount(2)
                .withInfoFormat(GML2_AS_STRING).withX(487).withY(305).getResponse());
    }
}