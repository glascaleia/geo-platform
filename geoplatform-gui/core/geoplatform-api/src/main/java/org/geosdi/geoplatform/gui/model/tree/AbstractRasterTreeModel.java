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
package org.geosdi.geoplatform.gui.model.tree;

import org.geosdi.geoplatform.gui.configuration.map.client.layer.GPLayerClientInfo;
import org.geosdi.geoplatform.gui.model.GPRasterBean;
import org.geosdi.geoplatform.gui.model.logo.GPAttributionLogoURLBean;
import org.geosdi.geoplatform.gui.model.temporal.dimension.GPTemporalDimensionBean;
import org.geosdi.geoplatform.gui.model.temporal.extent.GPTemporalExtentBean;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public abstract class AbstractRasterTreeModel extends GPLayerTreeModel implements GPRasterBean {

    private static final long serialVersionUID = -2542877101963530059L;
    //
    private GPTemporalDimensionBean dimension;
    private GPTemporalExtentBean extent;
    private GPAttributionLogoURLBean logoURLBean;

    protected AbstractRasterTreeModel() {
    }

    /**
     * @param layer
     */
    protected AbstractRasterTreeModel(GPLayerClientInfo layer) {
        super(layer);
    }

    /**
     * @return {@link GPTemporalDimensionBean}
     */
    @Override
    public GPTemporalDimensionBean getDimension() {
        return this.dimension;
    }

    /**
     * @param theDimension
     */
    @Override
    public void setDimension(GPTemporalDimensionBean theDimension) {
        this.dimension = theDimension;
    }

    /**
     * @return {@link GPTemporalExtentBean}
     */
    @Override
    public GPTemporalExtentBean getExtent() {
        return this.extent;
    }

    /**
     * @param theTemporalExtent
     */
    @Override
    public void setExtent(GPTemporalExtentBean theTemporalExtent) {
        this.extent = theTemporalExtent;
    }

    /**
     * @return {@link Boolean}
     */
    @Override
    public boolean isTemporalLayer() {
        return ((this.extent != null) && (this.extent.isTemporal()));
    }

    /**
     *
     * @return
     */
    public GPAttributionLogoURLBean getLogoURLBean() {
        return logoURLBean;
    }

    /**
     *
     * @param logoURLBean
     */
    public void setLogoURLBean(GPAttributionLogoURLBean logoURLBean) {
        this.logoURLBean = logoURLBean;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSetAttribution() {
        return this.logoURLBean != null && this.logoURLBean.getOnlineResource() != null;
    }

    @Override
    public String toString() {
        return "AbstractRasterTreeModel{"
                + super.toString()
                + ", dimension = " + this.dimension
                + ", extent = " + this.extent
                + ", logoURLBean = " + this.logoURLBean
                + '}';
    }
}