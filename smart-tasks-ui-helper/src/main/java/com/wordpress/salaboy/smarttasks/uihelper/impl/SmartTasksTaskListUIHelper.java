/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.impl;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskListDataSet;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskListUIHelper;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperDefinitionsProvider;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskListTableColumnDefinition;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskListTableDefinition;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;

/**
 *
 * @author esteban
 */
public class SmartTasksTaskListUIHelper implements TaskListUIHelper{

    private final HumanTaskService humanTaskService;
    private final String taskListId;
    private final String entityId;
    private final String taskType;
    private final TaskListTableDefinition taskListTableDefinition;
    
    public SmartTasksTaskListUIHelper(String taskListId, String entityId, String taskType, UIHelperConfiguration configuration, HumanTaskService humanTaskService ) {
        this.taskListId = taskListId;
        this.entityId = entityId;
        this.taskType = taskType;
        this.humanTaskService = humanTaskService;
        
        this.taskListTableDefinition = new UIHelperDefinitionsProvider(configuration).getTaskListTableDefinition(taskListId, entityId, taskType);
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
            Logger.getLogger(SmartTasksTaskListUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateFault ex) {
            //TODO: throw a more appropiated exception
            Logger.getLogger(SmartTasksTaskListUIHelper.class.getName()).log(Level.SEVERE, null, ex);
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
