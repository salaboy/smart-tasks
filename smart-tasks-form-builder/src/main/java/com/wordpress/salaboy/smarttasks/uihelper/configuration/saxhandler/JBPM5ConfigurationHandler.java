/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5MinaHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.BuilderConfiguration;

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
            
            JBPM5HumanTaskClientConfiguration clientConfiguration = new JBPM5MinaHumanTaskClientConfiguration(host,intPort);
            configuration.getHumanTaskServiceConfiguration().addHumanTaskClientConfiguration(name,clientConfiguration);
        }
    }

}
