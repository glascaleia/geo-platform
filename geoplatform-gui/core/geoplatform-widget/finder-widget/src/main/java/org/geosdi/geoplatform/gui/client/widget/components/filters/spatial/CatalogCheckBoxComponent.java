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
package org.geosdi.geoplatform.gui.client.widget.components.filters.spatial;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import org.geosdi.geoplatform.gui.client.i18n.CatalogFinderConstants;
import org.geosdi.geoplatform.gui.client.puregwt.event.CatalogSpatialEnableEvent;
import org.geosdi.geoplatform.gui.client.widget.components.GPCatalogFinderComponent;
import org.geosdi.geoplatform.gui.puregwt.GPEventBus;
import org.geosdi.geoplatform.gui.responce.AreaInfo;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class CatalogCheckBoxComponent implements GPCatalogFinderComponent {

    private AreaInfo areaInfo;
    private GPEventBus bus;
    private CheckBox activateFilter;
    private CatalogSpatialEnableEvent event = new CatalogSpatialEnableEvent();

    public CatalogCheckBoxComponent(AreaInfo theAreaInfo, GPEventBus theBus) {
        this.areaInfo = theAreaInfo;
        this.bus = theBus;
    }

    public FlexTable getCheckBoxComponent() {
        FlexTable table = new FlexTable();
        table.setCellSpacing(4);
        table.setCellPadding(1);

        table.getCellFormatter().setHorizontalAlignment(2, 1,
                HasHorizontalAlignment.ALIGN_CENTER);

        activateFilter = new CheckBox();
        activateFilter.setBoxLabel(CatalogFinderConstants.INSTANCE.CatalogCheckBoxComponent_activateFilterText());

        activateFilter.addListener(Events.Change, new Listener<FieldEvent>() {
            @Override
            public void handleEvent(FieldEvent be) {
                Boolean checked = (Boolean) be.getValue();

                areaInfo.setActive(checked);
                fireCatalogSpatialEnableEvent();
            }
        });
        activateFilter.setOriginalValue(Boolean.FALSE);

        table.setWidget(2, 1, activateFilter);

        return table;
    }

    @Override
    public void reset() {
        this.activateFilter.reset();
    }

    private void fireCatalogSpatialEnableEvent() {
        this.event.setEnable(this.areaInfo.isActive());
        this.bus.fireEvent(this.event);
    }
}
