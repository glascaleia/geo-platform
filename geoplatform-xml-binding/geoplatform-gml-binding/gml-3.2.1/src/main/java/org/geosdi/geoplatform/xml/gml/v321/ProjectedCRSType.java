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
// Generated on: 2012.04.18 at 11:58:17 AM CEST 
//


package org.geosdi.geoplatform.xml.gml.v321;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for ProjectedCRSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProjectedCRSType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractGeneralDerivedCRSType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}baseGeodeticCRS"/>
 *           &lt;element ref="{http://www.opengis.net/gml/3.2}baseGeographicCRS"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}cartesianCS"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProjectedCRSType", propOrder = {
    "baseGeodeticCRS",
    "baseGeographicCRS",
    "cartesianCS"
})
public class ProjectedCRSType
    extends AbstractGeneralDerivedCRSType
    implements ToString
{

    protected GeodeticCRSPropertyType baseGeodeticCRS;
    protected GeographicCRSPropertyType baseGeographicCRS;
    @XmlElementRef(name = "cartesianCS", namespace = "http://www.opengis.net/gml/3.2", type = JAXBElement.class)
    protected JAXBElement<CartesianCSPropertyType> cartesianCS;

    /**
     * Gets the value of the baseGeodeticCRS property.
     * 
     * @return
     *     possible object is
     *     {@link GeodeticCRSPropertyType }
     *     
     */
    public GeodeticCRSPropertyType getBaseGeodeticCRS() {
        return baseGeodeticCRS;
    }

    /**
     * Sets the value of the baseGeodeticCRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeodeticCRSPropertyType }
     *     
     */
    public void setBaseGeodeticCRS(GeodeticCRSPropertyType value) {
        this.baseGeodeticCRS = value;
    }

    public boolean isSetBaseGeodeticCRS() {
        return (this.baseGeodeticCRS!= null);
    }

    /**
     * Gets the value of the baseGeographicCRS property.
     * 
     * @return
     *     possible object is
     *     {@link GeographicCRSPropertyType }
     *     
     */
    public GeographicCRSPropertyType getBaseGeographicCRS() {
        return baseGeographicCRS;
    }

    /**
     * Sets the value of the baseGeographicCRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicCRSPropertyType }
     *     
     */
    public void setBaseGeographicCRS(GeographicCRSPropertyType value) {
        this.baseGeographicCRS = value;
    }

    public boolean isSetBaseGeographicCRS() {
        return (this.baseGeographicCRS!= null);
    }

    /**
     * Gets the value of the cartesianCS property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CartesianCSPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CartesianCSPropertyType }{@code >}
     *     
     */
    public JAXBElement<CartesianCSPropertyType> getCartesianCS() {
        return cartesianCS;
    }

    /**
     * Sets the value of the cartesianCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CartesianCSPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CartesianCSPropertyType }{@code >}
     *     
     */
    public void setCartesianCS(JAXBElement<CartesianCSPropertyType> value) {
        this.cartesianCS = value;
    }

    public boolean isSetCartesianCS() {
        return (this.cartesianCS!= null);
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
            GeodeticCRSPropertyType theBaseGeodeticCRS;
            theBaseGeodeticCRS = this.getBaseGeodeticCRS();
            strategy.appendField(locator, this, "baseGeodeticCRS", buffer, theBaseGeodeticCRS);
        }
        {
            GeographicCRSPropertyType theBaseGeographicCRS;
            theBaseGeographicCRS = this.getBaseGeographicCRS();
            strategy.appendField(locator, this, "baseGeographicCRS", buffer, theBaseGeographicCRS);
        }
        {
            JAXBElement<CartesianCSPropertyType> theCartesianCS;
            theCartesianCS = this.getCartesianCS();
            strategy.appendField(locator, this, "cartesianCS", buffer, theCartesianCS);
        }
        return buffer;
    }

}
