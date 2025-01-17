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
package org.geosdi.geoplatform.gml.impl.v311.jts;

import org.geojson.GeoJsonObject;
import org.geosdi.geoplatform.gml.impl.v311.AbstractGMLParserTest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.WKTReader;

import java.io.File;
import java.io.StringWriter;

import static java.io.File.separator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class JTSSextanteParserTest extends AbstractGMLParserTest {

    @Before
    public void setUp() throws Exception {
        reader = new WKTReader(geometryFactory);
    }

    @Test
    public void a_a_testPoint() throws Exception {
        Coordinate ptc = new Coordinate(10, 20);
        Point point = geometryFactory.createPoint(ptc);
        point.setSRID(4326);
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(point, writer);
        logger.info("GML V311 Point : \n\n" + writer);
    }

    @Test
    public void a_b_testLineString() throws Exception {
        Coordinate[] lsc = new Coordinate[8];
        lsc[0] = new Coordinate(5.0d, 5.0d);
        lsc[1] = new Coordinate(6.0d, 5.0d);
        lsc[2] = new Coordinate(6.0d, 6.0d);
        lsc[3] = new Coordinate(7.0d, 6.0d);
        lsc[4] = new Coordinate(7.0d, 7.0d);
        lsc[5] = new Coordinate(8.0d, 7.0d);
        lsc[6] = new Coordinate(8.0d, 8.0d);
        lsc[7] = new Coordinate(9.0d, 9.0d);
        LineString lineString = geometryFactory.createLineString(lsc);
        lineString.setSRID(4326);
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(lineString, writer);
        logger.info("GML V311 LineString : {}\n\n", writer);
    }

    @Test
    public void a_c_testLinearRing() throws Exception {
        Coordinate[] lrc = new Coordinate[10];
        lrc[0] = new Coordinate(7, 7);
        lrc[1] = new Coordinate(6, 9);
        lrc[2] = new Coordinate(6, 11);
        lrc[3] = new Coordinate(7, 12);
        lrc[4] = new Coordinate(9, 11);
        lrc[5] = new Coordinate(11, 12);
        lrc[6] = new Coordinate(13, 11);
        lrc[7] = new Coordinate(13, 9);
        lrc[8] = new Coordinate(11, 7);
        lrc[9] = new Coordinate(7, 7);
        LinearRing linearRing = geometryFactory.createLinearRing(lrc);
        linearRing.setSRID(4326);
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(linearRing, writer);
        logger.info("GML V311 LinearRing : \n\n" + writer);
    }

    @Test
    public void a_d_testPolygon() throws Exception {
        Geometry polygon = reader.read("POLYGON ((35 10, 10 20, 15 40,"
                + " 45 45, 35 10), (20 30, 35 35, 30 20, 20 30))");
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(polygon, writer);
        logger.info("GML V311 Polygon : \n\n" + writer);
    }

    @Test
    public void a_e_testMultiPoint() throws Exception {
        Geometry multiPoint = reader.read("MULTIPOINT ((10 40), (40 30), (20 20), (30 10))");
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(multiPoint, writer);
        logger.info("GML V311 MultiPoint : \n\n" + writer);
    }

    @Test
    public void a_f_testMultiLineString() throws Exception {
        Geometry multiLineString = reader.read("MULTILINESTRING ((10 10, 20 20, 10 40), "
                        + "(40 40, 30 30, 40 20, 30 10))");
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(multiLineString, writer);
        logger.info("GML V311 MultiLineString : \n\n" + writer);
    }

    @Test
    public void a_g_testMultiPolygon() throws Exception {
        Geometry multiPolygon = reader.read("MULTIPOLYGON (((40 40, 20 45,"
                + " 45 30, 40 40)), ((20 35, 45 20, 30 5, "
                + "10 10, 10 30, 20 35), (30 20, 20 25, 20 15, 30 20)))");
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(multiPolygon, writer);
        logger.info("GML V311 MultiPolygon : \n\n" + writer);
    }

    @Test
    public void a_h_testGeometryCollection() throws Exception {
        Geometry geometryCollection = reader.read("GEOMETRYCOLLECTION(POINT(0 0), "
                        + "POINT(1 0), POINT(1 1), POINT(0 1), LINESTRING(4 6,7 10), "
                        + "POLYGON ((35 10, 10 20, 15 40, 45 45, 35 10),"
                        + "(20 30, 35 35, 30 20, 20 30)), LINEARRING (7 7, 6 9, 6 11,"
                        + " 7 12, 9 11, 11 12, 13 11, 13 9, 11 7, 7 7))");
        StringWriter writer = new StringWriter();
        jaxbContext.acquireMarshaller().marshal(geometryCollection, writer);
        logger.info("GML V311 Geometry Collection : \n\n" + writer);
    }

    @Test
    public void a_i_unmarshalGMLGeometryTest() throws Exception {
        Point geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Point.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_POINT_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_l_unmarshalGMLGeometryTest() throws Exception {
        Polygon geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Polygon.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_POLYGON_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_m_unmarshalGMLGeometryTest() throws Exception {
        LinearRing geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "LinearRing.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_LINEAR_RING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_n_unmarshalGMLGeometryTest() throws Exception {
        LineString geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "LineString.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_o_unmarshalGMLGeometryTest() throws Exception {
        MultiPoint geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiPoint.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_POINT_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_p_unmarshalGMLGeometryTest() throws Exception {
        MultiPolygon geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiPolygon.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_POLYGON_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_q_unmarshalGMLGeometryTest() throws Exception {
        MultiLineString geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiLineString.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_r_unmarshalGMLGeometryTest() throws Exception {
        MultiLineString geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiLineString_srsDimension3.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_s_unmarshalGMLGeometryTest() throws Exception {
        Geometry geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiCurve.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_CURVE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_t_unmarshalGMLGeometryTest() throws Exception {
        Geometry geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_SURFACE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_u_unmarshalGMLGeometryTest() throws Exception {
        GeometryCollection geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "GeometryCollection.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_GEOMETRY_COLLECTION : {}\n", geometry);
    }

    @Test
    public void a_v_unmarshalGMLGeometryTest() throws Exception {
        Geometry geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface1.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_SURFACE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_w_unmarshalGMLGeometryTest() throws Exception {
        Geometry geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface2.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_SURFACE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_x_unmarshalGMLGeometryTest() throws Exception {
        Geometry geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface3.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_SURFACE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_y_unmarshalGMLGeometryTest() throws Exception {
        Geometry geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Curve1.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_CURVE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void a_z_unmarshalGMLGeometryTest() throws Exception {
        Geometry geometry = jaxbContext.acquireUnmarshaller().unmarshal(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Curve2.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_CURVE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_a_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.Point geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Point.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_POINT_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_b_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.Polygon geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Polygon.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_POLYGON_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_c_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.LineString geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "LinearRing.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_d_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.LineString geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "LineString.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_e_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.MultiPoint geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiPoint.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_POINT_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_f_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.MultiPolygon geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiPolygon.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_POLYGON_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_g_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.MultiLineString geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiLineString.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_h_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.MultiLineString geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiLineString_srsDimension3.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_i_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.MultiLineString geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiCurve.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_l_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.MultiPolygon geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_SURFACE_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_m_unmarshalGMLGeometryTest() throws Exception {
        org.geojson.GeometryCollection geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "GeometryCollection.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_GEOMETRY_COLLECTION : {}\n", geometry);
    }

    @Test
    public void b_n_unmarshalGMLGeometryTest() throws Exception {
        GeoJsonObject geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface1.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_POLYGON_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_o_unmarshalGMLGeometryTest() throws Exception {
        GeoJsonObject geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface2.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_POLYGON_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_p_unmarshalGMLGeometryTest() throws Exception {
        GeoJsonObject geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "MultiSurface3.xml")
                .collect(joining(separator))));
        logger.info("#################JTS_MULTI_POLYGON_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_q_unmarshalGMLGeometryTest() throws Exception {
        GeoJsonObject geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Curve1.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_LINESTRING_GEOMETRY : {}\n", geometry);
    }

    @Test
    public void b_r_unmarshalGMLGeometryTest() throws Exception {
        GeoJsonObject geometry = jaxbContext.acquireUnmarshaller().unmarshalAsGeoJson(new File(of(new File(".").getCanonicalPath(),
                "src", "test", "resources", "Curve2.xml")
                .collect(joining(separator))));
        logger.info("#################GEOJSON_MULTI_LINESTRING_GEOMETRY : {}\n", geometry);
    }
}