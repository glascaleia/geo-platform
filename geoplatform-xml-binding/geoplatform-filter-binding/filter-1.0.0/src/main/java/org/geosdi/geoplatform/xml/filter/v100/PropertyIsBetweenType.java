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
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.09.20 alle 09:29:16 AM CEST 
//


package org.geosdi.geoplatform.xml.filter.v100;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Classe Java per PropertyIsBetweenType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="PropertyIsBetweenType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/ogc}ComparisonOpsType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/ogc}expression"/&gt;
 *         &lt;element name="LowerBoundary" type="{http://www.opengis.net/ogc}LowerBoundaryType"/&gt;
 *         &lt;element name="UpperBoundary" type="{http://www.opengis.net/ogc}UpperBoundaryType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyIsBetweenType", propOrder = {
    "expression",
    "lowerBoundary",
    "upperBoundary"
})
public class PropertyIsBetweenType
    extends ComparisonOpsType
    implements ToString2
{

    @XmlElementRef(name = "expression", namespace = "http://www.opengis.net/ogc", type = JAXBElement.class)
    protected JAXBElement<?> expression;
    @XmlElement(name = "LowerBoundary", required = true)
    protected LowerBoundaryType lowerBoundary;
    @XmlElement(name = "UpperBoundary", required = true)
    protected UpperBoundaryType upperBoundary;

    /**
     * Recupera il valore della proprietà expression.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PropertyNameType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FunctionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LiteralType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
     *     
     */
    public JAXBElement<?> getExpression() {
        return expression;
    }

    /**
     * Imposta il valore della proprietà expression.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PropertyNameType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FunctionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LiteralType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryOperatorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
     *     
     */
    public void setExpression(JAXBElement<?> value) {
        this.expression = value;
    }

    public boolean isSetExpression() {
        return (this.expression!= null);
    }

    /**
     * Recupera il valore della proprietà lowerBoundary.
     * 
     * @return
     *     possible object is
     *     {@link LowerBoundaryType }
     *     
     */
    public LowerBoundaryType getLowerBoundary() {
        return lowerBoundary;
    }

    /**
     * Imposta il valore della proprietà lowerBoundary.
     * 
     * @param value
     *     allowed object is
     *     {@link LowerBoundaryType }
     *     
     */
    public void setLowerBoundary(LowerBoundaryType value) {
        this.lowerBoundary = value;
    }

    public boolean isSetLowerBoundary() {
        return (this.lowerBoundary!= null);
    }

    /**
     * Recupera il valore della proprietà upperBoundary.
     * 
     * @return
     *     possible object is
     *     {@link UpperBoundaryType }
     *     
     */
    public UpperBoundaryType getUpperBoundary() {
        return upperBoundary;
    }

    /**
     * Imposta il valore della proprietà upperBoundary.
     * 
     * @param value
     *     allowed object is
     *     {@link UpperBoundaryType }
     *     
     */
    public void setUpperBoundary(UpperBoundaryType value) {
        this.upperBoundary = value;
    }

    public boolean isSetUpperBoundary() {
        return (this.upperBoundary!= null);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            JAXBElement<?> theExpression;
            theExpression = this.getExpression();
            strategy.appendField(locator, this, "expression", buffer, theExpression, this.isSetExpression());
        }
        {
            LowerBoundaryType theLowerBoundary;
            theLowerBoundary = this.getLowerBoundary();
            strategy.appendField(locator, this, "lowerBoundary", buffer, theLowerBoundary, this.isSetLowerBoundary());
        }
        {
            UpperBoundaryType theUpperBoundary;
            theUpperBoundary = this.getUpperBoundary();
            strategy.appendField(locator, this, "upperBoundary", buffer, theUpperBoundary, this.isSetUpperBoundary());
        }
        return buffer;
    }

}
