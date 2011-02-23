/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.uihelper.impl;

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

    private final List<TTaskAbstract> taskAbstracts;
    private final TaskListTableDefinition taskListTableDefinition;

    public SmartTasksTaskListDataSet(TaskListTableDefinition taskListTableDefinition, List<TTaskAbstract> taskAbstracts) {
        this.taskListTableDefinition = taskListTableDefinition;
        this.taskAbstracts = taskAbstracts;
    }

    @Override
    public String[][] getData() {
        
        String[][] data = new String[this.taskAbstracts.size()][this.taskListTableDefinition.getColumns().size()];

        int i = 0;
        for (TTaskAbstract tTaskAbstract : this.taskAbstracts) {
            int j = 0;
            for (TaskListTableColumnDefinition taskListTableColumnDefinition : this.taskListTableDefinition.getColumns()) {
                Object expresionResult = MVEL.eval(taskListTableColumnDefinition.getSourceExpresion(), tTaskAbstract);
                String stringData = null;
                if (taskListTableColumnDefinition.getFormatter() != null) {
                    stringData = taskListTableColumnDefinition.getFormatter().format(expresionResult);
                } else {
                    if (expresionResult == null) {
                        stringData = "null";
                    } else {
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
        
        String[][] metaData = new String[this.taskAbstracts.size()][];
        
        int i =0;
        for (TTaskAbstract tTaskAbstract : this.taskAbstracts) {
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
