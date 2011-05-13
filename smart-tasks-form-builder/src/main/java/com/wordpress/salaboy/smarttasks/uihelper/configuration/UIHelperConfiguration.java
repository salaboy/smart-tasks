/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration;

import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import java.io.File;

/**
 * 
 * @author esteban
 */
public class UIHelperConfiguration {
    private File uiHelperRootDirectory;
    private HumanTaskServiceConfiguration humanTaskServiceConfiguration;

    protected UIHelperConfiguration() {
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
