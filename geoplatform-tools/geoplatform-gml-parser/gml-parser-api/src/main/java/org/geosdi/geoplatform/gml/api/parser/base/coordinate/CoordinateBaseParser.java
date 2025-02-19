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
package org.geosdi.geoplatform.gml.api.parser.base.coordinate;

import org.geosdi.geoplatform.gml.api.Coord;
import org.geosdi.geoplatform.gml.api.Coordinates;
import org.geosdi.geoplatform.gml.api.DirectPosition;
import org.geosdi.geoplatform.gml.api.DirectPositionList;
import org.geosdi.geoplatform.gml.api.parser.base.coordinate.geojson.GeoJsonCoordinateParser;
import org.geosdi.geoplatform.gml.api.parser.exception.ParserException;
import org.locationtech.jts.geom.Coordinate;

import javax.annotation.Nonnull;
import java.util.List;

import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface CoordinateBaseParser extends GeoJsonCoordinateParser {

    /**
     * @param directPosition
     * @return {@link Coordinate}
     * @throws ParserException
     */
    Coordinate parseCoordinate(@Nonnull(when = NEVER) DirectPosition directPosition) throws ParserException;

    /**
     * @param directPositionList
     * @return {@link Coordinate[]}
     * @throws ParserException
     */
    Coordinate[] parseCoordinates(@Nonnull(when = NEVER) DirectPositionList directPositionList) throws ParserException;

    /**
     * @param coord
     * @return {@link Coordinate}
     * @throws ParserException
     */
    Coordinate parseCoordinate(@Nonnull(when = NEVER) Coord coord) throws ParserException;

    /**
     * @param coordinates
     * @return {@link Coordinate[]}
     * @throws ParserException
     */
    Coordinate[] parseCoordinates(@Nonnull(when = NEVER) Coordinates coordinates) throws ParserException;

    /**
     * @param value
     * @param decimalSeparator
     * @param cs
     * @param ts
     * @return {@link Coordinate[]}
     * @throws ParserException
     */
    Coordinate[] parseCoordinates(@Nonnull(when = NEVER) String value, String decimalSeparator, String cs, String ts) throws ParserException;

    /**
     * @param value
     * @param decimalSeparator
     * @param cs
     * @return {@link Coordinate}
     * @throws ParserException
     */
    Coordinate parseCoordinate(@Nonnull(when = NEVER) String value, String decimalSeparator, String cs) throws ParserException;

    /**
     * @param coordinates
     * @return {@link Coordinate[]}
     * @throws ParserException
     */
    Coordinate[] parseCoordinate(Coordinates coordinates) throws ParserException;

    /**
     * @param positions
     * @return {@link Coordinate[]}
     * @throws ParserException
     */
    Coordinate[] parseCoordinates(@Nonnull(when = NEVER) List<? extends DirectPosition> positions) throws ParserException;

    /**
     * @param value
     * @param decimalSeparator
     * @return {@link Double}
     * @throws ParserException
     */
    double parseCoordinate(@Nonnull(when = NEVER) String value, String decimalSeparator) throws ParserException;
}