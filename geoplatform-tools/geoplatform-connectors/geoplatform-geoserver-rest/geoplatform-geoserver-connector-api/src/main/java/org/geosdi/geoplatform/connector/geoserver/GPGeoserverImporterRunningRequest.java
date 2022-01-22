/*
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2022 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.connector.geoserver;

import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.geosdi.geoplatform.connector.geoserver.request.running.GeoserverRestRunningRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonGetConnectorRequest;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
class GPGeoserverImporterRunningRequest extends GPJsonGetConnectorRequest<Boolean, GeoserverRestRunningRequest> implements GeoserverRestRunningRequest {

    /**
     * @param server
     * @param theJacksonSupport
     */
    GPGeoserverImporterRunningRequest(@Nonnull(when = NEVER) GPServerConnector server, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(server, theJacksonSupport);
    }

    /**
     * @return {@link Boolean}
     */
    @Override
    public Boolean isUp() {
        try {
            return this.getResponse();
        } catch (Exception ex) {
            return FALSE;
        }
    }

    /**
     * @return {@link Boolean}
     * @throws Exception
     */
    @Override
    public Boolean getResponse() throws Exception {
        HttpUriRequest httpMethod = this.prepareHttpMethod();
        httpMethod.addHeader("Content-Type", "application/json");
        logger.debug("#############################Executing -------------> {}\n", httpMethod.getUri().toString());
        CloseableHttpResponse httpResponse = super.securityConnector.secure(this, httpMethod);
        int statusCode = httpResponse.getCode();
        logger.debug("###############################STATUS_CODE : {} for Request : {}\n", statusCode,
                this.getClass().getSimpleName());
        return ((statusCode == 200) ? TRUE : FALSE);
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String baseURI = this.serverURI.toString();
        return ((baseURI.endsWith("/") ? baseURI.concat("imports") : baseURI.concat("/imports")));
    }

    /**
     * @return {@link Class<Boolean>}
     */
    @Override
    protected Class<Boolean> forClass() {
        return Boolean.class;
    }
}