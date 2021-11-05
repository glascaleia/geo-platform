/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2020 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.connector.geoserver.model.uri;

import com.google.common.base.Preconditions;
import io.reactivex.rxjava3.functions.Consumer;
import org.apache.hc.core5.net.URIBuilder;

import javax.annotation.Nonnull;
import javax.annotation.meta.When;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GeoserverRXQueryParamConsumer<B extends GPGeoserverQueryParam> implements Consumer<ThreadLocal<B>> {

    private final URIBuilder uriBuilder;

    /**
     * @param theUriBuilder
     */
    public GeoserverRXQueryParamConsumer(@Nonnull(when = When.NEVER) URIBuilder theUriBuilder) {
        Preconditions.checkArgument(theUriBuilder != null, "The Parameter uriBuilder must not be null.");
        this.uriBuilder = theUriBuilder;
    }

    /**
     * Consume the given value.
     *
     * @param queryParam the value
     * @throws Throwable if the implementation wishes to throw any type of exception
     */
    @Override
    public void accept(ThreadLocal<B> queryParam) throws Throwable {
        queryParam.get().addQueryParam(this.uriBuilder);
    }
}