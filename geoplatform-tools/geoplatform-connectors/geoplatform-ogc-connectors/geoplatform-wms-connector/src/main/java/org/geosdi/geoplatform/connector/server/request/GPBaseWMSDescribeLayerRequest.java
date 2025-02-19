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
package org.geosdi.geoplatform.connector.server.request;

import net.jcip.annotations.ThreadSafe;
import org.geosdi.geoplatform.connector.WMSVersion;
import org.geosdi.geoplatform.connector.server.GPWMSServerConnector;
import org.geosdi.geoplatform.jaxb.GPBaseJAXBContext;

import javax.annotation.Nonnull;
import javax.annotation.meta.When;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.ThreadLocal.withInitial;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@ThreadSafe
public abstract class GPBaseWMSDescribeLayerRequest<T> extends GPWMSBaseGetRequest<T> implements GPWMSDescribeLayerRequest<T> {

    private final WMSVersion version;
    private final ThreadLocal<String[]> layers;

    /**
     * @param server
     * @param theWmsJAXBContext
     */
    protected GPBaseWMSDescribeLayerRequest(@Nonnull(when = NEVER) GPWMSServerConnector server, @Nonnull(when = NEVER) GPBaseJAXBContext theWmsJAXBContext) {
        super(server, theWmsJAXBContext);
        this.version = server.getVersion();
        this.layers = withInitial(() -> null);
    }

    /**
     * @param theLayers
     * @return {@link GPWMSDescribeLayerRequest<T>}
     */
    @Override
    public GPWMSDescribeLayerRequest<T> withLayers(@Nonnull(when = When.NEVER) String... theLayers) {
        this.layers.set(theLayers);
        return this;
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String[] layers = this.layers.get();
        checkArgument(layers != null, "The Parameter layers must not be null.");
        String layersKVP = stream(layers)
                .filter(Objects::nonNull)
                .filter(layer -> !(layer.trim().isEmpty()))
                .map(String::trim)
                .collect(joining(","));
        checkArgument((layersKVP != null) && !(layersKVP.trim().isEmpty()), "The Parameter layersKVP must not be null");
        String baseURI = this.serverURI.toString();
        return (baseURI.contains("?") ?
                baseURI.concat(WMS_DESCRIBE_LAYER_BASE_REQUEST.replace("${start}", "&").replace("${version}", this.version.getVersion())
                        .replace("${layers}", layersKVP))
                : baseURI.concat(WMS_DESCRIBE_LAYER_BASE_REQUEST.replace("${start}", "?").replace("${version}", this.version.getVersion())
                .replace("${layers}", layersKVP)));
    }
}