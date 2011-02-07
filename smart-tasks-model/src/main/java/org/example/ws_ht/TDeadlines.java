
package org.example.ws_ht;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDeadlines complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDeadlines">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="startDeadline" type="{http://www.example.org/WS-HT}tDeadline" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="completionDeadline" type="{http://www.example.org/WS-HT}tDeadline" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tDeadlines", propOrder = {
    "startDeadline",
    "completionDeadline"
})
public class TDeadlines
    extends TExtensibleElements
{

    protected List<TDeadline> startDeadline;
    protected List<TDeadline> completionDeadline;

    /**
     * Gets the value of the startDeadline property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the startDeadline property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartDeadline().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDeadline }
     * 
     * 
     */
    public List<TDeadline> getStartDeadline() {
        if (startDeadline == null) {
            startDeadline = new ArrayList<TDeadline>();
        }
        return this.startDeadline;
    }

    /**
     * Gets the value of the completionDeadline property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completionDeadline property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompletionDeadline().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDeadline }
     * 
     * 
     */
    public List<TDeadline> getCompletionDeadline() {
        if (completionDeadline == null) {
            completionDeadline = new ArrayList<TDeadline>();
        }
        return this.completionDeadline;
    }

}
