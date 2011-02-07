
package org.example.ws_ht.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.example.ws_ht.TDeadlinesInfo;
import org.w3c.dom.Element;


/**
 * <p>Java class for tTaskAbstract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTaskAbstract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="status" type="{http://www.example.org/WS-HT/api}tStatus"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="createdOn" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="activationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="isSkipable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hasPotentialOwners" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="startByExists" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="completeByExists" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="presentationName" type="{http://www.example.org/WS-HT/api}tPresentationName" minOccurs="0"/>
 *         &lt;element name="presentationSubject" type="{http://www.example.org/WS-HT/api}tPresentationSubject" minOccurs="0"/>
 *         &lt;element name="renderingMethodExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasOutput" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hasFault" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hasAttachments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hasComments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="escalated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deadlinesInfo" type="{http://www.example.org/WS-HT}tDeadlinesInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTaskAbstract", propOrder = {
    "id",
    "taskType",
    "name",
    "status",
    "priority",
    "createdOn",
    "activationTime",
    "expirationTime",
    "isSkipable",
    "hasPotentialOwners",
    "startByExists",
    "completeByExists",
    "presentationName",
    "presentationSubject",
    "renderingMethodExists",
    "hasOutput",
    "hasFault",
    "hasAttachments",
    "hasComments",
    "escalated",
    "any",
    "deadlinesInfo"
})
public class TTaskAbstract {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String taskType;
    @XmlElement(required = true)
    protected QName name;
    @XmlElement(required = true)
    protected TStatus status;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger priority;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdOn;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activationTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTime;
    protected Boolean isSkipable;
    protected Boolean hasPotentialOwners;
    protected Boolean startByExists;
    protected Boolean completeByExists;
    protected String presentationName;
    protected String presentationSubject;
    protected boolean renderingMethodExists;
    protected Boolean hasOutput;
    protected Boolean hasFault;
    protected Boolean hasAttachments;
    protected Boolean hasComments;
    protected Boolean escalated;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    protected TDeadlinesInfo deadlinesInfo;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the taskType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * Sets the value of the taskType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskType(String value) {
        this.taskType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setName(QName value) {
        this.name = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link TStatus }
     *     
     */
    public TStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link TStatus }
     *     
     */
    public void setStatus(TStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPriority(BigInteger value) {
        this.priority = value;
    }

    /**
     * Gets the value of the createdOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the value of the createdOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedOn(XMLGregorianCalendar value) {
        this.createdOn = value;
    }

    /**
     * Gets the value of the activationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActivationTime() {
        return activationTime;
    }

    /**
     * Sets the value of the activationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActivationTime(XMLGregorianCalendar value) {
        this.activationTime = value;
    }

    /**
     * Gets the value of the expirationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationTime() {
        return expirationTime;
    }

    /**
     * Sets the value of the expirationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationTime(XMLGregorianCalendar value) {
        this.expirationTime = value;
    }

    /**
     * Gets the value of the isSkipable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSkipable() {
        return isSkipable;
    }

    /**
     * Sets the value of the isSkipable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSkipable(Boolean value) {
        this.isSkipable = value;
    }

    /**
     * Gets the value of the hasPotentialOwners property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasPotentialOwners() {
        return hasPotentialOwners;
    }

    /**
     * Sets the value of the hasPotentialOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasPotentialOwners(Boolean value) {
        this.hasPotentialOwners = value;
    }

    /**
     * Gets the value of the startByExists property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStartByExists() {
        return startByExists;
    }

    /**
     * Sets the value of the startByExists property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStartByExists(Boolean value) {
        this.startByExists = value;
    }

    /**
     * Gets the value of the completeByExists property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompleteByExists() {
        return completeByExists;
    }

    /**
     * Sets the value of the completeByExists property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompleteByExists(Boolean value) {
        this.completeByExists = value;
    }

    /**
     * Gets the value of the presentationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresentationName() {
        return presentationName;
    }

    /**
     * Sets the value of the presentationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentationName(String value) {
        this.presentationName = value;
    }

    /**
     * Gets the value of the presentationSubject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresentationSubject() {
        return presentationSubject;
    }

    /**
     * Sets the value of the presentationSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentationSubject(String value) {
        this.presentationSubject = value;
    }

    /**
     * Gets the value of the renderingMethodExists property.
     * 
     */
    public boolean isRenderingMethodExists() {
        return renderingMethodExists;
    }

    /**
     * Sets the value of the renderingMethodExists property.
     * 
     */
    public void setRenderingMethodExists(boolean value) {
        this.renderingMethodExists = value;
    }

    /**
     * Gets the value of the hasOutput property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasOutput() {
        return hasOutput;
    }

    /**
     * Sets the value of the hasOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasOutput(Boolean value) {
        this.hasOutput = value;
    }

    /**
     * Gets the value of the hasFault property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasFault() {
        return hasFault;
    }

    /**
     * Sets the value of the hasFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasFault(Boolean value) {
        this.hasFault = value;
    }

    /**
     * Gets the value of the hasAttachments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasAttachments() {
        return hasAttachments;
    }

    /**
     * Sets the value of the hasAttachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasAttachments(Boolean value) {
        this.hasAttachments = value;
    }

    /**
     * Gets the value of the hasComments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasComments() {
        return hasComments;
    }

    /**
     * Sets the value of the hasComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasComments(Boolean value) {
        this.hasComments = value;
    }

    /**
     * Gets the value of the escalated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEscalated() {
        return escalated;
    }

    /**
     * Sets the value of the escalated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEscalated(Boolean value) {
        this.escalated = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the deadlinesInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TDeadlinesInfo }
     *     
     */
    public TDeadlinesInfo getDeadlinesInfo() {
        return deadlinesInfo;
    }

    /**
     * Sets the value of the deadlinesInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDeadlinesInfo }
     *     
     */
    public void setDeadlinesInfo(TDeadlinesInfo value) {
        this.deadlinesInfo = value;
    }

}
