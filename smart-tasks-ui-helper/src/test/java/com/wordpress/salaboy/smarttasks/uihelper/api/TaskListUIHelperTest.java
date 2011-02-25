/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.uihelper.api;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.UIHelperConfigurationProvider;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockConfigurationHandler;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.uihelper.configuration.mock.MockHumanTaskServiceOperations;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.example.ws_ht.api.TStatus;
import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esteban
 */
public class TaskListUIHelperTest {

    public TaskListUIHelperTest() {
    }

    @Test
    public void testProfiles() {

        File root = new File(Thread.currentThread().getContextClassLoader().getResource(("TaskListUIHelperTest/testProfiles")).getFile());
        UIHelperConfigurationProvider uIHelperConfigurationProvider = new UIHelperConfigurationProvider(root);
        uIHelperConfigurationProvider.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(new MockHumanTaskClientConfiguration() {

            @Override
            public HumanTaskServiceOperations getServiceOperationsImplementation() {
                return new MockHumanTaskServiceOperations() {

                    @Override
                    public void initializeService() {
                    }

                    @Override
                    public void cleanUpService() {
                    }
                };
            }
        }));
        UIHelperConfiguration configuration = uIHelperConfigurationProvider.createConfiguration();


        SmartTaskUIHelper helper = new SmartTaskUIHelper(configuration);

        //Connection
        ConnectionData connectionData = new ConnectionData();
        connectionData.setEntityId("Some_User");
        helper.connect(connectionData);

        //taskList1 should take "Default" profile: 2 columns
        TaskListUIHelper taskListHelper = helper.getTaskListHelper("taskList1", null);


        String[] columnHeaders = taskListHelper.getColumnHeaders();
        assertEquals(2, columnHeaders.length);
        assertEquals("Id", columnHeaders[0]);
        assertEquals("Name", columnHeaders[1]);

        //taskList2 should take "Some_User" profile: 1 columns
        taskListHelper = helper.getTaskListHelper("taskList2", null);


        columnHeaders = taskListHelper.getColumnHeaders();
        assertEquals(1, columnHeaders.length);
        assertEquals("Id", columnHeaders[0]);


        //taskList2 should take "Some_User_TaskType1" profile now, because 
        //the task type is provided: 1 columns
        taskListHelper = helper.getTaskListHelper("taskList2", "TaskType1");

        columnHeaders = taskListHelper.getColumnHeaders();
        assertEquals(1, columnHeaders.length);
        assertEquals("Status", columnHeaders[0]);

        helper.disconnect();

        //Connect with different id
        connectionData = new ConnectionData();
        connectionData.setEntityId("Esteban");
        helper.connect(connectionData);

        //taskList2 should take "TaskType1" profile now: 2 columns
        taskListHelper = helper.getTaskListHelper("taskList2", "TaskType1");

        columnHeaders = taskListHelper.getColumnHeaders();
        assertEquals(2, columnHeaders.length);
        assertEquals("Status", columnHeaders[0]);
        assertEquals("Priority", columnHeaders[1]);

        helper.disconnect();
    }

    @Test
    public void testBasicData() {

        File root = new File(Thread.currentThread().getContextClassLoader().getResource(("TaskListUIHelperTest/testProfiles")).getFile());
        UIHelperConfigurationProvider uIHelperConfigurationProvider = new UIHelperConfigurationProvider(root);
        uIHelperConfigurationProvider.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(new MyHardcodedHumanTaskClientConfigurationMock()));
        UIHelperConfiguration configuration = uIHelperConfigurationProvider.createConfiguration();


        SmartTaskUIHelper helper = new SmartTaskUIHelper(configuration);

        //Connection
        ConnectionData connectionData = new ConnectionData();
        connectionData.setEntityId("Some_User");
        helper.connect(connectionData);

        //taskList1 should take "Default" profile: 2 columns
        TaskListUIHelper taskListHelper = helper.getTaskListHelper("taskList1", null);


        String[] columnHeaders = taskListHelper.getColumnHeaders();
        assertEquals(2, columnHeaders.length);
        assertEquals("Id", columnHeaders[0]);
        assertEquals("Name", columnHeaders[1]);

        int dataCount = taskListHelper.getDataCount();
        assertEquals(4, dataCount);

        //give me the first 2 tasks
        TaskListDataSet dataSet = taskListHelper.getDataSet(0, 2);
        String[][] data = dataSet.getData();
        assertEquals(2, data.length);
        assertEquals(2, data[0].length);
        assertEquals(2, data[1].length);
        //assertEquals("0", data[0][0]);
        assertEquals("Task 0", data[0][1]);
        //assertEquals("1", data[1][0]);
        assertEquals("Task 1", data[1][1]);

        //give me 2 mores tasks
        dataSet = taskListHelper.getDataSet(2, 2);
        data = dataSet.getData();
        assertEquals(2, data.length);
        assertEquals(2, data[0].length);
        assertEquals(2, data[1].length);
        //assertEquals("2", data[0][0]);
        assertEquals("Task 2", data[0][1]);
        //assertEquals("3", data[1][0]);
        assertEquals("Task 3", data[1][1]);

        helper.disconnect();
    }

    @Test
    public void testMetaData() {

        File root = new File(Thread.currentThread().getContextClassLoader().getResource(("TaskListUIHelperTest/testProfiles")).getFile());
        UIHelperConfigurationProvider uIHelperConfigurationProvider = new UIHelperConfigurationProvider(root);
        uIHelperConfigurationProvider.addUIHelperConfigurationUriHandler(new MockConfigurationHandler(new MyHardcodedHumanTaskClientConfigurationMock()));
        UIHelperConfiguration configuration = uIHelperConfigurationProvider.createConfiguration();


        SmartTaskUIHelper helper = new SmartTaskUIHelper(configuration);

        //Connection
        ConnectionData connectionData = new ConnectionData();
        connectionData.setEntityId("Some_User");
        helper.connect(connectionData);

        //taskList1 should take "Default" profile: 2 columns, NO metadata
        TaskListUIHelper taskListHelper = helper.getTaskListHelper("taskList1", null);

        assertNull(taskListHelper.getRowMetadataKeys());

        helper.disconnect();


        //New connection
        connectionData = new ConnectionData();
        connectionData.setEntityId("Esteban");
        helper.connect(connectionData);

        //taskList1 should take "Esteban" profile: 2 columns with metadata
        taskListHelper = helper.getTaskListHelper("taskList1", null);

        String[] rowMetadataKeys = taskListHelper.getRowMetadataKeys();
        
        assertNotNull(taskListHelper.getRowMetadataKeys());
        assertEquals(2, rowMetadataKeys.length);
        assertEquals("metaData1", rowMetadataKeys[0]);
        assertEquals("metaData2", rowMetadataKeys[1]);

        TaskListDataSet dataSet = taskListHelper.getDataSet(0, 4);

        String[][] rowsMetaData = dataSet.getRowsMetaData();
        assertEquals(4, rowsMetaData.length);

        for (int i = 0; i < rowsMetaData.length; i++) {
            String[] value = rowsMetaData[i];
            assertEquals("metaDataValue1", value[0]);
            assertEquals("metaDataValue2", value[1]);
        }

        helper.disconnect();
    }
}

class MyHardcodedHumanTaskClientConfigurationMock extends MockHumanTaskClientConfiguration {

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
            public List<TTaskAbstract> getMyTaskAbstracts(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
                List<TTaskAbstract> tasks = new ArrayList<TTaskAbstract>();

                //4 mock tasks
                for (int i = 0; i < 4; i++) {
                    TTaskAbstract taskAbstract = new TTaskAbstract();
                    taskAbstract.setId("" + i);
                    taskAbstract.setName(new QName("Task " + i));
                    tasks.add(taskAbstract);
                }

                if (fromTaskNumber == null) {
                    return tasks;
                } else {
                    return tasks.subList(fromTaskNumber, fromTaskNumber + maxTasks);
                }
            }
        };
    }
}