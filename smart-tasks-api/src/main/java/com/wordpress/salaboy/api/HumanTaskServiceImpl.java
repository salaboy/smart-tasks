/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.Map;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceImpl extends AuthorizedTaskOperationsDefault implements HumanTaskService{
    private Map<String, AuthorizedTaskOperations> taskOperations;
    
    public HumanTaskServiceImpl(Map<String, AuthorizedTaskOperations> taskOperations) {
        
        this.taskOperations = taskOperations;
        
    }
    
    public void setAuthorizedOrganizationalEntity(String entityId) {
        for(String key : this.taskOperations.keySet()){
            this.taskOperations.get(key).setAuthorizedEntityId(entityId);
        }
    }

   

    public Map<String, AuthorizedTaskOperations> getTaskOperations() {
        return this.taskOperations;
    }

    

}
