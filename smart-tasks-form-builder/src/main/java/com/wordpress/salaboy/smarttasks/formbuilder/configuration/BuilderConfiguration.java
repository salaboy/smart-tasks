/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.configuration;

import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.api.ExternalData;

import java.io.File;
import java.util.Map;

/**
 * 
 * @author esteban
 */
public class BuilderConfiguration {
    private File uiHelperRootDirectory;
    private HumanTaskServiceConfiguration humanTaskServiceConfiguration;
    private Map<String, ExternalData> externalContexts;
    
    protected BuilderConfiguration() {
    }

    /**
     * @return the contexts
     */
    public Map<String, ExternalData> getContexts() {
        return externalContexts;
    }


    /**
     * @param contexts the contexts to set
     */
    public void setContexts(Map<String, ExternalData> contexts) {
        this.externalContexts = contexts;
    }


    public void setHumanTaskServiceConfiguration(HumanTaskServiceConfiguration humanTaskServiceConfiguration) {
        this.humanTaskServiceConfiguration = humanTaskServiceConfiguration;
    }

    public void setUiHelperRootDirectory(File uiHelperRootDirectory) {
        this.uiHelperRootDirectory = uiHelperRootDirectory;
    }

    public HumanTaskServiceConfiguration getHumanTaskServiceConfiguration() {
        return humanTaskServiceConfiguration;
    }

    public File getUiHelperRootDirectory() {
        return uiHelperRootDirectory;
    }
    
}
