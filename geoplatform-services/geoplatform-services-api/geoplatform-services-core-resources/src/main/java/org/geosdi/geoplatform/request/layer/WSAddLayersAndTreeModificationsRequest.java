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
package org.geosdi.geoplatform.request.layer;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import org.geosdi.geoplatform.core.model.GPLayer;
import org.geosdi.geoplatform.core.model.GPRasterLayer;
import org.geosdi.geoplatform.core.model.GPVectorLayer;
import org.geosdi.geoplatform.request.TreeModificationRequest;
import org.geosdi.geoplatform.response.collection.GPWebServiceMapData;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WSAddLayersAndTreeModificationsRequest
        extends TreeModificationRequest {

    private static final long serialVersionUID = -8055754216178718106L;
    //
    private Long projectID;
    private Long parentFolderID;
    @XmlElementRefs(value = {
        @XmlElementRef(name = "gpRasterLayer", type = GPRasterLayer.class),
        @XmlElementRef(name = "gpVectorLayer", type = GPVectorLayer.class)})
    private List<GPLayer> layers;

    public WSAddLayersAndTreeModificationsRequest() {
    }

    public WSAddLayersAndTreeModificationsRequest(Long theProjectID,
            Long theParentFolderID, List<GPLayer> theLayers,
            GPWebServiceMapData theDescendantsMapData) {
        super(theDescendantsMapData);
        this.projectID = theProjectID;
        this.parentFolderID = theParentFolderID;
        this.layers = theLayers;
    }

    /**
     * @return the projectID
     */
    public Long getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    /**
     * @return the parentFolderID
     */
    public Long getParentFolderID() {
        return parentFolderID;
    }

    /**
     * @param parentFolderID the parentFolderID to set
     */
    public void setParentFolderID(Long parentFolderID) {
        this.parentFolderID = parentFolderID;
    }

    /**
     * @return the layers
     */
    public List<GPLayer> getLayers() {
        return layers;
    }

    /**
     * @param layers the layers to set
     */
    public void setLayers(List<GPLayer> layers) {
        this.layers = layers;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" + "projectID = " + projectID
                + ", parentFolderID = " + parentFolderID
                + ", layers = " + layers + '}';
    }

}
