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
package org.geosdi.geoplatform.wms;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.UnmarshalException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static org.geosdi.geoplatform.connector.WMSVersion.V130;
import static org.geosdi.geoplatform.services.builder.GPWMSDescribeLayerBuilder.WMSDescribeLayerBuilder.wmsDescribeLayerBuilder;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GPWMSDescribeLayerBuilderTest {

    private static final Logger logger = LoggerFactory.getLogger(GPWMSDescribeLayerBuilderTest.class);

    @Test
    public void a_wmsDescribeLayerTypeV111Test() throws Exception {
        String serverURL = "https://servizi.protezionecivile.it/webgis/sitdpc/gpServerProxy?targetURL=https://insar.irea.cnr.it/geoserver/wms%26v=dpc%26p=4WzL06EA";
        String layerName = "geonode:dtsup_stromboli";
        logger.info("###########################WMS_DESCRIBE_LAYER_RESPONSE : {}\n", wmsDescribeLayerBuilder()
                .withServerURL(serverURL).withLayerName(layerName).build());
    }

    @Test(expected = UnmarshalException.class)
    public void b_wmsDescribeLayerTypeV130Test() throws Exception {
        String serverURL = "https://servizi.protezionecivile.it/webgis/sitdpc/gpServerProxy?targetURL=https://insar.irea.cnr.it/geoserver/wms%26v=dpc%26p=4WzL06EA";
        String layerName = "geonode:dtsup_stromboli";
        logger.info("###########################WMS_DESCRIBE_LAYER_RESPONSE : {}\n", wmsDescribeLayerBuilder()
                .withServerURL(serverURL).withWMSVersion(V130).withLayerName(layerName).build());
    }

    @Test
    public void c_replaceTest() throws Exception {
        String url = "https://servizi.protezionecivile.it/webgis/sitdpc/gpServerProxy?targetURL=https://insar.irea.cnr.it/geoserver/wms%26v=dpc%26p=4WzL06EA&layerName=geonode:dtsup_stromboli";
        logger.info("{}\n", URLDecoder.decode(url, StandardCharsets.UTF_8.name()));
    }
}