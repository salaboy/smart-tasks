
package org.example.ws_ht;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDeadline complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDeadline">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="for" type="{http://www.example.org/WS-HT}tDuration-expr"/>
 *           &lt;element name="until" type="{http://www.example.org/WS-HT}tDeadline-expr"/>
 *         &lt;/choice>
 *         &lt;element name="escalation" type="{http://www.example.org/WS-HT}tEscalation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDeadline", propOrder = {
    "_for",
    "until",
    "escalation"
})
public class TDeadline
    extends TExtensibleElements
{

    @XmlElement(name = "for")
    protected TDurationExpr _for;
    protected TDeadlineExpr until;
    protected List<TEscalation> escalation;

    /**
     * Gets the value of the for property.
     * 
     * @return
     *     possible object is
     *     {@link TDurationExpr }
     *     
     */
    public TDurationExpr getFor() {
        return _for;
    }

    /**
     * Sets the value of the for property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDurationExpr }
     *     
     */
    public void setFor(TDurationExpr value) {
        this._for = value;
    }

    /**
     * Gets the value of the until property.
     * 
     * @return
     *     possible object is
     *     {@link TDeadlineExpr }
     *     
     */
    public TDeadlineExpr getUntil() {
        return until;
    }

    /**
     * Sets the value of the until property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDeadlineExpr }
     *     
     */
    public void setUntil(TDeadlineExpr value) {
        this.until = value;
    }

    /**
     * Gets the value of the escalation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the escalation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEscalation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEscalation }
     * 
     * 
     */
    public List<TEscalation> getEscalation() {
        if (escalation == null) {
            escalation = new ArrayList<TEscalation>();
        }
        return this.escalation;
    }

}
