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
package org.geosdi.geoplatform.gui.client.widget.wfs.map.dispatcher.executor;

import org.geosdi.geoplatform.gui.client.command.wfst.feature.UpdateFeatureGeometryRequest;
import org.geosdi.geoplatform.gui.client.command.wfst.feature.UpdateFeatureGeometryResponse;
import org.geosdi.geoplatform.gui.client.model.binder.IFeatureIdBinder;
import org.geosdi.geoplatform.gui.client.puregwt.wfs.event.FeatureStatusBarEvent;
import org.geosdi.geoplatform.gui.client.widget.wfs.statusbar.FeatureStatusBar;
import org.geosdi.geoplatform.gui.command.api.GPClientCommand;
import org.geosdi.geoplatform.gui.command.api.GPClientCommandExecutor;
import org.geosdi.geoplatform.gui.configuration.message.GeoPlatformMessage;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;

import javax.inject.Inject;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WFSUpdateGeometryExecutor extends WFSDispatcherExecutor implements
        IWFSUpdateGeometryExecutor {

    @Inject
    private UpdateFeatureGeometryRequest updateGeometryRequest;
    @Inject
    private IFeatureIdBinder fidBinder;
    @Inject
    private Vector vector;

    @Inject
    public WFSUpdateGeometryExecutor() {
        super(new FeatureStatusBarEvent("WFS Geometry Updating....",
                        FeatureStatusBar.FeatureStatusBarType.STATUS_LOADING),
                new FeatureStatusBarEvent("WFS Update Geometry Done.",
                        FeatureStatusBar.FeatureStatusBarType.STATUS_OK),
                new FeatureStatusBarEvent("WFS Update Geometry not done.",
                        FeatureStatusBar.FeatureStatusBarType.STATUS_NOT_OK),
                new FeatureStatusBarEvent("WFS Update Geometry Failed.",
                        FeatureStatusBar.FeatureStatusBarType.STATUS_ERROR));
    }

    @Override
    public void executeGeometryUpdate(final VectorFeature modifiedFeature,
                                      String wktGeometry, final VectorFeature oldFeature) {
        progressBar.show();

        setUpRequest(modifiedFeature, wktGeometry);

        GPClientCommandExecutor.executeCommand(
                new GPClientCommand<UpdateFeatureGeometryResponse>() {

                    private static final long serialVersionUID = 5836033208636357032L;

                    {
                        super.setCommandRequest(updateGeometryRequest);
                    }

                    @Override
                    public void onCommandSuccess(
                            UpdateFeatureGeometryResponse response) {
                        manageUpdateGeometryCommandSuccess(
                                response.getResult(),
                                modifiedFeature, oldFeature);
                    }

                    @Override
                    public void onCommandFailure(Throwable exception) {
                        manageUpdateGeometryCommandFailure(
                                modifiedFeature, oldFeature,
                                exception);
                    }

                });
    }

    final void setUpRequest(VectorFeature modifiedFeature,
                            String wktGeometry) {
        bus.fireEvent(loadingEvent);

        updateGeometryRequest.setFid(fidBinder.getFID());
        updateGeometryRequest.setWktGeometry(wktGeometry);
        updateGeometryRequest.setServerUrl(
                layerSchemaBinder.getLayerSchemaDTO().getScope());
        updateGeometryRequest.setTypeName(
                layerSchemaBinder.getLayerSchemaDTO().getTypeName());
        updateGeometryRequest.setGeometryAttributeName(
                layerSchemaBinder.getLayerSchemaDTO().getGeometry().getName());
    }

    final void manageUpdateGeometryCommandFailure(
            VectorFeature modifiedFeature,
            VectorFeature oldFeature, Throwable exception) {
        String errorMessage = "Error on WFS Update Geometry request";
        GeoPlatformMessage.errorMessage(
                "WFS Service Error",
                errorMessage + " - " + exception.getMessage());

        progressBar.hide();
        vector.removeFeature(modifiedFeature);
        vector.addFeature(oldFeature);

        bus.fireEvent(failedEvent);
    }

    final void manageUpdateGeometryCommandSuccess(Boolean result,
                                                  VectorFeature modifiedFeature, VectorFeature oldFeature) {
        progressBar.hide();
        if (result) {
            fireEvents();
        } else {
            vector.removeFeature(modifiedFeature);
            vector.addFeature(oldFeature);
            bus.fireEvent(statusNotOk);
        }
    }

}
