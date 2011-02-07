
package org.example.ws_ht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tReassignment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tReassignment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.example.org/WS-HT}potentialOwners"/>
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
@XmlType(name = "tReassignment", propOrder = {
    "potentialOwners"
})
public class TReassignment
    extends TExtensibleElements
{

    @XmlElement(required = true)
    protected TGenericHumanRole potentialOwners;

    /**
     * Gets the value of the potentialOwners property.
     * 
     * @return
     *     possible object is
     *     {@link TGenericHumanRole }
     *     
     */
    public TGenericHumanRole getPotentialOwners() {
        return potentialOwners;
    }

    /**
     * Sets the value of the potentialOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGenericHumanRole }
     *     
     */
    public void setPotentialOwners(TGenericHumanRole value) {
        this.potentialOwners = value;
    }

}
