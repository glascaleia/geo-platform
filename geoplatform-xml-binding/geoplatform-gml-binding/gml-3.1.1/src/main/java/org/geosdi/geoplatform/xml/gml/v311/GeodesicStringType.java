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

import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A GeodesicString consists of sequence of
 *    geodesic segments. The type essentially combines a sequence of
 *    Geodesic into a single object.
 *    The GeodesicString is computed from two or more positions and an
 *    interpolation using geodesics defined from the geoid (or 
 *    ellipsoid) of the co-ordinate reference system being used.
 *
 * <p>Java class for GeodesicStringType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GeodesicStringType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractCurveSegmentType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.opengis.net/gml}posList"/>
 *         &lt;group ref="{http://www.opengis.net/gml}geometricPositionGroup" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/choice>
 *       &lt;attribute name="interpolation" type="{http://www.opengis.net/gml}CurveInterpolationType" fixed="geodesic" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeodesicStringType", propOrder = {"posList", "geometricPositionGroup"})
@XmlSeeAlso({GeodesicType.class})
public class GeodesicStringType extends AbstractCurveSegmentType implements ToString {

    protected DirectPositionListType posList;
    @XmlElements({
            @XmlElement(name = "pos", type = DirectPositionType.class),
            @XmlElement(name = "pointProperty", type = PointPropertyType.class)})
    protected List<Object> geometricPositionGroup;
    @XmlAttribute(name = "interpolation")
    protected CurveInterpolationType interpolation;

    /**
     * Gets the value of the posList property.
     *
     * @return
     *     possible object is
     *     {@link DirectPositionListType }
     *
     */
    public DirectPositionListType getPosList() {
        return posList;
    }

    /**
     * Sets the value of the posList property.
     *
     * @param value
     *     allowed object is
     *     {@link DirectPositionListType }
     *
     */
    public void setPosList(DirectPositionListType value) {
        this.posList = value;
    }

    public boolean isSetPosList() {
        return (this.posList != null);
    }

    /**
     * Gets the value of the geometricPositionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geometricPositionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeometricPositionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectPositionType }
     * {@link PointPropertyType }
     *
     *
     */
    public List<Object> getGeometricPositionGroup() {
        if (geometricPositionGroup == null) {
            geometricPositionGroup = new ArrayList<Object>();
        }
        return this.geometricPositionGroup;
    }

    public boolean isSetGeometricPositionGroup() {
        return ((this.geometricPositionGroup != null) && (!this.geometricPositionGroup.isEmpty()));
    }

    public void unsetGeometricPositionGroup() {
        this.geometricPositionGroup = null;
    }

    /**
     * Gets the value of the interpolation property.
     *
     * @return
     *     possible object is
     *     {@link CurveInterpolationType }
     *
     */
    public CurveInterpolationType getInterpolation() {
        if (interpolation == null) {
            return CurveInterpolationType.GEODESIC;
        } else {
            return interpolation;
        }
    }

    /**
     * Sets the value of the interpolation property.
     *
     * @param value
     *     allowed object is
     *     {@link CurveInterpolationType }
     *
     */
    public void setInterpolation(CurveInterpolationType value) {
        this.interpolation = value;
    }

    public boolean isSetInterpolation() {
        return (this.interpolation != null);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            DirectPositionListType thePosList;
            thePosList = this.getPosList();
            strategy.appendField(locator, this, "posList", buffer, thePosList);
        }
        {
            List<Object> theGeometricPositionGroup;
            theGeometricPositionGroup = (this.isSetGeometricPositionGroup() ? this.getGeometricPositionGroup() : null);
            strategy.appendField(locator, this, "geometricPositionGroup", buffer, theGeometricPositionGroup);
        }
        {
            CurveInterpolationType theInterpolation;
            theInterpolation = this.getInterpolation();
            strategy.appendField(locator, this, "interpolation", buffer, theInterpolation);
        }
        return buffer;
    }

    public void setGeometricPositionGroup(List<Object> value) {
        this.geometricPositionGroup = null;
        List<Object> draftl = this.getGeometricPositionGroup();
        draftl.addAll(value);
    }

}
