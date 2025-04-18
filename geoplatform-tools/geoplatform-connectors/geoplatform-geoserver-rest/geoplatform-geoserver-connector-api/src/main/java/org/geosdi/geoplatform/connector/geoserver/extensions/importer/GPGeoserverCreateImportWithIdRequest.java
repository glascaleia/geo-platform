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
package org.geosdi.geoplatform.connector.geoserver.extensions.importer;

import io.reactivex.rxjava3.functions.Consumer;
import net.jcip.annotations.ThreadSafe;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.geosdi.geoplatform.connector.geoserver.model.extensions.importer.GPFileExpandType;
import org.geosdi.geoplatform.connector.geoserver.model.extensions.importer.body.GPGeoserverCreateImportBody;
import org.geosdi.geoplatform.connector.geoserver.request.extensions.importer.GeoserverCreateImportWithIdRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonPostConnectorRequest;
import org.geosdi.geoplatform.connector.uri.GPConnectorBooleanQueryParam;
import org.geosdi.geoplatform.connector.uri.GPConnectorRXQueryParamConsumer;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkArgument;
import static io.reactivex.rxjava3.core.Observable.fromArray;
import static java.lang.ThreadLocal.withInitial;
import static javax.annotation.meta.When.NEVER;
import static org.apache.hc.core5.http.ContentType.APPLICATION_JSON;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
@ThreadSafe
class GPGeoserverCreateImportWithIdRequest extends GPJsonPostConnectorRequest<Object, GeoserverCreateImportWithIdRequest> implements GeoserverCreateImportWithIdRequest {

    private final ThreadLocal<Integer> id;
    private final ThreadLocal<GPGeoserverCreateImportBody> body;
    private final ThreadLocal<GPConnectorBooleanQueryParam> async;
    private final ThreadLocal<GPConnectorBooleanQueryParam> exec;
    private final ThreadLocal<GPFileExpandType> expand;

    /**
     * @param theServerConnector
     * @param theJacksonSupport
     */
    GPGeoserverCreateImportWithIdRequest(@Nonnull(when = NEVER) GPServerConnector theServerConnector, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(theServerConnector, theJacksonSupport);
        this.id = withInitial(() -> null);
        this.body = withInitial(() -> null);
        this.async = withInitial(() -> null);
        this.exec = withInitial(() -> null);
        this.expand = withInitial(() -> null);
    }

    /**
     * @param theId
     * @return {@link GeoserverCreateImportWithIdRequest}
     */
    @Override
    public GeoserverCreateImportWithIdRequest withId(@Nonnull(when = NEVER) Integer theId) {
        this.id.set(theId);
        return self();
    }

    /**
     * @param theBody
     * @return {@link GeoserverCreateImportWithIdRequest}
     */
    @Override
    public GeoserverCreateImportWithIdRequest withBody(@Nonnull(when = NEVER) GPGeoserverCreateImportBody theBody) {
        this.body.set(theBody);
        return self();
    }

    /**
     * @param theExec
     * @return {@link GeoserverCreateImportWithIdRequest}
     */
    @Override
    public GeoserverCreateImportWithIdRequest withExec(@Nonnull(when = NEVER) Boolean theExec) {
        this.exec.set(new GPConnectorBooleanQueryParam("exec", theExec));
        return self();
    }

    /**
     * @param theExpand
     * @return {@link GeoserverCreateImportWithIdRequest}
     */
    @Override
    public GeoserverCreateImportWithIdRequest withExpand(@Nonnull(when = NEVER) GPFileExpandType theExpand) {
        this.expand.set(theExpand);
        return self();
    }

    /**
     * @param theAsync
     * @return {@link GeoserverCreateImportWithIdRequest}
     */
    @Override
    public GeoserverCreateImportWithIdRequest withAsync(@Nonnull(when = NEVER) Boolean theAsync) {
        this.async.set(new GPConnectorBooleanQueryParam("async", theAsync));
        return self();
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String baseURI = this.serverURI.toString();
        Integer id = this.id.get();
        checkArgument(id != null && id >= 0, "Parameter id must not be null");
        String path = ((baseURI.endsWith("/") ? baseURI.concat("imports/").concat(id.toString()) : baseURI.concat("/imports/").concat(id.toString())));
        URIBuilder uriBuilder = new URIBuilder(path);
        Consumer<ThreadLocal> consumer = new GPConnectorRXQueryParamConsumer(uriBuilder);
        fromArray(this.async, this.exec, this.expand)
                .doOnComplete(() -> logger.info("##################Uri Builder DONE.\n"))
                .filter(c-> c.get() != null)
                .subscribe(consumer, Throwable::printStackTrace);
        return uriBuilder.build().toString();
    }

    /**
     * @return {@link Class<String>}
     */
    @Override
    protected Class<Object> forClass() {
        return Object.class;
    }

    /**
     * @return {@link HttpEntity}
     */
    @Override
    protected HttpEntity prepareHttpEntity() throws Exception {
        GPGeoserverCreateImportBody body = this.body.get();
        checkArgument(body != null, "The importerBody must not be null.");
        String workspaceBodyString = jacksonSupport.getDefaultMapper().writeValueAsString(body);
        logger.debug("#############################IMPORTER_BODY : \n{}\n", workspaceBodyString);
        return new StringEntity(workspaceBodyString, APPLICATION_JSON);
    }
}