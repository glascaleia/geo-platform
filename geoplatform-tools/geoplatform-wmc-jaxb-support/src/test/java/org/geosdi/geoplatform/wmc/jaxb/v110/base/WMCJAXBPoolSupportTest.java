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
package org.geosdi.geoplatform.wmc.jaxb.v110.base;

import org.geosdi.geoplatform.wmc.support.v110.jaxb.context.pool.WMCJAXBContextPoolV110;
import org.geosdi.geoplatform.wmc.support.v110.jaxb.repository.WMCJAXBContextSupport;
import org.geosdi.geoplatform.xml.wmc.v110.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.stream.Collectors;

import static java.io.File.separator;
import static java.lang.String.join;
import static java.util.stream.Stream.of;
import static org.geosdi.geoplatform.wmc.support.v110.jaxb.repository.WMCJAXBContextProviderPoolV110.WMC_CONTEXT_POOL_KEY_V110;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class WMCJAXBPoolSupportTest {

    static {
        wmcJAXBContextPool = WMCJAXBContextSupport.getProvider(WMC_CONTEXT_POOL_KEY_V110);
    }

    private static final Logger logger = LoggerFactory.getLogger(WMCJAXBPoolSupportTest.class);
    //
    private final static WMCJAXBContextPoolV110 wmcJAXBContextPool;
    private static File wmcFile;
    private static File wmc1File;
    private static File wmc2File;
    private static File wmcLayerListFile;
    private static File wmcGeneralTypeFile;
    private static File wmcFormatListFile;
    private static File wmcStyleListFile;
    private static File wmcServerFile;
    private static File wmcLayerTypeFile;
    private static File wmcExtensionTypeFile;

    @BeforeClass
    public static void loadFile() throws Exception {
        String basePath = of(new File(".").getCanonicalPath(), "src", "test", "resources")
                .collect(Collectors.joining(separator));
        wmcFile = new File(join(separator, basePath, "WMC-v110.xml"));
        wmc1File = new File(join(separator, basePath, "WMC-1-v110.xml"));
        wmc2File = new File(join(separator, basePath, "WMC-1-v110.xml"));
        wmcLayerListFile = new File(join(separator, basePath, "WMCLayerTypeList-v110.xml"));
        wmcGeneralTypeFile = new File(join(separator, basePath, "WMCGeneralType-v110.xml"));
        wmcFormatListFile = new File(join(separator, basePath, "WMC-FormatList-v110.xml"));
        wmcStyleListFile = new File(join(separator, basePath, "WMC-StyleList-v110.xml"));
        wmcServerFile = new File(join(separator, basePath, "WMC-Server-v110.xml"));
        wmcLayerTypeFile = new File(join(separator, basePath, "WMCLayerType-v110.xml"));
        wmcExtensionTypeFile = new File(join(separator, basePath, "WMC-Extension-v110.xml"));
    }

    @Test
    public void a_wmcV110SupportPoolTest() throws Exception {
        ViewContextType viewContextType = wmcJAXBContextPool.unmarshal(wmcFile);
        logger.info("#####################{}\n", viewContextType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(viewContextType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void b_wmc1V110SupportPoolTest() throws Exception {
        ViewContextType viewContextType = wmcJAXBContextPool.unmarshal(wmc1File);
        logger.info("#####################{}\n", viewContextType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(viewContextType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void c_wmc2V110SupportPoolTest() throws Exception {
        ViewContextType viewContextType = wmcJAXBContextPool.unmarshal(wmc2File);
        logger.info("#####################{}\n", viewContextType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(viewContextType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void d_wmcGeneralTypeV110SupportPoolTest() throws Exception {
        GeneralType generalType = (GeneralType) wmcJAXBContextPool.unmarshal(wmcGeneralTypeFile);
        logger.info("#####################{}\n", generalType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(generalType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void e_wmcFormatListV110SupportPoolTest() throws Exception {
        FormatListType formatListType = (FormatListType) wmcJAXBContextPool.unmarshal(wmcFormatListFile);
        logger.info("#####################{}\n", formatListType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(formatListType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void f_wmcStyleListV110SupportPoolTest() throws Exception {
        StyleListType styleListType = (StyleListType) wmcJAXBContextPool.unmarshal(wmcStyleListFile);
        logger.info("#####################{}\n", styleListType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(styleListType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void g_wmcServerV110SupportPoolTest() throws Exception {
        ServerType serverType = (ServerType) wmcJAXBContextPool.unmarshal(wmcServerFile);
        logger.info("#####################{}\n", serverType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(serverType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void h_wmcLayerTypeV110SupportPoolTest() throws Exception {
        LayerType layerType = (LayerType) wmcJAXBContextPool.unmarshal(wmcLayerTypeFile);
        logger.info("#####################{}\n", layerType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(layerType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void i_wmcExtensionTypeV110SupportPoolTest() throws Exception {
        ExtensionType extensionType = (ExtensionType) wmcJAXBContextPool.unmarshal(wmcExtensionTypeFile);
        logger.info("#####################{}\n", extensionType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(extensionType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void l_wmcV110SupportPoolURLTest() throws Exception {
        ViewContextType viewContextType = wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMC-v110.xml"));
        logger.info("#####################{}\n", viewContextType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(viewContextType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void m_wmc1V110SupportPoolURLTest() throws Exception {
        ViewContextType viewContextType = wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMC-1-v110.xml"));
        logger.info("#####################{}\n", viewContextType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(viewContextType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void n_wmc2V110SupportPoolURLTest() throws Exception {
        ViewContextType viewContextType = wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMC-2-v110.xml"));
        logger.info("#####################{}\n", viewContextType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(viewContextType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Test
    public void o_wmcLayerListV110SupportPoolTest() throws Exception {
        LayerListType layerListType = (LayerListType) wmcJAXBContextPool.unmarshal(wmcLayerListFile);
        logger.info("#####################{}\n", layerListType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(layerListType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void p_wmcLayerListV110SupportPoolURLTest() throws Exception {
        LayerListType layerListType = (LayerListType) wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMCLayerTypeList-v110.xml"));
        logger.info("#####################{}\n", layerListType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(layerListType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void q_wmcGeneralTypeV110SupportPoolURLTest() throws Exception {
        GeneralType generalType = (GeneralType) wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMCGeneralType-v110.xml"));
        logger.info("#####################{}\n", generalType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(generalType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void r_wmcFormatListV110SupportPoolURLTest() throws Exception {
        FormatListType formatListType = (FormatListType) wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMC-FormatList-v110.xml"));
        logger.info("#####################{}\n", formatListType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(formatListType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void s_wmcStyleListV110SupportPoolURLTest() throws Exception {
        StyleListType styleListType = (StyleListType) wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMC-StyleList-v110.xml"));
        logger.info("#####################{}\n", styleListType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(styleListType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void t_wmcServerV110SupportPoolURLTest() throws Exception {
        ServerType serverType = (ServerType) wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMC-Server-v110.xml"));
        logger.info("#####################{}\n", serverType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(serverType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void u_wmcLayerTypeV110SupportPoolURLTest() throws Exception {
        LayerType layerType = (LayerType) wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMCLayerType-v110.xml"));
        logger.info("#####################{}\n", layerType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(layerType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }

    @Ignore(value = "Server is Down")
    @Test
    public void v_wmcExtensionTypeV110SupportPoolURLTest() throws Exception {
        ExtensionType extensionType = (ExtensionType) wmcJAXBContextPool
                .unmarshal(new URL("http://150.145.141.124/GONFALONI-Upload/WMC-Extension-v110.xml"));
        logger.info("#####################{}\n", extensionType);
        StringWriter writer = new StringWriter();
        wmcJAXBContextPool.marshal(extensionType, writer);
        logger.info("###########################\n{}\n\n", writer);
    }
}