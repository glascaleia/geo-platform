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
package org.geosdi.geoplatform.gml.api.jaxb;

import org.geosdi.geoplatform.gml.api.AbstractRingProperty;
import org.geosdi.geoplatform.gml.api.Coord;
import org.geosdi.geoplatform.gml.api.Coordinates;
import org.geosdi.geoplatform.gml.api.DirectPosition;
import org.geosdi.geoplatform.gml.api.DirectPositionList;
import org.geosdi.geoplatform.gml.api.GeometryProperty;
import org.geosdi.geoplatform.gml.api.LineString;
import org.geosdi.geoplatform.gml.api.LineStringProperty;
import org.geosdi.geoplatform.gml.api.LinearRing;
import org.geosdi.geoplatform.gml.api.LinearRingProperty;
import org.geosdi.geoplatform.gml.api.MultiGeometry;
import org.geosdi.geoplatform.gml.api.MultiGeometryProperty;
import org.geosdi.geoplatform.gml.api.MultiLineString;
import org.geosdi.geoplatform.gml.api.MultiLineStringProperty;
import org.geosdi.geoplatform.gml.api.MultiPoint;
import org.geosdi.geoplatform.gml.api.MultiPointProperty;
import org.geosdi.geoplatform.gml.api.MultiPolygon;
import org.geosdi.geoplatform.gml.api.MultiPolygonProperty;
import org.geosdi.geoplatform.gml.api.Point;
import org.geosdi.geoplatform.gml.api.PointProperty;
import org.geosdi.geoplatform.gml.api.Polygon;
import org.geosdi.geoplatform.gml.api.PolygonProperty;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface GMLObjectFactory {

    /**
     * @return {@link Coord}
     */
    Coord createCoordType();

    /**
     * @return {@link Coordinates}
     */
    Coordinates createCoordinatesType();

    /**
     * @return {@link DirectPosition}
     */
    DirectPosition createDirectPositionType();

    /**
     * @return {@link DirectPositionList}
     */
    DirectPositionList createDirectPositionListType();

    /**
     * @return {@link Point}
     */
    Point createPointType();

    /**
     * @return {@link PointProperty}
     */
    PointProperty createPointPropertyType();

    /**
     * @return {@link LineString}
     */
    LineString createLineStringType();

    /**
     * @return {@link LineStringProperty}
     */
    LineStringProperty createLineStringPropertyType();

    /**
     * @return {@link LinearRing}
     */
    LinearRing createLinearRingType();

    /**
     * @return {@link LinearRingProperty}
     */
    LinearRingProperty createLinearRingPropertyType();

    /**
     * @return {@link Polygon}
     */
    Polygon createPolygonType();

    /**
     * @return {@link PolygonProperty}
     */
    PolygonProperty createPolygonPropertyType();

    /**
     * @return {@link MultiPoint}
     */
    MultiPoint createMultiPointType();

    /**
     * @return {@link MultiPointProperty}
     */
    MultiPointProperty createMultiPointPropertyType();

    /**
     * @return {@link MultiLineString}
     */
    MultiLineString createMultiLineStringType();

    /**
     * @return {@link MultiLineStringProperty}
     */
    MultiLineStringProperty createMultiLineStringPropertyType();

    /**
     * @return {@link AbstractRingProperty}
     */
    AbstractRingProperty createAbstractRingPropertyType();

    /**
     * @return {@link MultiPolygon}
     */
    MultiPolygon createMultiPolygonType();

    /**
     * @return {@link MultiPolygonProperty}
     */
    MultiPolygonProperty createMultiPolygonPropertyType();

    /**
     * @return {@link MultiGeometry}
     */
    MultiGeometry createMultiGeometryType();

    /**
     * @return {@link MultiGeometryProperty}
     */
    MultiGeometryProperty createMultiGeometryPropertyType();

    /**
     * @return {@link GeometryProperty}
     */
    GeometryProperty createGeometryPropertyType();
}
