package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.ws_ht.api.TAttachment;
import org.example.ws_ht.api.TAttachmentInfo;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskFormBuilder;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskOperationsDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.api.exception.InvalidTaskException;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderDefinitionsProvider;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskFormDefinition;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;

/**
 * Helper to give support to the UI to show task details. It provides:
 * <ul>
 * <li>Show task details (input)</li>
 * <li>Show task form (output)</li>
 * <li>Show task operations</li>
 * </ul>
 * 
 * @author calcacuervo
 * 
 */
public class SmartTasksTaskFormBuilder implements TaskFormBuilder {

	private TaskFormDefinition taskFormDefinition;

	private String taskUIId;

	private String taskId;

	private String profile;

	private String entityId;

	private final HumanTaskService humanTaskService;

	private TaskOperationsDefinition operationsDefinition;

	/**
	 * Creates a new {@link SmartTasksTaskFormBuilder} instance.
	 * 
	 * @param configuration
	 * @param taskId
	 * @param profile
	 * @param humanTaskService
	 * @param taskType
	 *            this is a type to identify tasks.
	 * @param entityId
	 * @param operationsDefinitionFileName
	 *            the operations definition filename.
	 */
	public SmartTasksTaskFormBuilder(BuilderConfiguration configuration,
			String taskId, String profile,
			final HumanTaskService humanTaskService, final String taskType,
			final String entityId) {
		this.profile = profile;
		this.taskId = taskId;
		this.taskUIId = taskType;
		this.entityId = entityId;
		this.humanTaskService = humanTaskService;
		BuilderDefinitionsProvider provider = new BuilderDefinitionsProvider(
				configuration);
		this.taskFormDefinition = provider.getTaskFormDefinition(this.taskUIId,
				this.entityId, profile);
		this.operationsDefinition = provider
				.getTaskOperationsDefinition(this.humanTaskService
						.getTaskOriginatorType(this.taskId).toLowerCase());
		this.humanTaskService.setAuthorizedEntityId(entityId);
	}

	/**
	 * Returns the task details and inputs for the task.
	 * @throws InvalidTaskException if the task is not found.
	 */
	@Override
	public Map<String, String> getTaskInput() throws InvalidTaskException {
		try {
			TTask task = humanTaskService.getTaskInfo(this.taskId);
			if (task == null) {
				throw new InvalidTaskException(taskId,
						"Could not finde the task for the given id.");
			}
			MetaTask myTask = MetaTaskDecoratorService.getInstance().decorate(
					"base", task);
			// TODO, see if we can put this in a decorator.
			Map<String, Object> inputs = this.getMapTaskInputFields(taskId);
			myTask.setInputs(inputs);
			return new SmartTasksTaskDataSet(taskFormDefinition, myTask)
					.getTaskInputs();
		} catch (IllegalArgumentFault fault) {
			Logger.getLogger(SmartTasksTaskFormBuilder.class.getName())
					.log(Level.SEVERE,
							"There was an error obtaining task information.",
							fault);
		}
		Logger.getLogger(SmartTasksTaskFormBuilder.class.getName()).log(
				Level.SEVERE, "Could not obtain task input.");
		return null;
	}

	/**
	 * Given a taskId, it returns the attachments and returns it an an String
	 * array.
	 * 
	 * @param taskId
	 *            the task id to search.
	 * @return the attachments.
	 */
	private Map<String, Object> getMapTaskInputFields(String taskId) {
		try {
			List<TAttachmentInfo> attachmentsInfo = humanTaskService
					.getAttachmentInfos(taskId);
			if (attachmentsInfo != null && attachmentsInfo.size() > 0) {
				TAttachmentInfo firstAttachmentInfo = attachmentsInfo.get(0);
				List<TAttachment> attachmentsList = humanTaskService
						.getAttachments(this.taskId,
								firstAttachmentInfo.getName());
				if (attachmentsList != null && attachmentsList.size() > 0) {
					TAttachment attachment = attachmentsList.get(0);

					Object attachmentValue = attachment.getValue();
					// TODO check how to define an universal way for this
					// attachment!!
					if (attachmentValue instanceof Map) {
						return (Map<String, Object>) attachmentValue;
					} else {
						Map<String, Object> newMap = new HashMap<String, Object>();
						newMap.put("Content", attachmentValue);
						return newMap;
					}
				}
			}
			return new HashMap<String, Object>();
		} catch (Exception e) {
			Logger.getLogger(SmartTasksTaskFormBuilder.class.getName()).log(
					Level.SEVERE, "Could not obtain task input.", e);
			return null;
		}
	}

	/**
	 * Returns task needed output and default values.
	 */
	@Override
	public Map<String, String> getTaskOutput() throws InvalidTaskException {
		try {
			MetaTask myTask = MetaTaskDecoratorService.getInstance().decorate(
					"base", humanTaskService.getTaskInfo(this.taskId));
			return new SmartTasksTaskDataSet(this.taskFormDefinition, myTask)
					.getTaskOutputs();
		} catch (IllegalArgumentFault fault) {
			Logger.getLogger(SmartTasksTaskFormBuilder.class.getName())
					.log(Level.SEVERE,
							"There was an error obtaining task information.",
							fault);
		}
		Logger.getLogger(SmartTasksTaskFormBuilder.class.getName()).log(
				Level.SEVERE, "Could not obtain task input.");
		return null;
	}

	@Override
	public TaskOperationsDefinition getTaskOperations() throws InvalidTaskException {
		return operationsDefinition;
	}
	
	public void executeTaskAction(String actionName, Object data) throws InvalidTaskException {
		try {
		ActionExecutionHelper.executeAction(actionName, humanTaskService, taskId, data);
		}
		catch (Exception e) {
			Logger.getLogger(SmartTasksTaskFormBuilder.class.getName()).log(
					Level.SEVERE, "Could not execute action " + actionName, e);
		}
	}

}
