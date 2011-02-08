/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worpdress.salaboy;

import org.example.ws_ht.api.TTaskAbstract;
import org.jbpm.task.service.mina.MinaTaskClientHandler;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import com.wordpress.salaboy.api.HumanTaskClientRegistry;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.JBPM5AuthorizedTaskOperations;
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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salaboy
 */
public class JBPM5SmartTaskAdapterTest {

    private TaskServer jBPM5TaskServer;
    private TaskClient jBPM5TaskClient;
    private EntityManagerFactory emf;
    private TaskService taskService;
    private TaskServiceSession taskSession;
    private PoolingDataSource ds1;

    public JBPM5SmartTaskAdapterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws InterruptedException {
        //Start the taskServer from jBPM5

        startServer();
        
        Thread.sleep(5000); 
        //Create the taskClient
        MinaTaskClientConnector minaTaskClientConnector = 
                new MinaTaskClientConnector("jBPM5TaskClient", 
                    new MinaTaskClientHandler(SystemEventListenerFactory.getSystemEventListener()));
        
        jBPM5TaskClient = new TaskClient(minaTaskClientConnector);
        jBPM5TaskClient.connect("127.0.0.1", 9123);
        // add two sample task
        addSampleTasks();
        

        HumanTaskClientRegistry.getInstance().addQueryClient("jBPM5Query", new JBPM5AuthorizedTaskOperations(jBPM5TaskClient));
    }

    @After
    public void tearDown() throws Exception {
        jBPM5TaskClient.disconnect();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JBPM5SmartTaskAdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        stopServer();

    }

    @Test
    public void jBPM5ClientWrapperTest() throws Exception {
        List<TTaskAbstract> tasks = HumanTaskClientRegistry.getInstance().getQueryClient("jBPM5Query").getMyTaskAbstracts(null, "salaboy", null, null, null, null, null, null, null);
        
//        for(TaskDefinition task : tasks){
//            task.render();
//        }
        
        assertEquals(1, tasks.size());
        
        
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

        User salaboy = new User("salaboy");
        User Administrator = new User("Administrator");
        taskSession.addUser(Administrator);
        taskSession.addUser(salaboy);
      

        jBPM5TaskServer = new MinaTaskServer(taskService);
        Thread thread = new Thread(jBPM5TaskServer);
        thread.start();
    }

    private void stopServer() throws Exception {
        jBPM5TaskServer.stop();
    }

    private void addSampleTasks() {
        Task task1 = new Task();
        task1.setPriority(10);
        final I18NText taskName = new I18NText();
        taskName.setText("First Task");
        taskName.setLanguage("en-UK");
        
        task1.setSubjects(new ArrayList<I18NText>(){{add(taskName);}});
        task1.setNames(new ArrayList<I18NText>(){{add(taskName);}});
        task1.setDescriptions(new ArrayList<I18NText>(){{add(taskName);}});
        TaskData taskData = new TaskData();
        
        task1.setTaskData(taskData);
        PeopleAssignments people = new PeopleAssignments();
        people.setPotentialOwners(new ArrayList<OrganizationalEntity>(){{add(new User("salaboy"));}});
        people.setBusinessAdministrators(new ArrayList<OrganizationalEntity>(){{add(new User("Administrator"));}});
        task1.setPeopleAssignments(people);
        BlockingAddTaskResponseHandler handler = new BlockingAddTaskResponseHandler();
        jBPM5TaskClient.addTask(task1, null, handler);
        System.out.println("Task Created with ID = "+handler.getTaskId());
        
    }

   
}