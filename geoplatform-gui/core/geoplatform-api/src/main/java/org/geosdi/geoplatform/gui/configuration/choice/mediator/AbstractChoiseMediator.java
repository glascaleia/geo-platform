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
package org.geosdi.geoplatform.gui.configuration.choice.mediator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.geosdi.geoplatform.gui.configuration.choice.mediator.colleague.ChoiseColleague;
import org.geosdi.geoplatform.gui.configuration.choice.mediator.colleague.ChoiseColleagueKey;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class AbstractChoiseMediator<W extends Widget, K extends ChoiseColleagueKey, V extends ChoiseColleague>
        implements ChoiseMediator<K, V> {

    protected final Map<K, V> choiseColleagueRegistry = Maps.<K, V>newHashMap();
    protected W widget;
    protected V defaultColleague;
    protected HorizontalPanel hp;

    @Override
    public final V getChoiseColleague(K key) {
        return (isChoiseColleagueRegistered(key))
                ? this.choiseColleagueRegistry.get(key) : null;
    }

    @Override
    public final List<V> getChoiseColleagues() {
        return Collections.unmodifiableList(Lists.<V>newArrayList(
                choiseColleagueRegistry.values()));
    }

    @Override
    public final boolean isChoiseColleagueRegistered(K key) {
        return this.choiseColleagueRegistry.containsKey(key);
    }

    public final void bindWidget(W theWidget) {
        this.widget = theWidget;
    }

    @Override
    public <E> void executeColleague(E param) {
        if (defaultColleague != null) {
            this.defaultColleague.executeColleague(param);
        }
    }

    @Override
    public <R> void resetColleague(R param) {
        if (defaultColleague != null) {
            defaultColleague.resetColleague(param);
        }
    }

    @Override
    public final HorizontalPanel getGroupChoiseWidget() {
        if (choiseColleagueRegistry.isEmpty()) {
            throw new IllegalStateException("The Choise Registry is Empty.");
        }

        return this.hp = (hp == null) ? buildHorizontalPanel() : hp;
    }

    final HorizontalPanel buildHorizontalPanel() {
        HorizontalPanel panel = new HorizontalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setSpacing(16);
        for (Map.Entry<K, V> entry : choiseColleagueRegistry.entrySet()) {
            V getMapChoiseColleague = entry.getValue();
            panel.add(getMapChoiseColleague.getChoiseButton());
        }

        return panel;
    }

}
