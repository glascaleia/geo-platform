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
package org.geosdi.geoplatform.gui.server.command.layer.basic;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.geosdi.geoplatform.gui.client.command.layer.basic.LoadProjectRequest;
import org.geosdi.geoplatform.gui.client.command.layer.basic.LoadProjectResponse;
import org.geosdi.geoplatform.gui.command.server.GPCommand;
import org.geosdi.geoplatform.gui.configuration.map.client.layer.GPFolderClientInfo;
import org.geosdi.geoplatform.gui.server.ILayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
@Lazy(true)
@Component(value = "command.layer.basic.LoadProjectCommand")
public class LoadProjectCommand implements
        GPCommand<LoadProjectRequest, LoadProjectResponse> {

    private static final Logger logger = LoggerFactory.getLogger(
            LoadProjectCommand.class);
    //
    @Autowired
    private ILayerService layerService;

    @Override
    public LoadProjectResponse execute(
            LoadProjectRequest request,
            HttpServletRequest httpServletRequest) {

        logger.debug("##################### Executing {} Command", this.
                getClass().getSimpleName());

        logger.debug("Project id: " + request.getProjectId());

        ArrayList<GPFolderClientInfo> result = this.layerService.loadProject(request.getProjectId(),
                httpServletRequest);

        logger.debug("#################### Found {} ", result);

        return new LoadProjectResponse(result);
    }
}
