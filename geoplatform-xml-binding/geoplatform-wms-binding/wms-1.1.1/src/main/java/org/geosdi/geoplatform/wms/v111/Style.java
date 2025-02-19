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
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.11 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.01.24 alle 07:06:40 PM CET 
//


package org.geosdi.geoplatform.wms.v111;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "title",
    "_abstract",
    "legendURL",
    "styleSheetURL",
    "styleURL"
})
@XmlRootElement(name = "Style")
public class Style implements Serializable, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Abstract")
    protected String _abstract;
    @XmlElement(name = "LegendURL")
    protected List<LegendURL> legendURL;
    @XmlElement(name = "StyleSheetURL")
    protected StyleSheetURL styleSheetURL;
    @XmlElement(name = "StyleURL")
    protected StyleURL styleURL;

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Imposta il valore della proprietà title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Recupera il valore della proprietà abstract.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * Imposta il valore della proprietà abstract.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbstract(String value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the legendURL property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legendURL property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegendURL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegendURL }
     * 
     * 
     */
    public List<LegendURL> getLegendURL() {
        if (legendURL == null) {
            legendURL = new ArrayList<LegendURL>();
        }
        return this.legendURL;
    }

    /**
     * Recupera il valore della proprietà styleSheetURL.
     * 
     * @return
     *     possible object is
     *     {@link StyleSheetURL }
     *     
     */
    public StyleSheetURL getStyleSheetURL() {
        return styleSheetURL;
    }

    /**
     * Imposta il valore della proprietà styleSheetURL.
     * 
     * @param value
     *     allowed object is
     *     {@link StyleSheetURL }
     *     
     */
    public void setStyleSheetURL(StyleSheetURL value) {
        this.styleSheetURL = value;
    }

    /**
     * Recupera il valore della proprietà styleURL.
     * 
     * @return
     *     possible object is
     *     {@link StyleURL }
     *     
     */
    public StyleURL getStyleURL() {
        return styleURL;
    }

    /**
     * Imposta il valore della proprietà styleURL.
     * 
     * @param value
     *     allowed object is
     *     {@link StyleURL }
     *     
     */
    public void setStyleURL(StyleURL value) {
        this.styleURL = value;
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
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName, (this.name!= null));
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle, (this.title!= null));
        }
        {
            String theAbstract;
            theAbstract = this.getAbstract();
            strategy.appendField(locator, this, "_abstract", buffer, theAbstract, (this._abstract!= null));
        }
        {
            List<LegendURL> theLegendURL;
            theLegendURL = (((this.legendURL!= null)&&(!this.legendURL.isEmpty()))?this.getLegendURL():null);
            strategy.appendField(locator, this, "legendURL", buffer, theLegendURL, ((this.legendURL!= null)&&(!this.legendURL.isEmpty())));
        }
        {
            StyleSheetURL theStyleSheetURL;
            theStyleSheetURL = this.getStyleSheetURL();
            strategy.appendField(locator, this, "styleSheetURL", buffer, theStyleSheetURL, (this.styleSheetURL!= null));
        }
        {
            StyleURL theStyleURL;
            theStyleURL = this.getStyleURL();
            strategy.appendField(locator, this, "styleURL", buffer, theStyleURL, (this.styleURL!= null));
        }
        return buffer;
    }

    public void setLegendURL(List<LegendURL> value) {
        this.legendURL = null;
        if (value!= null) {
            List<LegendURL> draftl = this.getLegendURL();
            draftl.addAll(value);
        }
    }

}
