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
package org.geosdi.geoplatform.connector.pool.builder.v130;

import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.geosdi.geoplatform.connector.pool.builder.WMSConnectorBuilderPool;
import org.geosdi.geoplatform.connector.server.config.GPPooledConnectorConfig;
import org.geosdi.geoplatform.connector.server.security.GPSecurityConnector;
import org.geosdi.geoplatform.connector.server.v130.IGPWMSConnectorStoreV130;
import org.geosdi.geoplatform.support.httpclient.proxy.HttpClientProxyConfiguration;

import java.net.URL;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface WMSConnectorBuilderPoolV130 extends WMSConnectorBuilderPool<WMSConnectorBuilderPoolV130, IGPWMSConnectorStoreV130> {

    /**
     * @param theServerUrl
     * @return {@link WMSConnectorBuilderPoolV130}
     */
    WMSConnectorBuilderPoolV130 withServerUrl(URL theServerUrl);

    /**
     * @param thePooledConnectorConfig
     * @return {@link WMSConnectorBuilderPoolV130}
     */
    WMSConnectorBuilderPoolV130 withPooledConnectorConfig(GPPooledConnectorConfig thePooledConnectorConfig);

    /**
     * @param theSecurityConnector
     * @return {@link WMSConnectorBuilderPoolV130}
     */
    WMSConnectorBuilderPoolV130 withClientSecurity(GPSecurityConnector theSecurityConnector);

    /**
     * @param theProxyConfiguration
     * @return {@link WMSConnectorBuilderPoolV130}
     */
    WMSConnectorBuilderPoolV130 withProxyConfiguration(HttpClientProxyConfiguration theProxyConfiguration);

    /**
     * @param theSslConnectionSocketFactory
     * @return {@link WMSConnectorBuilderPoolV130}
     */
    WMSConnectorBuilderPoolV130 withSslConnectionSocketFactory(SSLConnectionSocketFactory theSslConnectionSocketFactory);

    /**
     * @return {@link IGPWMSConnectorStoreV130}
     * @throws Exception
     */
    IGPWMSConnectorStoreV130 build() throws Exception;

    /**
     * @return {@link WMSConnectorBuilderPoolV130}
     */
    static WMSConnectorBuilderPoolV130 wmsConnectorBuilderPoolV130() {
        return new GPWMSConnectorBuilderPoolV130();
    }
}