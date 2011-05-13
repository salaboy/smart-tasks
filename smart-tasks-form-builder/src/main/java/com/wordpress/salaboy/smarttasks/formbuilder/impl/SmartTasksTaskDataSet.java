/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import java.util.HashMap;
import java.util.Map;

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

	public SmartTasksTaskDataSet(TaskFormDefinition taskFormDefinition,
			MetaTask myTask) {
		this.taskFormDefinition = taskFormDefinition;
		this.myTask = myTask;
		this.expressionResolver = new MVELExpressionResolver();
	}

	/**
	 * This method will give a map in a form: Property->Value. Where the value
	 * can be an evaluated expression or some defined value.
	 */
	@Override
	public Map<String, String> getTaskInputs() {
		Map<String, String> taskDetails = new HashMap<String, String>();
		for (TaskPropertyDefinition column : taskFormDefinition
				.getInputFields()) {
			Object expresionResult = this.expressionResolver.resolveExpression(
					column.getSourceExpresion(), myTask);
			String stringData = null;
			if (column.getFormatter() != null) {
				stringData = column.getFormatter().format(expresionResult);
			} else {
				if (expresionResult == null) {
					stringData = "null";
				} else {
					stringData = expresionResult.toString();
				}
			}
			taskDetails.put(column.getName(), stringData);
		}
		return taskDetails;
	}

	@Override
	public Map<String, String> getTaskOutputs() {
		Map<String, String> taskDetails = new HashMap<String, String>();
		for (TaskPropertyDefinition column : taskFormDefinition
				.getOutputFields()) {
			Object expresionResult = this.expressionResolver.resolveExpression(
					column.getSourceExpresion(), myTask);
			String stringData = null;
			if (column.getFormatter() != null) {
				stringData = column.getFormatter().format(expresionResult);
			} else {
				if (expresionResult == null) {
					stringData = "null";
				} else {
					stringData = expresionResult.toString();
				}
			}
			taskDetails.put(column.getName(), stringData);
		}
		return taskDetails;
	}

}
