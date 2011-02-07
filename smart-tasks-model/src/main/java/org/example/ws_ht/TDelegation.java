
package org.example.ws_ht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDelegation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDelegation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="from" type="{http://www.example.org/WS-HT}tFrom" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="potentialDelegatees" type="{http://www.example.org/WS-HT}tPotentialDelegatees" default="nobody" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDelegation", propOrder = {
    "from"
})
public class TDelegation
    extends TExtensibleElements
{

    protected TFrom from;
    @XmlAttribute(name = "potentialDelegatees")
    protected TPotentialDelegatees potentialDelegatees;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link TFrom }
     *     
     */
    public TFrom getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFrom }
     *     
     */
    public void setFrom(TFrom value) {
        this.from = value;
    }

    /**
     * Gets the value of the potentialDelegatees property.
     * 
     * @return
     *     possible object is
     *     {@link TPotentialDelegatees }
     *     
     */
    public TPotentialDelegatees getPotentialDelegatees() {
        if (potentialDelegatees == null) {
            return TPotentialDelegatees.NOBODY;
        } else {
            return potentialDelegatees;
        }
    }

    /**
     * Sets the value of the potentialDelegatees property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPotentialDelegatees }
     *     
     */
    public void setPotentialDelegatees(TPotentialDelegatees value) {
        this.potentialDelegatees = value;
    }

}
