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
package org.geosdi.geoplatform.gui.configuration;

import static org.geosdi.geoplatform.gui.client.i18n.BaseMenuGenericToolConstants.INSTANCE;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class BaseMenuGenericTool<M extends GeoPlatformMenuCreator> extends GPMenuGenericTool<M> implements GPMenuItem {

    private static final long serialVersionUID = -865083411234763080L;
    //
    private String textKey;
    protected String text;

    /**
     * @return the text
     */
    @Override
    public String getText() {
        return ((this.text == null) && (this.textKey != null)) ? INSTANCE.getString(this.textKey) : text;
    }

    /**
     * @param text the text to set
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return {@link String}
     */
    public String getTextKey() {
        return textKey;
    }

    /**
     * @param textKey
     */
    @Override
    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{ " + "id = " + id
                + ", enabled = " + enabled
                + ", order = " + order
                + ", secure = " + secure
                + ", text = " + text
                + ", textKey = " + textKey + '}';
    }
}