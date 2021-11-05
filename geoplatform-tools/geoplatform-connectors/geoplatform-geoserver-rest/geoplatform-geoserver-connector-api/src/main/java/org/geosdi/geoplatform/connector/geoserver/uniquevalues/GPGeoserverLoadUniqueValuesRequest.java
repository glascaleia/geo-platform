/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2021 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.connector.geoserver.uniquevalues;

import net.jcip.annotations.ThreadSafe;
import org.geosdi.geoplatform.connector.geoserver.model.uniquevalues.GPGeoserverUniqueValue;
import org.geosdi.geoplatform.connector.geoserver.request.uniquevalue.GeoserverLoadUniqueValuesRequest;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonGetConnectorRequest;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;
import javax.annotation.meta.When;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
@ThreadSafe
public class GPGeoserverLoadUniqueValuesRequest extends GPJsonGetConnectorRequest<GPGeoserverUniqueValue, GeoserverLoadUniqueValuesRequest> implements GeoserverLoadUniqueValuesRequest {

    private final ThreadLocal<String> layerName;
    private final ThreadLocal<String> layerAttribute;

    /**
     * @param server
     * @param theJacksonSupport
     */
    GPGeoserverLoadUniqueValuesRequest(@Nonnull(when = NEVER) GPServerConnector server, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(server, theJacksonSupport);
        this.layerName = ThreadLocal.withInitial(() -> null);
        this.layerAttribute = ThreadLocal.withInitial(() -> null);
    }

    /**
     * @param theLayerName
     * @return {@link GeoserverLoadUniqueValuesRequest}
     */
    @Override
    public GeoserverLoadUniqueValuesRequest withLayerName(@Nonnull(when = NEVER) String theLayerName) {
        this.layerName.set(theLayerName);
        return self();
    }

    /**
     * @param theLayerAttribute
     * @return {@link GeoserverLoadUniqueValuesRequest}
     */
    @Override
    public GeoserverLoadUniqueValuesRequest withLayerAttribute(@Nonnull(when = When.NEVER) String theLayerAttribute) {
        this.layerAttribute.set(theLayerAttribute);
        return self();
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String urlPath = this.layerName.get();
        checkArgument((urlPath != null) && !(urlPath.trim().isEmpty()), "The Parameter urlPath must not be null or an empty string.");
        String baseURI = this.serverURI.toString();
        String layerName = this.layerName.get();
        checkArgument((layerName != null) && !(layerName.trim().isEmpty()), "The Parameter layerName must not be null or an empty string.");
        String layerAttribute = this.layerAttribute.get();
        checkArgument((layerAttribute != null) && !(layerAttribute.trim().isEmpty()), "The Parameter layerAttribute must not be null or an empty string.");
        return (baseURI.endsWith("/") ? baseURI.concat("uniquevalue/").concat(layerName).concat("/").concat(layerAttribute).concat("/classify.json") : baseURI.concat("/uniquevalue/").concat(layerName).concat("/").concat(layerAttribute).concat("/classify.json"));
    }

    /**
     * @return {@link Class<GPGeoserverUniqueValue>}
     */
    @Override
    protected Class<GPGeoserverUniqueValue> forClass() {
        return GPGeoserverUniqueValue.class;
    }
}