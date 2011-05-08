/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.uihelper.impl;

import java.util.HashMap;
import java.util.Map;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskDetailsDataSet;
import com.wordpress.salaboy.smarttasks.uihelper.expression.ExpressionResolver;
import com.wordpress.salaboy.smarttasks.uihelper.expression.MVELExpressionResolver;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskPropertyDefinition;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskTableDefinition;

/**
 * 
 * @author esteban
 */
public class SmartTasksTaskDataSet implements TaskDetailsDataSet {

	private final MetaTask myTask;
	private final TaskTableDefinition taskDetailsTableDefinition;
	private final ExpressionResolver expressionResolver;

	public SmartTasksTaskDataSet(
			TaskTableDefinition taskListTableDefinition, MetaTask myTask) {
		this.taskDetailsTableDefinition = taskListTableDefinition;
		this.myTask = myTask;
		this.expressionResolver = new MVELExpressionResolver();
	}

	/**
	 * This method will give a map in a form: Property->Value. Where the value
	 * can be an evaluated expression or some defined value.
	 */
	@Override
	public Map<String, String> getTaskDetails() {
		Map<String, String> taskDetails = new HashMap<String, String>();
		for (TaskPropertyDefinition column : taskDetailsTableDefinition
				.getColumns()) {
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
			taskDetails.put(column.getHeader(), stringData);
		}
		return taskDetails;
	}

}
