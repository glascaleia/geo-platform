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
package org.geosdi.geoplatform.connector.geoserver.extensions.classify;

import com.google.common.io.CharStreams;
import io.reactivex.rxjava3.functions.Consumer;
import net.jcip.annotations.ThreadSafe;
import org.apache.hc.core5.net.URIBuilder;
import org.geosdi.geoplatform.connector.geoserver.model.extensions.classify.GeoserverMethod;
import org.geosdi.geoplatform.connector.geoserver.model.extensions.rasterize.GeoserverRamp;
import org.geosdi.geoplatform.connector.geoserver.request.extensions.classify.GeoserverClassifyRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonGetConnectorRequest;
import org.geosdi.geoplatform.connector.uri.*;

import javax.annotation.Nonnull;
import java.io.BufferedReader;

import static com.google.common.base.Preconditions.checkArgument;
import static io.reactivex.rxjava3.core.Observable.fromArray;
import static java.lang.Boolean.FALSE;
import static java.lang.ThreadLocal.withInitial;
import static javax.annotation.meta.When.NEVER;
import static org.geosdi.geoplatform.connector.geoserver.styles.sld.GeoserverStyleSLDV100Request.JACKSON_JAXB_XML_SUPPORT;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
@ThreadSafe
class GPGeoserverClassifyRequest extends GPJsonGetConnectorRequest<String, GeoserverClassifyRequest> implements GeoserverClassifyRequest {

    private final ThreadLocal<String> vectorName = withInitial(() -> null);
    private final ThreadLocal<GPConnectorStringQueryParam> attribute = withInitial(() -> null);
    private final ThreadLocal<GeoserverRamp> geoserverRamp = withInitial(() -> null);
    private final ThreadLocal<GPConnectorQueryParam> intervals = withInitial(() -> null);
    private final ThreadLocal<GPConnectorQueryParam> method = withInitial(() -> null);
    private final ThreadLocal<GPConnectorBooleanQueryParam> open = withInitial(() -> null);
    private final ThreadLocal<GPConnectorBooleanQueryParam> reverse = withInitial(() -> null);
    private final ThreadLocal<GPConnectorBooleanQueryParam> normalize = withInitial(() -> null);
    private final ThreadLocal<GPConnectorStringQueryParam> startColor = withInitial(() -> null);
    private final ThreadLocal<GPConnectorStringQueryParam> endColor = withInitial(() -> null);
    private final ThreadLocal<GPConnectorStringQueryParam> midColor = withInitial(() -> null);
    private final ThreadLocal<GPConnectorBooleanQueryParam> size = withInitial(() -> null);
    private final ThreadLocal<GPConnectorStringQueryParam> symbol = withInitial(() -> null);
    private final ThreadLocal<String> format = withInitial(() -> "xml");

    /**
     * @param server
     */
    GPGeoserverClassifyRequest(@Nonnull(when = NEVER) GPServerConnector server) {
        super(server, JACKSON_JAXB_XML_SUPPORT);
    }

    /**
     * @param theVectorName
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withVectorName(@Nonnull(when = NEVER) String theVectorName) {
        this.vectorName.set(theVectorName);
        return self();
    }

    /**
     * @param theAttribute
     * @return
     */
    @Override
    public GeoserverClassifyRequest withAttribute(@Nonnull(when = NEVER) String theAttribute) {
        this.attribute.set(new GPConnectorStringQueryParam("attribute", theAttribute));
        return self();
    }

    /**
     * @param theGeoserverRamp
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withGeoserverRamp(@Nonnull(when = NEVER) GeoserverRamp theGeoserverRamp) {
        this.geoserverRamp.set(theGeoserverRamp);
        return self();
    }

    /**
     * @param theIntervals
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withIntervals(@Nonnull(when = NEVER) Integer theIntervals) {
        this.intervals.set(theIntervals != null ? new GPConnectorIntegerQueryParam("intervals", theIntervals) : new GPConnectorStringQueryParam("intervals", "2"));
        return self();
    }

    /**
     * @param theMethod
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withMethod(@Nonnull(when = NEVER) GeoserverMethod theMethod) {
        this.method.set(theMethod != null ? theMethod :new GPConnectorStringQueryParam("method", GeoserverMethod.equalInterval.name()));
        return self();
    }

    /**
     * @param theOpen
     * @return
     */
    @Override
    public GeoserverClassifyRequest withOpen(@Nonnull(when = NEVER) Boolean theOpen) {
        this.open.set(new GPConnectorBooleanQueryParam("open", theOpen == null ? FALSE : theOpen));
        return self();
    }

    /**
     * @param theReverse
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withReverse(@Nonnull(when = NEVER) Boolean theReverse) {
        this.reverse.set(new GPConnectorBooleanQueryParam("reverse", theReverse == null ? FALSE : theReverse));
        return self();
    }

    /**
     * @param theNormalize
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withNormalize(@Nonnull(when = NEVER) Boolean theNormalize) {
        this.normalize.set(new GPConnectorBooleanQueryParam("normalize", theNormalize == null ? FALSE : theNormalize));
        return self();
    }

    /**
     * @param theStartColor
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withStartColor(@Nonnull(when = NEVER) String theStartColor) {
        this.startColor.set(new GPConnectorStringQueryParam("startColor", theStartColor));
        return self();
    }

    /**
     * @param theEndColor
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withEndColor(@Nonnull(when = NEVER) String theEndColor) {
        this.endColor.set(new GPConnectorStringQueryParam("endColor", theEndColor));
        return self();
    }

    /**
     * @param theMidColor
     * @return {@link GeoserverClassifyRequest}
     */
    @Override
    public GeoserverClassifyRequest withMidColor(@Nonnull(when = NEVER) String theMidColor) {
        this.midColor.set(new GPConnectorStringQueryParam("midColor", theMidColor));
        return self();
    }

    /**
     * @param theSize
     * @return
     */
    @Override
    public GeoserverClassifyRequest withSize(@Nonnull(when = NEVER) Boolean theSize) {
        this.size.set(new GPConnectorBooleanQueryParam("size", theSize == null ? FALSE : theSize));
        return self();
    }

    /**
     * @param theSymbol
     * @return
     */
    @Override
    public GeoserverClassifyRequest withSymbol(@Nonnull(when = NEVER) String theSymbol) {
        this.symbol.set(new GPConnectorStringQueryParam("symbol", theSymbol));
        return self();
    }

    @Override
    public GeoserverClassifyRequest withFormat(@Nonnull(when = NEVER) String theFormat) {
        this.format.set(theFormat);
        return self();
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String baseURI = this.serverURI.toString();
        String vectorName = this.vectorName.get();
        checkArgument((vectorName != null) && !(vectorName.trim().isEmpty()), "The Parameter vectorName must not be null or an empty string.");
        String path = (baseURI.endsWith("/") ?
                baseURI.concat("sld/").concat(vectorName).concat("/classifier").concat(".").concat(this.format.get()) :
                baseURI.concat("/sld/").concat(vectorName).concat("/classifier").concat(".").concat(this.format.get()));
        URIBuilder uriBuilder = new URIBuilder(path);
        Consumer<ThreadLocal> consumer = new GPConnectorRXQueryParamConsumer(uriBuilder);
        fromArray(this.attribute, this.geoserverRamp, this.intervals, this.method, this.open, this.reverse, this.normalize,
                this.startColor, this.endColor, this.midColor, this.size, this.symbol)
                .doOnComplete(() -> logger.info("##################Uri Builder DONE.\n"))
                .filter(c-> c.get() != null)
                .subscribe(consumer, Throwable::printStackTrace);
        return uriBuilder.build().toString();
    }

    /**
     * @param reader
     * @return {@link String}
     * @throws Exception
     */
    @Override
    protected String readInternal(BufferedReader reader) throws Exception {
        return CharStreams.toString(reader);
    }

    /**
     * @return {@link Class<String>}
     */
    @Override
    protected Class<String> forClass() {
        return String.class;
    }
}