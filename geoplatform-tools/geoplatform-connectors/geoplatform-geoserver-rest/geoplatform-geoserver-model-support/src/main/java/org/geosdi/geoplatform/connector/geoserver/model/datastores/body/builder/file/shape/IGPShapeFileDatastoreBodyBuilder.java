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
package org.geosdi.geoplatform.connector.geoserver.model.datastores.body.builder.file.shape;

import com.google.common.base.Preconditions;
import io.reactivex.rxjava3.core.Flowable;
import org.geosdi.geoplatform.connector.geoserver.model.connection.key.IGPGeoserverConnectionKey;
import org.geosdi.geoplatform.connector.geoserver.model.connection.key.file.shape.GPGeoserverConnectionShapeFileValues;
import org.geosdi.geoplatform.connector.geoserver.model.datastores.GeoserverDatastoreType;
import org.geosdi.geoplatform.connector.geoserver.model.datastores.body.builder.file.GPGeoserverDatastoreBodyFileBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.meta.When;
import java.util.List;
import java.util.Objects;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface IGPShapeFileDatastoreBodyBuilder extends GPGeoserverDatastoreBodyFileBuilder<IGPShapeFileDatastoreBodyBuilder> {

    /**
     * <p>URL to a .shp file.</p>
     *
     * @param theUrl
     * @return {@link IGPShapeFileDatastoreBodyBuilder}
     */
    IGPShapeFileDatastoreBodyBuilder withUrl(@Nonnull(when = When.NEVER) java.net.URL theUrl);

    class GPShapeFileDatastoreBodyBuilder extends GeoserverDatastoreBodyFileBuilder<IGPShapeFileDatastoreBodyBuilder> implements IGPShapeFileDatastoreBodyBuilder {

        private static final Logger logger = LoggerFactory.getLogger(GPShapeFileDatastoreBodyBuilder.class);

        static {
            defaultValues = GPGeoserverConnectionShapeFileValues.defaultValues();
            requiredValues = GPGeoserverConnectionShapeFileValues.requiredValues();
        }

        private static final List<IGPGeoserverConnectionKey> defaultValues;
        private static final List<IGPGeoserverConnectionKey> requiredValues;

        GPShapeFileDatastoreBodyBuilder() {
            super(GeoserverDatastoreType.SHAPEFILE);
        }

        /**
         * @return {@link IGPShapeFileDatastoreBodyBuilder}
         */
        public static IGPShapeFileDatastoreBodyBuilder shapeFileDatastoreBodyBuilder() {
            return new GPShapeFileDatastoreBodyBuilder().injectDefaultValues();
        }

        /**
         * <p>URL to a .shp file.</p>
         *
         * @param theUrl
         * @return {@link IGPShapeFileDatastoreBodyBuilder}
         */
        @Override
        public IGPShapeFileDatastoreBodyBuilder withUrl(@Nonnull(when = When.NEVER) java.net.URL theUrl) {
            this.connectionParameters.compute(
                    GPGeoserverConnectionShapeFileValues.URL.getConnectionKey(), (k, v) -> (theUrl != null) ? theUrl.toString() : v);
            return self();
        }

        /**
         * @throws Exception
         */
        @Override
        protected void checkConnectionParameters() throws Exception {
            for (IGPGeoserverConnectionKey connectionKey : requiredValues) {
                logger.trace("@@@@@@@@@@@@@@@@@@@@@@@@@{} tries to check if : {} is present in connectionParameters.", this, connectionKey);
                String value = this.connectionParameters.get(connectionKey.getConnectionKey());
                Preconditions.checkArgument((value != null) && !(value.trim().isEmpty()), "For the Key : " + connectionKey.getConnectionKey()
                        + ", the value must not be null or an empty string.");
            }
        }

        /**
         * @return {@link IGPShapeFileDatastoreBodyBuilder}
         */
        @Override
        protected final IGPShapeFileDatastoreBodyBuilder injectDefaultValues() {
            Flowable.fromArray(defaultValues.stream().toArray(IGPGeoserverConnectionKey[]::new))
                    .filter(Objects::nonNull)
                    .blockingSubscribe(v -> this.connectionParameters.put(v.getConnectionKey(), v.getDefaultValue().toString()), Throwable::printStackTrace);
            return self();
        }
    }
}