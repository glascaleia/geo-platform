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
package org.geosdi.geoplatform.geoserver.extensions.importer;

import it.geosolutions.geoserver.rest.manager.GeoServerRESTImporterManager;
import net.sf.json.JSONObject;
import org.geosdi.geoplatform.geoserver.GeoserverConnectorTest;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.File;

import static java.io.File.separator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public class GeoserverConnectorImporterTest extends GeoserverConnectorTest {

    static final Logger logger = LoggerFactory.getLogger(GeoserverConnectorImporterTest.class);
    //
    @Resource(name = "geoServerRestImporterManager")
    private GeoServerRESTImporterManager geoServerRestImporterManager;

    @Test
   // @Ignore
    public void a_importerFile() throws Exception {

        File file = new File(of("src", "test", "resources", "topp-tasmania_cities_importer.kml").collect(joining(separator)));
        logger.info("############FILE: {}\n", file.getAbsolutePath() );
        Assert.assertTrue("#################FILE_EXSIST", file.exists());

//        String jsonData = "{" +
//                " \"targetWorkspace\": {\n" +
//                " \"workspace\": {\n" +
//                " \"name\": \" sf \"\n" +
//                " }\n" +
//                " },\n" +
//                " \"data\": {\n" +
//                " \"type\": \"file\",\n" +
//                " \"format\": \"KML\", \n" +
//                " \"file\": \"" + file.getAbsolutePath() + "\"\n" +
//                " }\n" +
//                " }\n" +
//                "}";

        String jsonData = "{\n" +
                " \"import\": {\n" +
                " \"targetWorkspace\": {\n" +
                " \"workspace\": {\n" +
                " \"name\": \"ws_vito\"\n" +
                " }\n" +
                " },\n" +
                "\"targetStore\": {\n" +
                " \"dataStore\": {\n" +
                " \"name\": \"ds_vito\"\n" +
                " }\n" +
                " },\n" +
                " \"data\": {\n" +
                " \"type\": \"file\",\n" +
                " \"file\": \"/home/geosdi/layer_importer1.kml\"\n" +
                " }\n" +
                " }\n" +
                "}";
    logger.info("#########JSON_DATA: {}\n", jsonData);

        int i = this.geoServerRestImporterManager.postNewImport(jsonData);
        logger.info("###############i:{}\n", i);
        JSONObject importObject = this.geoServerRestImporterManager.getImport(i);
        logger.info("###############RESPONSE:{}\n", importObject);

        JSONObject tasks = importObject.getJSONArray("tasks").getJSONObject(0);
        logger.info("#################{}\n", tasks);
        int t = tasks.getInt("id");
        logger.info("############t:{}\n", t);
        JSONObject layer = this.geoServerRestImporterManager.getLayer(i, t);
        logger.info("#####################LAYER: {}\n\n\n", layer);
        geoServerRestImporterManager.postImport(i);
    }
}