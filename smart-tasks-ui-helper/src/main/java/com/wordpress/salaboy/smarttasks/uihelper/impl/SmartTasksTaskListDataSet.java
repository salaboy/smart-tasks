/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.uihelper.impl;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskListDataSet;
import com.wordpress.salaboy.smarttasks.uihelper.expression.ExpressionResolver;
import com.wordpress.salaboy.smarttasks.uihelper.expression.MVELExpressionResolver;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskPropertyDefinition;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskTableDefinition;
import java.util.List;

/**
 *
 * @author esteban
 */
public class SmartTasksTaskListDataSet implements TaskListDataSet {

    private final List<MetaTask> myTasks;
    private final TaskTableDefinition taskListTableDefinition;
    private final ExpressionResolver expressionResolver;

    public SmartTasksTaskListDataSet(TaskTableDefinition taskListTableDefinition, List<MetaTask> myTasks) {
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
                for (TaskPropertyDefinition taskListTableColumnDefinition : this.taskListTableDefinition.getColumns()) {
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
