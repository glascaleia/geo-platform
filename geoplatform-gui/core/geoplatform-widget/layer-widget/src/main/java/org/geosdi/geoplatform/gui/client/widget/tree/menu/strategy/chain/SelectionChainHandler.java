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
package org.geosdi.geoplatform.gui.client.widget.tree.menu.strategy.chain;

import com.extjs.gxt.ui.client.widget.menu.Menu;
import org.geosdi.geoplatform.gui.configuration.composite.menu.store.StoreCompositeKey;
import org.geosdi.geoplatform.gui.impl.tree.menu.strategy.TreeMenuStrategyManager;
import org.geosdi.geoplatform.gui.model.tree.GPBeanTreeModel;

import java.util.List;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class SelectionChainHandler {

    private SelectionChainHandler successor;

    /**
     * @param strategyManager
     * @param selections
     * @return {@link Menu}
     */
    public abstract Menu buildMenu(TreeMenuStrategyManager strategyManager, List<GPBeanTreeModel> selections);

    /**
     * @param strategyManager
     * @param selections
     * @return {@link Menu}
     */
    protected Menu forwardBuildMenu(TreeMenuStrategyManager strategyManager, List<GPBeanTreeModel> selections) {
        return (successor != null) ? successor.buildMenu(strategyManager, selections) : null;
    }

    /**
     * @param strategyManager
     * @param selections
     * @return {@link Menu}
     */
    protected abstract Menu bindStrategy(TreeMenuStrategyManager strategyManager, List<GPBeanTreeModel> selections);

    /**
     * @param selections
     * @return {@link StoreCompositeKey}
     */
    protected StoreCompositeKey bindSelection(List<GPBeanTreeModel> selections) {
        return buildStoreCompositeKey(selections);
    }

    /**
     * @param selections
     * @return {@link StoreCompositeKey}
     */
    protected abstract StoreCompositeKey buildStoreCompositeKey(List<GPBeanTreeModel> selections);

    /**
     * @param successor the successor to set
     */
    public void setSuccessor(SelectionChainHandler successor) {
        this.successor = successor;
    }
}
