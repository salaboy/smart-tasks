/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import com.wordpress.salaboy.smarttasks.formbuilder.api.ExternalData;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskDetailsDataSet;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.ExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.MVELExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskFormDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskPropertyDefinition;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;

/**
 * This class represents a set of data about a given task. The task is an
 * instance of {@link MetaTask}, and provides services to get the input and
 * output of the task, adapting it to the configured configuration.
 */
public class SmartTasksTaskDataSet implements TaskDetailsDataSet {

	private final MetaTask myTask;
	private final TaskFormDefinition taskFormDefinition;
	private final ExpressionResolver expressionResolver;
	private final Map<String, ExternalData> externalData;
	
	public SmartTasksTaskDataSet(TaskFormDefinition taskFormDefinition,
			MetaTask myTask, Map<String, ExternalData> externalData) {
		this.taskFormDefinition = taskFormDefinition;
		this.myTask = myTask;
		this.expressionResolver = new MVELExpressionResolver();
		this.externalData = externalData;
	}

	/**
	 * This method will give a map in a form: Property->Value. Where the value
	 * can be an evaluated expression or some defined value.
	 */
	@Override
	public Map<String, Object> getTaskInputs() {
		Map<String, Object> taskDetails = new HashMap<String, Object>();
		for (TaskPropertyDefinition column : taskFormDefinition
				.getInputFields()) {
			Object expresionResult = this.expressionResolver.resolveExpression(
					column.getSourceExpresion(), myTask, this.externalData);
            if (expresionResult != null) {
                if (expresionResult instanceof QName) {
                    //TODO this is a hack because Yaml doesn't like QNAME!
                    expresionResult = expresionResult.toString();
                }
                taskDetails.put(column.getName(), expresionResult);
            }
		}
		return taskDetails;
	}

	@Override
	public Map<String, Object> getTaskOutputs() {
		Map<String, Object> taskDetails = new HashMap<String, Object>();
		for (TaskPropertyDefinition column : taskFormDefinition
				.getOutputFields()) {
			Object expresionResult = this.expressionResolver.resolveExpression(
					column.getSourceExpresion(), myTask, this.externalData);
			if (expresionResult != null) {
                taskDetails.put(column.getName(), expresionResult);
            }
		}
		return taskDetails;
	}

}
