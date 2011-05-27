/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler;

import org.jbpm.task.service.TaskClientConnector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HornetQHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5MinaHumanTaskClientConfiguration;

/**
 * UIHelperConfigurationUriHandler implementation that handles JBPM5
 * tags
 * @author esteban
 */
public class JBPM5ConfigurationHandler implements UIHelperConfigurationUriHandler{
    
    public static final String URI = "http://plugtree.org/smart-tasks/JBPM5";
    
    @Override
    public String getURI() {
        return URI;
    }

    @Override
    public void startElement(String tagName, Attributes attributes, BuilderConfiguration configuration) throws SAXException {
        if ("JBPM5HumanTaskServiceConfiguration".equals(tagName)){
            
            String name = attributes.getValue("name");
            if (name == null || name.isEmpty()){
                name = JBPM5HumanTaskClientConfiguration.TYPE;
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
            
            String serverType = attributes.getValue("serverType");
            HumanTaskClientConfiguration clientConfiguration = null;
            if ("hornetq".equalsIgnoreCase(serverType)) {
                clientConfiguration = new JBPM5HornetQHumanTaskClientConfiguration(
                    host, intPort);
            } else {
                clientConfiguration = new JBPM5MinaHumanTaskClientConfiguration(
                    host, intPort);
            }
            configuration.getHumanTaskServiceConfiguration().addHumanTaskClientConfiguration(name,clientConfiguration);
        }
    }

}
