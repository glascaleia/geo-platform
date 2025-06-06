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
package org.geosdi.geoplatform.gui.client.action.toolbar;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import org.geosdi.geoplatform.gui.action.toggle.MapToggleAction;
import org.geosdi.geoplatform.gui.client.Resources;
import org.geosdi.geoplatform.gui.client.i18n.MapModuleConstants;
import org.geosdi.geoplatform.gui.impl.map.GeoPlatformMap;

/**
 * @author Francesco Izzi - CNR IMAA - geoSDI Group
 *
 */
public class MeasureAction extends MapToggleAction {

    public MeasureAction(GeoPlatformMap mapWidget) {
        super(mapWidget, AbstractImagePrototype.create(Resources.ICONS.measure()),
                MapModuleConstants.INSTANCE.MeasureAction_tooltipText());
    }

    /**
     * (non-Javadoc)
     *
     * @see
     * com.extjs.gxt.ui.client.event.SelectionListener#componentSelected(com.extjs.gxt.ui.client.event.ComponentEvent)
     */
    @Override
    public void componentSelected(ButtonEvent ce) {
        ToggleButton button = (ToggleButton) ce.getSource();

        super.changeButtonState();

        this.deactivateAllMapControl();

        if (button.isPressed()) {
            mapWidget.getButtonBar().setPressedButton(button);
            this.mapWidget.activateMeasure();
        } else {
            this.mapWidget.deactivateMeasure();
        }

    }

    /**
     * (non-Javadoc)
     *
     * @see org.geosdi.geoplatform.gui.action.ToolbarMapAction#disableControl()
     */
    @Override
    public void disableControl() {
        this.mapWidget.deactivateMeasure();
    }

    private void deactivateAllMapControl() {
        if (mapWidget.isFeatureOperationEnable()) {
            mapWidget.deactivateFeatureOperation();
        }

        if (mapWidget.isModifyFeatureEnable()) {
            mapWidget.deactivateModifyFeature();
        }
    }
}
