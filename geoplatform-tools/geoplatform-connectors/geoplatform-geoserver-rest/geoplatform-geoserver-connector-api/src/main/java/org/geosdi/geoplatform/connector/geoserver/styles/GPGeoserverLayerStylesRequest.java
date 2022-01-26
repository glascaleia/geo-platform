/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2022 geoSDI Group (CNR IMAA - Potenza - ITALY).
 * <p>
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see http://www.gnu.org/licenses/
 * <p>
 * ====================================================================
 * <p>
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole combination.
 * <p>
 * As a special exception, the copyright holders of this library give you permission
 * to link this library with independent modules to produce an executable, regardless
 * of the license terms of these independent modules, and to copy and distribute
 * the resulting executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the license of
 * that module. An independent module is a module which is not derived from or
 * based on this library. If you modify this library, you may extend this exception
 * to your version of the library, but you are not obligated to do so. If you do not
 * wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.connector.geoserver.styles;

import net.jcip.annotations.ThreadSafe;
import org.geosdi.geoplatform.connector.geoserver.model.styles.GPGeoserverStyles;
import org.geosdi.geoplatform.connector.geoserver.request.styles.GeoserverLayerStylesRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonGetConnectorRequest;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.ThreadLocal.withInitial;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@ThreadSafe
class GPGeoserverLayerStylesRequest extends GPJsonGetConnectorRequest<GPGeoserverStyles, GeoserverLayerStylesRequest> implements GeoserverLayerStylesRequest {

    private final ThreadLocal<String> layer = withInitial(() -> null);

    /**
     * @param server
     * @param theJacksonSupport
     */
    GPGeoserverLayerStylesRequest(@Nonnull(when = NEVER) GPServerConnector server, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(server, theJacksonSupport);
    }

    /**
     * @param theLayerName
     * @return {@link GeoserverLayerStylesRequest}
     */
    @Override
    public GeoserverLayerStylesRequest withLayerName(@Nonnull(when = NEVER) String theLayerName) {
        this.layer.set(theLayerName);
        return self();
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String layerName = this.layer.get();
        checkArgument(((layerName != null) && !(layerName.trim().isEmpty())), "The Parameter Layer Name must not be null or an Empty String.");
        String baseURI = this.serverURI.toString();
        return ((baseURI.endsWith("/") ? baseURI.concat("layers/").concat(layerName).concat("/styles.json") :
                baseURI.concat("/layers/").concat(layerName).concat("/styles.json")));
    }

    /**
     * @return {@link Class<GPGeoserverStyles>}
     */
    @Override
    protected Class<GPGeoserverStyles> forClass() {
        return GPGeoserverStyles.class;
    }
}