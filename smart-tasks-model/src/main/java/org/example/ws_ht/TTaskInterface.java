
package org.example.ws_ht;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tTaskInterface complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTaskInterface">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/WS-HT}tExtensibleElements">
 *       &lt;attribute name="portType" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="operation" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="responsePortType" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="responseOperation" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTaskInterface")
public class TTaskInterface
    extends TExtensibleElements
{

    @XmlAttribute(name = "portType", required = true)
    protected QName portType;
    @XmlAttribute(name = "operation", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String operation;
    @XmlAttribute(name = "responsePortType")
    protected QName responsePortType;
    @XmlAttribute(name = "responseOperation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String responseOperation;

    /**
     * Gets the value of the portType property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getPortType() {
        return portType;
    }

    /**
     * Sets the value of the portType property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setPortType(QName value) {
        this.portType = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the responsePortType property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getResponsePortType() {
        return responsePortType;
    }

    /**
     * Sets the value of the responsePortType property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setResponsePortType(QName value) {
        this.responsePortType = value;
    }

    /**
     * Gets the value of the responseOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseOperation() {
        return responseOperation;
    }

    /**
     * Sets the value of the responseOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseOperation(String value) {
        this.responseOperation = value;
    }

}
