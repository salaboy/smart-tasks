
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
 * <p>Java class for tTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTask">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="interface" type="{http://www.example.org/WS-HT}tTaskInterface"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}priority" minOccurs="0"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}peopleAssignments"/>
 *         &lt;element name="delegation" type="{http://www.example.org/WS-HT}tDelegation" minOccurs="0"/>
 *         &lt;element name="presentationElements" type="{http://www.example.org/WS-HT}tPresentationElements"/>
 *         &lt;element name="outcome" type="{http://www.example.org/WS-HT}tQuery" minOccurs="0"/>
 *         &lt;element name="searchBy" type="{http://www.example.org/WS-HT}tExpression" minOccurs="0"/>
 *         &lt;element name="renderings" type="{http://www.example.org/WS-HT}tRenderings" minOccurs="0"/>
 *         &lt;element name="deadlines" type="{http://www.example.org/WS-HT}tDeadlines" minOccurs="0"/>
 *         &lt;element name="autoActivate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="savingTaskHistory" type="{http://www.example.org/WS-HT}tSavingTaskHistory" minOccurs="0"/>
 *         &lt;element name="deadlinesInfo" type="{http://www.example.org/WS-HT}tDeadlinesInfo" minOccurs="0"/>
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
@XmlType(name = "tTask", propOrder = {
    "_interface",
    "priority",
    "peopleAssignments",
    "delegation",
    "presentationElements",
    "outcome",
    "searchBy",
    "renderings",
    "deadlines",
    "autoActivate",
    "savingTaskHistory",
    "deadlinesInfo"
})
public class TTask
    extends TExtensibleElements
{

    @XmlElement(name = "interface", required = true)
    protected TTaskInterface _interface;
    protected TPriority priority;
    @XmlElement(required = true)
    protected TPeopleAssignments peopleAssignments;
    protected TDelegation delegation;
    @XmlElement(required = true)
    protected TPresentationElements presentationElements;
    protected TQuery outcome;
    protected TExpression searchBy;
    protected TRenderings renderings;
    protected TDeadlines deadlines;
    @XmlElement(defaultValue = "false")
    protected Boolean autoActivate;
    protected TSavingTaskHistory savingTaskHistory;
    protected TDeadlinesInfo deadlinesInfo;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    /**
     * Gets the value of the interface property.
     * 
     * @return
     *     possible object is
     *     {@link TTaskInterface }
     *     
     */
    public TTaskInterface getInterface() {
        return _interface;
    }

    /**
     * Sets the value of the interface property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTaskInterface }
     *     
     */
    public void setInterface(TTaskInterface value) {
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
     * Gets the value of the delegation property.
     * 
     * @return
     *     possible object is
     *     {@link TDelegation }
     *     
     */
    public TDelegation getDelegation() {
        return delegation;
    }

    /**
     * Sets the value of the delegation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDelegation }
     *     
     */
    public void setDelegation(TDelegation value) {
        this.delegation = value;
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
     * Gets the value of the outcome property.
     * 
     * @return
     *     possible object is
     *     {@link TQuery }
     *     
     */
    public TQuery getOutcome() {
        return outcome;
    }

    /**
     * Sets the value of the outcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link TQuery }
     *     
     */
    public void setOutcome(TQuery value) {
        this.outcome = value;
    }

    /**
     * Gets the value of the searchBy property.
     * 
     * @return
     *     possible object is
     *     {@link TExpression }
     *     
     */
    public TExpression getSearchBy() {
        return searchBy;
    }

    /**
     * Sets the value of the searchBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExpression }
     *     
     */
    public void setSearchBy(TExpression value) {
        this.searchBy = value;
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
     * Gets the value of the deadlines property.
     * 
     * @return
     *     possible object is
     *     {@link TDeadlines }
     *     
     */
    public TDeadlines getDeadlines() {
        return deadlines;
    }

    /**
     * Sets the value of the deadlines property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDeadlines }
     *     
     */
    public void setDeadlines(TDeadlines value) {
        this.deadlines = value;
    }

    /**
     * Gets the value of the autoActivate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoActivate() {
        return autoActivate;
    }

    /**
     * Sets the value of the autoActivate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoActivate(Boolean value) {
        this.autoActivate = value;
    }

    /**
     * Gets the value of the savingTaskHistory property.
     * 
     * @return
     *     possible object is
     *     {@link TSavingTaskHistory }
     *     
     */
    public TSavingTaskHistory getSavingTaskHistory() {
        return savingTaskHistory;
    }

    /**
     * Sets the value of the savingTaskHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSavingTaskHistory }
     *     
     */
    public void setSavingTaskHistory(TSavingTaskHistory value) {
        this.savingTaskHistory = value;
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
