
package org.example.ws_ht;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPeopleAssignments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPeopleAssignments">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.example.org/WS-HT}genericHumanRole" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tPeopleAssignments", propOrder = {
    "genericHumanRole"
})
public class TPeopleAssignments
    extends TExtensibleElements
{

    @XmlElementRefs({
        @XmlElementRef(name = "excludedOwners", namespace = "http://www.example.org/WS-HT", type = JAXBElement.class),
        @XmlElementRef(name = "recipients", namespace = "http://www.example.org/WS-HT", type = JAXBElement.class),
        @XmlElementRef(name = "taskStakeholders", namespace = "http://www.example.org/WS-HT", type = JAXBElement.class),
        @XmlElementRef(name = "potentialOwners", namespace = "http://www.example.org/WS-HT", type = JAXBElement.class),
        @XmlElementRef(name = "taskInitiator", namespace = "http://www.example.org/WS-HT", type = JAXBElement.class),
        @XmlElementRef(name = "businessAdministrators", namespace = "http://www.example.org/WS-HT", type = JAXBElement.class)
    })
    protected List<JAXBElement<TGenericHumanRole>> genericHumanRole;

    /**
     * Gets the value of the genericHumanRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericHumanRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericHumanRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * 
     * 
     */
    public List<JAXBElement<TGenericHumanRole>> getGenericHumanRole() {
        if (genericHumanRole == null) {
            genericHumanRole = new ArrayList<JAXBElement<TGenericHumanRole>>();
        }
        return this.genericHumanRole;
    }

}
