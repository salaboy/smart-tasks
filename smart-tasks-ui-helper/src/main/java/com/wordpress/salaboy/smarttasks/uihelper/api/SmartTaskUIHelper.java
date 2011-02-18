/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.api;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfigurationProvider;
import com.wordpress.salaboy.smarttasks.uihelper.impl.SmartTasksTaskListUIHelper;
import java.io.File;

/**
 *
 * @author esteban
 */
public class SmartTaskUIHelper {

    private boolean connected;
    private ConnectionData connectionData;
    private HumanTaskService humanTaskService;
    private UIHelperConfiguration configuration;

    public SmartTaskUIHelper(File root) {
        //TODO: add the possibility to register custom UIHelperConfigurationUriHandlers
        this.configuration = new UIHelperConfigurationProvider(root).createConfiguration();
        this.humanTaskService = HumanTaskServiceFactory.newHumanTaskService(configuration.getHumanTaskServiceConfiguration());
    }
    
    
    
    public void connect(ConnectionData connectionData){
        if (this.connected){
            this.disconnect();
        }
        
        this.connectionData = connectionData;
        try {
            this.humanTaskService.activate(connectionData.getEntityId());
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
    
    public TaskListUIHelper getTaskListHelper(String taskListId, String taskType){
        this.checkIfConnected();
        return new SmartTasksTaskListUIHelper(taskListId, this.connectionData.getEntityId(), taskType, configuration, humanTaskService );
    }
    
    private void checkIfConnected(){
        if (!this.connected){
            throw new IllegalStateException("UIHelper is disconnected!");
        }
    }
    
}
