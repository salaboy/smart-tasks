/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author esteban
 */
public class UIHelperConfigurationProvider {
    
    public static final String UI_HELPER_FILE_NAME="UIHelper.config.xml";
    
    public static UIHelperConfiguration createConfiguration(File root) {
        
        if (root == null){
            root = new File(".");
        }
        
        File configFile = new File(root,UI_HELPER_FILE_NAME);
        
        if (!configFile.exists()){
            throw new IllegalArgumentException("No configuration file found at "+configFile.getAbsolutePath());
        }
        
        try {
            UIHelperConfiguration configuration = new UIHelperConfigurationParser().parse(new FileInputStream(configFile));
            configuration.setUiHelperRootDirectory(root);
            return configuration;
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("No configuration file found at "+configFile.getAbsolutePath());
        }
    }

    
    
}
