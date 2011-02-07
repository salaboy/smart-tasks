
package org.example.ws_ht.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.example.ws_ht.TOrganizationalEntity;
import org.w3c.dom.Element;


/**
 * <p>Java class for tTaskQueryResultRow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTaskQueryResultRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="status" type="{http://www.example.org/WS-HT/api}tStatus"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="taskInitiator" type="{http://www.example.org/WS-HT}tOrganizationalEntity"/>
 *         &lt;element name="taskStakeholders" type="{http://www.example.org/WS-HT}tOrganizationalEntity"/>
 *         &lt;element name="potentialOwners" type="{http://www.example.org/WS-HT}tOrganizationalEntity"/>
 *         &lt;element name="businessAdministrators" type="{http://www.example.org/WS-HT}tOrganizationalEntity"/>
 *         &lt;element name="actualOwner" type="{http://www.example.org/WS-HT}tUser"/>
 *         &lt;element name="notificationRecipients" type="{http://www.example.org/WS-HT}tOrganizationalEntity"/>
 *         &lt;element name="createdOn" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="activationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="expirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="isSkipable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasPotentialOwners" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="startByExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="completeByExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="presentationName" type="{http://www.example.org/WS-HT/api}tPresentationName"/>
 *         &lt;element name="presentationSubject" type="{http://www.example.org/WS-HT/api}tPresentationSubject"/>
 *         &lt;element name="presentationDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="renderingMethodExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasOutput" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasFault" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasAttachments" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasComments" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="escalated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="primarySearchBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;any processContents='lax' namespace='##other'/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTaskQueryResultRow", propOrder = {
    "idOrTaskTypeOrName"
})
public class TTaskQueryResultRow {

    @XmlElementRefs({
        @XmlElementRef(name = "taskStakeholders", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "potentialOwners", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "actualOwner", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "taskInitiator", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "hasFault", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "escalated", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "hasAttachments", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "name", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "presentationName", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "priority", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "createdOn", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "activationTime", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "businessAdministrators", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "presentationSubject", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "status", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "expirationTime", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "notificationRecipients", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "createdBy", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "startByExists", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "renderingMethodExists", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "isSkipable", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "hasComments", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "id", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "primarySearchBy", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "presentationDescription", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "hasPotentialOwners", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "hasOutput", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "taskType", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class),
        @XmlElementRef(name = "completeByExists", namespace = "http://www.example.org/WS-HT/api", type = JAXBElement.class)
    })
    @XmlAnyElement(lax = true)
    protected List<Object> idOrTaskTypeOrName;

    /**
     * Gets the value of the idOrTaskTypeOrName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idOrTaskTypeOrName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdOrTaskTypeOrName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}
     * {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link QName }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TStatus }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link Object }
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link Element }
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * 
     */
    public List<Object> getIdOrTaskTypeOrName() {
        if (idOrTaskTypeOrName == null) {
            idOrTaskTypeOrName = new ArrayList<Object>();
        }
        return this.idOrTaskTypeOrName;
    }

}
