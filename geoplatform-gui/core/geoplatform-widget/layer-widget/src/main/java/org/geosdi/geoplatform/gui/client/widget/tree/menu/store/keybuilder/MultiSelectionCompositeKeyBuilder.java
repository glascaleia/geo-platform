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
package org.geosdi.geoplatform.gui.client.widget.tree.menu.store.keybuilder;

import org.geosdi.geoplatform.gui.configuration.composite.menu.store.MultiSelectionCompositeKey;
import org.geosdi.geoplatform.gui.configuration.composite.menu.store.StoreCompositeKey;
import org.geosdi.geoplatform.gui.model.tree.AbstractFolderTreeNode;
import org.geosdi.geoplatform.gui.model.tree.AbstractRootTreeNode;
import org.geosdi.geoplatform.gui.model.tree.GPBeanTreeModel;
import org.geosdi.geoplatform.gui.model.tree.GPLayerTreeModel;

import java.util.List;

import static org.geosdi.geoplatform.gui.configuration.composite.menu.MultiSelectionElementType.*;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class MultiSelectionCompositeKeyBuilder extends SelectionCompositeKeyBuilder {

    /**
     * @param selections
     * @return {@link StoreCompositeKey}
     */
    @Override
    public StoreCompositeKey buildStoreCompositeKey(List<GPBeanTreeModel> selections) {

        boolean rootSelected = false;
        boolean compositeSelected = false;
        boolean leafSelected = false;
        boolean allSelected = false;

        for (GPBeanTreeModel gPBeanTreeModel : selections) {
            if ((!rootSelected) && (gPBeanTreeModel instanceof AbstractRootTreeNode)) {
                rootSelected = true;
            }

            if ((!compositeSelected) && (gPBeanTreeModel instanceof AbstractFolderTreeNode)) {
                compositeSelected = true;
            }

            if ((!leafSelected) && (gPBeanTreeModel instanceof GPLayerTreeModel)) {
                leafSelected = true;
            }

            if ((rootSelected) && (compositeSelected) && (leafSelected)) {
                allSelected = true;
                break;
            }
        }

        return (allSelected) ? new MultiSelectionCompositeKey(ALL)
                : ((compositeSelected) && (leafSelected))
                ? new MultiSelectionCompositeKey(
                COMPOSITE_LEAF)
                : (compositeSelected)
                ? new MultiSelectionCompositeKey(
                ONLY_COMPOSITE)
                : (leafSelected)
                ? new MultiSelectionCompositeKey(
                ONLY_LEAF) : null;
    }
}
