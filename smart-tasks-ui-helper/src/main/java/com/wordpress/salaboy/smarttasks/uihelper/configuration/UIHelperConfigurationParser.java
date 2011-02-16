/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.uihelper.configuration;

import com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler.ConfigurationHandler;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author esteban
 */
public class UIHelperConfigurationParser {

    public UIHelperConfiguration parse(InputStream source) {
        SAXParser saxParser;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(false);
        factory.setValidating(false);
        
         UIHelperConfiguration configuration = new UIHelperConfiguration();
            ConfigurationHandler configurationHandler = new ConfigurationHandler(configuration);
        
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(source, configurationHandler);
            
            if (configurationHandler.hasErrors()){
                throw new IllegalStateException(configurationHandler.getErrorMessages());
            }
            
        } catch (Exception ex) {
            throw new IllegalArgumentException("Error parsing configuration file.",ex);
        }

        return configuration;
    }
}
