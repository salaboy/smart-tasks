package com.wordpress.salaboy.smarttasks.formbuilder.utils.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.core.io.Resource;

import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfigurationProvider;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.UIHelperConfigurationUriHandler;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.XMLConfigurationParser;

/**
 * This is an extension of {@link BuilderConfiguration}, which is intended to be
 * build based with the parameters given by constructor, discarding the use of
 * {@link BuilderConfigurationProvider}. It it really useful to be used when
 * configuring a form builder with spring. It uses spring {@link Resource} to
 * get the directories, to make it easier to configure.
 * 
 * @author calcacuervo
 * 
 */
public class ResourceBasedBuilderConfiguration extends BuilderConfiguration {

    /**
     * Constructs a new {@link ResourceBasedBuilderConfiguration} instance.
     * @param rootDirectory the root directory.
     * @param externalContexts the external contexts that will be used by the form builder.
     * @param uiHelperConfigurationUriHandlers the set of uri handlers. 
     * @param uiHelperFileName the name of the fiel which has the configuration.
     */
    public ResourceBasedBuilderConfiguration(
            Resource rootDirectory,
            Map<String, Object> externalContexts,
            Set<UIHelperConfigurationUriHandler> uiHelperConfigurationUriHandlers,
            String uiHelperFileName) {
        File configFile = null;
        try {
            configFile = new File(rootDirectory.getFile(), uiHelperFileName);

            if (!configFile.exists()) {
                throw new IllegalArgumentException(
                        "No configuration file found at "
                                + configFile.getAbsolutePath());
            }

            parse(new FileInputStream(configFile),
                    uiHelperConfigurationUriHandlers);
            this.setUiHelperRootDirectory(rootDirectory.getFile());
            this.setContexts(externalContexts);

        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException(
                    "No configuration file found at "
                            + configFile.getAbsolutePath(), ex);
        } catch (IOException e) {
            throw new IllegalArgumentException("IOExeption with file found at "
                    + configFile.getAbsolutePath(), e);
        }

    }

    private void parse(
            InputStream source,
            Set<UIHelperConfigurationUriHandler> uiHelperConfigurationUriHandlers) {
        SAXParser saxParser;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false);

        XMLConfigurationParser configurationHandler = new XMLConfigurationParser(
                this);

        // Register configuration handlers
        for (UIHelperConfigurationUriHandler uIHelperConfigurationUriHandler : uiHelperConfigurationUriHandlers) {
            configurationHandler
                    .registerHandler(uIHelperConfigurationUriHandler);
        }

        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(source, configurationHandler);

            if (configurationHandler.hasErrors()) {
                throw new IllegalStateException(
                        configurationHandler.getErrorMessages());
            }

        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Error parsing configuration file.", ex);
        }
    }
}
