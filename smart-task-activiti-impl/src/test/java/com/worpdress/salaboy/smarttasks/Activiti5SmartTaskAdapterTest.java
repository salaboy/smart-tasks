/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smarttasks;

import org.activiti.engine.task.Task;
import com.wordpress.salaboy.api.HumanTaskClientRegistry;
import com.worpdress.salaboy.api.TaskDefinition;
import com.worpdress.salaboy.smarttasks.activiti5wrapper.Activiti5QueryClientWrapper;
import java.util.List;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
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
    private TaskService taskService;
    

    public Activiti5SmartTaskAdapterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        assertNotNull(processEngine);
        taskService = processEngine.getTaskService();
        assertNotNull(taskService);
        initSampleTask();
        HumanTaskClientRegistry.getInstance().addQueryClient("Activiti5Query", new Activiti5QueryClientWrapper(taskService));
        
    }

    @After
    public void tearDown() {
    }

   
     @Test
     public void hello() {
      
        
        List<TaskDefinition> tasks = HumanTaskClientRegistry.getInstance().getQueryClient("Activiti5Query").getMyTaskAbstracts("salaboy");
        assertEquals(1, tasks.size());
     }

    private void initSampleTask() {
        Task task = taskService.newTask();
        task.setName("First Task");
        task.setDescription("This is the first Task");
        task.setPriority(10);
        taskService.saveTask(task);
        taskService.setAssignee(task.getId(), "salaboy");
    }

}