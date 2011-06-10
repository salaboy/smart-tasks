/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.api;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import org.example.ws_ht.api.TAttachment;
import org.example.ws_ht.api.TAttachmentInfo;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.smarttasks.formbuilder.api.exception.InvalidTaskException;
import com.wordpress.salaboy.smarttasks.formbuilder.api.output.TaskForm;
import com.wordpress.salaboy.smarttasks.formbuilder.api.output.TaskListsData;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderDefinitionsProvider;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.ExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.expression.MVELExpressionResolver;
import com.wordpress.salaboy.smarttasks.formbuilder.impl.ActionExecutionHelper;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskFormDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableColumnDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskListTableDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskPropertyDefinition;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;

/**
 * This class is the main one for this module. It will provide de UI, based in
 * the given configuration, the necessary services to build the tsak list and
 * task forms.
 * 
 * @author esteban
 */
public class SmartTaskBuilder {

	private boolean connected;
	private ConnectionData connectionData;
	private HumanTaskService humanTaskService;
	private BuilderConfiguration configuration;
	private ExpressionResolver expressionResolver;

	public SmartTaskBuilder(BuilderConfiguration configuration) {
		this.configuration = configuration;
		this.humanTaskService = HumanTaskServiceFactory
				.newHumanTaskService(configuration
						.getHumanTaskServiceConfiguration());
		this.expressionResolver = new MVELExpressionResolver();
	}

	public void connect(ConnectionData connectionData) {
		if (this.connected) {
			this.disconnect();
		}

		this.connectionData = connectionData;
		try {
			this.humanTaskService.initializeService();
		} catch (Exception ex) {
			throw new IllegalStateException(
					"Could not connect to HumanTaskService", ex);
		}

		this.connected = true;
	}

	public void disconnect() {
		if (this.humanTaskService != null) {
			this.humanTaskService.cleanUpService();
		}
		this.connected = false;
	}

	public String getTaskList(String profile) {
		this.checkIfConnected();
		this.humanTaskService.setAuthorizedEntityId(this.connectionData
				.getEntityId());
		TaskListTableDefinition taskListTableDefinition = new BuilderDefinitionsProvider(
				configuration).getTaskListTableDefinition(
				this.connectionData.getEntityId(), profile);
		try {
			List<MetaTask> myTasks = MetaTaskDecoratorService.getInstance()
					.decorateAbstractList(
							// taskListTableDefinition.getDecorator(),
							"base",
							humanTaskService.getMyTaskAbstracts(null,
									this.connectionData.getEntityId(), null,
									null, null, null, null, null, null));
			return this.getTaskListData(myTasks, taskListTableDefinition);
		} catch (Exception e) {
			Logger.getLogger(SmartTaskBuilder.class.getName()).log(
					Level.SEVERE, "There was an error", e);
			return null;
		}

	}

	private String getTaskListData(List<MetaTask> myTasks,
			TaskListTableDefinition taskListTableDefinition) {

		String[][] data = new String[myTasks.size()][taskListTableDefinition
				.getColumns().size()];
		int i = 0;
		for (MetaTask metaTask : myTasks) {
			int j = 0;
			for (TaskListTableColumnDefinition taskListTableColumnDefinition : taskListTableDefinition
					.getColumns()) {
				Object expresionResult = this.expressionResolver
						.resolveExpression(taskListTableColumnDefinition
								.getSourceExpresion(), metaTask,
								this.configuration.getContexts());
				if (expresionResult != null) {
					if (expresionResult instanceof QName) {
						expresionResult = expresionResult.toString();
					}
					data[i][j] = expresionResult.toString();
					j++;
				}
			}
			i++;
		}
		int p = 0;
		String[] columns = new String[taskListTableDefinition.getColumns()
		                              .size()];
		for (TaskListTableColumnDefinition taskListTableColumnDefinition : taskListTableDefinition
				.getColumns()) {
				columns[p] = taskListTableColumnDefinition.getHeader();
				p++;
		}
		TaskListsData taskListData = new TaskListsData(data, columns);
		Yaml yaml = new Yaml();
		return yaml.dump(taskListData);
	}

	// public TaskFormBuilder getTaskForm(String taskId, String taskUIId,
	// String profile) {
	// this.checkIfConnected();
	// return new SmartTasksTaskFormBuilder(configuration, taskId, profile,
	// humanTaskService, taskUIId, this.connectionData.getEntityId());
	// }

	public String getTaskForm(String taskId, String taskUIId, String profile)
			throws InvalidTaskException {
		this.checkIfConnected();
		this.humanTaskService.setAuthorizedEntityId(this.connectionData
				.getEntityId());
		BuilderDefinitionsProvider provider = new BuilderDefinitionsProvider(
				configuration);
		TaskFormDefinition taskFormDefinition = provider.getTaskFormDefinition(
				taskUIId, this.connectionData.getEntityId(), profile);
		DumperOptions options = new DumperOptions();
		options.setAllowReadOnlyProperties(true);
		Yaml yaml = new Yaml(options);
		TaskForm taskForm = new TaskForm();
		taskForm.setInputs(this.getTaskInput(taskId, taskFormDefinition));
		taskForm.setOutputs(this.getTaskOutput(taskId, taskFormDefinition));
		return yaml.dump(taskForm);
	}

	private Map<String, Object> getTaskInput(String taskId,
			TaskFormDefinition taskFormDefinition) throws InvalidTaskException {
		try {
			TTask task = humanTaskService.getTaskInfo(taskId);
			if (task == null) {
				throw new InvalidTaskException(taskId,
						"Could not finde the task for the given id.");
			}
			MetaTask myTask = MetaTaskDecoratorService.getInstance().decorate(
					"base", task);
			Map<String, Object> inputs = this.getMapTaskInputFields(taskId);
			myTask.setInputs(inputs);

			return this.resolveTaskInformation(
					taskFormDefinition.getInputFields(), myTask,
					this.configuration.getContexts());

		} catch (IllegalArgumentFault fault) {
			Logger.getLogger(SmartTaskBuilder.class.getName()).log(
					Level.SEVERE,
					"There was an error obtaining task information.", fault);
		}
		Logger.getLogger(SmartTaskBuilder.class.getName()).log(Level.SEVERE,
				"Could not obtain task input.");
		return null;
	}

	private Map<String, Object> getMapTaskInputFields(String taskId) {
		try {
			List<TAttachmentInfo> attachmentsInfo = humanTaskService
					.getAttachmentInfos(taskId);
			if (attachmentsInfo != null && attachmentsInfo.size() > 0) {
				TAttachmentInfo firstAttachmentInfo = attachmentsInfo.get(0);
				List<TAttachment> attachmentsList = humanTaskService
						.getAttachments(taskId, firstAttachmentInfo.getName());
				if (attachmentsList != null && attachmentsList.size() > 0) {
					TAttachment attachment = attachmentsList.get(0);

					Object attachmentValue = attachment.getValue();
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
			Logger.getLogger(SmartTaskBuilder.class.getName()).log(
					Level.SEVERE, "Could not obtain task input.", e);
			return null;
		}
	}

	/**
	 * Returns task needed output and default values.
	 */

	private Map<String, Object> getTaskOutput(String taskId,
			TaskFormDefinition taskFormDefinition) throws InvalidTaskException {
		try {
			MetaTask myTask = MetaTaskDecoratorService.getInstance().decorate(
					"base", humanTaskService.getTaskInfo(taskId));
			// TODO, see if we can put this in a decorator.
			Map<String, Object> inputs = this.getMapTaskInputFields(taskId);
			myTask.setInputs(inputs);
			return this.resolveTaskInformation(
					taskFormDefinition.getOutputFields(), myTask,
					this.configuration.getContexts());
		} catch (IllegalArgumentFault fault) {
			Logger.getLogger(SmartTaskBuilder.class.getName()).log(
					Level.SEVERE,
					"There was an error obtaining task information.", fault);
		}
		Logger.getLogger(SmartTaskBuilder.class.getName()).log(Level.SEVERE,
				"Could not obtain task input.");
		return null;
	}

	private Map<String, Object> resolveTaskInformation(
			List<TaskPropertyDefinition> fields, MetaTask myTask,
			Map<String, Object> externalData) {
		Map<String, Object> taskInformation = new LinkedHashMap<String, Object>();
		for (TaskPropertyDefinition column : fields) {
			Object expresionResult = this.expressionResolver.resolveExpression(
					column.getSourceExpresion(), myTask, externalData);
			if (expresionResult != null) {
				if (expresionResult instanceof QName) {
					// TODO this is a hack!
					expresionResult = expresionResult.toString();
				}
				taskInformation.put(column.getName(), expresionResult);
			}
		}
		return taskInformation;
	}

	private void checkIfConnected() {
		if (!this.connected) {
			throw new IllegalStateException("UIHelper is disconnected!");
		}
	}

	public TaskOperationsDefinition getTaskOperations(String taskId)
			throws InvalidTaskException {
		BuilderDefinitionsProvider provider = new BuilderDefinitionsProvider(
				configuration);
		return provider.getTaskOperationsDefinition(this.humanTaskService
				.getTaskOriginatorType(taskId).toLowerCase());

	}

	public void executeTaskAction(String actionName, Object data, String taskId)
			throws InvalidTaskException {
		try {
			this.humanTaskService.setAuthorizedEntityId(this.connectionData
					.getEntityId());
			ActionExecutionHelper.executeAction(actionName, humanTaskService,
					taskId, data);
		} catch (Exception e) {
			Logger.getLogger(SmartTaskBuilder.class.getName()).log(
					Level.SEVERE, "Could not execute action " + actionName, e);
		}
	}

}
