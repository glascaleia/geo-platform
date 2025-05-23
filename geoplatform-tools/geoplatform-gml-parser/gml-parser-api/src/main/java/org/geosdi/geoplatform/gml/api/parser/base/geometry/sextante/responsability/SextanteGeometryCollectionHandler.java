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
package org.geosdi.geoplatform.gml.api.parser.base.geometry.sextante.responsability;

import org.geojson.GeoJsonObject;
import org.geosdi.geoplatform.gml.api.AbstractGeometricAggregate;
import org.geosdi.geoplatform.gml.api.AbstractGeometry;
import org.geosdi.geoplatform.gml.api.MultiGeometryProperty;
import org.geosdi.geoplatform.gml.api.PropertyType;
import org.geosdi.geoplatform.gml.api.parser.base.geometry.collection.GMLBaseGeometryCollectionParser;
import org.geosdi.geoplatform.gml.api.parser.exception.ParserException;
import org.locationtech.jts.geom.Geometry;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
class SextanteGeometryCollectionHandler extends SextanteGeometryHandler {

    private GMLBaseGeometryCollectionParser geometryCollectionParser;

    SextanteGeometryCollectionHandler() {
        this.geometryCollectionParser = new GMLBaseGeometryCollectionParser();
    }

    /**
     * @param gmlGeometry
     * @return {@link Geometry}
     * @throws ParserException
     */
    @Override
    public Geometry parseGeometry(AbstractGeometry gmlGeometry) throws ParserException {
        return isCompatibleGeometry(gmlGeometry)
                ? geometryCollectionParser.parseGeometry((AbstractGeometricAggregate) gmlGeometry)
                : super.forwardParseGeometry(gmlGeometry);
    }

    /**
     * @param propertyType
     * @return {@link Geometry}
     * @throws ParserException
     */
    @Override
    public Geometry parseGeometry(PropertyType propertyType) throws ParserException {
        return isCompatibleProperty(propertyType)
                ? geometryCollectionParser.parseGeometry((MultiGeometryProperty) propertyType)
                : super.forwardParseGeometry(propertyType);
    }

    /**
     * @param gmlGeometry
     * @return {@link GeoJsonObject}
     * @throws ParserException
     */
    @Override
    public GeoJsonObject parseGeometryAsGeoJson(AbstractGeometry gmlGeometry) throws ParserException {
        return isCompatibleGeometry(gmlGeometry)
                ? geometryCollectionParser.parseGeometryAsGeoJson((AbstractGeometricAggregate) gmlGeometry)
                : super.forwardParseGeometryAsGeoJson(gmlGeometry);
    }

    /**
     * @param propertyType
     * @return {@link GeoJsonObject}
     * @throws ParserException
     */
    @Override
    public GeoJsonObject parseGeometryAsGeoJson(PropertyType propertyType) throws ParserException {
        return isCompatibleProperty(propertyType)
                ? geometryCollectionParser.parseGeometryAsGeoJson((MultiGeometryProperty) propertyType)
                : super.forwardParseGeometryAsGeoJson(propertyType);
    }

    /**
     * @param gmlGeometry
     * @return {@link Boolean}
     */
    @Override
    protected boolean isCompatibleGeometry(Object gmlGeometry) {
        return gmlGeometry instanceof AbstractGeometricAggregate;
    }

    /**
     * @param propertyType
     * @return {@link Boolean}
     */
    @Override
    protected boolean isCompatibleProperty(Object propertyType) {
        return propertyType instanceof MultiGeometryProperty;
    }
}