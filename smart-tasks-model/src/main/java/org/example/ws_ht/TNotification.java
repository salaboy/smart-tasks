
package org.example.ws_ht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for tNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tNotification">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="interface" type="{http://www.example.org/WS-HT}tNotificationInterface"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}priority" minOccurs="0"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}peopleAssignments"/>
 *         &lt;element name="presentationElements" type="{http://www.example.org/WS-HT}tPresentationElements"/>
 *         &lt;element name="renderings" type="{http://www.example.org/WS-HT}tRenderings" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tNotification", propOrder = {
    "_interface",
    "priority",
    "peopleAssignments",
    "presentationElements",
    "renderings"
})
public class TNotification
    extends TExtensibleElements
{

    @XmlElement(name = "interface", required = true)
    protected TNotificationInterface _interface;
    protected TPriority priority;
    @XmlElement(required = true)
    protected TPeopleAssignments peopleAssignments;
    @XmlElement(required = true)
    protected TPresentationElements presentationElements;
    protected TRenderings renderings;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    /**
     * Gets the value of the interface property.
     * 
     * @return
     *     possible object is
     *     {@link TNotificationInterface }
     *     
     */
    public TNotificationInterface getInterface() {
        return _interface;
    }

    /**
     * Sets the value of the interface property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNotificationInterface }
     *     
     */
    public void setInterface(TNotificationInterface value) {
        this._interface = value;
    }

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
     * Gets the value of the presentationElements property.
     * 
     * @return
     *     possible object is
     *     {@link TPresentationElements }
     *     
     */
    public TPresentationElements getPresentationElements() {
        return presentationElements;
    }

    /**
     * Sets the value of the presentationElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPresentationElements }
     *     
     */
    public void setPresentationElements(TPresentationElements value) {
        this.presentationElements = value;
    }

    /**
     * Gets the value of the renderings property.
     * 
     * @return
     *     possible object is
     *     {@link TRenderings }
     *     
     */
    public TRenderings getRenderings() {
        return renderings;
    }

    /**
     * Sets the value of the renderings property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRenderings }
     *     
     */
    public void setRenderings(TRenderings value) {
        this.renderings = value;
    }

    /**
     * Gets the value of the name property.
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
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
