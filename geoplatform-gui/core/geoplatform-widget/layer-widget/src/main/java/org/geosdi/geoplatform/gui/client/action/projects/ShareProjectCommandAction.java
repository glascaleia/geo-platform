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
package org.geosdi.geoplatform.gui.client.action.projects;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.core.client.GWT;
import org.geosdi.geoplatform.gui.client.command.layer.defaultproject.DefaultProjectCommandRequest;
import org.geosdi.geoplatform.gui.client.command.layer.defaultproject.DefaultProjectCommandResponse;
import org.geosdi.geoplatform.gui.client.config.BasicGinInjector;
import org.geosdi.geoplatform.gui.client.i18n.LayerModuleConstants;
import org.geosdi.geoplatform.gui.client.i18n.windows.WindowsConstants;
import org.geosdi.geoplatform.gui.client.img.LayerWidgetImage;
import org.geosdi.geoplatform.gui.client.widget.SearchStatus;
import org.geosdi.geoplatform.gui.command.api.ClientCommandDispatcher;
import org.geosdi.geoplatform.gui.command.api.GPClientCommand;
import org.geosdi.geoplatform.gui.configuration.message.GeoPlatformMessage;
import org.geosdi.geoplatform.gui.impl.map.event.GPLoginEvent;
import org.geosdi.geoplatform.gui.impl.view.LayoutManager;
import org.geosdi.geoplatform.gui.model.message.AbstractCommandAction;
import org.geosdi.geoplatform.gui.puregwt.GPHandlerManager;
import org.geosdi.geoplatform.gui.puregwt.layers.projects.event.GPDefaultProjectTreeEvent;
import org.geosdi.geoplatform.gui.puregwt.session.TimeoutHandlerManager;
import org.geosdi.geoplatform.gui.shared.GPMessageCommandType;
import org.geosdi.geoplatform.gui.utility.GPSessionTimeout;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class ShareProjectCommandAction<X extends ButtonEvent> extends AbstractCommandAction<X> {

    private static final Logger logger = Logger.getLogger("ShareProjectCommandAction");
    //
    private final GPDefaultProjectTreeEvent defaultProjectEvent = new GPDefaultProjectTreeEvent();


    public ShareProjectCommandAction() {
        super(LayerWidgetImage.INSTANCE.commandProj(),
                BasicGinInjector.MainInjector.getInstance().getCommandActionMediator());
        logger.log(Level.INFO, "###################################ShareProjectCommandAction");
    }

    @Override
    public final void registerCommandActionToMediator() {
        this.commandActionMediator.put(GPMessageCommandType.OPEN_PROJECT, this);
    }

    @Override
    public void componentSelected(ButtonEvent ce) {
        final Long projectID = Long.parseLong(super.commandProperties);


        final DefaultProjectCommandRequest defaultProjectCommandRequest = GWT.<DefaultProjectCommandRequest>create(
                DefaultProjectCommandRequest.class);
        defaultProjectCommandRequest.setProjectID(projectID);

        ClientCommandDispatcher.getInstance().execute(new GPClientCommand<DefaultProjectCommandResponse>() {

            /**
             * @param response
             */
            @Override
            public void onCommandSuccess(DefaultProjectCommandResponse response) {

                TimeoutHandlerManager.fireEvent(defaultProjectEvent);
            }

            /**
             * @param exception
             */
            @Override
            public void onCommandFailure(Throwable exception) {
                if (exception.getCause() instanceof GPSessionTimeout) {
                    GPHandlerManager.fireEvent(new GPLoginEvent(null));
                } else {
                    GeoPlatformMessage.errorMessage(
                            LayerModuleConstants.INSTANCE.ShareProjectCommandAction_errorLoadingProjectText(),
                            WindowsConstants.INSTANCE.errorMakingConnectionBodyText());
                    LayoutManager.getInstance().getStatusMap().setStatus(
                            LayerModuleConstants.INSTANCE.ShareProjectCommandAction_errorLoadingProjectText(),
                            SearchStatus.EnumSearchStatus.STATUS_NO_SEARCH.toString());
                    System.out.println(
                            "Error loading project: " + exception.toString() + " data: " + exception.getMessage());
                }
            }
        });
    }
}
