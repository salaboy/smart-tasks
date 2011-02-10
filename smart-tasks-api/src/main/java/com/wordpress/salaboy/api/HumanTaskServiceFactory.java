/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceFactory {
    
    public static HumanTaskService newHumanTaskService(HumanTaskServiceConfiguration config) throws IllegalStateException{
        Map<String, HumanTaskServiceOperations> clientConfigs = new HashMap<String, HumanTaskServiceOperations>();
        
        for(String key : config.getHumanTaskClientConfigurations().keySet()){
           if(config.getHumanTaskClientConfigurations().get(key).getType().equals("jBPM5") ){
                try {
                    Class<?> clazz = Class.forName("com.wordpress.salaboy.smarttasks.jbpm5wrapper.JBPM5HumanTaskServiceOperations");
                    Constructor<?> constructor = clazz.getConstructor(config.getHumanTaskClientConfigurations().get(key).getClass());
                    HumanTaskServiceOperations newInstance = (HumanTaskServiceOperations) constructor.newInstance(config.getHumanTaskClientConfigurations().get(key));
                   
                   clientConfigs.put("jBPM5TaskOperation", newInstance);
                } catch (Exception ex) {
                    throw new IllegalStateException("Unable to create JBPM5HumanTaskServiceOperations instance: "+ex.getMessage(), ex);
                }
           }
           
           if(config.getHumanTaskClientConfigurations().get(key).getType().equals("Activiti") ){
                try {
                    Class<?> clazz = Class.forName("com.wordpress.salaboy.smarttasks.activiti5wrapper.ActivitiHumanTaskServiceOperations");
                    Constructor<?> constructor = clazz.getConstructor(config.getHumanTaskClientConfigurations().get(key).getClass());
                    HumanTaskServiceOperations newInstance = (HumanTaskServiceOperations) constructor.newInstance(config.getHumanTaskClientConfigurations().get(key));
                   
                   clientConfigs.put("ActivitiTaskOperation", newInstance);
                } catch (Exception ex) {
                    throw new IllegalStateException("Unable to create ActivitiHumanTaskServiceOperations instance: "+ex.getMessage(), ex);
                }
           }
        }
        
        HumanTaskService humanTaskService = new HumanTaskServiceImpl(clientConfigs);
        
        return humanTaskService;
    }

}
