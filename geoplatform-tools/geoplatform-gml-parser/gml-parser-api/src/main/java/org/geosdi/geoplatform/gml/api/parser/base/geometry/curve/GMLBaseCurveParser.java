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
package org.geosdi.geoplatform.gml.api.parser.base.geometry.curve;

import org.geosdi.geoplatform.gml.api.*;
import org.geosdi.geoplatform.gml.api.parser.base.AbstractGMLBaseSRSParser;
import org.geosdi.geoplatform.gml.api.parser.exception.ParserException;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GMLBaseCurveParser extends GMLCurveParser {

    /**
     * @param theGeometryFactory
     * @param theSrsParser
     */
    public GMLBaseCurveParser(@Nonnull(when = NEVER) GeometryFactory theGeometryFactory, @Nonnull(when = NEVER) AbstractGMLBaseSRSParser theSrsParser) {
        super(theGeometryFactory, theSrsParser);
    }

    /**
     * @param gmlGeometry
     * @return {@link Collection<LineString>}
     * @throws ParserException
     */
    @Override
    public Collection<LineString> parseGeometry(@Nonnull(when = NEVER) Curve gmlGeometry) throws ParserException {
        checkArgument(gmlGeometry != null, "The Parameter gmlGeometry must not be null.");
        List<LineString> lines = new ArrayList<>();
        if (gmlGeometry.isSetSegments()) {
            CurveSegmentArrayProperty curveArrySegment = gmlGeometry.getSegments();
            for (AbstractCurveSegment curveSegment : curveArrySegment.getAbstractCurveSegment()) {
                if (curveSegment instanceof LineStringSegment) {
                    lines.add(coordCurveHandler.parseGeometry(geometryFactory, (LineStringSegment) curveSegment, coordinateParser));
                } else if (curveSegment instanceof ArcString) {
                    lines.add(coordCurveHandler.parseGeometry(geometryFactory, (ArcString) curveSegment, coordinateParser));
                } else {
                    logger.warn("###################Impossible parse element : {}\n", curveSegment.getClass().getSimpleName());
                }
            }
        }
        return lines;
    }

    /**
     * @param gmlGeometry
     * @return {@link Collection<org.geojson.LineString>}
     * @throws ParserException
     */
    @Override
    public Collection<org.geojson.LineString> parseGeometryAsGeoJson(@Nonnull(when = NEVER) Curve gmlGeometry) throws ParserException {
        checkArgument(gmlGeometry != null, "The Parameter gmlGeometry must not be null.");
        List<org.geojson.LineString> lines = new ArrayList<>();
        if (gmlGeometry.isSetSegments()) {
            CurveSegmentArrayProperty curveArrySegment = gmlGeometry.getSegments();
            for (AbstractCurveSegment curveSegment : curveArrySegment.getAbstractCurveSegment()) {
                if (curveSegment instanceof LineStringSegment) {
                    lines.add(coordCurveHandler.parseGeometryAsGeoJson((LineStringSegment) curveSegment, coordinateParser));
                } else if(curveSegment instanceof ArcString) {
                    lines.add(coordCurveHandler.parseGeometryAsGeoJson((ArcString) curveSegment, coordinateParser));
                } else {
                    logger.warn("###################Impossible parse element : {}\n", curveSegment.getClass().getSimpleName());
                }
            }
        }
        return lines;
    }
}