/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceFactory {
    
    public static HumanTaskService newHumanTaskService(HumanTaskServiceConfiguration config) throws IllegalStateException{
        Map<String, HumanTaskServiceOperations> clientConfigs = new HashMap<String, HumanTaskServiceOperations>();

        for (Map.Entry<String, HumanTaskClientConfiguration> entry : config.getHumanTaskClientConfigurations().entrySet()) {
            clientConfigs.put(entry.getKey(), entry.getValue().getServiceOperationsImplementation());
        }
        
        HumanTaskService humanTaskService = new HumanTaskServiceImpl(clientConfigs);
        
        return humanTaskService;
    }

}
