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
package org.geosdi.geoplatform.connector.geoserver.security.services;

import com.google.common.io.CharStreams;
import net.jcip.annotations.ThreadSafe;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.geosdi.geoplatform.connector.geoserver.model.security.rule.GPGeoserverRules;
import org.geosdi.geoplatform.connector.geoserver.model.security.rule.GeoserverRules;
import org.geosdi.geoplatform.connector.geoserver.request.security.services.GeoserverUpdateAclServicesRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonPutConnectorRequest;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;
import java.io.BufferedReader;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.ThreadLocal.withInitial;
import static javax.annotation.meta.When.NEVER;
import static org.apache.hc.core5.http.ContentType.APPLICATION_JSON;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
@ThreadSafe
class GPGeoserverUpdateAclServicesRequest extends GPJsonPutConnectorRequest<Boolean, GeoserverUpdateAclServicesRequest> implements GeoserverUpdateAclServicesRequest {

    private final ThreadLocal<GPGeoserverRules> geoserverRulesBody;

    /**
     * @param theServerConnector
     * @param theJacksonSupport
     */
    GPGeoserverUpdateAclServicesRequest(@Nonnull(when = NEVER) GPServerConnector theServerConnector,
            @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(theServerConnector, theJacksonSupport);
        this.geoserverRulesBody = withInitial(() -> null);
    }

    /**
     * @param theGeoserverRulesBody
     * @return {@link GeoserverUpdateAclServicesRequest}
     */
    @Override
    public GeoserverUpdateAclServicesRequest withBody(@Nonnull(when = NEVER) GPGeoserverRules theGeoserverRulesBody) {
        this.geoserverRulesBody.set(theGeoserverRulesBody);
        return self();
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String baseURI = this.serverURI.toString();
        return ((baseURI.endsWith("/") ? baseURI.concat("security/acl/services.json") :
                baseURI.concat("/security/acl/services.json")));
    }

    /**
     * @return {@link Class<Boolean>}
     */
    protected Class<Boolean> forClass() {
        return Boolean.class;
    }

    /**
     * @param reader
     * @return
     * @throws Exception
     */
    @Override
    protected Boolean readInternal(BufferedReader reader) throws Exception {
        String value = CharStreams.toString(reader);
        return ((value != null) && (value.trim().isEmpty()) ? TRUE : FALSE);
    }

    /**
     * @return {@link HttpEntity}
     */
    @Override
    protected HttpEntity prepareHttpEntity() throws Exception {
        GeoserverRules geoserverRulesBody = this.geoserverRulesBody.get();
        checkArgument(geoserverRulesBody != null, "The geoserverRuleBody must not be null.");
        String layerBodyString = jacksonSupport.getDefaultMapper().writeValueAsString(geoserverRulesBody);
        logger.debug("#############################LAYER : \n{}\n", layerBodyString);
        return new StringEntity(layerBodyString, APPLICATION_JSON);
    }
}