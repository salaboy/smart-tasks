
package org.example.ws_ht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tFrom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tFrom">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleMixedContentElements">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="argument" type="{http://www.example.org/WS-HT}tArgument" minOccurs="0"/>
 *           &lt;element name="literal" type="{http://www.example.org/WS-HT}tLiteral" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="expressionLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="logicalPeopleGroup" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFrom")
public class TFrom
    extends TExtensibleMixedContentElements
{

    @XmlAttribute(name = "expressionLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String expressionLanguage;
    @XmlAttribute(name = "logicalPeopleGroup")
    protected QName logicalPeopleGroup;

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

    /**
     * Gets the value of the logicalPeopleGroup property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getLogicalPeopleGroup() {
        return logicalPeopleGroup;
    }

    /**
     * Sets the value of the logicalPeopleGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setLogicalPeopleGroup(QName value) {
        this.logicalPeopleGroup = value;
    }

}
