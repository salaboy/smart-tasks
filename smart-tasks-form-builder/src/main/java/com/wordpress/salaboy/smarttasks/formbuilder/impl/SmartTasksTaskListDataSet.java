/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskListDataSet;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.ExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.MVELExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskFormDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableColumnDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskPropertyDefinition;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import java.util.List;

/**
 *
 * @author esteban
 */
public class SmartTasksTaskListDataSet implements TaskListDataSet {

    private final List<MetaTask> myTasks;
    private final TaskListTableDefinition taskListTableDefinition;
    private final ExpressionResolver expressionResolver;

    public SmartTasksTaskListDataSet(TaskListTableDefinition taskListTableDefinition, List<MetaTask> myTasks) {
        this.taskListTableDefinition = taskListTableDefinition;
        this.myTasks = myTasks;
        this.expressionResolver = new MVELExpressionResolver();
    }

    @Override
    public String[][] getData() {
        
        String[][] data = new String[myTasks.size()][this.taskListTableDefinition.getColumns().size()]; 
            
            int i = 0;
            for (MetaTask metaTask : myTasks) {
                int j = 0;
                for (TaskListTableColumnDefinition taskListTableColumnDefinition : this.taskListTableDefinition.getColumns()) {
                    Object expresionResult = this.expressionResolver.resolveExpression(taskListTableColumnDefinition.getSourceExpresion(), metaTask);
                    
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
            metaData[i] = new String[rowMetadata.length];
            for (int j = 0; j < metaData[i].length; j++) {
                Object expressionResult = this.expressionResolver.resolveExpression(rowMetadata[j][1],metaTask);
                metaData[i][j] = expressionResult == null? "null":expressionResult.toString(); 
            }
            i++;
        }
        
        
        return metaData;
    }
}
