/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salaboy
 * This class will contain a Map with all the human task clients registered for an UI.
 * Allowing multi client configurations
 */
public class HumanTaskClientRegistry {
    private Map<String, HumanTaskActionClientWrapper> actionClients = new HashMap<String, HumanTaskActionClientWrapper>();
    private Map<String, HumanTaskQueryClientWrapper> queryClients = new HashMap<String, HumanTaskQueryClientWrapper>();
    private static HumanTaskClientRegistry registry;
    public static HumanTaskClientRegistry getInstance(){
        if(registry == null){
            registry = new HumanTaskClientRegistry();
        }
        return registry;
    }
    
    private HumanTaskClientRegistry() {
       
    }

    public void addActionClient(String name, HumanTaskActionClientWrapper client){
        this.actionClients.put(name, client);
    }
    
    public void addQueryClient(String name, HumanTaskQueryClientWrapper client){
        this.queryClients.put(name, client);
    }
   
    public HumanTaskQueryClientWrapper getQueryClient(String name){
        return this.queryClients.get(name);
    }

    public HumanTaskActionClientWrapper getActionClient(String name){
        return this.actionClients.get(name);
    }
    
    
    
}
