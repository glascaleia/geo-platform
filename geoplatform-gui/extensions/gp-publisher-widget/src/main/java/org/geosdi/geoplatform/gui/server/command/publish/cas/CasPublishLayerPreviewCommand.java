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
package org.geosdi.geoplatform.gui.server.command.publish.cas;

import org.geosdi.geoplatform.exception.ResourceNotFoundFault;
import org.geosdi.geoplatform.gui.client.command.publish.basic.PublishLayerPreviewResponse;
import org.geosdi.geoplatform.gui.client.command.publish.cas.CasPublishLayerPreviewRequest;
import org.geosdi.geoplatform.gui.command.server.GPCommand;
import org.geosdi.geoplatform.gui.global.GeoPlatformException;
import org.geosdi.geoplatform.gui.server.SessionUtility;
import org.geosdi.geoplatform.gui.utility.GPReloadURLException;
import org.geosdi.geoplatform.gui.utility.GPSessionTimeout;
import org.geosdi.geoplatform.request.PublishLayersRequest;
import org.geosdi.geoplatform.services.GPPublisherBasicServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Lazy(true)
@Component(value = "command.publish.cas.CasPublishLayerPreviewCommand")
@Profile(value = "gs_cas")
public class CasPublishLayerPreviewCommand implements
        GPCommand<CasPublishLayerPreviewRequest, PublishLayerPreviewResponse> {

    private static final Logger logger = LoggerFactory.getLogger(
            CasPublishLayerPreviewCommand.class);
    private GPPublisherBasicServiceImpl casPublisherService;
    @Autowired
    private SessionUtility sessionUtility;

    @Override
    public PublishLayerPreviewResponse execute(CasPublishLayerPreviewRequest request,
            HttpServletRequest httpServletRequest) {
        try {
            sessionUtility.getLoggedAccount(httpServletRequest);
        } catch (GPSessionTimeout timeout) {
            throw new GeoPlatformException(timeout);
        }
        String result = null;
        try {
            List<String> layerList = request.getLayerList();
            casPublisherService.publishAll(new PublishLayersRequest(
                    httpServletRequest.getSession().getId(), request.getWorkspace(),
                    "dataTest", layerList));
        } catch (ResourceNotFoundFault ex) {
            ex.printStackTrace();
            throw new GeoPlatformException("Error on publish shape.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new GeoPlatformException("Error on publish shape.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new GeoPlatformException(new GPReloadURLException(
                    "Error on reloading cluster."));
        }
        return new PublishLayerPreviewResponse(result);

    }

    /**
     * @param casPublisherService
     */
    @Resource
    public void setCasPublisherService(
            @Qualifier("casPublisherService") GPPublisherBasicServiceImpl casPublisherService) {
        this.casPublisherService = casPublisherService;
    }
}
