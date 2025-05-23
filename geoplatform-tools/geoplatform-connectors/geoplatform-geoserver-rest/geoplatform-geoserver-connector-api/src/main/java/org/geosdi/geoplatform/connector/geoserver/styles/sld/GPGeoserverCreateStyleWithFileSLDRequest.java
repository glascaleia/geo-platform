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
package org.geosdi.geoplatform.connector.geoserver.styles.sld;

import io.reactivex.rxjava3.functions.Consumer;
import net.jcip.annotations.ThreadSafe;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.FileEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.geosdi.geoplatform.connector.geoserver.styles.base.GPGeoserverBaseCreateStyleRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.uri.GPConnectorBooleanQueryParam;
import org.geosdi.geoplatform.connector.uri.GPConnectorStringQueryParam;
import org.geosdi.geoplatform.connector.uri.GPConnectorRXQueryParamConsumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;

import static com.google.common.base.Preconditions.checkArgument;
import static io.reactivex.rxjava3.core.Observable.fromArray;
import static java.lang.ThreadLocal.withInitial;
import static javax.annotation.meta.When.NEVER;
import static org.geosdi.geoplatform.connector.geoserver.model.format.GPFormatExtension.SLD;
import static org.geosdi.geoplatform.connector.geoserver.model.format.GPFormatExtension.SLD_1_1_0;
import static org.geosdi.geoplatform.connector.geoserver.styles.sld.GeoserverStyleSLDV100Request.JACKSON_JAXB_XML_SUPPORT;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
@ThreadSafe
class GPGeoserverCreateStyleWithFileSLDRequest extends GPGeoserverBaseCreateStyleRequest<File, GeoserverCreateStyleWithFileSLDRequest> implements GeoserverCreateStyleWithFileSLDRequest {

    private final ThreadLocal<GPConnectorStringQueryParam> style;
    private final ThreadLocal<GPConnectorBooleanQueryParam> raw;

    /**
     * @param theServerConnector
     */
    GPGeoserverCreateStyleWithFileSLDRequest(@Nonnull(when = NEVER) GPServerConnector theServerConnector) {
        super(theServerConnector, JACKSON_JAXB_XML_SUPPORT);
        this.style = withInitial(() -> null);
        this.raw = withInitial(() -> null);
    }

    /**
     * @param theStyleName
     * @return {@link GPGeoserverCreateStyleWithFileSLDRequest}
     */
    @Override
    public GeoserverCreateStyleWithFileSLDRequest withStyleName(@Nonnull(when = NEVER) String theStyleName) {
        this.style.set(new GPConnectorStringQueryParam("name", theStyleName));
        return self();
    }

    /**
     * @param theStyleBody
     * @return {@link GeoserverCreateStyleWithFileSLDRequest}
     */
    @Override
    public GeoserverCreateStyleWithFileSLDRequest withStyleBody(@Nonnull(when = NEVER) File theStyleBody) {
        this.styleBody.set(theStyleBody);
        return self();
    }

    /**
     * @param theRaw
     * @return {@link GeoserverCreateStyleWithFileSLDRequest}
     */
    @Override
    public GeoserverCreateStyleWithFileSLDRequest withRaw(@Nullable Boolean theRaw) {
        this.raw.set(new GPConnectorBooleanQueryParam("raw", theRaw));
        return self();
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String baseURI = super.createUriPath();
        URIBuilder uriBuilder = new URIBuilder(baseURI);
        Consumer<ThreadLocal> consumer = new GPConnectorRXQueryParamConsumer(uriBuilder);
        fromArray(this.raw, this.style)
                .doOnComplete(() -> logger.info("##################Uri Builder DONE.\n"))
                .filter(c-> c.get() != null)
                .subscribe(consumer, Throwable::printStackTrace);
        return uriBuilder.build().toString();
    }

    /**
     * @return {@link HttpEntity}
     */
    @Override
    protected HttpEntity prepareHttpEntity() throws Exception {
        File file = this.styleBody.get();
        checkArgument(((file != null) && (file.exists()) && !(file.isDirectory())), "The style file must not be null");
        String contentType = this.checkSLD10Version(this.styleBody.get()) ? SLD.getContentType() : SLD_1_1_0
                .getContentType();
        FileEntity builder = new FileEntity(file, ContentType.create(contentType));
        return builder;
    }

    /**
     * @param httpMethod
     */
    @Override
    protected void addHeaderParams(HttpUriRequest httpMethod) {
        String contentType = this.checkSLD10Version(this.styleBody.get()) ? SLD.getContentType() : SLD_1_1_0
                .getContentType();
        httpMethod.addHeader("Content-Type", contentType);
    }
}