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
// Generated on: 2015.06.17 at 04:41:23 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20060504.src;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.AbstractObjectType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.CharacterStringPropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gmd.CIOnlineResourcePropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for SV_OperationMetadata_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SV_OperationMetadata_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gco}AbstractObject_Type">
 *       &lt;sequence>
 *         &lt;element name="operationName" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="DCP" type="{http://www.isotc211.org/2005/srv}DCPList_PropertyType" maxOccurs="unbounded"/>
 *         &lt;element name="operationDescription" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="invocationName" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="parameters" type="{http://www.isotc211.org/2005/srv}SV_Parameter_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="connectPoint" type="{http://www.isotc211.org/2005/gmd}CI_OnlineResource_PropertyType" maxOccurs="unbounded"/>
 *         &lt;element name="dependsOn" type="{http://www.isotc211.org/2005/srv}SV_OperationMetadata_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SV_OperationMetadata_Type", propOrder = {
    "operationName",
    "dcp",
    "operationDescription",
    "invocationName",
    "parameters",
    "connectPoint",
    "dependsOn"
})
public class SVOperationMetadataType
    extends AbstractObjectType
    implements ToString
{

    @XmlElement(required = true)
    protected CharacterStringPropertyType operationName;
    @XmlElement(name = "DCP", required = true)
    protected List<DCPListPropertyType> dcp;
    protected CharacterStringPropertyType operationDescription;
    protected CharacterStringPropertyType invocationName;
    protected List<SVParameterPropertyType> parameters;
    @XmlElement(required = true)
    protected List<CIOnlineResourcePropertyType> connectPoint;
    protected List<SVOperationMetadataPropertyType> dependsOn;

    /**
     * Gets the value of the operationName property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getOperationName() {
        return operationName;
    }

    /**
     * Sets the value of the operationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setOperationName(CharacterStringPropertyType value) {
        this.operationName = value;
    }

    public boolean isSetOperationName() {
        return (this.operationName!= null);
    }

    /**
     * Gets the value of the dcp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dcp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDCP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DCPListPropertyType }
     * 
     * 
     */
    public List<DCPListPropertyType> getDCP() {
        if (dcp == null) {
            dcp = new ArrayList<DCPListPropertyType>();
        }
        return this.dcp;
    }

    public boolean isSetDCP() {
        return ((this.dcp!= null)&&(!this.dcp.isEmpty()));
    }

    public void unsetDCP() {
        this.dcp = null;
    }

    /**
     * Gets the value of the operationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getOperationDescription() {
        return operationDescription;
    }

    /**
     * Sets the value of the operationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setOperationDescription(CharacterStringPropertyType value) {
        this.operationDescription = value;
    }

    public boolean isSetOperationDescription() {
        return (this.operationDescription!= null);
    }

    /**
     * Gets the value of the invocationName property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getInvocationName() {
        return invocationName;
    }

    /**
     * Sets the value of the invocationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setInvocationName(CharacterStringPropertyType value) {
        this.invocationName = value;
    }

    public boolean isSetInvocationName() {
        return (this.invocationName!= null);
    }

    /**
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SVParameterPropertyType }
     * 
     * 
     */
    public List<SVParameterPropertyType> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<SVParameterPropertyType>();
        }
        return this.parameters;
    }

    public boolean isSetParameters() {
        return ((this.parameters!= null)&&(!this.parameters.isEmpty()));
    }

    public void unsetParameters() {
        this.parameters = null;
    }

    /**
     * Gets the value of the connectPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CIOnlineResourcePropertyType }
     * 
     * 
     */
    public List<CIOnlineResourcePropertyType> getConnectPoint() {
        if (connectPoint == null) {
            connectPoint = new ArrayList<CIOnlineResourcePropertyType>();
        }
        return this.connectPoint;
    }

    public boolean isSetConnectPoint() {
        return ((this.connectPoint!= null)&&(!this.connectPoint.isEmpty()));
    }

    public void unsetConnectPoint() {
        this.connectPoint = null;
    }

    /**
     * Gets the value of the dependsOn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependsOn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependsOn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SVOperationMetadataPropertyType }
     * 
     * 
     */
    public List<SVOperationMetadataPropertyType> getDependsOn() {
        if (dependsOn == null) {
            dependsOn = new ArrayList<SVOperationMetadataPropertyType>();
        }
        return this.dependsOn;
    }

    public boolean isSetDependsOn() {
        return ((this.dependsOn!= null)&&(!this.dependsOn.isEmpty()));
    }

    public void unsetDependsOn() {
        this.dependsOn = null;
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
            CharacterStringPropertyType theOperationName;
            theOperationName = this.getOperationName();
            strategy.appendField(locator, this, "operationName", buffer, theOperationName);
        }
        {
            List<DCPListPropertyType> theDCP;
            theDCP = (this.isSetDCP()?this.getDCP():null);
            strategy.appendField(locator, this, "dcp", buffer, theDCP);
        }
        {
            CharacterStringPropertyType theOperationDescription;
            theOperationDescription = this.getOperationDescription();
            strategy.appendField(locator, this, "operationDescription", buffer, theOperationDescription);
        }
        {
            CharacterStringPropertyType theInvocationName;
            theInvocationName = this.getInvocationName();
            strategy.appendField(locator, this, "invocationName", buffer, theInvocationName);
        }
        {
            List<SVParameterPropertyType> theParameters;
            theParameters = (this.isSetParameters()?this.getParameters():null);
            strategy.appendField(locator, this, "parameters", buffer, theParameters);
        }
        {
            List<CIOnlineResourcePropertyType> theConnectPoint;
            theConnectPoint = (this.isSetConnectPoint()?this.getConnectPoint():null);
            strategy.appendField(locator, this, "connectPoint", buffer, theConnectPoint);
        }
        {
            List<SVOperationMetadataPropertyType> theDependsOn;
            theDependsOn = (this.isSetDependsOn()?this.getDependsOn():null);
            strategy.appendField(locator, this, "dependsOn", buffer, theDependsOn);
        }
        return buffer;
    }

    public void setDCP(List<DCPListPropertyType> value) {
        this.dcp = null;
        List<DCPListPropertyType> draftl = this.getDCP();
        draftl.addAll(value);
    }

    public void setParameters(List<SVParameterPropertyType> value) {
        this.parameters = null;
        List<SVParameterPropertyType> draftl = this.getParameters();
        draftl.addAll(value);
    }

    public void setConnectPoint(List<CIOnlineResourcePropertyType> value) {
        this.connectPoint = null;
        List<CIOnlineResourcePropertyType> draftl = this.getConnectPoint();
        draftl.addAll(value);
    }

    public void setDependsOn(List<SVOperationMetadataPropertyType> value) {
        this.dependsOn = null;
        List<SVOperationMetadataPropertyType> draftl = this.getDependsOn();
        draftl.addAll(value);
    }

}
