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
// Generato il: 2017.12.01 alle 08:55:18 AM CET 
//


package org.geosdi.geoplatform.xml.wps.v100;

import org.geosdi.geoplatform.xml.ows.v110.CodeType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

import javax.xml.bind.annotation.*;


/**
 * Definition of a format, encoding,  schema, and unit-of-measure for an output to be returned from a process.
 * <p>
 * <p>Classe Java per OutputDefinitionType complex type.
 * <p>
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;complexType name="OutputDefinitionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}Identifier"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/wps/1.0.0}ComplexDataEncoding"/&gt;
 *       &lt;attribute name="uom" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputDefinitionType", propOrder = {
        "identifier"
})
@XmlSeeAlso({
        DocumentOutputDefinitionType.class
})
public class OutputDefinitionType implements ToString2 {

    @XmlElement(name = "Identifier", namespace = "http://www.opengis.net/ows/1.1", required = true)
    protected CodeType identifier;
    @XmlAttribute(name = "uom")
    @XmlSchemaType(name = "anyURI")
    protected String uom;
    @XmlAttribute(name = "mimeType")
    protected String mimeType;
    @XmlAttribute(name = "encoding")
    @XmlSchemaType(name = "anyURI")
    protected String encoding;
    @XmlAttribute(name = "schema")
    @XmlSchemaType(name = "anyURI")
    protected String schema;

    /**
     * Unambiguous identifier or name of an output, unique for this process.
     *
     * @return possible object is
     * {@link CodeType }
     */
    public CodeType getIdentifier() {
        return identifier;
    }

    /**
     * Imposta il valore della proprietà identifier.
     *
     * @param value allowed object is
     *              {@link CodeType }
     */
    public void setIdentifier(CodeType value) {
        this.identifier = value;
    }

    public boolean isSetIdentifier() {
        return (this.identifier != null);
    }

    /**
     * Recupera il valore della proprietà uom.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUom() {
        return uom;
    }

    /**
     * Imposta il valore della proprietà uom.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUom(String value) {
        this.uom = value;
    }

    public boolean isSetUom() {
        return (this.uom != null);
    }

    /**
     * Recupera il valore della proprietà mimeType.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Imposta il valore della proprietà mimeType.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMimeType(String value) {
        this.mimeType = value;
    }

    public boolean isSetMimeType() {
        return (this.mimeType != null);
    }

    /**
     * Recupera il valore della proprietà encoding.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Imposta il valore della proprietà encoding.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEncoding(String value) {
        this.encoding = value;
    }

    public boolean isSetEncoding() {
        return (this.encoding != null);
    }

    /**
     * Recupera il valore della proprietà schema.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Imposta il valore della proprietà schema.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSchema(String value) {
        this.schema = value;
    }

    public boolean isSetSchema() {
        return (this.schema != null);
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
            CodeType theIdentifier;
            theIdentifier = this.getIdentifier();
            strategy.appendField(locator, this, "identifier", buffer, theIdentifier, this.isSetIdentifier());
        }
        {
            String theUom;
            theUom = this.getUom();
            strategy.appendField(locator, this, "uom", buffer, theUom, this.isSetUom());
        }
        {
            String theMimeType;
            theMimeType = this.getMimeType();
            strategy.appendField(locator, this, "mimeType", buffer, theMimeType, this.isSetMimeType());
        }
        {
            String theEncoding;
            theEncoding = this.getEncoding();
            strategy.appendField(locator, this, "encoding", buffer, theEncoding, this.isSetEncoding());
        }
        {
            String theSchema;
            theSchema = this.getSchema();
            strategy.appendField(locator, this, "schema", buffer, theSchema, this.isSetSchema());
        }
        return buffer;
    }

}
