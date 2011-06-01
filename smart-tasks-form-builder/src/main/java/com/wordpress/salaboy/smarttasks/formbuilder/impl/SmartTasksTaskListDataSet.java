/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.yaml.snakeyaml.Yaml;

import com.wordpress.salaboy.smarttasks.formbuilder.api.ExternalData;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskListDataSet;
import com.wordpress.salaboy.smarttasks.formbuilder.api.output.TaskListMetadata;
import com.wordpress.salaboy.smarttasks.formbuilder.api.output.TaskListsData;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.ExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.MVELExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableColumnDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableDefinition;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;

/**
 * 
 * @author esteban
 */
public class SmartTasksTaskListDataSet implements TaskListDataSet {

    private final List<MetaTask> myTasks;
    private final TaskListTableDefinition taskListTableDefinition;
    private final ExpressionResolver expressionResolver;
    private final Map<String, ExternalData> externalData;

    public SmartTasksTaskListDataSet(
            TaskListTableDefinition taskListTableDefinition,
            List<MetaTask> myTasks, Map<String, ExternalData> externalData) {
        this.taskListTableDefinition = taskListTableDefinition;
        this.myTasks = myTasks;
        this.expressionResolver = new MVELExpressionResolver();
        this.externalData = externalData;
    }

    @Override
    public String getData() {

        Object[][] data = new Object[myTasks.size()][this.taskListTableDefinition
                .getColumns().size()];

        int i = 0;
        for (MetaTask metaTask : myTasks) {
            int j = 0;
            for (TaskListTableColumnDefinition taskListTableColumnDefinition : this.taskListTableDefinition
                    .getColumns()) {
                Object expresionResult = this.expressionResolver
                        .resolveExpression(taskListTableColumnDefinition
                                .getSourceExpresion(), metaTask,
                                this.externalData);
                if (expresionResult instanceof QName) {
                    expresionResult = expresionResult.toString();
                }
                data[i][j] = expresionResult;
                j++;
            }
            i++;
        }
        TaskListsData taskListData = new TaskListsData(data);
        Yaml yaml = new Yaml();
        return yaml.dump(taskListData);
    }

    @Override
    public String getRowsMetaData() {
        String[][] rowMetadata = this.taskListTableDefinition.getRowsMetaData();

        if (rowMetadata == null) {
            // No metadata defined
            return null;
        }

        Object[][] metaData = new String[this.myTasks.size()][];

        int i = 0;
        for (MetaTask metaTask : this.myTasks) {
            metaData[i] = new String[rowMetadata.length];
            for (int j = 0; j < metaData[i].length; j++) {
                Object expressionResult = this.expressionResolver
                        .resolveExpression(rowMetadata[j][1], metaTask, null);
                if (expressionResult instanceof QName) {
                    expressionResult = expressionResult.toString();
                }
                metaData[i][j] = expressionResult;
            }
            i++;
        }
        TaskListMetadata tasklistmetadata = new TaskListMetadata(metaData);
        Yaml yaml = new Yaml();
        return yaml.dump(tasklistmetadata);
    }
}
