/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler;

import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * UIHelperConfigurationUriHandler implementation that handles UIHelperConfiguration
 * own tags
 * @author esteban
 */
public class UIHelperConfigurationHandler implements UIHelperConfigurationUriHandler{
    
    public static final String URI = "";
    
    @Override
    public String getURI() {
        return URI;
    }

    @Override
    public void startElement(String tagName, Attributes attributes, UIHelperConfiguration configuration) throws SAXException {
        if ("humanTaskServicesConfigurations".equals(tagName)){
            configuration.setHumanTaskServiceConfiguration(new HumanTaskServiceConfiguration());
        }
    }

}
