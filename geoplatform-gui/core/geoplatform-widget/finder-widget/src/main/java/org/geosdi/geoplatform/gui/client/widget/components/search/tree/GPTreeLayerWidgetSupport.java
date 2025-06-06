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
package org.geosdi.geoplatform.gui.client.widget.components.search.tree;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import org.geosdi.geoplatform.gui.client.puregwt.handler.CatalogTreeLayerHandler;
import org.geosdi.geoplatform.gui.client.widget.components.search.pagination.RecordsContainer;
import org.geosdi.geoplatform.gui.client.widget.expander.GPCatalogExpander;
import org.geosdi.geoplatform.gui.model.tree.GPBeanTreeModel;
import org.geosdi.geoplatform.gui.puregwt.GPEventBus;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface GPTreeLayerWidgetSupport extends CatalogTreeLayerHandler {

    Label getLabel();

    Button getAddOnTreeButton();

    Button getLoadWMSCapabilitiesButton();

    void createLabelComponent();

    void createLoadWMSGetCapabilitiesButton();

    void createAddLayersTreeButton();

    /**
     * <p>
     * Internal Class to manage all {@link GPTreeLayerWidgetSupport}
     * Operations<p>
     */
    static abstract class TreeLayerWidgetSupport implements GPTreeLayerWidgetSupport {

        protected final TreePanel<GPBeanTreeModel> tree;
        protected final GPCatalogExpander expander;
        protected Label operationLabel;
        protected Button addLayersToTreeButton;
        protected Button loadWMSGetCapabilities;
        protected final GPEventBus bus;

        public TreeLayerWidgetSupport(TreePanel<GPBeanTreeModel> theTree,
                RecordsContainer recordsContainer, GPEventBus theBus) {
            tree = theTree;
            expander = new GPCatalogExpander(tree, recordsContainer);
            this.bus = theBus;

            this.createLabelComponent();
            this.createLoadWMSGetCapabilitiesButton();
            this.createAddLayersTreeButton();

            this.bus.addHandler(CatalogTreeLayerHandler.TYPE, this);
        }

        @Override
        public Label getLabel() {
            return this.operationLabel;
        }

        @Override
        public Button getAddOnTreeButton() {
            return this.addLayersToTreeButton;
        }

        @Override
        public Button getLoadWMSCapabilitiesButton() {
            return this.loadWMSGetCapabilities;
        }

    }

}
