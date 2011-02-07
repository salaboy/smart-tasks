
package org.example.ws_ht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tOrganizationalEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tOrganizationalEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.example.org/WS-HT}users"/>
 *         &lt;element ref="{http://www.example.org/WS-HT}groups"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tOrganizationalEntity", propOrder = {
    "users",
    "groups"
})
public class TOrganizationalEntity {

    protected TUserlist users;
    protected TGrouplist groups;

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link TUserlist }
     *     
     */
    public TUserlist getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserlist }
     *     
     */
    public void setUsers(TUserlist value) {
        this.users = value;
    }

    /**
     * Gets the value of the groups property.
     * 
     * @return
     *     possible object is
     *     {@link TGrouplist }
     *     
     */
    public TGrouplist getGroups() {
        return groups;
    }

    /**
     * Sets the value of the groups property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGrouplist }
     *     
     */
    public void setGroups(TGrouplist value) {
        this.groups = value;
    }

}
