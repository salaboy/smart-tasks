
package org.example.ws_ht;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tLogicalPeopleGroups complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tLogicalPeopleGroups">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="logicalPeopleGroup" type="{http://www.example.org/WS-HT}tLogicalPeopleGroup" maxOccurs="unbounded"/>
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
@XmlType(name = "tLogicalPeopleGroups", propOrder = {
    "logicalPeopleGroup"
})
public class TLogicalPeopleGroups
    extends TExtensibleElements
{

    @XmlElement(required = true)
    protected List<TLogicalPeopleGroup> logicalPeopleGroup;

    /**
     * Gets the value of the logicalPeopleGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logicalPeopleGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogicalPeopleGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLogicalPeopleGroup }
     * 
     * 
     */
    public List<TLogicalPeopleGroup> getLogicalPeopleGroup() {
        if (logicalPeopleGroup == null) {
            logicalPeopleGroup = new ArrayList<TLogicalPeopleGroup>();
        }
        return this.logicalPeopleGroup;
    }

}
