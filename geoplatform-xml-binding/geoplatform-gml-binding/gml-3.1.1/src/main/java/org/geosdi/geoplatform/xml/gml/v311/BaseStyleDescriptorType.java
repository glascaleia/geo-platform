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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.gml.w3._2001.smil20.language.AnimateColorType;
import org.geosdi.geoplatform.xml.gml.w3._2001.smil20.language.AnimateMotionType;
import org.geosdi.geoplatform.xml.gml.w3._2001.smil20.language.AnimateType;
import org.geosdi.geoplatform.xml.gml.w3._2001.smil20.language.SetType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;



/**
 * Base complex type for geometry, topology, label and graph styles.
 * 
 * <p>Java class for BaseStyleDescriptorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseStyleDescriptorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType">
 *       &lt;sequence>
 *         &lt;element name="spatialResolution" type="{http://www.opengis.net/gml}ScaleType" minOccurs="0"/>
 *         &lt;element name="styleVariation" type="{http://www.opengis.net/gml}StyleVariationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}animate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}animateMotion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}animateColor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}set" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseStyleDescriptorType", propOrder = {
    "spatialResolution",
    "styleVariation",
    "animate",
    "animateMotion",
    "animateColor",
    "set"
})
@XmlSeeAlso({
    GraphStyleType.class,
    LabelStyleType.class,
    TopologyStyleType.class,
    GeometryStyleType.class
})
public class BaseStyleDescriptorType
    extends AbstractGMLType
    implements ToString
{

    protected ScaleType spatialResolution;
    protected List<StyleVariationType> styleVariation;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<AnimateType> animate;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<AnimateMotionType> animateMotion;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<AnimateColorType> animateColor;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<SetType> set;

    /**
     * Gets the value of the spatialResolution property.
     * 
     * @return
     *     possible object is
     *     {@link ScaleType }
     *     
     */
    public ScaleType getSpatialResolution() {
        return spatialResolution;
    }

    /**
     * Sets the value of the spatialResolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScaleType }
     *     
     */
    public void setSpatialResolution(ScaleType value) {
        this.spatialResolution = value;
    }

    public boolean isSetSpatialResolution() {
        return (this.spatialResolution!= null);
    }

    /**
     * Gets the value of the styleVariation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the styleVariation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStyleVariation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StyleVariationType }
     * 
     * 
     */
    public List<StyleVariationType> getStyleVariation() {
        if (styleVariation == null) {
            styleVariation = new ArrayList<StyleVariationType>();
        }
        return this.styleVariation;
    }

    public boolean isSetStyleVariation() {
        return ((this.styleVariation!= null)&&(!this.styleVariation.isEmpty()));
    }

    public void unsetStyleVariation() {
        this.styleVariation = null;
    }

    /**
     * Gets the value of the animate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnimateType }
     * 
     * 
     */
    public List<AnimateType> getAnimate() {
        if (animate == null) {
            animate = new ArrayList<AnimateType>();
        }
        return this.animate;
    }

    public boolean isSetAnimate() {
        return ((this.animate!= null)&&(!this.animate.isEmpty()));
    }

    public void unsetAnimate() {
        this.animate = null;
    }

    /**
     * Gets the value of the animateMotion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animateMotion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimateMotion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnimateMotionType }
     * 
     * 
     */
    public List<AnimateMotionType> getAnimateMotion() {
        if (animateMotion == null) {
            animateMotion = new ArrayList<AnimateMotionType>();
        }
        return this.animateMotion;
    }

    public boolean isSetAnimateMotion() {
        return ((this.animateMotion!= null)&&(!this.animateMotion.isEmpty()));
    }

    public void unsetAnimateMotion() {
        this.animateMotion = null;
    }

    /**
     * Gets the value of the animateColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animateColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimateColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnimateColorType }
     * 
     * 
     */
    public List<AnimateColorType> getAnimateColor() {
        if (animateColor == null) {
            animateColor = new ArrayList<AnimateColorType>();
        }
        return this.animateColor;
    }

    public boolean isSetAnimateColor() {
        return ((this.animateColor!= null)&&(!this.animateColor.isEmpty()));
    }

    public void unsetAnimateColor() {
        this.animateColor = null;
    }

    /**
     * Gets the value of the set property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the set property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SetType }
     * 
     * 
     */
    public List<SetType> getSet() {
        if (set == null) {
            set = new ArrayList<SetType>();
        }
        return this.set;
    }

    public boolean isSetSet() {
        return ((this.set!= null)&&(!this.set.isEmpty()));
    }

    public void unsetSet() {
        this.set = null;
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
            ScaleType theSpatialResolution;
            theSpatialResolution = this.getSpatialResolution();
            strategy.appendField(locator, this, "spatialResolution", buffer, theSpatialResolution);
        }
        {
            List<StyleVariationType> theStyleVariation;
            theStyleVariation = (this.isSetStyleVariation()?this.getStyleVariation():null);
            strategy.appendField(locator, this, "styleVariation", buffer, theStyleVariation);
        }
        {
            List<AnimateType> theAnimate;
            theAnimate = (this.isSetAnimate()?this.getAnimate():null);
            strategy.appendField(locator, this, "animate", buffer, theAnimate);
        }
        {
            List<AnimateMotionType> theAnimateMotion;
            theAnimateMotion = (this.isSetAnimateMotion()?this.getAnimateMotion():null);
            strategy.appendField(locator, this, "animateMotion", buffer, theAnimateMotion);
        }
        {
            List<AnimateColorType> theAnimateColor;
            theAnimateColor = (this.isSetAnimateColor()?this.getAnimateColor():null);
            strategy.appendField(locator, this, "animateColor", buffer, theAnimateColor);
        }
        {
            List<SetType> theSet;
            theSet = (this.isSetSet()?this.getSet():null);
            strategy.appendField(locator, this, "set", buffer, theSet);
        }
        return buffer;
    }

    public void setStyleVariation(List<StyleVariationType> value) {
        this.styleVariation = null;
        List<StyleVariationType> draftl = this.getStyleVariation();
        draftl.addAll(value);
    }

    public void setAnimate(List<AnimateType> value) {
        this.animate = null;
        List<AnimateType> draftl = this.getAnimate();
        draftl.addAll(value);
    }

    public void setAnimateMotion(List<AnimateMotionType> value) {
        this.animateMotion = null;
        List<AnimateMotionType> draftl = this.getAnimateMotion();
        draftl.addAll(value);
    }

    public void setAnimateColor(List<AnimateColorType> value) {
        this.animateColor = null;
        List<AnimateColorType> draftl = this.getAnimateColor();
        draftl.addAll(value);
    }

    public void setSet(List<SetType> value) {
        this.set = null;
        List<SetType> draftl = this.getSet();
        draftl.addAll(value);
    }

}
