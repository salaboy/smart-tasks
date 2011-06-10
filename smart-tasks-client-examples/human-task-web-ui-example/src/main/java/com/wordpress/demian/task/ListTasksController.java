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
import org.yaml.snakeyaml.Yaml;

import com.wordpress.salaboy.smarttasks.formbuilder.api.ConnectionData;
import com.wordpress.salaboy.smarttasks.formbuilder.api.SmartTaskBuilder;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskOperationsDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.api.exception.InvalidTaskException;
import com.wordpress.salaboy.smarttasks.formbuilder.api.output.TaskForm;
import com.wordpress.salaboy.smarttasks.formbuilder.api.output.TaskListsData;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfigurationProvider;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.ActivitiConfigurationHandler;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.saxhandler.JBPM5ConfigurationHandler;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorBase;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;

/**
 * Controller to handle the task requests.
 * 
 * @author calcacuervo
 */
@Controller
public class ListTasksController {

    private static final Logger logger = LoggerFactory
            .getLogger(ListTasksController.class);

    SmartTaskBuilder helper;

    public ListTasksController() {
        MetaTaskDecoratorService.getInstance().registerDecorator("base",
                new MetaTaskDecoratorBase());
        File root = new File(Thread.currentThread().getContextClassLoader()
                .getResource("uihelper").getFile());
        Map<String, Object> contexts = new HashMap<String, Object>();
        contexts.put("mockExternalService", new MockExternalContext());
        BuilderConfigurationProvider configurationProvider = new BuilderConfigurationProvider(
                root, contexts);
        configurationProvider
                .addUIHelperConfigurationUriHandler(new JBPM5ConfigurationHandler());
        configurationProvider
                .addUIHelperConfigurationUriHandler(new ActivitiConfigurationHandler());
        BuilderConfiguration config = configurationProvider
                .createConfiguration();
        helper = new SmartTaskBuilder(config);

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
        ConnectionData connectionData = new ConnectionData(entity);
        helper.connect(connectionData);
        String set = helper.getTaskList(profile);
//        TaskListDataSet set = taskListHelper.getDataSet(0,
//                taskListHelper.getDataCount());
        Yaml yaml = new Yaml();
        TaskListsData taskListdata = (TaskListsData) yaml.load(set);
        Object[][] data = taskListdata.getData();
        model.addAttribute("data", data);
        String[] headers = taskListdata.getColumnHeaders();
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
            Object[] allData = data[i];
            if (allData[idIndex] instanceof String) {
                taskNames.put((String)allData[idIndex],
                        ((String)allData[nameIndex]).replaceAll(" ", ""));
            }
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
        ConnectionData connectionData = new ConnectionData(entity);
        helper.connect(connectionData);
//        taskHelper = helper.getTaskSupportHelper(id, name.trim(), profile);
        try {
            String stringTaskInfo = helper.getTaskForm(id, name.trim(), profile);
            Yaml yaml = new Yaml();
            TaskForm deserializedInfo = (TaskForm) yaml
                    .load(stringTaskInfo);
            Map<String, Object> taskInfo = deserializedInfo.getInputs();
            
            Map<String, Object> taskOutput = deserializedInfo.getOutputs();
            TaskOperationsDefinition operationsDef = helper
                    .getTaskOperations(id);
            model.addAttribute("operations", operationsDef);
            model.addAttribute("taskInput", taskInfo);
            model.addAttribute("taskOutput", taskOutput);
            model.addAttribute("user", entity);
            model.addAttribute("profile", profile);
            model.addAttribute("name", name);
            model.addAttribute("id", taskInfo.get("Id"));
            return "task";
        } catch (InvalidTaskException e) {
            logger.warn("Did not find any task for this id.", e);
            return "redirect:/new/";
        }
    }

    @RequestMapping(value = "/task/execute/{entity}/{profile}/{id}/{name}/{action}/{document}", method = RequestMethod.GET)
    public String executeTask(@PathVariable("id") String taskId,
            @PathVariable("action") String action,
            @PathVariable("entity") String entity,
            @PathVariable("name") String name,
            @PathVariable("document") String document,
            @PathVariable("profile") String profile, Model model) {
        if (helper != null) {
        	helper.connect(new ConnectionData(entity));
            try {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("document", document);
                helper.executeTaskAction(action, map, taskId);
            } catch (InvalidTaskException e) {
                logger.error("Could not execute this action, because the task does not exist!");
                return "redirect:new";
            }
        }
        return this.taskInfo(taskId, entity, name, profile, model);
    }

    @RequestMapping(value = "/task/execute/{entity}/{profile}/{id}/{name}/{action}", method = RequestMethod.GET)
    public String executeTask(@PathVariable("id") String taskId,
            @PathVariable("action") String action,
            @PathVariable("entity") String entity,
            @PathVariable("name") String name,
            @PathVariable("profile") String profile, Model model) {
        return this.executeTask(taskId, action, entity, name, null, profile,
                model);
    }

}
