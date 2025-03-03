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
package org.geosdi.geoplatform.connector.wms.bridge.store;

import org.geosdi.geoplatform.connector.bridge.implementor.GPWMSGetFeatureInfoReader;
import org.geosdi.geoplatform.connector.bridge.store.GPWMSGetFeatureInfoReaderStore;
import org.geosdi.geoplatform.connector.bridge.store.WMSGetFeatureInfoReaderStore;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.geosdi.geoplatform.connector.server.request.WMSFeatureInfoFormat.*;
import static org.geosdi.geoplatform.connector.wms.bridge.implementor.GPWMSGetFeatureInfoMockReader.MOCK_FORMAT;
import static org.junit.Assert.assertNotNull;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class GPWMSGetFeatureInfoReaderStoreTest {

    private static final Logger logger = LoggerFactory.getLogger(GPWMSGetFeatureInfoReaderStoreTest.class);
    //
    private static final WMSGetFeatureInfoReaderStore store = new GPWMSGetFeatureInfoReaderStore();

    @Test
    public void a_loadWMSGetFeatureReaderASTextPlainTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> textPlainGetFeatureReader = store.getImplementorByKey(TEXT_PLAIN);
        assertNotNull(textPlainGetFeatureReader);
        logger.info("################################TEXT_PLAIN_READER : {}\n", textPlainGetFeatureReader);
    }

    @Test
    public void b_loadWMSGetFeatureReaderASTextHtmlTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> textHtmlGetFeatureReader = store.getImplementorByKey(TEXT_HTML);
        assertNotNull(textHtmlGetFeatureReader);
        logger.info("################################TEXT_HTML_READER : {}\n", textHtmlGetFeatureReader);
    }

    @Test
    public void c_loadWMSGetFeatureReaderASJsonTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> jsonGetFeatureReader = store.getImplementorByKey(JSON);
        assertNotNull(jsonGetFeatureReader);
        logger.info("################################JSON_READER : {}\n", jsonGetFeatureReader);
    }

    @Test
    public void d_loadWMSGetFeatureReaderASGml2Test() throws Exception {
        GPWMSGetFeatureInfoReader<?> gml2GetFeatureReader = store.getImplementorByKey(GML2);
        assertNotNull(gml2GetFeatureReader);
        logger.info("################################GML2_READER : {}\n", gml2GetFeatureReader);
    }

    @Test
    public void e_loadWMSGetFeatureReaderASGml2StringTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> gml2GetFeatureReader = store.getImplementorByKey(GML2_AS_STRING);
        assertNotNull(gml2GetFeatureReader);
        logger.info("################################GML2_STRING_READER : {}\n", gml2GetFeatureReader);
    }

    @Test
    public void f_loadWMSGetFeatureReaderASGml2StoreTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> gml2GetFeatureReader = store.getImplementorByKey(GML2_AS_STORE);
        assertNotNull(gml2GetFeatureReader);
        logger.info("################################GML2_STORE_READER : {}\n", gml2GetFeatureReader);
    }

    @Test
    public void g_loadWMSGetFeatureReaderASGmlStoreTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> mockGetFeatureReader = store.getImplementorByKey(MOCK_FORMAT);
        assertNotNull(mockGetFeatureReader);
        logger.info("################################MOCK_STORE_READER : {}\n", mockGetFeatureReader);
    }

    @Test
    public void h_loadWMSGetFeatureReaderASGml3Test() throws Exception {
        GPWMSGetFeatureInfoReader<?> gml3GetFeatureReader = store.getImplementorByKey(GML3);
        assertNotNull(gml3GetFeatureReader);
        logger.info("################################GML3_READER : {}\n", gml3GetFeatureReader);
    }

    @Test
    public void i_loadWMSGetFeatureReaderASGml3StringTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> gml3GetFeatureReader = store.getImplementorByKey(GML3_AS_STRING);
        assertNotNull(gml3GetFeatureReader);
        logger.info("################################GML3_STRING_READER : {}\n", gml3GetFeatureReader);
    }

    @Test
    public void l_loadWMSGetFeatureReaderASGml3StoreTest() throws Exception {
        GPWMSGetFeatureInfoReader<?> gml3GetFeatureReader = store.getImplementorByKey(GML3_AS_STORE);
        assertNotNull(gml3GetFeatureReader);
        logger.info("################################GML3_STORE_READER : {}\n", gml3GetFeatureReader);
    }
}