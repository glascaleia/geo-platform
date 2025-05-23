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
package org.geosdi.geoplatform.connector.geoserver.featuretypes;

import com.google.common.io.CharStreams;
import net.jcip.annotations.ThreadSafe;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.geosdi.geoplatform.connector.geoserver.model.featuretypes.IGPGeoserverFeatureTypeInfo;
import org.geosdi.geoplatform.connector.geoserver.request.featuretypes.GeoserverUpdateFeatureTypeRequest;
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
class GPGeoserverUpdateFeatureTypeRequest extends GPJsonPutConnectorRequest<Boolean, GeoserverUpdateFeatureTypeRequest> implements GeoserverUpdateFeatureTypeRequest {

    private final ThreadLocal<String> workspace;
    private final ThreadLocal<String> store;
    private final ThreadLocal<String> feature;
    private final ThreadLocal<IGPGeoserverFeatureTypeInfo> featureTypeBody;

    /**
     * @param theServerConnector
     * @param theJacksonSupport
     */
    GPGeoserverUpdateFeatureTypeRequest(@Nonnull(when = NEVER) GPServerConnector theServerConnector, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(theServerConnector, theJacksonSupport);
        this.workspace = withInitial(() -> null);
        this.store = withInitial(() -> null);
        this.featureTypeBody = withInitial(() -> null);
        this.feature = withInitial(() -> null);
    }

    /**
     * @param theWorkspace
     * @return {@link GeoserverUpdateFeatureTypeRequest}
     */
    @Override
    public GeoserverUpdateFeatureTypeRequest withWorkspace(@Nonnull(when = NEVER) String theWorkspace) {
        this.workspace.set(theWorkspace);
        return self();
    }

    /**
     * @param theStore
     * @return {@link GeoserverUpdateFeatureTypeRequest}
     */
    @Override
    public GeoserverUpdateFeatureTypeRequest withStore(@Nonnull(when = NEVER) String theStore) {
        this.store.set(theStore);
        return self();
    }

    /**
     * @param theFeatureName
     * @return {@link GeoserverUpdateFeatureTypeRequest}
     */
    @Override
    public GeoserverUpdateFeatureTypeRequest withFeatureName(@Nonnull(when = NEVER) String theFeatureName) {
        this.feature.set(theFeatureName);
        return self();
    }

    /**
     * @param theFeatureTypeBody
     * @return {@link GeoserverUpdateFeatureTypeRequest}
     */
    @Override
    public <FeatureTypeBody extends IGPGeoserverFeatureTypeInfo> GeoserverUpdateFeatureTypeRequest withFeatureTypeBody(@Nonnull(when = NEVER) FeatureTypeBody theFeatureTypeBody) {
        this.featureTypeBody.set(theFeatureTypeBody);
        return self();
    }

    /**
     * @return {@link HttpEntity}
     */
    @Override
    protected HttpEntity prepareHttpEntity() throws Exception {
        IGPGeoserverFeatureTypeInfo featureTypeBody = this.featureTypeBody.get();
        checkArgument(featureTypeBody != null, "The Parameter featureTypeBody must not be null.");
        String featureTypeBodyString = jacksonSupport.getDefaultMapper().writeValueAsString(featureTypeBody);
        logger.debug("#############################FEATURE_TYPE_BODY : \n{}\n", featureTypeBodyString);
        return new StringEntity(featureTypeBodyString, APPLICATION_JSON);
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String workspace = this.workspace.get();
        checkArgument((workspace != null) && !(workspace.trim().isEmpty()), "The Parameter workspace must not be null or an empty string.");
        String store = this.store.get();
        checkArgument((store != null) && !(store.trim().isEmpty()), "The Parameter store must not be null or an empty string.");
        String baseURI = this.serverURI.toString();
        String feature = this.feature.get();
        checkArgument((feature != null) && !(feature.trim().isEmpty()), "The Parameter feature must not be null or an empty string.");
        return ((baseURI.endsWith("/") ? baseURI.concat("workspaces/").concat(workspace).concat("/datastores/").concat(store).concat("/featuretypes/").concat(feature)
                : baseURI.concat("/workspaces/").concat(workspace).concat("/datastores/").concat(store).concat("/featuretypes/").concat(feature)));
    }

    /**
     * @param reader
     * @return {@link Boolean}
     * @throws Exception
     */
    @Override
    protected Boolean readInternal(BufferedReader reader) throws Exception {
        try {
            String value = CharStreams.toString(reader);
            return ((value != null) && (value.trim().isEmpty()) ? TRUE : FALSE);
        } catch (Exception ex) {
            ex.printStackTrace();
            return FALSE;
        }
    }

    /**
     * @return {@link Class<Boolean>}
     */
    @Override
    protected Class<Boolean> forClass() {
        return Boolean.class;
    }
}