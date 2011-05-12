package com.wordpress.salaboy.smarttasks.uihelper.impl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.ws_ht.api.wsdl.IllegalArgumentFault;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskOperationsDefinition;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskSupportUIHelper;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperDefinitionsProvider;
import com.wordpress.salaboy.smarttasks.uihelper.model.TaskTableDefinition;

/**
 * Helper to give support to the UI to show task details. It provides:
 * <ul>
 * <li>Show task details</li>
 * <li>Show task form</li>
 * <li>Show task operations</li>
 * </ul>
 * @author calcacuervo
 *
 */
public class SmartTasksTaskSupportUIHelper implements TaskSupportUIHelper {

	private TaskTableDefinition taskDetailsDefinition;

	private TaskTableDefinition taskFormDefinition;

	private String taskUIId;

	private String taskId;

	private String profile;
 
	private String entityId;

	private final HumanTaskService humanTaskService;

	private TaskOperationsDefinition operationsDefinition;
	
	private static final String operationsDefinitionFileName = "operations";

	/**
	 * Creates a new {@link SmartTasksTaskSupportUIHelper} instance.
	 * @param configuration
	 * @param taskId
	 * @param profile
	 * @param humanTaskService
	 * @param taskUIId this is and Id to identify the task in the UI definition.
	 * @param entityId
	 * @param operationsDefinitionFileName the operations definition filename.
	 */
	public SmartTasksTaskSupportUIHelper(UIHelperConfiguration configuration,
			String taskId, String profile,
			final HumanTaskService humanTaskService, final String taskUIId,
			final String entityId) {
		this.profile = profile;
		this.taskId = taskId;
		this.taskUIId = taskUIId;
		this.entityId = entityId;
		this.humanTaskService = humanTaskService;
		UIHelperDefinitionsProvider provider = new UIHelperDefinitionsProvider(
				configuration);
		this.taskDetailsDefinition = provider.getTaskDetailsTableDefinition(
				this.taskUIId, this.entityId, this.profile);
		this.taskFormDefinition = provider.getTaskFormTableDefinition(
				this.taskUIId, this.entityId, profile);
		this.operationsDefinition = provider
				.getTaskOperationsDefinition(this.humanTaskService.getTaskOriginatorType(this.taskId).toLowerCase());
	}

	/**
	 * Returns the task details in form of a map.
	 */
	@Override
	public Map<String, String> getTaskDetails() {
		try {
			MetaTask myTask = MetaTaskDecoratorService.getInstance().decorate(
					"base", humanTaskService.getTaskInfo(this.taskId));
			return new SmartTasksTaskDataSet(taskDetailsDefinition, myTask)
					.getTaskDetails();
		} catch (IllegalArgumentFault fault) {
			Logger.getLogger(SmartTasksTaskSupportUIHelper.class.getName())
					.log(Level.SEVERE,
							"There was an error obtaining task information.",
							fault);
		}
		return null;
	}

	/**
	 * Returns task form inputs and default values.
	 */
	@Override
	public Map<String, String> getTaskFormInputs() {
		try {
			MetaTask myTask = MetaTaskDecoratorService.getInstance().decorate(
					"base", humanTaskService.getTaskInfo(this.taskId));
			return new SmartTasksTaskDataSet(this.taskFormDefinition, myTask)
					.getTaskDetails();
		} catch (IllegalArgumentFault fault) {
			Logger.getLogger(SmartTasksTaskSupportUIHelper.class.getName())
					.log(Level.SEVERE,
							"There was an error obtaining task information.",
							fault);
		}
		return null;
	}

	@Override
	public TaskOperationsDefinition getTaskOperations() {
		return operationsDefinition;
	}
}
