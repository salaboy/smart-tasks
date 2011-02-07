
package org.example.ws_ht.protocol;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.ws_ht.protocol package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Skipped_QNAME = new QName("http://www.example.org/WS-HT/protocol", "skipped");
    private final static QName _Fault_QNAME = new QName("http://www.example.org/WS-HT/protocol", "fault");
    private final static QName _Exit_QNAME = new QName("http://www.example.org/WS-HT/protocol", "exit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.ws_ht.protocol
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProtocolMsgType }
     * 
     */
    public ProtocolMsgType createProtocolMsgType() {
        return new ProtocolMsgType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProtocolMsgType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/protocol", name = "skipped")
    public JAXBElement<ProtocolMsgType> createSkipped(ProtocolMsgType value) {
        return new JAXBElement<ProtocolMsgType>(_Skipped_QNAME, ProtocolMsgType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProtocolMsgType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/protocol", name = "fault")
    public JAXBElement<ProtocolMsgType> createFault(ProtocolMsgType value) {
        return new JAXBElement<ProtocolMsgType>(_Fault_QNAME, ProtocolMsgType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProtocolMsgType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/protocol", name = "exit")
    public JAXBElement<ProtocolMsgType> createExit(ProtocolMsgType value) {
        return new JAXBElement<ProtocolMsgType>(_Exit_QNAME, ProtocolMsgType.class, null, value);
    }

}
