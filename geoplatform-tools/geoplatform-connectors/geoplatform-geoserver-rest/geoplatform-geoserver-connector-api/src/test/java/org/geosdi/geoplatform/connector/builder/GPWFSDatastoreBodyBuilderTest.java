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
package org.geosdi.geoplatform.connector.builder;

import org.geosdi.geoplatform.connector.geoserver.model.datastores.body.IGPGeoserverCreateDatastoreBody;
import org.geosdi.geoplatform.support.jackson.GPJacksonSupport;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import static org.geosdi.geoplatform.connector.geoserver.model.datastores.body.builder.wfs.IGPWFSDatastoreBodyBuilder.GPWFSDatastoreBodyBuilder.wfsDatastoreBodyBuilder;
import static org.geosdi.geoplatform.support.jackson.property.GPJacksonSupportEnum.*;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class GPWFSDatastoreBodyBuilderTest {

    private static final Logger logger = LoggerFactory.getLogger(GPWFSDatastoreBodyBuilderTest.class);
    //
    private static final JacksonSupport jacksonSupport = new GPJacksonSupport(UNWRAP_ROOT_VALUE_ENABLE,
            FAIL_ON_UNKNOW_PROPERTIES_DISABLE,
            ACCEPT_SINGLE_VALUE_AS_ARRAY_ENABLE,
            WRAP_ROOT_VALUE_ENABLE,
            INDENT_OUTPUT_ENABLE);

    @Test
    public void a_buildWFSDatastoreTest() throws Exception {
        IGPGeoserverCreateDatastoreBody createDatastoreBody = wfsDatastoreBodyBuilder()
                .withName("DATASTORE_TEST")
                .withWFSGetCapabilitiesUrl(new URL("http://150.145.141.92/geoserver/ows?service=wfs&version=1.1.0&request=GetCapabilities"))
                .build();
        logger.info("###########################GEOSERVER_CREATE_DATASTORE_BODY : \n{}\n", jacksonSupport
                .getDefaultMapper().writeValueAsString(createDatastoreBody));
    }

    @Test(expected = IllegalArgumentException.class)
    public void b_buildWFSDatastoreTest() throws Exception {
        IGPGeoserverCreateDatastoreBody createDatastoreBody = wfsDatastoreBodyBuilder()
                .withName("DATASTORE_TEST_1")
                .build();
        logger.info("###########################GEOSERVER_CREATE_DATASTORE_BODY : \n{}\n", jacksonSupport
                .getDefaultMapper().writeValueAsString(createDatastoreBody));
    }
}