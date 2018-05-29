/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2018 geoSDI Group (CNR IMAA - Potenza - ITALY).
 * <p>
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see http://www.gnu.org/licenses/
 * <p>
 * ====================================================================
 * <p>
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole combination.
 * <p>
 * As a special exception, the copyright holders of this library give you permission
 * to link this library with independent modules to produce an executable, regardless
 * of the license terms of these independent modules, and to copy and distribute
 * the resulting executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the license of
 * that module. An independent module is a module which is not derived from or
 * based on this library. If you modify this library, you may extend this exception
 * to your version of the library, but you are not obligated to do so. If you do not
 * wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.gui.client.widget.wfs.tree.activator;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.core.client.GWT;
import org.geosdi.geoplatform.gui.client.config.annotation.tree.WFSLayerTree;
import org.geosdi.geoplatform.gui.client.config.annotation.tree.WFSTreeLeafMenu;
import org.geosdi.geoplatform.gui.client.config.annotation.tree.WFSTreeRootMenu;
import org.geosdi.geoplatform.gui.client.model.tree.WFSLayerTreeNode;
import org.geosdi.geoplatform.gui.client.widget.tree.GPTreePanel;
import org.geosdi.geoplatform.gui.puregwt.GPEventBus;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
@Singleton
public class GPWFSTreeMenuActivator  {

    private final GPTreePanel tree;
    private final GPEventBus bus;
    @Inject
    @WFSTreeLeafMenu
    private Menu leafMenu;
    @Inject
    @WFSTreeRootMenu
    private Menu rootMenu;

    @Inject
    public GPWFSTreeMenuActivator(@WFSLayerTree GPTreePanel theTree, GPEventBus theBus) {
        this.tree = theTree;
        this.bus = theBus;
    }

    public void activeTreeContextMenu() {
        tree.addListener(Events.OnContextMenu, new Listener() {

            @Override
            public void handleEvent(BaseEvent be) {
                if(tree.getSelectionModel().getSelectedItem() instanceof WFSLayerTreeNode )
                    tree.setContextMenu(leafMenu);
                else{
                    rootMenu.hide(Boolean.TRUE);
                    rootMenu.setVisible(Boolean.FALSE);
                    tree.setContextMenu(rootMenu);

                }
            }

        });
    }
}