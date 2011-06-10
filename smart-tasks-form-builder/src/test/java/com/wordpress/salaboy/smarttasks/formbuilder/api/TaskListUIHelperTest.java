/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.formbuilder.api;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.example.ws_ht.api.TStatus;
import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.smarttasks.formbuilder.api.output.TaskListsData;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.BuilderConfigurationProvider;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.mock.MockConfigurationHandler;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.mock.MockHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.formbuilder.configuration.mock.MockHumanTaskServiceOperations;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorBase;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecoratorService;

/**
 * 
 * @author esteban
 */
public class TaskListUIHelperTest {

	public TaskListUIHelperTest() {
	}

	Yaml yaml = new Yaml();

	@Test
	public void testProfiles() {
		MetaTaskDecoratorService.getInstance().registerDecorator("base",
				new MetaTaskDecoratorBase());
		File root = new File(Thread.currentThread().getContextClassLoader()
				.getResource(("TaskListUIHelperTest/testProfiles")).getFile());
		BuilderConfigurationProvider uIHelperConfigurationProvider = new BuilderConfigurationProvider(
				root);
		uIHelperConfigurationProvider
				.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(
						new MyHardcodedHumanTaskClientConfigurationMock()));
		BuilderConfiguration configuration = uIHelperConfigurationProvider
				.createConfiguration();

		SmartTaskBuilder helper = new SmartTaskBuilder(configuration);

		// Connection
		ConnectionData connectionData = new ConnectionData("Some_User");
		helper.connect(connectionData);

		// taskList1 should take "Default" profile: 2 columns
		String taskList = helper.getTaskList("default");

		TaskListsData input = (TaskListsData) yaml.load(taskList);
		String[] columnHeaders = input.getColumnHeaders();
		assertEquals(1, columnHeaders.length);
		assertEquals("Id", columnHeaders[0]);

		
		// taskList2 should take "Some_User_TaskType1" profile now, because
		// the task type is provided: 1 columns
		taskList = helper.getTaskList("TaskType1");
		input = (TaskListsData) yaml.load(taskList);
		columnHeaders = input.getColumnHeaders();
		assertEquals(1, columnHeaders.length);
		assertEquals("Status", columnHeaders[0]);

		helper.disconnect();

		// Connect with different id
	
		helper.disconnect();
	}

	@Test
	public void testBasicData() {
		MetaTaskDecoratorService.getInstance().registerDecorator("base",
				new MetaTaskDecoratorBase());

		File root = new File(Thread.currentThread().getContextClassLoader()
				.getResource(("TaskListUIHelperTest/testProfiles")).getFile());
		BuilderConfigurationProvider uIHelperConfigurationProvider = new BuilderConfigurationProvider(
				root);
		uIHelperConfigurationProvider
				.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(
						new MyHardcodedHumanTaskClientConfigurationMock()));
		BuilderConfiguration configuration = uIHelperConfigurationProvider
				.createConfiguration();

		SmartTaskBuilder helper = new SmartTaskBuilder(configuration);

		// Connection
		ConnectionData connectionData = new ConnectionData("Some_User");
		helper.connect(connectionData);

		// taskList1 should take "Default" profile: 2 columns
		String taskList = helper.getTaskList(null);

		TaskListsData input = (TaskListsData) yaml
		.load(taskList);
		String[] columnHeaders = input.getColumnHeaders();

		assertEquals(1, columnHeaders.length);
		assertEquals("Id", columnHeaders[0]);
		
		Object[][] data = input.getData();
		assertEquals(4, data.length);
		assertEquals(1, data[0].length);
		assertEquals(1, data[1].length);
		

		helper.disconnect();
	}

//	@Test
//	public void testMetaData() {
//		MetaTaskDecoratorService.getInstance().registerDecorator("base",
//				new MetaTaskDecoratorBase());
//		File root = new File(Thread.currentThread().getContextClassLoader()
//				.getResource(("TaskListUIHelperTest/testProfiles")).getFile());
//		BuilderConfigurationProvider uIHelperConfigurationProvider = new BuilderConfigurationProvider(
//				root);
//		uIHelperConfigurationProvider
//				.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(
//						new MyHardcodedHumanTaskClientConfigurationMock()));
//		BuilderConfiguration configuration = uIHelperConfigurationProvider
//				.createConfiguration();
//
//		SmartTaskBuilder helper = new SmartTaskBuilder(configuration);
//
//		// Connection
//		ConnectionData connectionData = new ConnectionData();
//		connectionData.setEntityId("Some_User");
//		helper.connect(connectionData);
//
//		// taskList1 should take "Default" profile: 2 columns, NO metadata
//		TaskListBuilder taskListHelper = helper.getTaskListHelper("taskList1",
//				null);
//
//		assertNull(taskListHelper.getRowMetadataKeys());
//
//		helper.disconnect();
//
//		// New connection
//		connectionData = new ConnectionData();
//		connectionData.setEntityId("Esteban");
//		helper.connect(connectionData);
//
//		// taskList1 should take "Esteban" profile: 2 columns with metadata
//		taskListHelper = helper.getTaskListHelper("taskList1", null);
//
//		String stringRowMetadata = taskListHelper.getRowMetadataKeys();
//		TaskListRowMetadataKeys keys = (TaskListRowMetadataKeys) yaml
//				.load(stringRowMetadata);
//		String[] rowMetadataKeys = keys.getKeys();
//
//		assertNotNull(taskListHelper.getRowMetadataKeys());
//		assertEquals(3, rowMetadataKeys.length);
//		assertEquals("metaData1", rowMetadataKeys[0]);
//		assertEquals("metaData2", rowMetadataKeys[1]);
//		assertEquals("metaData3", rowMetadataKeys[2]);
//
//		TaskListDataSet dataSet = taskListHelper.getDataSet(0, 4);
//
//		stringRowMetadata = dataSet.getRowsMetaData();
//		TaskListMetadata metadata = (TaskListMetadata) yaml
//				.load(stringRowMetadata);
//		Object[][] rowsMetaData = metadata.getData();
//		assertEquals(4, rowsMetaData.length);
//
//		for (int i = 0; i < rowsMetaData.length; i++) {
//			Object[] value = rowsMetaData[i];
//			assertEquals("metaDataValue1", value[0]);
//			assertEquals("metaDataValue2", value[1]);
//			assertEquals("Task " + i, value[2]);
//		}
//
//		helper.disconnect();
//	}
//
//	@Test
//	public void testBasicMetaModel() {
//		MetaTaskDecoratorService.getInstance().registerDecorator("base",
//				new MetaTaskDecoratorBase());
//		File root = new File(Thread.currentThread().getContextClassLoader()
//				.getResource(("TaskListUIHelperTest/testProfiles")).getFile());
//		BuilderConfigurationProvider uIHelperConfigurationProvider = new BuilderConfigurationProvider(
//				root);
//		uIHelperConfigurationProvider
//				.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(
//						new MyHardcodedHumanTaskClientConfigurationMock()));
//		BuilderConfiguration configuration = uIHelperConfigurationProvider
//				.createConfiguration();
//
//		SmartTaskBuilder helper = new SmartTaskBuilder(configuration);
//
//		// Connection
//		ConnectionData connectionData = new ConnectionData();
//		connectionData.setEntityId("SalaboyMeta");
//		helper.connect(connectionData);
//
//		// taskList1 should take "Default" profile: 2 columns
//		TaskListBuilder taskListHelper = helper.getTaskListHelper("taskList3",
//				null);
//
//		String stringColumnHeaders = taskListHelper.getColumnHeaders();
//		TaskListColumHeaders input = (TaskListColumHeaders) yaml
//				.load(stringColumnHeaders);
//		String[] columnHeaders = input.getColumnHeaders();
//
//		assertEquals(1, columnHeaders.length);
//		assertEquals("StringRep", columnHeaders[0]);
//
//		int dataCount = taskListHelper.getDataCount();
//		assertEquals(4, dataCount);
//
//		// give me the first 2 tasks
//		TaskListDataSet dataSet = taskListHelper.getDataSet(0, 2);
//		String stringData = dataSet.getData();
//		TaskListsData listData = (TaskListsData) yaml.load(stringData);
//		Object[][] data = listData.getData();
//		Assert.assertEquals(2, data.length);
//
//		helper.disconnect();
//	}
//
}

class MyHardcodedHumanTaskClientConfigurationMock extends
		MockHumanTaskClientConfiguration {

	@Override
	public HumanTaskServiceOperations getServiceOperationsImplementation() {
		return new MockHumanTaskServiceOperations() {

			@Override
			public void initializeService() {
			}

			@Override
			public void cleanUpService() {
			}

			@Override
			public List<TTaskAbstract> getMyTaskAbstracts(String taskType,
					String genericHumanRole, String workQueue,
					List<TStatus> status, String whereClause,
					String orderByClause, String createdOnClause,
					Integer maxTasks, Integer fromTaskNumber)
					throws IllegalArgumentFault, IllegalStateFault {
				List<TTaskAbstract> tasks = new ArrayList<TTaskAbstract>();

				// 4 mock tasks
				for (int i = 0; i < 4; i++) {
					TTaskAbstract taskAbstract = new TTaskAbstract();
					taskAbstract.setId("" + i);
					taskAbstract.setStatus(TStatus.IN_PROGRESS);
					taskAbstract.setName(new QName("Task " + i));
					tasks.add(taskAbstract);
				}

				if (fromTaskNumber == null) {
					return tasks;
				} else {
					return tasks.subList(fromTaskNumber, fromTaskNumber
							+ maxTasks);
				}
			}
		};
	}
}
