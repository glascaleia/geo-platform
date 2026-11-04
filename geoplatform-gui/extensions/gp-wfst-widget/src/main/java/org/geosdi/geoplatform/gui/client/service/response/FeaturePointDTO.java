/*
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2026 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gui.client.service.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Arrays;

/**
 * La geometria di una {@link FeatureDTO} del geocoding: un Point GeoJSON, con le coordinate in ordine longitudine,
 * latitudine.
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeaturePointDTO implements Serializable {

    private static final long serialVersionUID = 4419372615482271736L;
    //
    private String type;
    private double[] coordinates;

    /**
     * Costruttore vuoto, per domino-jackson.
     */
    public FeaturePointDTO() {
    }

    /**
     * @return {@link String} il tipo GeoJSON della geometria, "Point"
     */
    public String getType() {
        return type;
    }

    /**
     * @param theType il tipo GeoJSON della geometria
     */
    public void setType(String theType) {
        this.type = theType;
    }

    /**
     * @return le coordinate: longitudine, latitudine
     */
    public double[] getCoordinates() {
        return coordinates;
    }

    /**
     * @param theCoordinates le coordinate: longitudine, latitudine
     */
    public void setCoordinates(double[] theCoordinates) {
        this.coordinates = theCoordinates;
    }

    /**
     * @return la longitudine, la prima coordinata
     */
    public double getLongitude() {
        return this.coordinates[0];
    }

    /**
     * @return la latitudine, la seconda coordinata
     */
    public double getLatitude() {
        return this.coordinates[1];
    }

    /**
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "FeaturePointDTO{" +
                "type='" + type + '\'' +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
