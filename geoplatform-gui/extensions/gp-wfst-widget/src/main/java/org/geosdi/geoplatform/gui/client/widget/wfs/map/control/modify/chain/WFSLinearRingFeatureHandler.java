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
package org.geosdi.geoplatform.gui.client.widget.wfs.map.control.modify.chain;

import org.geosdi.geoplatform.gui.client.editor.map.chain.LinearRingEditorHandler;
import org.geosdi.geoplatform.gui.client.editor.map.control.ModifyEditorFeature;
import org.geosdi.geoplatform.gui.client.puregwt.map.dispatcher.FeatureDispatcherHandler;
import org.geosdi.geoplatform.gui.client.puregwt.map.dispatcher.modify.event.ModifyFeatureDispatcherEvent;
import org.geosdi.geoplatform.gui.client.widget.wfs.map.dispatcher.WFSFeatureDispatcher;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WFSLinearRingFeatureHandler extends LinearRingEditorHandler {

    public static final ModifyFeatureDispatcherEvent event = FeatureDispatcherHandler.MODIFY_FEATURE_EVENT;

    public WFSLinearRingFeatureHandler(
            ModifyEditorFeature theModifyEditorControl) {
        super(theModifyEditorControl);

        super.setSuperiorEditorHandler(new WFSPolygonFeatureHandler(
                theModifyEditorControl));
    }

    @Override
    protected void manageUpdatedFeature(VectorFeature modifiedFeature,
                                        VectorFeature oldFeature) {
        Geometry geom = modifiedFeature.getGeometry().clone();
//        String wktGeometry = modifyEditorControl.getWKTEditorConverter().convertGeometry(
//                geom, new Projection(
//                GPCoordinateReferenceSystem.WGS_84.getCode()));

        event.setModifiedFeature(modifiedFeature);
        event.setOldFeature(oldFeature);
        event.setWktGeometry(geom.toString());

        WFSFeatureDispatcher.fireFeatureDispatcherEvent(event);
    }

}
