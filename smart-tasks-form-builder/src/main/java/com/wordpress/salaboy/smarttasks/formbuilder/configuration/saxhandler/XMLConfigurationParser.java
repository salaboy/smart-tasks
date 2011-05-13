/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler;

import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author esteban
 */
public class XMLConfigurationParser extends DefaultHandler{
    
    private final BuilderConfiguration configuration;
    private List<String> errorMessages = new ArrayList<String>();
    private Map<String,UIHelperConfigurationUriHandler> uriHandlers = new HashMap<String, UIHelperConfigurationUriHandler>();

    public XMLConfigurationParser(BuilderConfiguration configuration) {
        this.configuration = configuration;
    }
    
    public final void registerHandler(UIHelperConfigurationUriHandler handler){
        this.uriHandlers.put(handler.getURI(), handler);
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        UIHelperConfigurationUriHandler handler = this.uriHandlers.get(uri);
        
        if (handler == null){
            this.errorMessages.add(uri + " does not have a registered handler");
        }

        handler.startElement(localName, attributes, configuration);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        this.errorMessages.add("ERROR: "+e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        this.errorMessages.add("FATAL ERROR: "+e.getMessage());
    }

    public boolean hasErrors(){
        return !this.errorMessages.isEmpty();
    }
    
    public String getErrorMessages(){
        StringBuilder sb = new StringBuilder();
        for (String error : errorMessages) {
            sb.append(error);
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
