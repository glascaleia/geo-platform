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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.17 at 10:27:36 PM CEST 
//


package org.geosdi.geoplatform.xml.gml.v311;

import org.geosdi.geoplatform.gml.api.CurveInterpolation;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CurveInterpolationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CurveInterpolationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="linear"/>
 *     &lt;enumeration value="geodesic"/>
 *     &lt;enumeration value="circularArc3Points"/>
 *     &lt;enumeration value="circularArc2PointWithBulge"/>
 *     &lt;enumeration value="circularArcCenterPointWithRadius"/>
 *     &lt;enumeration value="elliptical"/>
 *     &lt;enumeration value="clothoid"/>
 *     &lt;enumeration value="conic"/>
 *     &lt;enumeration value="polynomialSpline"/>
 *     &lt;enumeration value="cubicSpline"/>
 *     &lt;enumeration value="rationalSpline"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CurveInterpolationType")
@XmlEnum
public enum CurveInterpolationType implements CurveInterpolation {

    @XmlEnumValue("linear")
    LINEAR("linear"),
    @XmlEnumValue("geodesic")
    GEODESIC("geodesic"),
    @XmlEnumValue("circularArc3Points")
    CIRCULAR_ARC_3_POINTS("circularArc3Points"),
    @XmlEnumValue("circularArc2PointWithBulge")
    CIRCULAR_ARC_2_POINT_WITH_BULGE("circularArc2PointWithBulge"),
    @XmlEnumValue("circularArcCenterPointWithRadius")
    CIRCULAR_ARC_CENTER_POINT_WITH_RADIUS("circularArcCenterPointWithRadius"),
    @XmlEnumValue("elliptical")
    ELLIPTICAL("elliptical"),
    @XmlEnumValue("clothoid")
    CLOTHOID("clothoid"),
    @XmlEnumValue("conic")
    CONIC("conic"),
    @XmlEnumValue("polynomialSpline")
    POLYNOMIAL_SPLINE("polynomialSpline"),
    @XmlEnumValue("cubicSpline")
    CUBIC_SPLINE("cubicSpline"),
    @XmlEnumValue("rationalSpline")
    RATIONAL_SPLINE("rationalSpline");
    private final String value;

    CurveInterpolationType(String v) {
        value = v;
    }

    /**
     * @return {@link String}
     */
    @Override
    public String value() {
        return value;
    }

    public static CurveInterpolationType fromValue(String v) {
        for (CurveInterpolationType c: CurveInterpolationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
