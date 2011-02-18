/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration.mock;

import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler.UIHelperConfigurationUriHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author esteban
 */
public class MockConfigurationHandler implements UIHelperConfigurationUriHandler{
    
    public static final String URI = "http://plugtree.org/smart-tasks/MOCK";
    
    @Override
    public String getURI() {
        return URI;
    }

    @Override
    public void startElement(String tagName, Attributes attributes, UIHelperConfiguration configuration) throws SAXException {
        if ("MockHumanTaskServiceConfiguration".equals(tagName)){
            
            String attr1 = attributes.getValue("attr1");
            String attr2 = attributes.getValue("attr2");
            
            MockHumanTaskClientConfiguration clientConfiguration = new MockHumanTaskClientConfiguration();
            clientConfiguration.setAttr1(attr1);
            clientConfiguration.setAttr2(attr2);
            configuration.getHumanTaskServiceConfiguration().addHumanTaskClientConfiguration(clientConfiguration.getType(),clientConfiguration);
        }
    }


}
