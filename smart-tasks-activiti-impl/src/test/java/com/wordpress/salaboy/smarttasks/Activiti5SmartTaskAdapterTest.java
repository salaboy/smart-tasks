/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks;

import com.wordpress.salaboy.smarttasks.activiti5wrapper.conf.ActivitiHumanTaskClientConfiguration;
import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import org.example.ws_ht.api.TTaskAbstract;
import org.activiti.engine.task.Task;
import java.util.List;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
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
public class Activiti5SmartTaskAdapterTest {
    private HumanTaskService humanTaskService;

    public Activiti5SmartTaskAdapterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp()  {
        humanTaskService =  createHumanTaskService();
        
   
    }

    @After
    public void tearDown() {
        
         this.humanTaskService.cleanUpService();
    }

   
     @Test
     public void hello() throws IllegalArgumentFault, IllegalStateFault {
        
            initSampleTask();
            
        
            
            List<TTaskAbstract> tasks = this.humanTaskService.getMyTaskAbstracts(null, "salaboy", null, null, null, null, null, null, null);
            assertEquals(1, tasks.size());
        
       
        
      
     }

    private void initSampleTask() {
        
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService(); 
        Task task = taskService.newTask();
        task.setName("First Task");
        task.setDescription("This is the first Task");
        task.setPriority(10);
        taskService.saveTask(task);
        taskService.setAssignee(task.getId(), "salaboy");
        
    }
    
      private HumanTaskService createHumanTaskService(){
        HumanTaskServiceConfiguration humanTaskServiceConfiguration = new HumanTaskServiceConfiguration();
        humanTaskServiceConfiguration.addHumanTaskClientConfiguration("Activiti", new ActivitiHumanTaskClientConfiguration("activity.cfg.xml"));
        return HumanTaskServiceFactory.newHumanTaskService(humanTaskServiceConfiguration);
    }

}