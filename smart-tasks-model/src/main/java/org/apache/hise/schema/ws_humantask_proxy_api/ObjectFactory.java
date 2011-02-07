
package org.apache.hise.schema.ws_humantask_proxy_api;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.apache.hise.schema.ws_humantask_proxy_api package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.hise.schema.ws_humantask_proxy_api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CompleteRequest }
     * 
     */
    public CompleteRequest createCompleteRequest() {
        return new CompleteRequest();
    }

    /**
     * Create an instance of {@link GetTaskRequest }
     * 
     */
    public GetTaskRequest createGetTaskRequest() {
        return new GetTaskRequest();
    }

    /**
     * Create an instance of {@link StandardFault }
     * 
     */
    public StandardFault createStandardFault() {
        return new StandardFault();
    }

    /**
     * Create an instance of {@link CompleteResponse }
     * 
     */
    public CompleteResponse createCompleteResponse() {
        return new CompleteResponse();
    }

    /**
     * Create an instance of {@link GetTaskResponse }
     * 
     */
    public GetTaskResponse createGetTaskResponse() {
        return new GetTaskResponse();
    }

}
