//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.09.20 alle 09:31:16 AM CEST 
//


package org.geosdi.geoplatform.xml.sld.v100;

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
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{http://www.opengis.net/sld}GraphicFill"/&gt;
 *           &lt;element ref="{http://www.opengis.net/sld}GraphicStroke"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/sld}CssParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "graphicFill",
    "graphicStroke",
    "cssParameter"
})
@XmlRootElement(name = "Stroke")
public class Stroke implements ToString2
{

    @XmlElement(name = "GraphicFill")
    protected GraphicFill graphicFill;
    @XmlElement(name = "GraphicStroke")
    protected GraphicStroke graphicStroke;
    @XmlElement(name = "CssParameter")
    protected List<CssParameter> cssParameter;

    /**
     * Recupera il valore della proprietà graphicFill.
     * 
     * @return
     *     possible object is
     *     {@link GraphicFill }
     *     
     */
    public GraphicFill getGraphicFill() {
        return graphicFill;
    }

    /**
     * Imposta il valore della proprietà graphicFill.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphicFill }
     *     
     */
    public void setGraphicFill(GraphicFill value) {
        this.graphicFill = value;
    }

    public boolean isSetGraphicFill() {
        return (this.graphicFill!= null);
    }

    /**
     * Recupera il valore della proprietà graphicStroke.
     * 
     * @return
     *     possible object is
     *     {@link GraphicStroke }
     *     
     */
    public GraphicStroke getGraphicStroke() {
        return graphicStroke;
    }

    /**
     * Imposta il valore della proprietà graphicStroke.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphicStroke }
     *     
     */
    public void setGraphicStroke(GraphicStroke value) {
        this.graphicStroke = value;
    }

    public boolean isSetGraphicStroke() {
        return (this.graphicStroke!= null);
    }

    /**
     * Gets the value of the cssParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cssParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCssParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CssParameter }
     * 
     * 
     */
    public List<CssParameter> getCssParameter() {
        if (cssParameter == null) {
            cssParameter = new ArrayList<CssParameter>();
        }
        return this.cssParameter;
    }

    public boolean isSetCssParameter() {
        return ((this.cssParameter!= null)&&(!this.cssParameter.isEmpty()));
    }

    public void unsetCssParameter() {
        this.cssParameter = null;
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
            GraphicFill theGraphicFill;
            theGraphicFill = this.getGraphicFill();
            strategy.appendField(locator, this, "graphicFill", buffer, theGraphicFill, this.isSetGraphicFill());
        }
        {
            GraphicStroke theGraphicStroke;
            theGraphicStroke = this.getGraphicStroke();
            strategy.appendField(locator, this, "graphicStroke", buffer, theGraphicStroke, this.isSetGraphicStroke());
        }
        {
            List<CssParameter> theCssParameter;
            theCssParameter = (this.isSetCssParameter()?this.getCssParameter():null);
            strategy.appendField(locator, this, "cssParameter", buffer, theCssParameter, this.isSetCssParameter());
        }
        return buffer;
    }

    public void setCssParameter(List<CssParameter> value) {
        this.cssParameter = null;
        if (value!= null) {
            List<CssParameter> draftl = this.getCssParameter();
            draftl.addAll(value);
        }
    }

}