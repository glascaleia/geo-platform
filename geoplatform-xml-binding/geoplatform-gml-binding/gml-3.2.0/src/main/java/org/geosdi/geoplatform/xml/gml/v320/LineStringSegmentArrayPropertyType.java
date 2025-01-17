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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * gml:LineStringSegmentArrayPropertyType provides a container for line strings.
 * 
 * <p>Classe Java per LineStringSegmentArrayPropertyType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="LineStringSegmentArrayPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://www.opengis.net/gml}LineStringSegment"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineStringSegmentArrayPropertyType", propOrder = {
    "lineStringSegment"
})
public class LineStringSegmentArrayPropertyType
    implements Cloneable, CopyTo, Equals, HashCode, MergeFrom, ToString
{

    @XmlElement(name = "LineStringSegment")
    protected List<LineStringSegmentType> lineStringSegment;

    /**
     * Gets the value of the lineStringSegment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineStringSegment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineStringSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineStringSegmentType }
     * 
     * 
     */
    public List<LineStringSegmentType> getLineStringSegment() {
        if (lineStringSegment == null) {
            lineStringSegment = new ArrayList<LineStringSegmentType>();
        }
        return this.lineStringSegment;
    }

    public boolean isSetLineStringSegment() {
        return ((this.lineStringSegment!= null)&&(!this.lineStringSegment.isEmpty()));
    }

    public void unsetLineStringSegment() {
        this.lineStringSegment = null;
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
        {
            List<LineStringSegmentType> theLineStringSegment;
            theLineStringSegment = this.getLineStringSegment();
            strategy.appendField(locator, this, "lineStringSegment", buffer, theLineStringSegment);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LineStringSegmentArrayPropertyType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LineStringSegmentArrayPropertyType that = ((LineStringSegmentArrayPropertyType) object);
        {
            List<LineStringSegmentType> lhsLineStringSegment;
            lhsLineStringSegment = this.getLineStringSegment();
            List<LineStringSegmentType> rhsLineStringSegment;
            rhsLineStringSegment = that.getLineStringSegment();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lineStringSegment", lhsLineStringSegment), LocatorUtils.property(thatLocator, "lineStringSegment", rhsLineStringSegment), lhsLineStringSegment, rhsLineStringSegment)) {
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
        int currentHashCode = 1;
        {
            List<LineStringSegmentType> theLineStringSegment;
            theLineStringSegment = this.getLineStringSegment();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lineStringSegment", theLineStringSegment), currentHashCode, theLineStringSegment);
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
        if (draftCopy instanceof LineStringSegmentArrayPropertyType) {
            final LineStringSegmentArrayPropertyType copy = ((LineStringSegmentArrayPropertyType) draftCopy);
            if (this.isSetLineStringSegment()) {
                List<LineStringSegmentType> sourceLineStringSegment;
                sourceLineStringSegment = this.getLineStringSegment();
                @SuppressWarnings("unchecked")
                List<LineStringSegmentType> copyLineStringSegment = ((List<LineStringSegmentType> ) strategy.copy(LocatorUtils.property(locator, "lineStringSegment", sourceLineStringSegment), sourceLineStringSegment));
                copy.unsetLineStringSegment();
                List<LineStringSegmentType> uniqueLineStringSegmentl = copy.getLineStringSegment();
                uniqueLineStringSegmentl.addAll(copyLineStringSegment);
            } else {
                copy.unsetLineStringSegment();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new LineStringSegmentArrayPropertyType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy strategy) {
        if (right instanceof LineStringSegmentArrayPropertyType) {
            final LineStringSegmentArrayPropertyType target = this;
            final LineStringSegmentArrayPropertyType leftObject = ((LineStringSegmentArrayPropertyType) left);
            final LineStringSegmentArrayPropertyType rightObject = ((LineStringSegmentArrayPropertyType) right);
            {
                List<LineStringSegmentType> lhsLineStringSegment;
                lhsLineStringSegment = leftObject.getLineStringSegment();
                List<LineStringSegmentType> rhsLineStringSegment;
                rhsLineStringSegment = rightObject.getLineStringSegment();
                target.unsetLineStringSegment();
                List<LineStringSegmentType> uniqueLineStringSegmentl = target.getLineStringSegment();
                uniqueLineStringSegmentl.addAll(((List<LineStringSegmentType> ) strategy.merge(LocatorUtils.property(leftLocator, "lineStringSegment", lhsLineStringSegment), LocatorUtils.property(rightLocator, "lineStringSegment", rhsLineStringSegment), lhsLineStringSegment, rhsLineStringSegment)));
            }
        }
    }

    public void setLineStringSegment(List<LineStringSegmentType> value) {
        List<LineStringSegmentType> draftl = this.getLineStringSegment();
        draftl.addAll(value);
    }

    public LineStringSegmentArrayPropertyType withLineStringSegment(LineStringSegmentType... values) {
        if (values!= null) {
            for (LineStringSegmentType value: values) {
                getLineStringSegment().add(value);
            }
        }
        return this;
    }

    public LineStringSegmentArrayPropertyType withLineStringSegment(Collection<LineStringSegmentType> values) {
        if (values!= null) {
            getLineStringSegment().addAll(values);
        }
        return this;
    }

    public LineStringSegmentArrayPropertyType withLineStringSegment(List<LineStringSegmentType> value) {
        setLineStringSegment(value);
        return this;
    }

}
