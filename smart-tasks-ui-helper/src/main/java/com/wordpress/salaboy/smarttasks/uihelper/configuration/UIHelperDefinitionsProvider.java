/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskOperationsDefinition;
import com.wordpress.salaboy.smarttasks.uihelper.impl.SmartTasksTaskSupportUIHelper;
import com.wordpress.salaboy.smarttasks.uihelper.model.GraphTaskOperations;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskTableDefinition;

/**
 *
 * @author esteban
 */
public class UIHelperDefinitionsProvider {
    
    public static final String DEFINITIONS_DIRECTORY = "definitions";
    public static final String TASK_LISTS_DEFINITIONS_DIRECTORY = "taskLists";
    public static final String TASK_DESCRIPTIONS_DEFINITIONS_DIRECTORY = "taskDefinitions";
    public static final String TASK_FORMS_DEFINITIONS_DIRECTORY = "formDefinitions";
    public static final String TASK_OPERATIONS_DIRECTORY = "operationDefinitions";
    
    private final File definitionsDirectory;

    public UIHelperDefinitionsProvider(UIHelperConfiguration uiHelperConfiguration) {
        File uiHelperRootDirectory = uiHelperConfiguration.getUiHelperRootDirectory();
        definitionsDirectory = new File(uiHelperRootDirectory,DEFINITIONS_DIRECTORY);
        
        if (!definitionsDirectory.exists()){
            throw new IllegalStateException("Error creating Definitions Provider: "+definitionsDirectory.getAbsolutePath()+" does not exist!");
        }
        
        if (!definitionsDirectory.isDirectory()){
            throw new IllegalStateException("Error creating Definitions Provider: "+definitionsDirectory.getAbsolutePath()+" is not a directory!");
        }
    }
    
    public TaskTableDefinition getTaskDetailsTableDefinition(String taskUIId, String entityId, String profile) {
    	File taskConfigurationFile = new File(new File(this.definitionsDirectory,TASK_DESCRIPTIONS_DEFINITIONS_DIRECTORY),taskUIId + ".config.json");
    	if (taskConfigurationFile == null || !taskConfigurationFile.exists()) {
    		taskConfigurationFile = new File(new File(this.definitionsDirectory,TASK_DESCRIPTIONS_DEFINITIONS_DIRECTORY), "default.config.json");	
    	}
    	return createDefinition(taskUIId, entityId, profile, taskConfigurationFile);
    }
    
    public TaskOperationsDefinition getTaskOperationsDefinition(String fileName) {
    	File taskConfigurationFile = new File(new File(this.definitionsDirectory,TASK_OPERATIONS_DIRECTORY),fileName + ".config.json");
    	TaskOperationsDefinition operationsDefinitions;
		try {
			operationsDefinitions = new GraphTaskOperations(taskConfigurationFile);
			return operationsDefinitions;
		} catch (JsonParseException e) {
			Logger.getLogger(UIHelperDefinitionsProvider.class.getName())
			.log(Level.SEVERE,
					"There was a problem getting operations definitions",
					e);
		} catch (FileNotFoundException e) {
			Logger.getLogger(UIHelperDefinitionsProvider.class.getName())
			.log(Level.SEVERE,
					"There was a problem getting operations definitions",
					e);
		}
    	return null;
    }
    
    public TaskTableDefinition getTaskFormTableDefinition(String taskUIId, String entityId, String profile) {
    	File taskConfigurationFile = new File(new File(this.definitionsDirectory,TASK_FORMS_DEFINITIONS_DIRECTORY),taskUIId + ".config.json");
    	if (taskConfigurationFile == null || !taskConfigurationFile.exists()) {
    		taskConfigurationFile = new File(new File(this.definitionsDirectory,TASK_DESCRIPTIONS_DEFINITIONS_DIRECTORY), "default.config.json");	
    	}
        return createDefinition(taskUIId, entityId, profile, taskConfigurationFile);
    }

    public TaskTableDefinition getTaskListTableDefinition(String taskListId, String entityId, String taskType) {
        //TODO: add a cache here
        
        //Convert the configuration file.
        File taskListConfigurationFile = new File(new File(this.definitionsDirectory,TASK_LISTS_DEFINITIONS_DIRECTORY),taskListId+".config.json");
        return createDefinition(taskListId, entityId, taskType,
				taskListConfigurationFile);
        
    }

	private TaskTableDefinition createDefinition(String taskListId,
			String entityId, String taskType, File taskListConfigurationFile) {
		Collection<TaskTableDefinition> definitions = null;
        try {
            Gson gson = new Gson();
            definitions = gson.fromJson(new FileReader(taskListConfigurationFile), new TypeToken<Collection<TaskTableDefinition>>() {}.getType());
            //TODO populate cache here
            
            //check if a profile is defined for the entityId and taskType
            if (entityId != null && taskType != null){
                String profileName = entityId+"_"+taskType;
                TaskTableDefinition definition = this.getTaskTableDefinition(definitions, profileName);
                if (definition != null){
                    return definition;
                }
            }
            
            //no entityId-taskType profile defined. Lets check for entityId then
            if (entityId != null){
                String profileName = entityId;
                TaskTableDefinition definition = this.getTaskTableDefinition(definitions, profileName);
                if (definition != null){
                    return definition;
                }
            }
            
            //no entityId profile defined. Lets check for taskType then
            if (taskType != null){
                String profileName = taskType;
                TaskTableDefinition definition = this.getTaskTableDefinition(definitions, profileName);
                if (definition != null){
                    return definition;
                }
            }
            
            //no specicial profile foind. Let's find the Default:
            String profileName = TaskTableDefinition.DEFAULT_PROFILE_NAME;
            TaskTableDefinition definition = this.getTaskTableDefinition(definitions, profileName);
            if (definition != null){
                return definition;
            }
            
            //no Default profile -> Error!
            throw new IllegalStateException("No Default configuration defined for : "+taskListId);
            
        } catch (FileNotFoundException ex) {
            throw new IllegalStateException("No configuration defined for : "+taskListId);
        }
	}

    private TaskTableDefinition getTaskTableDefinition(Collection<TaskTableDefinition> definitions, String profileName){
        for (TaskTableDefinition taskListTableDefinition : definitions) {
            if (taskListTableDefinition.getProfile().equals(profileName)){
              return taskListTableDefinition;  
            }
        }
        
        return null;
    }
    
    
}
