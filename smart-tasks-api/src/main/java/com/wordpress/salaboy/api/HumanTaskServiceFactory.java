/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceFactory {
    
    public static HumanTaskService newHumanTaskService(HumanTaskServiceConfiguration config) throws IllegalStateException{
        List<HumanTaskServiceOperations> clientConfigs = new ArrayList<HumanTaskServiceOperations>();
        
        for (HumanTaskClientConfiguration humanTaskClientConfiguration : config.getHumanTaskClientConfigurations().values()) {
            clientConfigs.add(humanTaskClientConfiguration.getServiceOperationsImplementation());
        }
        
        HumanTaskService humanTaskService = new HumanTaskServiceImpl(clientConfigs);
        
        return humanTaskService;
    }

}
