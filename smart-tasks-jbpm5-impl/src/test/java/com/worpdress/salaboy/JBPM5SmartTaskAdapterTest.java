/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worpdress.salaboy;

import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;
import com.wordpress.salaboy.api.HumanTaskService;
import org.example.ws_ht.api.TTaskAbstract;
import org.jbpm.task.service.mina.MinaTaskClientHandler;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.drools.SystemEventListenerFactory;
import org.jbpm.process.workitem.wsht.BlockingAddTaskResponseHandler;
import org.jbpm.task.I18NText;
import org.jbpm.task.OrganizationalEntity;
import org.jbpm.task.PeopleAssignments;
import org.jbpm.task.Task;
import org.jbpm.task.TaskData;
import org.jbpm.task.User;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.TaskServer;
import org.jbpm.task.service.TaskService;
import org.jbpm.task.service.TaskServiceSession;
import org.jbpm.task.service.mina.MinaTaskClientConnector;
import org.jbpm.task.service.mina.MinaTaskServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salaboy
 */
public class JBPM5SmartTaskAdapterTest {

    private TaskServer jBPM5TaskServer;
    private EntityManagerFactory emf;
    private TaskService taskService;
    private TaskServiceSession taskSession;
    private PoolingDataSource ds1;
    private String taskClientHost = "127.0.0.1";
    private int taskClientPort = 9123;
    private HumanTaskService humanTaskService;
    private User administrator;
    private User salaboy;

    public JBPM5SmartTaskAdapterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        //Start the taskServer from jBPM5

        startServer();

        Thread.sleep(5000);

        // add two sample task
        addSampleTasks();


        HumanTaskServiceConfiguration humanTaskServiceConfiguration = new HumanTaskServiceConfiguration();
        humanTaskServiceConfiguration.addHumanTaskClientConfiguration("JBPM5", new JBPM5HumanTaskClientConfiguration(taskClientHost, taskClientPort));
        this.humanTaskService = HumanTaskServiceFactory.newHumanTaskService(humanTaskServiceConfiguration);
        this.humanTaskService.initializeService();
    }

    @After
    public void tearDown() throws Exception {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JBPM5SmartTaskAdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.humanTaskService.cleanUpService();
        stopServer();

        emf.close();
        ds1.close();
    }

    @Ignore
    public void jBPM5ClientWrapperTest() throws Exception {
        List<TTaskAbstract> tasks = this.humanTaskService.getMyTaskAbstracts(null, "salaboy", null, null, null, null, null, null, null);
        assertEquals(1, tasks.size());
    }

    @Test
    public void jBPM5ClientTaskClaimTest() throws Exception {
        this.humanTaskService.setAuthorizedEntityId(salaboy.getId());
        List<TTaskAbstract> tasks = this.humanTaskService.getMyTaskAbstracts(null, salaboy.getId(), null, null, null, null, null, null, null);
        assertEquals(1, tasks.size());

        TTaskAbstract taskAbstract = tasks.get(0);

        this.humanTaskService.start(taskAbstract.getId());
        this.humanTaskService.complete(taskAbstract.getId(), null);

        tasks = humanTaskService.getMyTaskAbstracts(null, salaboy.getId(), null, null, null, null, null, null, null);

        assertEquals(0, tasks.size());
    }

    private void startServer() {
        if (jBPM5TaskServer != null && jBPM5TaskServer.isRunning()) {
            throw new IllegalStateException("Server is already started");
        }

        ds1 = new PoolingDataSource();
        ds1.setUniqueName("jdbc/testDS1");

        ds1.setClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        ds1.setMaxPoolSize(5);
        ds1.setAllowLocalTransactions(true);
        ds1.getDriverProperties().put("user", "root");
        ds1.getDriverProperties().put("password", "atcroot");
        ds1.getDriverProperties().put("databaseName", "droolsflow");
        ds1.getDriverProperties().put("serverName", "localhost");

        ds1.init();
        // Use persistence.xml configuration
        emf = Persistence.createEntityManagerFactory("org.jbpm.task");

        taskService = new TaskService(emf, SystemEventListenerFactory.getSystemEventListener());
        taskSession = taskService.createSession();
        MockUserInfo userInfo = new MockUserInfo();
        taskService.setUserinfo(userInfo);

        salaboy = new User("salaboy");
        administrator = new User("Administrator");
        taskSession.addUser(administrator);
        taskSession.addUser(salaboy);

        jBPM5TaskServer = new MinaTaskServer(taskService);
        Thread thread = new Thread(jBPM5TaskServer);
        thread.start();
    }

    private void stopServer() throws Exception {
        if (jBPM5TaskServer != null) {
            jBPM5TaskServer.stop();
        }
    }

    private void addSampleTasks() throws Exception {

        MinaTaskClientConnector minaTaskClientConnector =
                new MinaTaskClientConnector("TestClient",
                new MinaTaskClientHandler(SystemEventListenerFactory.getSystemEventListener()));
        TaskClient client = new TaskClient(minaTaskClientConnector);
        client.connect(this.taskClientHost, this.taskClientPort);

        Task task1 = new Task();
        task1.setPriority(10);
        final I18NText taskName = new I18NText();
        taskName.setText("First Task");
        taskName.setLanguage("en-UK");

        task1.setSubjects(new ArrayList<I18NText>() {

            {
                add(taskName);
            }
        });
        task1.setNames(new ArrayList<I18NText>() {

            {
                add(taskName);
            }
        });
        task1.setDescriptions(new ArrayList<I18NText>() {

            {
                add(taskName);
            }
        });
        TaskData taskData = new TaskData();

        task1.setTaskData(taskData);
        PeopleAssignments people = new PeopleAssignments();
        people.setPotentialOwners(new ArrayList<OrganizationalEntity>() {

            {
                add(salaboy);
            }
        });
        people.setBusinessAdministrators(new ArrayList<OrganizationalEntity>() {

            {
                add(administrator);
            }
        });
        task1.setPeopleAssignments(people);
        BlockingAddTaskResponseHandler handler = new BlockingAddTaskResponseHandler();

        client.addTask(task1, null, handler);
        System.out.println("Task Created with ID = " + handler.getTaskId());

        BlockingTaskSummaryResponseHandler taskSummaryHandler = new BlockingTaskSummaryResponseHandler();
        client.getTasksAssignedAsPotentialOwner(salaboy.getId(), "en-UK", taskSummaryHandler);

        assertEquals(1, taskSummaryHandler.getResults().size());


        client.disconnect();

    }
}