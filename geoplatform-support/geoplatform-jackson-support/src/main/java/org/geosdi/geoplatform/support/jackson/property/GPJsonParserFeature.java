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

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Nonnull;

import static com.fasterxml.jackson.core.json.JsonReadFeature.*;
import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public enum GPJsonParserFeature implements JacksonSupportConfigFeature<Feature> {

    AUTO_CLOSE_SOURCE_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return Feature.AUTO_CLOSE_SOURCE;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, AUTO_CLOSE_SOURCE_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return Feature.AUTO_CLOSE_SOURCE;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_COMMENTS_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_COMMENTS;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_COMMENTS_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_COMMENTS;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_YAML_COMMENTS_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_YAML_COMMENTS;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_YAML_COMMENTS_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_YAML_COMMENTS;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_UNQUOTED_FIELD_NAMES_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_UNQUOTED_FIELD_NAMES;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_UNQUOTED_FIELD_NAMES_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_UNQUOTED_FIELD_NAMES;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_SINGLE_QUOTES_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_SINGLE_QUOTES;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_SINGLE_QUOTES_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return Feature.ALLOW_SINGLE_QUOTES;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_UNQUOTED_CONTROL_CHARS_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_UNQUOTED_CONTROL_CHARS_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_NUMERIC_LEADING_ZEROS_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_NUMERIC_LEADING_ZEROS_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_NON_NUMERIC_NUMBERS_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return ALLOW_NON_NUMERIC_NUMBERS.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, ALLOW_NON_NUMERIC_NUMBERS_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return ALLOW_NON_NUMERIC_NUMBERS.mappedFeature();
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, STRICT_DUPLICATE_DETECTION_ENABLE(TRUE) {
        @Override
        public Feature getFeature() {
            return Feature.STRICT_DUPLICATE_DETECTION;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

    }, STRICT_DUPLICATE_DETECTION_DISABLE(FALSE) {
        @Override
        public Feature getFeature() {
            return Feature.STRICT_DUPLICATE_DETECTION;
        }

        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }
    }, USE_FAST_DOUBLE_PARSER_ENABLE(TRUE) {
        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(getFeature(), getValue());
        }

        /**
         * @return {@link Feature}
         */
        @Override
        public Feature getFeature() {
            return Feature.USE_FAST_DOUBLE_PARSER;
        }
    }, USE_FAST_DOUBLE_PARSER_DISABLE(FALSE) {
        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(this.getFeature(), this.getValue());
        }

        /**
         * @return {@link Feature}
         */
        @Override
        public Feature getFeature() {
            return Feature.USE_FAST_DOUBLE_PARSER;
        }
    }, USE_FAST_BIG_NUMBER_PARSER_ENABLE(TRUE) {
        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(this.getFeature(), this.getValue());
        }

        /**
         * @return {@link Feature}
         */
        @Override
        public Feature getFeature() {
            return Feature.USE_FAST_BIG_NUMBER_PARSER;
        }
    }, USE_FAST_BIG_NUMBER_PARSER_DISABLE(FALSE) {
        /**
         * @param mapper
         */
        @Override
        public void configureMapper(ObjectMapper mapper) {
            mapper.configure(this.getFeature(), this.getValue());
        }

        /**
         * @return {@link Feature}
         */
        @Override
        public Feature getFeature() {
            return Feature.USE_FAST_BIG_NUMBER_PARSER;
        }
    };

    private final Boolean state;

    /**
     * @param theState
     */
    GPJsonParserFeature(@Nonnull(when = NEVER) Boolean theState) {
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