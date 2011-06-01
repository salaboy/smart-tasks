/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.configuration;

import com.wordpress.salaboy.smarttasks.formbuilder.api.ExternalData;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.ActivitiConfigurationHandler;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.JBPM5ConfigurationHandler;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.UIHelperConfigurationHandler;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.UIHelperConfigurationUriHandler;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.XMLConfigurationParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author esteban
 */
public class BuilderConfigurationProvider {
    
    public static final String UI_HELPER_FILE_NAME="UIHelper.config.xml";

    private File rootDirectory;
    private Set<UIHelperConfigurationUriHandler> uiHelperConfigurationUriHandlers = new HashSet<UIHelperConfigurationUriHandler>();
    private Map<String, ExternalData> externalContexts;
    
    public BuilderConfigurationProvider(File rootDirectory){
        this(rootDirectory, new HashMap<String, ExternalData>());
    }
    
    public BuilderConfigurationProvider(File rootDirectory, Map<String, ExternalData> externalContexts){
        if (rootDirectory == null){
            rootDirectory = new File(".");
        }
        this.rootDirectory = rootDirectory;
        
        //Add default handlers
        this.uiHelperConfigurationUriHandlers.add(new UIHelperConfigurationHandler());
        this.uiHelperConfigurationUriHandlers.add(new ActivitiConfigurationHandler());
        this.uiHelperConfigurationUriHandlers.add(new JBPM5ConfigurationHandler());
        this.externalContexts = externalContexts;
    }
    
    public void addUIHelperConfigurationUriHandler(UIHelperConfigurationUriHandler uiHelperConfigurationUriHandler){
        this.uiHelperConfigurationUriHandlers.add(uiHelperConfigurationUriHandler);
    }
    
    public BuilderConfiguration createConfiguration() {
        
        File configFile = new File(this.rootDirectory,UI_HELPER_FILE_NAME);
        
        if (!configFile.exists()){
            throw new IllegalArgumentException("No configuration file found at "+configFile.getAbsolutePath());
        }
        
        try {
            BuilderConfiguration configuration = this.parse(new FileInputStream(configFile));
            configuration.setUiHelperRootDirectory(this.rootDirectory);
            configuration.setContexts(this.externalContexts);
            return configuration;
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("No configuration file found at "+configFile.getAbsolutePath());
        }
    }

    private BuilderConfiguration parse(InputStream source) {
        SAXParser saxParser;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false);

        BuilderConfiguration configuration = new BuilderConfiguration();
        XMLConfigurationParser configurationHandler = new XMLConfigurationParser(configuration);

        //Register configuration handlers
        for (UIHelperConfigurationUriHandler uIHelperConfigurationUriHandler : uiHelperConfigurationUriHandlers) {
            configurationHandler.registerHandler(uIHelperConfigurationUriHandler);
        }
        
        
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(source, configurationHandler);

            if (configurationHandler.hasErrors()) {
                throw new IllegalStateException(configurationHandler.getErrorMessages());
            }

        } catch (Exception ex) {
            throw new IllegalArgumentException("Error parsing configuration file.", ex);
        }

        return configuration;
    }
    
}
