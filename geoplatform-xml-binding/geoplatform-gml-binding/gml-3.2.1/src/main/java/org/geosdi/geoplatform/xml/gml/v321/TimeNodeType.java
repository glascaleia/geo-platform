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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for TimeNodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeNodeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractTimeTopologyPrimitiveType">
 *       &lt;sequence>
 *         &lt;element name="previousEdge" type="{http://www.opengis.net/gml/3.2}TimeEdgePropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nextEdge" type="{http://www.opengis.net/gml/3.2}TimeEdgePropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="position" type="{http://www.opengis.net/gml/3.2}TimeInstantPropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeNodeType", propOrder = {
    "previousEdge",
    "nextEdge",
    "position"
})
public class TimeNodeType
    extends AbstractTimeTopologyPrimitiveType
    implements ToString
{

    protected List<TimeEdgePropertyType> previousEdge;
    protected List<TimeEdgePropertyType> nextEdge;
    protected TimeInstantPropertyType position;

    /**
     * Gets the value of the previousEdge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previousEdge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreviousEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimeEdgePropertyType }
     * 
     * 
     */
    public List<TimeEdgePropertyType> getPreviousEdge() {
        if (previousEdge == null) {
            previousEdge = new ArrayList<TimeEdgePropertyType>();
        }
        return this.previousEdge;
    }

    public boolean isSetPreviousEdge() {
        return ((this.previousEdge!= null)&&(!this.previousEdge.isEmpty()));
    }

    public void unsetPreviousEdge() {
        this.previousEdge = null;
    }

    /**
     * Gets the value of the nextEdge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nextEdge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNextEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimeEdgePropertyType }
     * 
     * 
     */
    public List<TimeEdgePropertyType> getNextEdge() {
        if (nextEdge == null) {
            nextEdge = new ArrayList<TimeEdgePropertyType>();
        }
        return this.nextEdge;
    }

    public boolean isSetNextEdge() {
        return ((this.nextEdge!= null)&&(!this.nextEdge.isEmpty()));
    }

    public void unsetNextEdge() {
        this.nextEdge = null;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link TimeInstantPropertyType }
     *     
     */
    public TimeInstantPropertyType getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeInstantPropertyType }
     *     
     */
    public void setPosition(TimeInstantPropertyType value) {
        this.position = value;
    }

    public boolean isSetPosition() {
        return (this.position!= null);
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
            List<TimeEdgePropertyType> thePreviousEdge;
            thePreviousEdge = (this.isSetPreviousEdge()?this.getPreviousEdge():null);
            strategy.appendField(locator, this, "previousEdge", buffer, thePreviousEdge);
        }
        {
            List<TimeEdgePropertyType> theNextEdge;
            theNextEdge = (this.isSetNextEdge()?this.getNextEdge():null);
            strategy.appendField(locator, this, "nextEdge", buffer, theNextEdge);
        }
        {
            TimeInstantPropertyType thePosition;
            thePosition = this.getPosition();
            strategy.appendField(locator, this, "position", buffer, thePosition);
        }
        return buffer;
    }

    public void setPreviousEdge(List<TimeEdgePropertyType> value) {
        this.previousEdge = null;
        List<TimeEdgePropertyType> draftl = this.getPreviousEdge();
        draftl.addAll(value);
    }

    public void setNextEdge(List<TimeEdgePropertyType> value) {
        this.nextEdge = null;
        List<TimeEdgePropertyType> draftl = this.getNextEdge();
        draftl.addAll(value);
    }

}
