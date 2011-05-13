/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration.mock;

import com.wordpress.salaboy.smarttasks.uihelper.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler.UIHelperConfigurationUriHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author esteban
 */
public class MockConfigurationHandler implements UIHelperConfigurationUriHandler{
    
    public static final String URI = "http://plugtree.org/smart-tasks/MOCK";
    
    private MockHumanTaskClientConfiguration mockHumanTaskClientConfiguration;

    public MockConfigurationHandler() {
        this(new MockHumanTaskClientConfiguration());
    }
    
    public MockConfigurationHandler(MockHumanTaskClientConfiguration mockHumanTaskClientConfiguration) {
        this.mockHumanTaskClientConfiguration = mockHumanTaskClientConfiguration;
    }
    
    
    
    

    public String getURI() {
        return URI;
    }


    public void startElement(String tagName, Attributes attributes, BuilderConfiguration configuration) throws SAXException {
        if ("MockHumanTaskServiceConfiguration".equals(tagName)){
            
            String attr1 = attributes.getValue("attr1");
            String attr2 = attributes.getValue("attr2");
            
            mockHumanTaskClientConfiguration.setAttr1(attr1);
            mockHumanTaskClientConfiguration.setAttr2(attr2);
            configuration.getHumanTaskServiceConfiguration().addHumanTaskClientConfiguration(mockHumanTaskClientConfiguration.getType(),mockHumanTaskClientConfiguration);
        }
    }


}
