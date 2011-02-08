/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import org.example.ws_ht.TOrganizationalEntity;
import org.example.ws_ht.api.wsdl.TaskOperations;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceImpl implements HumanTaskService, AuthorizedService{
    private TaskOperations taskOperations;
    public HumanTaskServiceImpl(TaskOperations taskOperations) {
        this.taskOperations =  taskOperations;
        
    }

    
    
    public void setAuthorizedOrganizationalEntity(TOrganizationalEntity entity) {
        this.taskOperations.setAuthorizedOrganizationalEntity(entity);
    }

    public TOrganizationalEntity getAuthorizedOrganizationalEntinty() {
        return this.taskOperations.getAuthorizedOrganizationalEntity();
    }

    public TaskOperations getTaskOperations() {
        return this.taskOperations;
    }
    

}
