/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.conf;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceConfiguration {
    private Map<String, HumanTaskClientConfiguration> clientConfs = new HashMap<String, HumanTaskClientConfiguration>();
    
    
    
    public void addHumanTaskClientConfiguration(String name, HumanTaskClientConfiguration conf){
        clientConfs.put(name, conf);
    }
    
    public Map<String, HumanTaskClientConfiguration> getHumanTaskClientConfigurations(){
        return this.clientConfs;
    }
    
    
    
 }
