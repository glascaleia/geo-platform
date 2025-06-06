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


package org.geosdi.geoplatform.xml.iso19139.v20060504.gmd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.BooleanPropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.CharacterStringPropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.GenericNamePropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Information identifing the feature catalogue
 * 
 * <p>Java class for MD_FeatureCatalogueDescription_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MD_FeatureCatalogueDescription_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmd}AbstractMD_ContentInformation_Type">
 *       &lt;sequence>
 *         &lt;element name="complianceCode" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includedWithDataset" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType"/>
 *         &lt;element name="featureTypes" type="{http://www.isotc211.org/2005/gco}GenericName_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featureCatalogueCitation" type="{http://www.isotc211.org/2005/gmd}CI_Citation_PropertyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MD_FeatureCatalogueDescription_Type", propOrder = {
    "complianceCode",
    "language",
    "includedWithDataset",
    "featureTypes",
    "featureCatalogueCitation"
})
public class MDFeatureCatalogueDescriptionType
    extends AbstractMDContentInformationType
    implements ToString
{

    protected BooleanPropertyType complianceCode;
    protected List<CharacterStringPropertyType> language;
    @XmlElement(required = true)
    protected BooleanPropertyType includedWithDataset;
    protected List<GenericNamePropertyType> featureTypes;
    @XmlElement(required = true)
    protected List<CICitationPropertyType> featureCatalogueCitation;

    /**
     * Gets the value of the complianceCode property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getComplianceCode() {
        return complianceCode;
    }

    /**
     * Sets the value of the complianceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setComplianceCode(BooleanPropertyType value) {
        this.complianceCode = value;
    }

    public boolean isSetComplianceCode() {
        return (this.complianceCode!= null);
    }

    /**
     * Gets the value of the language property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the language property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacterStringPropertyType }
     * 
     * 
     */
    public List<CharacterStringPropertyType> getLanguage() {
        if (language == null) {
            language = new ArrayList<CharacterStringPropertyType>();
        }
        return this.language;
    }

    public boolean isSetLanguage() {
        return ((this.language!= null)&&(!this.language.isEmpty()));
    }

    public void unsetLanguage() {
        this.language = null;
    }

    /**
     * Gets the value of the includedWithDataset property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getIncludedWithDataset() {
        return includedWithDataset;
    }

    /**
     * Sets the value of the includedWithDataset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setIncludedWithDataset(BooleanPropertyType value) {
        this.includedWithDataset = value;
    }

    public boolean isSetIncludedWithDataset() {
        return (this.includedWithDataset!= null);
    }

    /**
     * Gets the value of the featureTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericNamePropertyType }
     * 
     * 
     */
    public List<GenericNamePropertyType> getFeatureTypes() {
        if (featureTypes == null) {
            featureTypes = new ArrayList<GenericNamePropertyType>();
        }
        return this.featureTypes;
    }

    public boolean isSetFeatureTypes() {
        return ((this.featureTypes!= null)&&(!this.featureTypes.isEmpty()));
    }

    public void unsetFeatureTypes() {
        this.featureTypes = null;
    }

    /**
     * Gets the value of the featureCatalogueCitation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureCatalogueCitation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureCatalogueCitation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CICitationPropertyType }
     * 
     * 
     */
    public List<CICitationPropertyType> getFeatureCatalogueCitation() {
        if (featureCatalogueCitation == null) {
            featureCatalogueCitation = new ArrayList<CICitationPropertyType>();
        }
        return this.featureCatalogueCitation;
    }

    public boolean isSetFeatureCatalogueCitation() {
        return ((this.featureCatalogueCitation!= null)&&(!this.featureCatalogueCitation.isEmpty()));
    }

    public void unsetFeatureCatalogueCitation() {
        this.featureCatalogueCitation = null;
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
            BooleanPropertyType theComplianceCode;
            theComplianceCode = this.getComplianceCode();
            strategy.appendField(locator, this, "complianceCode", buffer, theComplianceCode);
        }
        {
            List<CharacterStringPropertyType> theLanguage;
            theLanguage = (this.isSetLanguage()?this.getLanguage():null);
            strategy.appendField(locator, this, "language", buffer, theLanguage);
        }
        {
            BooleanPropertyType theIncludedWithDataset;
            theIncludedWithDataset = this.getIncludedWithDataset();
            strategy.appendField(locator, this, "includedWithDataset", buffer, theIncludedWithDataset);
        }
        {
            List<GenericNamePropertyType> theFeatureTypes;
            theFeatureTypes = (this.isSetFeatureTypes()?this.getFeatureTypes():null);
            strategy.appendField(locator, this, "featureTypes", buffer, theFeatureTypes);
        }
        {
            List<CICitationPropertyType> theFeatureCatalogueCitation;
            theFeatureCatalogueCitation = (this.isSetFeatureCatalogueCitation()?this.getFeatureCatalogueCitation():null);
            strategy.appendField(locator, this, "featureCatalogueCitation", buffer, theFeatureCatalogueCitation);
        }
        return buffer;
    }

    public void setLanguage(List<CharacterStringPropertyType> value) {
        this.language = null;
        List<CharacterStringPropertyType> draftl = this.getLanguage();
        draftl.addAll(value);
    }

    public void setFeatureTypes(List<GenericNamePropertyType> value) {
        this.featureTypes = null;
        List<GenericNamePropertyType> draftl = this.getFeatureTypes();
        draftl.addAll(value);
    }

    public void setFeatureCatalogueCitation(List<CICitationPropertyType> value) {
        this.featureCatalogueCitation = null;
        List<CICitationPropertyType> draftl = this.getFeatureCatalogueCitation();
        draftl.addAll(value);
    }

}
