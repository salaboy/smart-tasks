
package org.example.ws_ht;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPresentationElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPresentationElements">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.example.org/WS-HT}tText" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="presentationParameters" type="{http://www.example.org/WS-HT}tPresentationParameters" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://www.example.org/WS-HT}tText" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.example.org/WS-HT}tDescription" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tPresentationElements", propOrder = {
    "name",
    "presentationParameters",
    "subject",
    "description"
})
public class TPresentationElements
    extends TExtensibleElements
{

    protected List<TText> name;
    protected TPresentationParameters presentationParameters;
    protected List<TText> subject;
    protected List<TDescription> description;

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TText }
     * 
     * 
     */
    public List<TText> getName() {
        if (name == null) {
            name = new ArrayList<TText>();
        }
        return this.name;
    }

    /**
     * Gets the value of the presentationParameters property.
     * 
     * @return
     *     possible object is
     *     {@link TPresentationParameters }
     *     
     */
    public TPresentationParameters getPresentationParameters() {
        return presentationParameters;
    }

    /**
     * Sets the value of the presentationParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPresentationParameters }
     *     
     */
    public void setPresentationParameters(TPresentationParameters value) {
        this.presentationParameters = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TText }
     * 
     * 
     */
    public List<TText> getSubject() {
        if (subject == null) {
            subject = new ArrayList<TText>();
        }
        return this.subject;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDescription }
     * 
     * 
     */
    public List<TDescription> getDescription() {
        if (description == null) {
            description = new ArrayList<TDescription>();
        }
        return this.description;
    }

}
