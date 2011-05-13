package com.wordpress.salaboy.smarttasks.uihelper.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.example.ws_ht.api.TStatus;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
import org.junit.Test;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorBase;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfigurationProvider;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockConfigurationHandler;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskServiceOperations;

public class TaskSupportUIHelperTest {

	@Test
	public void getTaskDetails() {
		MetaTaskDecoratorService.getInstance().registerDecorator("base",
				new MetaTaskDecoratorBase());
		File root = new File(Thread.currentThread().getContextClassLoader()
				.getResource(("TaskSupportUIHelperTest")).getFile());
		UIHelperConfigurationProvider uIHelperConfigurationProvider = new UIHelperConfigurationProvider(
				root);
		uIHelperConfigurationProvider
				.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(
						new MockHumanTaskClientConfiguration() {

							@Override
							public HumanTaskServiceOperations getServiceOperationsImplementation() {
								return new MockHumanTaskServiceOperations() {
									@Override
									public String getTaskOriginatorType(
											String taskId) {
										return "mock";
									}

									@Override
									public TTask getTaskInfo(String identifier)
											throws IllegalArgumentFault {
										TTask task = new TTask();
										task.setId("1");
										task.setStatus(TStatus.IN_PROGRESS);
										return task;
									}

									@Override
									public List<TTaskAbstract> getMyTaskAbstracts(
											String taskType,
											String genericHumanRole,
											String workQueue,
											List<TStatus> status,
											String whereClause,
											String orderByClause,
											String createdOnClause,
											Integer maxTasks,
											Integer fromTaskNumber)
											throws IllegalArgumentFault,
											IllegalStateFault {
										TTaskAbstract taskAbtrAbstract = new TTaskAbstract();
										taskAbtrAbstract.setId("1");
										List<TTaskAbstract> taskList = new ArrayList<TTaskAbstract>();
										taskList.add(taskAbtrAbstract);
										return taskList;
									}
								};
							}
						}));
		UIHelperConfiguration configuration = uIHelperConfigurationProvider
				.createConfiguration();

		SmartTaskUIHelper helper = new SmartTaskUIHelper(configuration);

		// Connection
		ConnectionData connectionData = new ConnectionData();
		connectionData.setEntityId("Some_User");
		helper.connect(connectionData);
		TaskListUIHelper listHelper = helper.getTaskListHelper("taskList1",
				"default");
		TaskListDataSet data = listHelper.getDataSet(0, 1);
		TaskSupportUIHelper taskHelper = helper.getTaskSupportHelper(
				data.getData()[0][0], "some", "salaboy");
		Map<String, String> details = taskHelper.getTaskInput();
		Assert.assertEquals("IN_PROGRESS", details.get("Status"));
	}
}
