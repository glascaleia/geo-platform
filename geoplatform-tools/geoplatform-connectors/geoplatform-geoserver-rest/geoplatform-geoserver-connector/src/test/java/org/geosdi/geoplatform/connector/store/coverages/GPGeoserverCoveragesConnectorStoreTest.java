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
package org.geosdi.geoplatform.connector.store.coverages;

import org.geosdi.geoplatform.connector.geoserver.request.workspaces.coverages.GeoserverLoadCoverageRequest;
import org.geosdi.geoplatform.connector.geoserver.request.workspaces.coverages.GeoserverLoadCoveragesRequest;
import org.geosdi.geoplatform.connector.geoserver.request.workspaces.coverages.GeoserverLoadStoreCoverageRequest;
import org.geosdi.geoplatform.connector.geoserver.request.workspaces.coverages.GeoserverResetCoverageCacheRequest;
import org.geosdi.geoplatform.connector.store.GPBaseGeoserverConnectorStoreTest;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(NAME_ASCENDING)
public class GPGeoserverCoveragesConnectorStoreTest extends GPBaseGeoserverConnectorStoreTest {

    @Test
    public void a_loadWorkspaceCoveragesTest() throws Exception {
        GeoserverLoadCoveragesRequest loadCoveragesRequest = geoserverConnectorStoreV2_27_x.loadWorkspaceCoveragesRequest();
        loadCoveragesRequest.withWorkspace("topp");
        logger.info("########################WORKSPACE_COVERAGES_RESPONSE : {}\n", loadCoveragesRequest.getResponse());
    }

    @Test
    public void b_loadAllCoveragesTest() throws Exception {
        GeoserverLoadCoveragesRequest loadCoveragesRequest = geoserverConnectorStoreV2_27_x.loadWorkspaceCoveragesRequest();
        loadCoveragesRequest.withWorkspace("topp").withQueryList("ALL");
        logger.info("########################ALL_COVERAGES_RESPONSE : {}\n", loadCoveragesRequest.getResponse());
    }

    @Test
    public void c_loadCoverageTest() throws Exception {
        GeoserverLoadCoverageRequest loadCoverageRequest = geoserverConnectorStoreV2_27_x.loadWorkspaceCoverageRequest();
        loadCoverageRequest.withWorkspace("sf").withCoverage("sfdem");
        logger.info("#######################LOAD_WORKSPACE_COVERAGE_RESPONSE : {}\n", loadCoverageRequest.getResponse());
    }

    @Test
    public void d_loadWorkspaceStoreCoverageTest() throws Exception {
        GeoserverLoadStoreCoverageRequest loadCoverageRequest = geoserverConnectorStoreV2_27_x.loadWorkspaceStoreCoverageRequest();
        loadCoverageRequest.withWorkspace("sf").withCoverage("sfdem").withStore("sfdem");
        logger.info("#######################LOAD_WORKSPACE_STORE_COVERAGE_RESPONSE : {}\n", loadCoverageRequest.getResponse());
    }

    @Test
    public void e_resetCoverageCacheTest() throws Exception {
        GeoserverResetCoverageCacheRequest resetCoverageCacheRequest = geoserverConnectorStoreV2_27_x.resetCoverageCacheRequest();
        logger.info("#######################RESET_COVERAGE_CACHE_RESPONSE : {}\n", resetCoverageCacheRequest.withWorkspace("sf")
                .withCoverage("sfdem").withStore("sfdem").getResponse());
    }
}