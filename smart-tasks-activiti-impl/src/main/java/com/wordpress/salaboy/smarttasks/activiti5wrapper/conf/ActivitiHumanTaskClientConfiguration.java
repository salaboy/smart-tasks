/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.activiti5wrapper.conf;

import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;

/**
 *
 * @author salaboy
 */
public class ActivitiHumanTaskClientConfiguration implements HumanTaskClientConfiguration{

    private String configurationResource;
    
    public ActivitiHumanTaskClientConfiguration(String configurationResource) {
        this.configurationResource =  configurationResource;
    }

    public String getConfigurationResource() {
        return configurationResource;
    }

    
    public String getType() {
        return "Activiti";
    }

}
