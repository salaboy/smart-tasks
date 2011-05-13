/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler;

import com.wordpress.salaboy.smarttasks.activiti5wrapper.conf.ActivitiHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * UIHelperConfigurationUriHandler implementation that handles Activiti
 * tags
 * @author esteban
 */
public class ActivitiConfigurationHandler implements UIHelperConfigurationUriHandler{
    
    public static final String URI = "http://plugtree.org/smart-tasks/Activiti";
    
    @Override
    public String getURI() {
        return URI;
    }

    @Override
    public void startElement(String tagName, Attributes attributes, BuilderConfiguration configuration) throws SAXException {
        if ("ActivityHumanTaskServiceConfiguration".equals(tagName)){
            String name = attributes.getValue("name");
            if (name == null || name.isEmpty()){
                name = ActivitiHumanTaskClientConfiguration.TYPE;
            }
            
            String configurationResource = attributes.getValue("configurationResource");
            if (configurationResource == null || configurationResource.isEmpty()){
                throw new IllegalStateException("configurationResource is mandatory for <ActivityHumanTaskServiceConfiguration>");
            }
            ActivitiHumanTaskClientConfiguration clientConfiguration = new ActivitiHumanTaskClientConfiguration(configurationResource);
            configuration.getHumanTaskServiceConfiguration().addHumanTaskClientConfiguration(name,clientConfiguration);
        }
    }

}
