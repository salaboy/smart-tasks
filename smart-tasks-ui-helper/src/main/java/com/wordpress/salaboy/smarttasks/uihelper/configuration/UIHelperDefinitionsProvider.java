/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskListTableDefinition;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

/**
 *
 * @author esteban
 */
public class UIHelperDefinitionsProvider {
    
    public static final String DEFINITIONS_DIRECTORY = "definitions";
    public static final String TASK_LISTS_DEFINITIONS_DIRECTORY = "taskLists";
    
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
    
    public TaskListTableDefinition getTaskListTableDefinition(String taskListId, String entityId, String taskType) {
        //TODO: add a cache here
        
        //Convert the configuration file.
        File taskListConfigurationFile = new File(new File(this.definitionsDirectory,TASK_LISTS_DEFINITIONS_DIRECTORY),taskListId+".config.json");
        Collection<TaskListTableDefinition> definitions = null;
        try {
            Gson gson = new Gson();
            definitions = gson.fromJson(new FileReader(taskListConfigurationFile), new TypeToken<Collection<TaskListTableDefinition>>() {}.getType());
            //TODO populate cache here
            
            //check if a profile is defined for the entityId and taskType
            if (entityId != null && taskType != null){
                String profileName = entityId+"_"+taskType;
                TaskListTableDefinition definition = this.getTaskListTableDefinition(definitions, profileName);
                if (definition != null){
                    return definition;
                }
            }
            
            //no entityId-taskType profile defined. Lets check for entityId then
            if (entityId != null){
                String profileName = entityId;
                TaskListTableDefinition definition = this.getTaskListTableDefinition(definitions, profileName);
                if (definition != null){
                    return definition;
                }
            }
            
            //no entityId profile defined. Lets check for taskType then
            if (taskType != null){
                String profileName = taskType;
                TaskListTableDefinition definition = this.getTaskListTableDefinition(definitions, profileName);
                if (definition != null){
                    return definition;
                }
            }
            
            //no specicial profile foind. Let's find the Default:
            String profileName = TaskListTableDefinition.DEFAULT_PROFILE_NAME;
            TaskListTableDefinition definition = this.getTaskListTableDefinition(definitions, profileName);
            if (definition != null){
                return definition;
            }
            
            //no Default profile -> Error!
            throw new IllegalStateException("No Default configuration defined for : "+taskListId);
            
        } catch (FileNotFoundException ex) {
            throw new IllegalStateException("No configuration defined for : "+taskListId);
        }
        
    }

    private TaskListTableDefinition getTaskListTableDefinition(Collection<TaskListTableDefinition> definitions, String profileName){
        for (TaskListTableDefinition taskListTableDefinition : definitions) {
            if (taskListTableDefinition.getProfile().equals(profileName)){
              return taskListTableDefinition;  
            }
        }
        
        return null;
    }
    
}
