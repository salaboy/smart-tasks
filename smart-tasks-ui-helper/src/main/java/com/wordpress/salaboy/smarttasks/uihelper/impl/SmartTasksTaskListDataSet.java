/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.uihelper.impl;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskListDataSet;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskListTableColumnDefinition;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskListTableDefinition;
import java.util.List;
import org.example.ws_ht.api.TTaskAbstract;
import org.mvel2.MVEL;

/**
 *
 * @author esteban
 */
public class SmartTasksTaskListDataSet implements TaskListDataSet {

    private final List<MetaTask> myTasks;
    private final TaskListTableDefinition taskListTableDefinition;

    public SmartTasksTaskListDataSet(TaskListTableDefinition taskListTableDefinition, List<MetaTask> myTasks) {
        this.taskListTableDefinition = taskListTableDefinition;
        this.myTasks = myTasks;
    }

    @Override
    public String[][] getData() {
        
        String[][] data = new String[myTasks.size()][this.taskListTableDefinition.getColumns().size()]; 
            
            int i = 0;
            for (MetaTask metaTask : myTasks) {
                int j = 0;
                for (TaskListTableColumnDefinition taskListTableColumnDefinition : this.taskListTableDefinition.getColumns()) {
                    Object expresionResult = null;
                    if(taskListTableColumnDefinition.getSourceExpresion().startsWith("meta:")){
                        
                        expresionResult = MVEL.eval(taskListTableColumnDefinition.getSourceExpresion().split(":")[1],metaTask);
                    }
                    else if(taskListTableColumnDefinition.getSourceExpresion().startsWith("task:")){
                        
                        expresionResult = MVEL.eval(taskListTableColumnDefinition.getSourceExpresion().split(":")[1],metaTask.getTask());
                    }
                    else{
                        expresionResult = MVEL.eval(taskListTableColumnDefinition.getSourceExpresion(),metaTask.getTaskAbstract());
                    }
                    String stringData = null;
                    if (taskListTableColumnDefinition.getFormatter() != null){
                        stringData = taskListTableColumnDefinition.getFormatter().format(expresionResult);
                    }else{
                        if (expresionResult == null){
                            stringData = "null";
                        }else{
                            stringData = expresionResult.toString();
                        }
                    }
                    
                    data[i][j] = stringData;
                    j++;
                }
                i++;
            }
            
            return data;
    }
    
    @Override
    public String[][] getRowsMetaData() {
        String[][] rowMetadata = this.taskListTableDefinition.getRowsMetaData();
        
        if (rowMetadata == null){
            //No metadata defined
            return null;
        }
        
        String[][] metaData = new String[this.myTasks.size()][];
        
        int i =0;
        for (MetaTask metaTask : this.myTasks) {
            metaData[i] = new String[rowMetadata[0].length];
            for (int j = 0; j < metaData[i].length; j++) {
                //TODO: add support for expressions in metadata
                metaData[i][j] = rowMetadata[j][1]; 
            }
            i++;
        }
        
        
        return metaData;
    }
}
