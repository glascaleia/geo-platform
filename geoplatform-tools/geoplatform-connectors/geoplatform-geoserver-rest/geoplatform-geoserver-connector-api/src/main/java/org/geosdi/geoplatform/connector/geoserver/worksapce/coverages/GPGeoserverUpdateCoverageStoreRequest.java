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
package org.geosdi.geoplatform.connector.geoserver.worksapce.coverages;

import com.google.common.io.CharStreams;
import io.reactivex.rxjava3.functions.Consumer;
import net.jcip.annotations.ThreadSafe;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.geosdi.geoplatform.connector.geoserver.model.coveragestores.GPGeoserverUpdateCoverageStoreBody;
import org.geosdi.geoplatform.connector.geoserver.model.workspace.coverages.GPGeoserverCalculateQueryParam;
import org.geosdi.geoplatform.connector.geoserver.model.workspace.coverages.GPGeoserverCalculateValueQueryParam;
import org.geosdi.geoplatform.connector.geoserver.request.workspaces.coverages.GeoserverUpdateCoverageStoreRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonPutConnectorRequest;
import org.geosdi.geoplatform.connector.uri.GPConnectorRXQueryParamConsumer;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.BufferedReader;

import static com.google.common.base.Preconditions.checkArgument;
import static io.reactivex.rxjava3.core.Observable.fromArray;
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
class GPGeoserverUpdateCoverageStoreRequest extends GPJsonPutConnectorRequest<Boolean, GeoserverUpdateCoverageStoreRequest> implements GeoserverUpdateCoverageStoreRequest {

    private final ThreadLocal<String> workspaceName = withInitial(() -> null);
    private final ThreadLocal<String> storeName = withInitial(() -> null);
    private final ThreadLocal<String> coverageName = withInitial(() -> null);
    private final ThreadLocal<GPGeoserverCalculateQueryParam> calculate = withInitial(() -> null);
    private final ThreadLocal<GPGeoserverUpdateCoverageStoreBody> body = withInitial(() -> null);

    /**
     * @param theServerConnector
     * @param theJacksonSupport
     */
    GPGeoserverUpdateCoverageStoreRequest(@Nonnull(when = NEVER) GPServerConnector theServerConnector, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(theServerConnector, theJacksonSupport);
    }


    /**
     * @param theWorkspace
     * @return {@link GeoserverUpdateCoverageStoreRequest}
     */
    @Override
    public GeoserverUpdateCoverageStoreRequest withWorkspace(@Nonnull(when = NEVER) String theWorkspace) {
        this.workspaceName.set(theWorkspace);
        return self();
    }

    /**
     * @param theStore
     * @return {@link GeoserverUpdateCoverageStoreRequest}
     */
    @Override
    public GeoserverUpdateCoverageStoreRequest withStore(@Nonnull(when = NEVER) String theStore) {
        this.storeName.set(theStore);
        return self();
    }

    /**
     * @param theCoverage
     * @return {@link GeoserverUpdateCoverageStoreRequest}
     */
    @Override
    public GeoserverUpdateCoverageStoreRequest withCoverage(@Nonnull(when = NEVER) String theCoverage) {
        this.coverageName.set(theCoverage);
        return self();
    }

    /**
     * @param theCalculates
     * @return {@link GeoserverUpdateCoverageStoreRequest}
     */
    @Override
    public GeoserverUpdateCoverageStoreRequest withCalculate(@Nullable GPGeoserverCalculateValueQueryParam[] theCalculates) {
        this.calculate.set(new GPGeoserverCalculateQueryParam(theCalculates));
        return self();
    }

    /**
     * @param theBody
     * @return {@link GeoserverUpdateCoverageStoreRequest}
     */
    @Override
    public GeoserverUpdateCoverageStoreRequest withBody(@Nonnull(when = NEVER) GPGeoserverUpdateCoverageStoreBody theBody) {
        this.body.set(theBody);
        return self();
    }

    /**
     * @return {@link HttpEntity}
     */
    @Override
    protected HttpEntity prepareHttpEntity() throws Exception {
        GPGeoserverUpdateCoverageStoreBody body = this.body.get();
        checkArgument(body != null, "The Parameter body must not be null.");
        String coverageBodyAsString = this.jacksonSupport.getDefaultMapper().writeValueAsString(body);
        logger.debug("#############################COVERAGE_BODY_STRING : \n{}\n", coverageBodyAsString);
        return new StringEntity(coverageBodyAsString, APPLICATION_JSON);
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String workspaceName = this.workspaceName.get();
        checkArgument((workspaceName != null) && !(workspaceName.trim().isEmpty()), "The Parameter workspaceName must not be null or an empty string.");
        String storeName = this.storeName.get();
        checkArgument((storeName != null) && !(storeName.trim().isEmpty()), "The Parameter storeName must not be null or an empty string.");
        String coverage = this.coverageName.get();
        checkArgument((coverage != null) && !(coverage.trim().isEmpty()), "The Parameter coverage must not be null or an empty string.");
        coverage = coverage.concat(".json");
        String baseURI = this.serverURI.toString();
        URIBuilder uriBuilder = new URIBuilder(((baseURI.endsWith("/") ? baseURI.concat("workspaces/").concat(workspaceName).concat("/coveragestores/").concat(storeName).concat("/coverages/").concat(coverage)
                : baseURI.concat("/workspaces/").concat(workspaceName).concat("/coveragestores/").concat(storeName).concat("/coverages/").concat(coverage))));
        Consumer<ThreadLocal> consumer = new GPConnectorRXQueryParamConsumer(uriBuilder);
        fromArray(this.calculate)
                .doOnComplete(() -> logger.info("##################Uri Builder DONE.\n"))
                .filter(c-> c.get() != null)
                .subscribe(consumer, Throwable::printStackTrace);
        return uriBuilder.build().toString();
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
     * @return {@link Class<String>}
     */
    @Override
    protected Class<Boolean> forClass() {
        return Boolean.class;
    }
}