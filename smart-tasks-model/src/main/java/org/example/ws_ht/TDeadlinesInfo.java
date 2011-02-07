
package org.example.ws_ht;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDeadlinesInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDeadlinesInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="startBy" type="{http://www.example.org/WS-HT}tDeadlineInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="completeBy" type="{http://www.example.org/WS-HT}tDeadlineInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDeadlinesInfo", propOrder = {
    "startBy",
    "completeBy"
})
public class TDeadlinesInfo {

    protected List<TDeadlineInfo> startBy;
    protected List<TDeadlineInfo> completeBy;

    /**
     * Gets the value of the startBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the startBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDeadlineInfo }
     * 
     * 
     */
    public List<TDeadlineInfo> getStartBy() {
        if (startBy == null) {
            startBy = new ArrayList<TDeadlineInfo>();
        }
        return this.startBy;
    }

    /**
     * Gets the value of the completeBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completeBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompleteBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDeadlineInfo }
     * 
     * 
     */
    public List<TDeadlineInfo> getCompleteBy() {
        if (completeBy == null) {
            completeBy = new ArrayList<TDeadlineInfo>();
        }
        return this.completeBy;
    }

}
