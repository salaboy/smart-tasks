/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.api;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.impl.SmartTasksTaskFormBuilder;
import com.wordpress.salaboy.smarttasks.formbuilder.impl.SmartTasksTaskListBuilder;

/**
 * This class is the main one for this module. It will provide de UI, based in
 * the given configuration, the necessary services to build the tsak list and
 * task forms.
 * 
 * @author esteban
 */
public class SmartTaskBuilder {

    private boolean connected;
    private ConnectionData connectionData;
    private HumanTaskService humanTaskService;
    private BuilderConfiguration configuration;

    public SmartTaskBuilder(BuilderConfiguration configuration) {
        this.configuration = configuration;
        this.humanTaskService = HumanTaskServiceFactory.newHumanTaskService(configuration.getHumanTaskServiceConfiguration());
    }
    
    
    
    public void connect(ConnectionData connectionData){
        if (this.connected){
            this.disconnect();
        }
        
        this.connectionData = connectionData;
        try {
            this.humanTaskService.initializeService();
        } catch (Exception ex) {
            throw new IllegalStateException("Could not connect to HumanTaskService",ex);
        }
        
        this.connected = true;
    }
    
    public void disconnect(){
        if (this.humanTaskService != null){
            this.humanTaskService.cleanUpService();
        }
        this.connected = false;
    }
    
    public TaskListBuilder getTaskListHelper(String taskListId, String taskType){
        this.checkIfConnected();
        return new SmartTasksTaskListBuilder(taskListId, this.connectionData.getEntityId(), taskType, configuration, humanTaskService );
    }
    
    public TaskFormBuilder getTaskSupportHelper(String taskId, String taskUIId, String profile) {
    	this.checkIfConnected();
    	return new SmartTasksTaskFormBuilder(configuration, taskId, profile, humanTaskService, taskUIId, this.connectionData.getEntityId());
    }
    
    private void checkIfConnected(){
        if (!this.connected){
            throw new IllegalStateException("UIHelper is disconnected!");
        }
    }
    
}
