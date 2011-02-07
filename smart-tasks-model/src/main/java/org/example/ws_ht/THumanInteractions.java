
package org.example.ws_ht;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tHumanInteractions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tHumanInteractions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="extensions" type="{http://www.example.org/WS-HT}tExtensions" minOccurs="0"/>
 *         &lt;element name="import" type="{http://www.example.org/WS-HT}tImport" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}logicalPeopleGroups" minOccurs="0"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}tasks" minOccurs="0"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}notifications" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="targetNamespace" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="queryLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="expressionLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tHumanInteractions", propOrder = {
    "extensions",
    "_import",
    "logicalPeopleGroups",
    "tasks",
    "notifications"
})
public class THumanInteractions
    extends TExtensibleElements
{

    protected TExtensions extensions;
    @XmlElement(name = "import")
    protected List<TImport> _import;
    protected TLogicalPeopleGroups logicalPeopleGroups;
    protected TTasks tasks;
    protected TNotifications notifications;
    @XmlAttribute(name = "targetNamespace", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String targetNamespace;
    @XmlAttribute(name = "queryLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String queryLanguage;
    @XmlAttribute(name = "expressionLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String expressionLanguage;

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link TExtensions }
     *     
     */
    public TExtensions getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExtensions }
     *     
     */
    public void setExtensions(TExtensions value) {
        this.extensions = value;
    }

    /**
     * Gets the value of the import property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the import property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TImport }
     * 
     * 
     */
    public List<TImport> getImport() {
        if (_import == null) {
            _import = new ArrayList<TImport>();
        }
        return this._import;
    }

    /**
     * Gets the value of the logicalPeopleGroups property.
     * 
     * @return
     *     possible object is
     *     {@link TLogicalPeopleGroups }
     *     
     */
    public TLogicalPeopleGroups getLogicalPeopleGroups() {
        return logicalPeopleGroups;
    }

    /**
     * Sets the value of the logicalPeopleGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLogicalPeopleGroups }
     *     
     */
    public void setLogicalPeopleGroups(TLogicalPeopleGroups value) {
        this.logicalPeopleGroups = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link TTasks }
     *     
     */
    public TTasks getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTasks }
     *     
     */
    public void setTasks(TTasks value) {
        this.tasks = value;
    }

    /**
     * Gets the value of the notifications property.
     * 
     * @return
     *     possible object is
     *     {@link TNotifications }
     *     
     */
    public TNotifications getNotifications() {
        return notifications;
    }

    /**
     * Sets the value of the notifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNotifications }
     *     
     */
    public void setNotifications(TNotifications value) {
        this.notifications = value;
    }

    /**
     * Gets the value of the targetNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * Sets the value of the targetNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    /**
     * Gets the value of the queryLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryLanguage() {
        return queryLanguage;
    }

    /**
     * Sets the value of the queryLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryLanguage(String value) {
        this.queryLanguage = value;
    }

    /**
     * Gets the value of the expressionLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionLanguage() {
        return expressionLanguage;
    }

    /**
     * Sets the value of the expressionLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionLanguage(String value) {
        this.expressionLanguage = value;
    }

}
