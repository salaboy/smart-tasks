/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskListBuilder;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskListDataSet;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderDefinitionsProvider;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableColumnDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskPropertyDefinition;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;

/**
 *
 * @author esteban
 */
public class SmartTasksTaskListBuilder implements TaskListBuilder{

    private final HumanTaskService humanTaskService;
    private final String taskListId;
    private final String entityId;
    private final String taskType;
    private final TaskListTableDefinition taskListTableDefinition;
    
    public SmartTasksTaskListBuilder(String taskListId, String entityId, String taskType, BuilderConfiguration configuration, HumanTaskService humanTaskService ) {
        this.taskListId = taskListId;
        this.entityId = entityId;
        this.taskType = taskType;
        this.humanTaskService = humanTaskService;
        
        this.taskListTableDefinition = new BuilderDefinitionsProvider(configuration).getTaskListTableDefinition(taskListId, entityId, taskType);
    }
    
    
    
    @Override
    public String[] getColumnHeaders() {
        
        String[] headers = new String[this.taskListTableDefinition.getColumns().size()];
        int i=0;
        for (TaskListTableColumnDefinition taskListTableColumnDefinition : this.taskListTableDefinition.getColumns()) {
            headers[i] = taskListTableColumnDefinition.getHeader();
            i++;
        }
        
        return headers;
    }

    @Override
    public TaskListDataSet getDataSet(int from, int amount){
        try{
             List<MetaTask> myTasks = MetaTaskDecoratorService.getInstance().decorateAbstractList(
                        //taskListTableDefinition.getDecorator(),
                        "base",
                        humanTaskService.getMyTaskAbstracts(taskListId, entityId, null, null, null, null, null, amount, from));
            
            return new SmartTasksTaskListDataSet(taskListTableDefinition, myTasks);
        } catch (IllegalArgumentFault ex) {
            throw new IllegalArgumentException(ex);
        } catch (IllegalStateFault ex) {
            throw new IllegalStateException(ex);
        }
        
    }

    @Override
    public int getDataCount() {
        List<TTaskAbstract> myTasks = null;
        try {
            myTasks = humanTaskService.getMyTaskAbstracts(taskType, entityId, null, null, null, null, null, null, null);
        } catch (IllegalArgumentFault ex) {
            //TODO: throw a more appropiated exception
            Logger.getLogger(SmartTasksTaskListBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateFault ex) {
            //TODO: throw a more appropiated exception
            Logger.getLogger(SmartTasksTaskListBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (myTasks == null){
            return 0;
        }
        return myTasks.size();
    }
    
    @Override
    public String[] getRowMetadataKeys() {
        String[][] rowMetadata = this.taskListTableDefinition.getRowsMetaData();
        
        if (rowMetadata == null){
            //No metadata defined
            return null;
        }
        
        String[] keys = new String[rowMetadata.length];
        
        for (int i = 0; i < rowMetadata.length; i++) {
            keys[i] = rowMetadata[i][0];
        }
        
        return keys;
    }
    
}
