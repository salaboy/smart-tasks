
package org.example.ws_ht.api.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.example.ws_ht.TOrganizationalEntity;


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
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="organizationalEntity" type="{http://www.example.org/WS-HT}tOrganizationalEntity"/>
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
    "identifier",
    "organizationalEntity"
})
@XmlRootElement(name = "forward")
public class Forward {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String identifier;
    @XmlElement(required = true)
    protected TOrganizationalEntity organizationalEntity;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the organizationalEntity property.
     * 
     * @return
     *     possible object is
     *     {@link TOrganizationalEntity }
     *     
     */
    public TOrganizationalEntity getOrganizationalEntity() {
        return organizationalEntity;
    }

    /**
     * Sets the value of the organizationalEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOrganizationalEntity }
     *     
     */
    public void setOrganizationalEntity(TOrganizationalEntity value) {
        this.organizationalEntity = value;
    }

}
