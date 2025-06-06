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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "BoundingBox")
public class BoundingBox implements Serializable, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "SRS", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String srs;
    @XmlAttribute(name = "minx", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String minx;
    @XmlAttribute(name = "miny", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String miny;
    @XmlAttribute(name = "maxx", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maxx;
    @XmlAttribute(name = "maxy", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maxy;
    @XmlAttribute(name = "resx")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String resx;
    @XmlAttribute(name = "resy")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String resy;

    /**
     * Recupera il valore della proprietà srs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRS() {
        return srs;
    }

    /**
     * Imposta il valore della proprietà srs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRS(String value) {
        this.srs = value;
    }

    /**
     * Recupera il valore della proprietà minx.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinx() {
        return minx;
    }

    /**
     * Imposta il valore della proprietà minx.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinx(String value) {
        this.minx = value;
    }

    /**
     * Recupera il valore della proprietà miny.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiny() {
        return miny;
    }

    /**
     * Imposta il valore della proprietà miny.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiny(String value) {
        this.miny = value;
    }

    /**
     * Recupera il valore della proprietà maxx.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxx() {
        return maxx;
    }

    /**
     * Imposta il valore della proprietà maxx.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxx(String value) {
        this.maxx = value;
    }

    /**
     * Recupera il valore della proprietà maxy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxy() {
        return maxy;
    }

    /**
     * Imposta il valore della proprietà maxy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxy(String value) {
        this.maxy = value;
    }

    /**
     * Recupera il valore della proprietà resx.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResx() {
        return resx;
    }

    /**
     * Imposta il valore della proprietà resx.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResx(String value) {
        this.resx = value;
    }

    /**
     * Recupera il valore della proprietà resy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResy() {
        return resy;
    }

    /**
     * Imposta il valore della proprietà resy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResy(String value) {
        this.resy = value;
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
            String theSRS;
            theSRS = this.getSRS();
            strategy.appendField(locator, this, "srs", buffer, theSRS, (this.srs!= null));
        }
        {
            String theMinx;
            theMinx = this.getMinx();
            strategy.appendField(locator, this, "minx", buffer, theMinx, (this.minx!= null));
        }
        {
            String theMiny;
            theMiny = this.getMiny();
            strategy.appendField(locator, this, "miny", buffer, theMiny, (this.miny!= null));
        }
        {
            String theMaxx;
            theMaxx = this.getMaxx();
            strategy.appendField(locator, this, "maxx", buffer, theMaxx, (this.maxx!= null));
        }
        {
            String theMaxy;
            theMaxy = this.getMaxy();
            strategy.appendField(locator, this, "maxy", buffer, theMaxy, (this.maxy!= null));
        }
        {
            String theResx;
            theResx = this.getResx();
            strategy.appendField(locator, this, "resx", buffer, theResx, (this.resx!= null));
        }
        {
            String theResy;
            theResy = this.getResy();
            strategy.appendField(locator, this, "resy", buffer, theResy, (this.resy!= null));
        }
        return buffer;
    }

}
