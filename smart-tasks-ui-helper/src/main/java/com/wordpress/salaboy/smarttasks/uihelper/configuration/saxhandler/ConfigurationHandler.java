/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler;

import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.activiti5wrapper.conf.ActivitiHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author esteban
 */
public class ConfigurationHandler extends DefaultHandler{
    
    private final UIHelperConfiguration configuration;
    private List<String> errorMessages = new ArrayList<String>();

    public ConfigurationHandler(UIHelperConfiguration configuration) {
        this.configuration = configuration;
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("humanTaskServiceConfiguration".equals(qName)){
            this.configuration.setHumanTaskServiceConfiguration(new HumanTaskServiceConfiguration());
        }else if ("ActivityHumanTaskServiceConfiguration".equals(qName)){
            String name = attributes.getValue("name");
            if (name == null || name.isEmpty()){
                name = "Activiti";
            }
            
            String configurationResource = attributes.getValue("configurationResource");
            if (configurationResource == null || configurationResource.isEmpty()){
                throw new IllegalStateException("configurationResource is mandatory for <ActivityHumanTaskServiceConfiguration>");
            }
            ActivitiHumanTaskClientConfiguration clientConfiguration = new ActivitiHumanTaskClientConfiguration(configurationResource);
            this.configuration.getHumanTaskServiceConfiguration().addHumanTaskClientConfiguration(name,clientConfiguration);
        }else if ("JBPM5HumanTaskServiceConfiguration".equals(qName)){
            
            String name = attributes.getValue("name");
            if (name == null || name.isEmpty()){
                name = "Activiti";
            }
            
            String host = attributes.getValue("host");
            if (host == null || host.isEmpty()){
                throw new IllegalStateException("host is mandatory for <JBPM5HumanTaskServiceConfiguration>");
            }
            
            String port = attributes.getValue("port");
            if (port == null || port.isEmpty()){
                throw new IllegalStateException("port is mandatory for <JBPM5HumanTaskServiceConfiguration>");
            }
            int intPort = Integer.parseInt(port);
            
            JBPM5HumanTaskClientConfiguration clientConfiguration = new JBPM5HumanTaskClientConfiguration(host,intPort);
            this.configuration.getHumanTaskServiceConfiguration().addHumanTaskClientConfiguration(name,clientConfiguration);
        }
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
