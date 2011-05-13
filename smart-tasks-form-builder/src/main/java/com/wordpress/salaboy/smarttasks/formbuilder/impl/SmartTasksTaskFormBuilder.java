package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.ws_ht.api.TAttachment;
import org.example.ws_ht.api.TAttachmentInfo;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.jbpm.task.Content;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskFormBuilder;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskOperationsDefinition;
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
	 * Returns the task details and inputs for the task
	 */
	@Override
	public Map<String, String> getTaskInput() {
		try {
			MetaTask myTask = MetaTaskDecoratorService.getInstance().decorate(
					"base", humanTaskService.getTaskInfo(this.taskId));
			// TODO, see if we can put this in a decorator.
			String[] inputs = this.getTaskInputFields(taskId);
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
	private String[] getTaskInputFields(String taskId) {
		try {
			List<TAttachmentInfo> attachmentsInfo = humanTaskService
					.getAttachmentInfos(taskId);
			TAttachmentInfo firstAttachmentInfo = attachmentsInfo.get(0);
			TAttachment attachment = humanTaskService.getAttachments(
					this.taskId, firstAttachmentInfo.getName()).get(0);

			ByteArrayInputStream bais = new ByteArrayInputStream(
					((Content) attachment.getValue()).getContent());
			ObjectInputStream ois = new ObjectInputStream(bais);
			String taskinfo = (String) ois.readObject();
			return taskinfo.split(",");
		} catch (Exception e) {
			Logger.getLogger(SmartTasksTaskFormBuilder.class.getName())
					.log(Level.SEVERE, "Could not obtain task input.", e);
			return null;
		}
	}

	/**
	 * Returns task needed output and default values.
	 */
	@Override
	public Map<String, String> getTaskOutput() {
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
	public TaskOperationsDefinition getTaskOperations() {
		return operationsDefinition;
	}
	
	public void executeTaskAction(String actionName, Object data) {
		try {
		ActionExecutionHelper.executeAction(actionName, humanTaskService, taskId, data);
		}
		catch (Exception e) {
			Logger.getLogger(SmartTasksTaskFormBuilder.class.getName()).log(
					Level.SEVERE, "Could not execute action " + actionName, e);
		}
	}

}
