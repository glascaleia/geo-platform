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
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.06.18 alle 12:52:42 AM CEST 
//


package org.geosdi.geoplatform.xml.gml.v320;

import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBMergeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.MergeFrom;
import org.jvnet.jaxb2_commons.lang.MergeStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Classe Java per ProjectedCRSType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ProjectedCRSType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGeneralDerivedCRSType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/gml}baseGeodeticCRS"/>
 *           &lt;element ref="{http://www.opengis.net/gml}baseGeographicCRS"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.opengis.net/gml}cartesianCS"/>
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
    implements Cloneable, CopyTo, Equals, HashCode, MergeFrom, ToString
{

    protected GeodeticCRSPropertyType baseGeodeticCRS;
    protected GeographicCRSPropertyType baseGeographicCRS;
    @XmlElementRef(name = "cartesianCS", namespace = "http://www.opengis.net/gml", type = JAXBElement.class)
    protected JAXBElement<CartesianCSPropertyType> cartesianCS;

    /**
     * Recupera il valore della proprietà baseGeodeticCRS.
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
     * Imposta il valore della proprietà baseGeodeticCRS.
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
     * Recupera il valore della proprietà baseGeographicCRS.
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
     * Imposta il valore della proprietà baseGeographicCRS.
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
     * Recupera il valore della proprietà cartesianCS.
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
     * Imposta il valore della proprietà cartesianCS.
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProjectedCRSType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ProjectedCRSType that = ((ProjectedCRSType) object);
        {
            GeodeticCRSPropertyType lhsBaseGeodeticCRS;
            lhsBaseGeodeticCRS = this.getBaseGeodeticCRS();
            GeodeticCRSPropertyType rhsBaseGeodeticCRS;
            rhsBaseGeodeticCRS = that.getBaseGeodeticCRS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "baseGeodeticCRS", lhsBaseGeodeticCRS), LocatorUtils.property(thatLocator, "baseGeodeticCRS", rhsBaseGeodeticCRS), lhsBaseGeodeticCRS, rhsBaseGeodeticCRS)) {
                return false;
            }
        }
        {
            GeographicCRSPropertyType lhsBaseGeographicCRS;
            lhsBaseGeographicCRS = this.getBaseGeographicCRS();
            GeographicCRSPropertyType rhsBaseGeographicCRS;
            rhsBaseGeographicCRS = that.getBaseGeographicCRS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "baseGeographicCRS", lhsBaseGeographicCRS), LocatorUtils.property(thatLocator, "baseGeographicCRS", rhsBaseGeographicCRS), lhsBaseGeographicCRS, rhsBaseGeographicCRS)) {
                return false;
            }
        }
        {
            JAXBElement<CartesianCSPropertyType> lhsCartesianCS;
            lhsCartesianCS = this.getCartesianCS();
            JAXBElement<CartesianCSPropertyType> rhsCartesianCS;
            rhsCartesianCS = that.getCartesianCS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cartesianCS", lhsCartesianCS), LocatorUtils.property(thatLocator, "cartesianCS", rhsCartesianCS), lhsCartesianCS, rhsCartesianCS)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            GeodeticCRSPropertyType theBaseGeodeticCRS;
            theBaseGeodeticCRS = this.getBaseGeodeticCRS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "baseGeodeticCRS", theBaseGeodeticCRS), currentHashCode, theBaseGeodeticCRS);
        }
        {
            GeographicCRSPropertyType theBaseGeographicCRS;
            theBaseGeographicCRS = this.getBaseGeographicCRS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "baseGeographicCRS", theBaseGeographicCRS), currentHashCode, theBaseGeographicCRS);
        }
        {
            JAXBElement<CartesianCSPropertyType> theCartesianCS;
            theCartesianCS = this.getCartesianCS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cartesianCS", theCartesianCS), currentHashCode, theCartesianCS);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        super.copyTo(locator, draftCopy, strategy);
        if (draftCopy instanceof ProjectedCRSType) {
            final ProjectedCRSType copy = ((ProjectedCRSType) draftCopy);
            if (this.isSetBaseGeodeticCRS()) {
                GeodeticCRSPropertyType sourceBaseGeodeticCRS;
                sourceBaseGeodeticCRS = this.getBaseGeodeticCRS();
                GeodeticCRSPropertyType copyBaseGeodeticCRS = ((GeodeticCRSPropertyType) strategy.copy(LocatorUtils.property(locator, "baseGeodeticCRS", sourceBaseGeodeticCRS), sourceBaseGeodeticCRS));
                copy.setBaseGeodeticCRS(copyBaseGeodeticCRS);
            } else {
                copy.baseGeodeticCRS = null;
            }
            if (this.isSetBaseGeographicCRS()) {
                GeographicCRSPropertyType sourceBaseGeographicCRS;
                sourceBaseGeographicCRS = this.getBaseGeographicCRS();
                GeographicCRSPropertyType copyBaseGeographicCRS = ((GeographicCRSPropertyType) strategy.copy(LocatorUtils.property(locator, "baseGeographicCRS", sourceBaseGeographicCRS), sourceBaseGeographicCRS));
                copy.setBaseGeographicCRS(copyBaseGeographicCRS);
            } else {
                copy.baseGeographicCRS = null;
            }
            if (this.isSetCartesianCS()) {
                JAXBElement<CartesianCSPropertyType> sourceCartesianCS;
                sourceCartesianCS = this.getCartesianCS();
                @SuppressWarnings("unchecked")
                JAXBElement<CartesianCSPropertyType> copyCartesianCS = ((JAXBElement<CartesianCSPropertyType> ) strategy.copy(LocatorUtils.property(locator, "cartesianCS", sourceCartesianCS), sourceCartesianCS));
                copy.setCartesianCS(copyCartesianCS);
            } else {
                copy.cartesianCS = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new ProjectedCRSType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof ProjectedCRSType) {
            final ProjectedCRSType target = this;
            final ProjectedCRSType leftObject = ((ProjectedCRSType) left);
            final ProjectedCRSType rightObject = ((ProjectedCRSType) right);
            {
                GeodeticCRSPropertyType lhsBaseGeodeticCRS;
                lhsBaseGeodeticCRS = leftObject.getBaseGeodeticCRS();
                GeodeticCRSPropertyType rhsBaseGeodeticCRS;
                rhsBaseGeodeticCRS = rightObject.getBaseGeodeticCRS();
                target.setBaseGeodeticCRS(((GeodeticCRSPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "baseGeodeticCRS", lhsBaseGeodeticCRS), LocatorUtils.property(rightLocator, "baseGeodeticCRS", rhsBaseGeodeticCRS), lhsBaseGeodeticCRS, rhsBaseGeodeticCRS)));
            }
            {
                GeographicCRSPropertyType lhsBaseGeographicCRS;
                lhsBaseGeographicCRS = leftObject.getBaseGeographicCRS();
                GeographicCRSPropertyType rhsBaseGeographicCRS;
                rhsBaseGeographicCRS = rightObject.getBaseGeographicCRS();
                target.setBaseGeographicCRS(((GeographicCRSPropertyType) strategy.merge(LocatorUtils.property(leftLocator, "baseGeographicCRS", lhsBaseGeographicCRS), LocatorUtils.property(rightLocator, "baseGeographicCRS", rhsBaseGeographicCRS), lhsBaseGeographicCRS, rhsBaseGeographicCRS)));
            }
            {
                JAXBElement<CartesianCSPropertyType> lhsCartesianCS;
                lhsCartesianCS = leftObject.getCartesianCS();
                JAXBElement<CartesianCSPropertyType> rhsCartesianCS;
                rhsCartesianCS = rightObject.getCartesianCS();
                target.setCartesianCS(((JAXBElement<CartesianCSPropertyType> ) strategy.merge(LocatorUtils.property(leftLocator, "cartesianCS", lhsCartesianCS), LocatorUtils.property(rightLocator, "cartesianCS", rhsCartesianCS), lhsCartesianCS, rhsCartesianCS)));
            }
        }
    }

    public ProjectedCRSType withBaseGeodeticCRS(GeodeticCRSPropertyType value) {
        setBaseGeodeticCRS(value);
        return this;
    }

    public ProjectedCRSType withBaseGeographicCRS(GeographicCRSPropertyType value) {
        setBaseGeographicCRS(value);
        return this;
    }

    public ProjectedCRSType withCartesianCS(JAXBElement<CartesianCSPropertyType> value) {
        setCartesianCS(value);
        return this;
    }

    @Override
    public ProjectedCRSType withConversion(JAXBElement<GeneralConversionPropertyType> value) {
        setConversion(value);
        return this;
    }

    @Override
    public ProjectedCRSType withDomainOfValidity(DomainOfValidityElement... values) {
        if (values!= null) {
            for (DomainOfValidityElement value: values) {
                getDomainOfValidity().add(value);
            }
        }
        return this;
    }

    @Override
    public ProjectedCRSType withDomainOfValidity(Collection<DomainOfValidityElement> values) {
        if (values!= null) {
            getDomainOfValidity().addAll(values);
        }
        return this;
    }

    @Override
    public ProjectedCRSType withScope(String... values) {
        if (values!= null) {
            for (String value: values) {
                getScope().add(value);
            }
        }
        return this;
    }

    @Override
    public ProjectedCRSType withScope(Collection<String> values) {
        if (values!= null) {
            getScope().addAll(values);
        }
        return this;
    }

    @Override
    public ProjectedCRSType withDomainOfValidity(List<DomainOfValidityElement> value) {
        setDomainOfValidity(value);
        return this;
    }

    @Override
    public ProjectedCRSType withScope(List<String> value) {
        setScope(value);
        return this;
    }

    @Override
    public ProjectedCRSType withRemarks(String value) {
        setRemarks(value);
        return this;
    }

    @Override
    public ProjectedCRSType withMetaDataProperty(MetaDataPropertyType... values) {
        if (values!= null) {
            for (MetaDataPropertyType value: values) {
                getMetaDataProperty().add(value);
            }
        }
        return this;
    }

    @Override
    public ProjectedCRSType withMetaDataProperty(Collection<MetaDataPropertyType> values) {
        if (values!= null) {
            getMetaDataProperty().addAll(values);
        }
        return this;
    }

    @Override
    public ProjectedCRSType withDescription(StringOrRefType value) {
        setDescription(value);
        return this;
    }

    @Override
    public ProjectedCRSType withDescriptionReference(ReferenceType value) {
        setDescriptionReference(value);
        return this;
    }

    @Override
    public ProjectedCRSType withIdentifier(CodeWithAuthorityType value) {
        setIdentifier(value);
        return this;
    }

    @Override
    public ProjectedCRSType withName(CodeType... values) {
        if (values!= null) {
            for (CodeType value: values) {
                getName().add(value);
            }
        }
        return this;
    }

    @Override
    public ProjectedCRSType withName(Collection<CodeType> values) {
        if (values!= null) {
            getName().addAll(values);
        }
        return this;
    }

    @Override
    public ProjectedCRSType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public ProjectedCRSType withMetaDataProperty(List<MetaDataPropertyType> value) {
        setMetaDataProperty(value);
        return this;
    }

    @Override
    public ProjectedCRSType withName(List<CodeType> value) {
        setName(value);
        return this;
    }

}
