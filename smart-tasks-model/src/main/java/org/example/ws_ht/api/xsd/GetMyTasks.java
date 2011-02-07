
package org.example.ws_ht.api.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.example.ws_ht.api.TStatus;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="genericHumanRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workQueue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.example.org/WS-HT/api}tStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="whereClause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderByClause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdOnClause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxTasks" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fromTaskNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "taskType",
    "genericHumanRole",
    "workQueue",
    "status",
    "whereClause",
    "orderByClause",
    "createdOnClause",
    "maxTasks",
    "fromTaskNumber"
})
@XmlRootElement(name = "getMyTasks")
public class GetMyTasks {

    @XmlElement(required = true)
    protected String taskType;
    protected String genericHumanRole;
    protected String workQueue;
    protected List<TStatus> status;
    protected String whereClause;
    protected String orderByClause;
    protected String createdOnClause;
    protected Integer maxTasks;
    @XmlElement(defaultValue = "0")
    protected Integer fromTaskNumber;

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
     * Gets the value of the genericHumanRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericHumanRole() {
        return genericHumanRole;
    }

    /**
     * Sets the value of the genericHumanRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericHumanRole(String value) {
        this.genericHumanRole = value;
    }

    /**
     * Gets the value of the workQueue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkQueue() {
        return workQueue;
    }

    /**
     * Sets the value of the workQueue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkQueue(String value) {
        this.workQueue = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TStatus }
     * 
     * 
     */
    public List<TStatus> getStatus() {
        if (status == null) {
            status = new ArrayList<TStatus>();
        }
        return this.status;
    }

    /**
     * Gets the value of the whereClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhereClause() {
        return whereClause;
    }

    /**
     * Sets the value of the whereClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhereClause(String value) {
        this.whereClause = value;
    }

    /**
     * Gets the value of the orderByClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * Sets the value of the orderByClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderByClause(String value) {
        this.orderByClause = value;
    }

    /**
     * Gets the value of the createdOnClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedOnClause() {
        return createdOnClause;
    }

    /**
     * Sets the value of the createdOnClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedOnClause(String value) {
        this.createdOnClause = value;
    }

    /**
     * Gets the value of the maxTasks property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxTasks() {
        return maxTasks;
    }

    /**
     * Sets the value of the maxTasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxTasks(Integer value) {
        this.maxTasks = value;
    }

    /**
     * Gets the value of the fromTaskNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFromTaskNumber() {
        return fromTaskNumber;
    }

    /**
     * Sets the value of the fromTaskNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFromTaskNumber(Integer value) {
        this.fromTaskNumber = value;
    }

}
