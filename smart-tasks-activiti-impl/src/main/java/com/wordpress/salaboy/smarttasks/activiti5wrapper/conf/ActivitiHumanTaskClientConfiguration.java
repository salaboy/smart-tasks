/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.activiti5wrapper.conf;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.activiti5wrapper.ActivitiHumanTaskServiceOperations;

/**
 *
 * @author salaboy
 */
public class ActivitiHumanTaskClientConfiguration implements HumanTaskClientConfiguration{
    public final static String TYPE = "Activiti";
    private String configurationResource;
    
    public ActivitiHumanTaskClientConfiguration(String configurationResource) {
        this.configurationResource =  configurationResource;
    }

    public String getConfigurationResource() {
        return configurationResource;
    }

    
    public String getType() {
        return TYPE;
    }

    public HumanTaskServiceOperations getServiceOperationsImplementation() {
        return new ActivitiHumanTaskServiceOperations(this);
    }

}
