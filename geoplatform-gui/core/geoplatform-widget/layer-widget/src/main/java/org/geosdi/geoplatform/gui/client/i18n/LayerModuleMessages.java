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
package org.geosdi.geoplatform.gui.client.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public interface LayerModuleMessages extends Messages {

    public final static LayerModuleMessages INSTANCE = GWT.create(LayerModuleMessages.class);

    String RefreshLayerAction_statusReloadTimeInfoMessage(int reloadTime);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapRequestMessage(String getMapRequest);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapVersionMessage(String getMapVersion);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapLayersMessage(String getMapLayers);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapSRSMessage(String getMapSRS);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapBBOXMessage(String getMapBBOX);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapWidthMessage(String getMapWidth);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapHeightMessage(String getMapHeight);

    String LoadWmsGetMapFromUrlWidget_suggestionCheckGetMapFormatMessage(String getMapFormat);

    String GPProjectSearchPanel_projectRemovedMessage(String projectName);

    String GPTreeStoreWidget_renameAlertBodyMessage(String existingLayers);

    String GPFolderNameFieldBinding_folderInfoHTMLMessage(int numberOfDescendants);

    String LayerTimeFilterWidget_dimensionSizeHTMLMessage(int dimensionSize);

    String LayerTimeFilterWidget_layerStatusShowedMessage(String timeFilter);

    String LayerTimeFilterWidget_rangeDateErrorMessage();

    String LayerTimeFilterWidget_periodDateErrorMessage();

    String LayerTimeFilterWidget_upperLimitDate(String timeFilter);

    String LayerTimeFilterWidget_lowerLimitDate(String timeFilter);

    String LayerTimeFilterWidget_noDateFound(String date1, String date2);

    String LayerTimeFilterWidget_dateInFuture();
}
