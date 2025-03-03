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
package org.geosdi.geoplatform.gui.client.action.menu;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.google.gwt.core.client.GWT;
import org.geosdi.geoplatform.gui.client.command.layer.refresh.LayerRefreshCommandRequest;
import org.geosdi.geoplatform.gui.client.command.layer.refresh.LayerRefreshCommandResponse;
import org.geosdi.geoplatform.gui.client.i18n.LayerModuleConstants;
import org.geosdi.geoplatform.gui.client.i18n.LayerModuleMessages;
import org.geosdi.geoplatform.gui.client.i18n.windows.WindowsConstants;
import org.geosdi.geoplatform.gui.client.model.LayerRefreshTimeValue;
import org.geosdi.geoplatform.gui.client.model.LayerRefreshTimeValue.LayerRefreshTimeEnum;
import org.geosdi.geoplatform.gui.client.widget.SearchStatus;
import org.geosdi.geoplatform.gui.client.widget.tree.GPTreePanel;
import org.geosdi.geoplatform.gui.command.api.ClientCommandDispatcher;
import org.geosdi.geoplatform.gui.command.api.GPClientCommand;
import org.geosdi.geoplatform.gui.configuration.message.GeoPlatformMessage;
import org.geosdi.geoplatform.gui.global.enumeration.GlobalRegistryEnum;
import org.geosdi.geoplatform.gui.impl.map.event.ReloadLayerMapEvent;
import org.geosdi.geoplatform.gui.impl.view.LayoutManager;
import org.geosdi.geoplatform.gui.model.GPLayerBean;
import org.geosdi.geoplatform.gui.model.tree.GPBeanTreeModel;
import org.geosdi.geoplatform.gui.model.tree.GPLayerTreeModel;
import org.geosdi.geoplatform.gui.puregwt.GPHandlerManager;
import org.geosdi.geoplatform.gui.puregwt.xmpp.XMPPHandlerManager;
import org.geosdi.geoplatform.gui.puregwt.xmpp.handler.IXMPPRefreshLayerHandler;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class RefreshLayerAction extends SelectionChangedListener<LayerRefreshTimeValue> implements IXMPPRefreshLayerHandler {

    private final GPTreePanel<GPBeanTreeModel> treePanel;
    private ReloadLayerMapEvent reloadLayerEvent;

    public RefreshLayerAction(GPTreePanel<GPBeanTreeModel> treePanel) {
        this.treePanel = treePanel;
        XMPPHandlerManager.addHandler(IXMPPRefreshLayerHandler.TYPE, this);
    }

    @Override
    public void selectionChanged(SelectionChangedEvent<LayerRefreshTimeValue> se) {
        final GPBeanTreeModel itemSelected = this.treePanel.getSelectionModel().getSelectedItem();
        if (!(itemSelected instanceof GPLayerTreeModel)) {
            throw new IllegalArgumentException("It is possible to refresh only layers");
        }
        final GPLayerTreeModel layerSelected = (GPLayerTreeModel) itemSelected;
        final LayerRefreshTimeEnum refreshTimeEnum = se.getSelectedItem().get(LayerRefreshTimeValue.REFRESH_TIME_KEY);


        final LayerRefreshCommandRequest layerRefreshCommandRequest = GWT.<LayerRefreshCommandRequest>create(
                LayerRefreshCommandRequest.class);

        layerRefreshCommandRequest.setEmiteResource(
                (String) Registry.get(GlobalRegistryEnum.EMITE_RESOURCE.getValue()));
        layerRefreshCommandRequest.setLayerUUID(layerSelected.getUUID());
        layerRefreshCommandRequest.setSecondToRefresh(refreshTimeEnum.getValue());

        ClientCommandDispatcher.getInstance().execute(new GPClientCommand<LayerRefreshCommandResponse>() {

            {
                super.setCommandRequest(layerRefreshCommandRequest);
            }

            /**
             * @param response
             */
            @Override
            public void onCommandSuccess(LayerRefreshCommandResponse response) {
                if (refreshTimeEnum.getValue() != LayerRefreshTimeValue.NO_REFRESH_VALUE) {
                    LayoutManager.getInstance().getStatusMap().setStatus(
                            LayerModuleMessages.INSTANCE.RefreshLayerAction_statusReloadTimeInfoMessage(
                                    refreshTimeEnum.getValue()),
                            SearchStatus.EnumSearchStatus.STATUS_SEARCH.toString());
                } else {
                    LayoutManager.getInstance().getStatusMap()
                            .setStatus(LayerModuleConstants.INSTANCE.RefreshLayerAction_statusStopReloadTimeText(),
                                    SearchStatus.EnumSearchStatus.STATUS_SEARCH.toString());
                }
                layerSelected.setRefreshTime(refreshTimeEnum.getValue());
                treePanel.refresh(layerSelected);
            }

            /**
             * @param exception
             */
            @Override
            public void onCommandFailure(Throwable exception) {
                GeoPlatformMessage.errorMessage(WindowsConstants.INSTANCE.errorReloadingTitleText(),
                        WindowsConstants.INSTANCE.errorMakingConnectionBodyText());
                LayoutManager.getInstance().getStatusMap()
                        .setStatus(LayerModuleConstants.INSTANCE.RefreshLayerAction_statusReloadTimeErrorText(),
                                SearchStatus.EnumSearchStatus.STATUS_NO_SEARCH.toString());
                System.out.println(
                        "Error setting the reload time for layer: " + exception.toString() + " data: " + exception.getMessage());
            }
        });
    }

    @Override
    public void handleMessageBody(final String messageBody) {
        GPBeanTreeModel element = treePanel.getStore().findModel(messageBody);
        if (element != null && element instanceof GPLayerTreeModel && ((GPLayerTreeModel) element).isChecked()) {
            this.reloadLayerEvent = new ReloadLayerMapEvent((GPLayerBean) element);
            GPHandlerManager.fireEvent(this.reloadLayerEvent);
        } else if (element instanceof GPLayerTreeModel) {


            final LayerRefreshCommandRequest layerRefreshCommandRequest = GWT.<LayerRefreshCommandRequest>create(
                    LayerRefreshCommandRequest.class);

            layerRefreshCommandRequest.setEmiteResource(
                    (String) Registry.get(GlobalRegistryEnum.EMITE_RESOURCE.getValue()));
            layerRefreshCommandRequest.setLayerUUID(messageBody);
            layerRefreshCommandRequest.setSecondToRefresh(0);

            ClientCommandDispatcher.getInstance().execute(new GPClientCommand<LayerRefreshCommandResponse>() {

                /**
                 * @param response
                 */
                @Override
                public void onCommandSuccess(LayerRefreshCommandResponse response) {

                }

                /**
                 * @param exception
                 */
                @Override
                public void onCommandFailure(Throwable exception) {

                }
            });
        }
    }
}
