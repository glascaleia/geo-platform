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
package org.geosdi.geoplatform.support.jackson.property;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Boolean.TRUE;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public enum GPJsonIncludeFeature implements JacksonSupportConfigFeature<JsonInclude.Include> {

    ALWAYS(TRUE) {
        /**
         * @return {@link JsonInclude.Include}
         */
        @Override
        public JsonInclude.Include getFeature() {
            return JsonInclude.Include.ALWAYS;
        }

        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.setSerializationInclusion(getFeature());
        }
    }, NON_NULL(TRUE) {
        /**
         * @return {@link JsonInclude.Include}
         */
        @Override
        public JsonInclude.Include getFeature() {
            return JsonInclude.Include.NON_NULL;
        }

        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.setSerializationInclusion(getFeature());
        }
    }, NON_ABSENT(TRUE) {
        /**
         * @return {@link JsonInclude.Include}
         */
        @Override
        public JsonInclude.Include getFeature() {
            return JsonInclude.Include.NON_ABSENT;
        }

        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.setSerializationInclusion(getFeature());
        }
    }, NON_EMPTY(TRUE) {
        /**
         * @return {@link JsonInclude.Include}
         */
        @Override
        public JsonInclude.Include getFeature() {
            return JsonInclude.Include.NON_EMPTY;
        }

        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.setSerializationInclusion(getFeature());
        }
    }, NON_DEFAULT(TRUE) {
        /**
         * @return {@link JsonInclude.Include}
         */
        @Override
        public JsonInclude.Include getFeature() {
            return JsonInclude.Include.NON_DEFAULT;
        }

        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.setSerializationInclusion(getFeature());
        }
    }, USE_DEFAULTS(TRUE) {
        /**
         * @return {@link JsonInclude.Include}
         */
        @Override
        public JsonInclude.Include getFeature() {
            return JsonInclude.Include.USE_DEFAULTS;
        }

        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.setSerializationInclusion(getFeature());
        }
    };

    private final Boolean state;

    /**
     * @param theState
     */
    GPJsonIncludeFeature(@Nonnull(when = NEVER) Boolean theState) {
        checkArgument(theState != null, "The Parameter state must not be null.");
        this.state = theState;
    }

    /**
     * @return {@link Boolean}
     */
    @Override
    public Boolean getValue() {
        return this.state;
    }
}