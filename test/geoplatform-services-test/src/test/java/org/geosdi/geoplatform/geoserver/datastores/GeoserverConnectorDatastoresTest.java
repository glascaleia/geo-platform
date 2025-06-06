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
package org.geosdi.geoplatform.geoserver.datastores;

import it.geosolutions.geoserver.rest.GeoServerRESTPublisher;
import it.geosolutions.geoserver.rest.decoder.RESTDataStoreList;
import it.geosolutions.geoserver.rest.encoder.datastore.GSPostGISDatastoreEncoder;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.io.FilenameUtils;
import org.geosdi.geoplatform.connector.geoserver.model.datastores.GPGeoserverLoadDatastores;
import org.geosdi.geoplatform.connector.geoserver.model.datastores.body.IGPGeoserverCreateDatastoreBody;
import org.geosdi.geoplatform.connector.geoserver.model.featuretypes.GPGeoserverFeatureTypeInfo;
import org.geosdi.geoplatform.connector.geoserver.model.file.GPGeoserverDataStoreFileExtension;
import org.geosdi.geoplatform.connector.geoserver.model.layers.vector.GeoserverVectorLayer;
import org.geosdi.geoplatform.connector.geoserver.model.styles.GPGeoserverStyle;
import org.geosdi.geoplatform.connector.geoserver.model.upload.GPGeoserverUploadMethod;
import org.geosdi.geoplatform.connector.geoserver.request.datastores.GeoserverLoadDatastoresRequest;
import org.geosdi.geoplatform.geoserver.GeoserverConnectorTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static java.io.File.separator;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;
import static org.geosdi.geoplatform.connector.geoserver.model.datastores.body.builder.db.postgis.IGPPostgisDatastoreBodyBuilder.GPPostgisDatastoreBodyBuilder.postgisDatastoreBodyBuilder;
import static org.geosdi.geoplatform.connector.geoserver.model.datastores.body.builder.db.postgis.jndi.IGPPostgisJndiDatastoreBuilder.GPPostgisJndiDatastoreBuilder.postgisJndiDatastoreBuilder;
import static org.geosdi.geoplatform.connector.geoserver.model.projection.GPProjectionPolicy.FORCE_DECLARED;
import static org.junit.Assert.assertTrue;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public class GeoserverConnectorDatastoresTest extends GeoserverConnectorTest {

    static final Logger logger = LoggerFactory.getLogger(GeoserverConnectorDatastoresTest.class);
    //
    private @Value("configurator{host_postgis_datastore_publisher}")
    String hostPostgisDatastore;
    private @Value("configurator{port_postgis_datastore_publisher}")
    int portPostgisDatastore;
    private @Value("configurator{min_connections_postgis_datastore_publisher}")
    int minConnectionsPostgisDatastore;
    private @Value("configurator{max_connections_postgis_datastore_publisher}")
    int maxConnectionsPostgisDatastore;
    private @Value("configurator{timeout_connections_postgis_datastore_publisher}")
    int timeoutConnectionsPostgisDatastore;
    private @Value("configurator{db_name_postgis_datastore_publisher}")
    String dbNamePostgisDatastore;
    private @Value("configurator{username_db_postgis_datastore_publisher}")
    String userNameDBPostgisDatastore;
    private @Value("configurator{password_db_postgis_datastore_publisher}")
    String passwordDBPostgisDatastore;

    @Test
    public void a_getDataStores() throws Exception {
        RESTDataStoreList store = restReader.getDatastores("tiger");
        GeoserverLoadDatastoresRequest gpGeoserverLoadDatastoresRequest = this.geoserverConnectorStore.loadDatastoresRequest().withWorkspaceName("tiger");
        GPGeoserverLoadDatastores gpGeoserverLoadDatastores = gpGeoserverLoadDatastoresRequest.getResponse();
        assertTrue("#####################", store.getNames().size() == gpGeoserverLoadDatastores.getDataStores().size());
        logger.info("##########################DATA_STORES: {}\n", gpGeoserverLoadDatastoresRequest.getResponse().getDataStores());
        logger.info("##########################DATA_STORES: {}\n", store.getNames());
        List<String> names = gpGeoserverLoadDatastores.getDataStores().stream()
                .map(c -> c.getName()).collect(Collectors.toList());
        store.getNames().stream().forEach(n -> assertTrue("##################", names.contains(n)));
    }

    @Test
    public void b_existDatastores() throws Exception {
        assertTrue("####################", this.restReader.existsDatastore("tiger", "nyc", TRUE) ==
                this.geoserverConnectorStore.loadDatastoreRequest().withWorkspaceName("tiger").withStoreName("nyc").withQuietNotFound(TRUE).exist());
        assertTrue("####################", this.restReader.existsDatastore("tiger", "nycc", TRUE) ==
                this.geoserverConnectorStore.loadDatastoreRequest().withWorkspaceName("tiger").withStoreName("nycc").withQuietNotFound(TRUE).exist());
    }

    @Ignore(value = "Store store_vito may be not present")
    @Test
    public void c_deleteDatastore() throws Exception {
        assertTrue("####################", this.geoserverConnectorStore.loadDatastoreRequest().withWorkspaceName("sf").withStoreName("store_vito").withQuietNotFound(TRUE).exist());
        this.geoserverConnectorStore.deleteDatastoreRequest().withDatastoreName("store_vito").withWorkspaceName("sf").withRecurse(TRUE).getResponse();
        Assert.assertFalse("####################", this.geoserverConnectorStore.loadDatastoreRequest().withWorkspaceName("sf").withStoreName("store_vito").withQuietNotFound(TRUE).exist());
    }

    @Ignore
    @Test
    public void e_testRest() throws Exception {
        NameValuePair[] params = new NameValuePair[1];
        NameValuePair nameValuePair = new NameValuePair("charset", "UTF-8");
        params[0] = nameValuePair;
        File file = new File(of("src", "test", "resources", "admin_shp_comuni.zip").collect(joining(separator)));

        this.restPublisher.publishShp("sf", "store_vito", params, "admin_shp_comuni", GeoServerRESTPublisher.UploadMethod.FILE,
                        file.toURI(), "EPSG:32633", "burg");
    }

    @Ignore
    @Test
    public void d_updateDataStoreWithShape() throws Exception {
        File file = new File(of("src", "test", "resources", "admin_shp_comuni.zip").collect(joining(separator)));
        assertTrue("#################FILE_EXSIST", file.exists());
        logger.info("#############FILE: {}\n", file.toURI());
        logger.info("##################{}\n", FilenameUtils.getBaseName(file.toURI().toString()));
        if (this.geoserverConnectorStore.dataStoreUploadFiles().withWorkspace("sf").withStore("store_vito")
                .withMethod(GPGeoserverUploadMethod.FILE)
                //.withConfigure(GPGeoserverParameterConfigure.FIRST)
                .withCharset("UTF-8").withFormat(GPGeoserverDataStoreFileExtension.SHP).withFileName("admin_shp_comuni")
                .withFile(file).getResponse()) {
            logger.info("############ERRO TO CREATE STORE");
        }
        GPGeoserverFeatureTypeInfo gpGeoserverFeatureTypeInfo = new GPGeoserverFeatureTypeInfo();
        gpGeoserverFeatureTypeInfo.setName("admin_shp_comuni");
        gpGeoserverFeatureTypeInfo.setTitle("admin_shp_comuni");
        gpGeoserverFeatureTypeInfo.setEnabled(TRUE);
        gpGeoserverFeatureTypeInfo.setProjectionPolicy(FORCE_DECLARED);

        String srs = "EPSG:32633";
        boolean srsNull = !(srs != null && srs.length() != 0);
        if (!srsNull) {
            gpGeoserverFeatureTypeInfo.setSrs(srs);
        } else {
            // this under the assumption that when the destination srs is null the nativeCRS has an EPSG one so we force them to be the same
            gpGeoserverFeatureTypeInfo.setNativeCRS(null);
        }
        logger.info("###############{}\n", this.geoserverConnectorStore.updateFeatureTypeRequest()
                .withWorkspace("sf")
                .withFeatureTypeBody(gpGeoserverFeatureTypeInfo)
                .withStore("store_vito")
                .withFeatureName("admin_shp_comuni")
                .getResponse());
        String defaultStyle = "polygon";
        GeoserverVectorLayer geoserverRasterLayer = new GeoserverVectorLayer();
        GPGeoserverStyle gpGeoserverStyle = new GPGeoserverStyle();
        gpGeoserverStyle.setName(defaultStyle.indexOf(":") != -1 ? defaultStyle.split(":")[0] : defaultStyle);
        geoserverRasterLayer.setDefaultStyle(gpGeoserverStyle);
        logger.info("##############{}\n", this.geoserverConnectorStore.updateLayerRequest().withWorkspaceName("sf").withLayerName("admin_shp_comuni").withLayerBody(geoserverRasterLayer).getResponse());
    }

    @Ignore
    @Test
    public void e_deleteFeature() throws Exception {
        logger.info("##############{}\n", this.geoserverConnectorStore.deleteFeatureTypeRequest()
                .withWorkspace("sf")
                .withStore("store_vito")
                .withRecurse(TRUE)
                .withFeatureTypeName("admin_shp_comuni").getResponse());
    }

    @Ignore
    @Test
    public void f_createDatastore() throws Exception {
        logger.info("###################{}\n", this.geoserverConnectorStore.createDatastoreRequest()
                .withWorkspaceName("sf")
                .withDatastoreBody(postgisDatastoreBodyBuilder()
                        .withName("store_vito")
                        .withHost(hostPostgisDatastore)
                        .withPort(portPostgisDatastore)
                        .withDatabase(dbNamePostgisDatastore)
                        .withSchema("public")
                        .withUser(userNameDBPostgisDatastore)
                        .withPassword(passwordDBPostgisDatastore)
                        .withExposePrimaryKeys(FALSE)
                        .withMaxConnections(maxConnectionsPostgisDatastore)
                        .withMinConnections(minConnectionsPostgisDatastore)
                        .withConnectionTimeout(timeoutConnectionsPostgisDatastore)
                        .withFetchSize(1000)
                        .withValidateConnections(Boolean.TRUE)
                        .withLooseBbox(Boolean.TRUE)
                        .withMaxOpenPreparedStatements(50).build()).getResponseAsString());
    }

    @Ignore
    @Test
    public void g_createPostgisDatastore() throws Exception {
        GSPostGISDatastoreEncoder postGISDatastoreEncoder = new GSPostGISDatastoreEncoder("ws_vito");
        postGISDatastoreEncoder.setJndiReferenceName("java:comp/env/jdbc/postgres_layerbuilder");
        postGISDatastoreEncoder.setLooseBBox(Boolean.TRUE);
        postGISDatastoreEncoder.setEstimatedExtends(Boolean.TRUE);
        postGISDatastoreEncoder.setEnabled(Boolean.TRUE);
        logger.info("############{}\n", postGISDatastoreEncoder);

        IGPGeoserverCreateDatastoreBody createDatastoreBody = postgisJndiDatastoreBuilder()
                .withName("ws_vito")
                .withJndiReferenceName("java:comp/env/jdbc/postgres_layerbuilder")
                .withLooseBbox(TRUE)
                .withEstimatedExtends(TRUE)
                .withEnabled(TRUE)
                .withFetchSize(1000)
                .withPreparedStatements(FALSE)
                .withEstimatedExtends(FALSE).build();
        logger.info("#################\n{}", createDatastoreBody);
    }

}