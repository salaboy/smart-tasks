
package org.example.ws_ht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tLocalNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tLocalNotification">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element ref="{http://www.example.org/WS-HT}priority" minOccurs="0"/>
 *           &lt;element ref="{http://www.example.org/WS-HT}peopleAssignments" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute name="reference" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLocalNotification", propOrder = {
    "priority",
    "peopleAssignments"
})
public class TLocalNotification
    extends TExtensibleElements
{

    protected TPriority priority;
    protected TPeopleAssignments peopleAssignments;
    @XmlAttribute(name = "reference", required = true)
    protected QName reference;

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link TPriority }
     *     
     */
    public TPriority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPriority }
     *     
     */
    public void setPriority(TPriority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the peopleAssignments property.
     * 
     * @return
     *     possible object is
     *     {@link TPeopleAssignments }
     *     
     */
    public TPeopleAssignments getPeopleAssignments() {
        return peopleAssignments;
    }

    /**
     * Sets the value of the peopleAssignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPeopleAssignments }
     *     
     */
    public void setPeopleAssignments(TPeopleAssignments value) {
        this.peopleAssignments = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setReference(QName value) {
        this.reference = value;
    }

}
