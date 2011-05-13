package com.wordpress.demian.task;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorBase;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;
import com.wordpress.salaboy.smarttasks.uihelper.api.ConnectionData;
import com.wordpress.salaboy.smarttasks.uihelper.api.SmartTaskUIHelper;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskListDataSet;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskListUIHelper;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskOperationsDefinition;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskSupportUIHelper;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfigurationProvider;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler.ActivitiConfigurationHandler;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.saxhandler.JBPM5ConfigurationHandler;

/**
 * Controller to handle the task requests.
 * 
 * @author calcacuervo
 */
@Controller
public class ListTasksController {

	private static final Logger logger = LoggerFactory
			.getLogger(ListTasksController.class);

	SmartTaskUIHelper helper;

	TaskSupportUIHelper taskHelper = null;
	
	public ListTasksController() {
		MetaTaskDecoratorService.getInstance().registerDecorator("base",
				new MetaTaskDecoratorBase());
		File root = new File(Thread.currentThread().getContextClassLoader()
				.getResource("uihelper").getFile());
		UIHelperConfigurationProvider configurationProvider = new UIHelperConfigurationProvider(
				root);
		configurationProvider
				.addUIHelperConfigurationUriHandler(new JBPM5ConfigurationHandler());
		configurationProvider
				.addUIHelperConfigurationUriHandler(new ActivitiConfigurationHandler());
		UIHelperConfiguration config = configurationProvider
				.createConfiguration();
		helper = new SmartTaskUIHelper(config);

	}

	// TODO it should not be needed
	@RequestMapping(value = "/new/")
	public String start(Model model) {
		return "start";
	}

	/**
	 * This method gets the task list using the UIHelper classes.
	 * 
	 * @param entity
	 * @param profile
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list/{entity}/{profile}", method = RequestMethod.GET)
	public String list(@PathVariable("entity") String entity,
			@PathVariable("profile") String profile, Model model) {
		logger.info("Let's get the Task List!");
		ConnectionData connectionData = new ConnectionData();
		connectionData.setEntityId(entity);
		helper.connect(connectionData);
		TaskListUIHelper taskListHelper = helper.getTaskListHelper("taskList1",
				profile);
		TaskListDataSet set = taskListHelper.getDataSet(0,
				taskListHelper.getDataCount());
		String[][] data = set.getData();
		model.addAttribute("data", data);

		String[] headers = taskListHelper.getColumnHeaders();
		model.addAttribute("headers", headers);
		int idIndex = -1;
		for (int i = 0; i < headers.length; i++) {
			String string = headers[i];
			if (string.equalsIgnoreCase("id")) {
				model.addAttribute("idIndex", i);
				idIndex = i;
			}
		}
		Map<String, String> taskNames = new HashMap();
		int nameIndex = -1;
		for (int i = 0; i < headers.length; i++) {
			String string = headers[i];
			if (string.equalsIgnoreCase("name")) {
				nameIndex = i;
			}
		}
		for (int i = 0; i < data.length; i++) {
			String[] allData = data[i];
			taskNames.put(allData[idIndex], allData[nameIndex].replaceAll(" ", ""));
		}
		model.addAttribute("taskNames", taskNames);
		model.addAttribute("user", entity);
		model.addAttribute("profile", profile);
		return "list";
	}

	@RequestMapping(value = "/task/{entity}/{profile}/{id}/{name}", method = RequestMethod.GET)
	public String taskInfo(@PathVariable("id") String id,
			@PathVariable("entity") String entity,
			@PathVariable("name") String name,
			@PathVariable("profile") String profile, Model model) {
		logger.info("Let's get the Task List!");
		ConnectionData connectionData = new ConnectionData();
		connectionData.setEntityId(entity);
		helper.connect(connectionData);
		taskHelper = helper.getTaskSupportHelper(id, name.trim(), profile);
		Map<String, String> taskInfo = taskHelper.getTaskInput();
		
		Map<String, String> taskOutput = taskHelper.getTaskOutput();
		TaskOperationsDefinition operationsDef = taskHelper.getTaskOperations();
		model.addAttribute("operations", operationsDef);
		model.addAttribute("taskInput", taskInfo);
		model.addAttribute("taskOutput", taskOutput);
		model.addAttribute("user", entity);
		model.addAttribute("profile", profile);
		model.addAttribute("name", name);
		model.addAttribute("id", taskInfo.get("Id"));
		return "task";
	}

	@RequestMapping(value = "/task/execute/{entity}/{profile}/{id}/{name}/{action}/{document}", method = RequestMethod.GET)
	public String executeTask(@PathVariable("id") String taskId,
			@PathVariable("action") String action,
			@PathVariable("entity") String entity,
			@PathVariable("name") String name,
			@PathVariable("document") String document,
			@PathVariable("profile") String profile, Model model) {
		if (taskHelper != null) {
			taskHelper.executeTaskAction(action, document);
		}
		return this.taskInfo(taskId, entity, name, profile, model);
	}
	
	@RequestMapping(value = "/task/execute/{entity}/{profile}/{id}/{name}/{action}", method = RequestMethod.GET)
	public String executeTask(@PathVariable("id") String taskId,
			@PathVariable("action") String action,
			@PathVariable("entity") String entity,
			@PathVariable("name") String name,
			@PathVariable("profile") String profile, Model model) {
		return this.executeTask(taskId, action, entity, name, null,  profile, model);
	}

}
