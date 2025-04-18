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
 * <p>Classe Java per anonymous complex type.
 * <p>
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/wps/1.0.0}RequestBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}Identifier"/&gt;
 *         &lt;element name="DataInputs" type="{http://www.opengis.net/wps/1.0.0}DataInputsType" minOccurs="0"/&gt;
 *         &lt;element name="ResponseForm" type="{http://www.opengis.net/wps/1.0.0}ResponseFormType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "identifier",
        "dataInputs",
        "responseForm"
})
@XmlRootElement(name = "Execute")
public class Execute extends RequestBaseType implements ToString2 {

    @XmlElement(name = "Identifier", namespace = "http://www.opengis.net/ows/1.1", required = true)
    protected CodeType identifier;
    @XmlElement(name = "DataInputs")
    protected DataInputsType dataInputs;
    @XmlElement(name = "ResponseForm")
    protected ResponseFormType responseForm;

    /**
     * Identifier of the Process to be executed. This Process identifier shall be as listed in the ProcessOfferings section of the WPS Capabilities document.
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
     * Recupera il valore della proprietà dataInputs.
     *
     * @return possible object is
     * {@link DataInputsType }
     */
    public DataInputsType getDataInputs() {
        return dataInputs;
    }

    /**
     * Imposta il valore della proprietà dataInputs.
     *
     * @param value allowed object is
     *              {@link DataInputsType }
     */
    public void setDataInputs(DataInputsType value) {
        this.dataInputs = value;
    }

    public boolean isSetDataInputs() {
        return (this.dataInputs != null);
    }

    /**
     * Recupera il valore della proprietà responseForm.
     *
     * @return possible object is
     * {@link ResponseFormType }
     */
    public ResponseFormType getResponseForm() {
        return responseForm;
    }

    /**
     * Imposta il valore della proprietà responseForm.
     *
     * @param value allowed object is
     *              {@link ResponseFormType }
     */
    public void setResponseForm(ResponseFormType value) {
        this.responseForm = value;
    }

    public boolean isSetResponseForm() {
        return (this.responseForm != null);
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
            CodeType theIdentifier;
            theIdentifier = this.getIdentifier();
            strategy.appendField(locator, this, "identifier", buffer, theIdentifier, this.isSetIdentifier());
        }
        {
            DataInputsType theDataInputs;
            theDataInputs = this.getDataInputs();
            strategy.appendField(locator, this, "dataInputs", buffer, theDataInputs, this.isSetDataInputs());
        }
        {
            ResponseFormType theResponseForm;
            theResponseForm = this.getResponseForm();
            strategy.appendField(locator, this, "responseForm", buffer, theResponseForm, this.isSetResponseForm());
        }
        return buffer;
    }

}
