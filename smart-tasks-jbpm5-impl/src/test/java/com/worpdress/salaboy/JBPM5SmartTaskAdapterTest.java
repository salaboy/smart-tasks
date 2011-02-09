/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worpdress.salaboy;

import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;
import com.wordpress.salaboy.api.HumanTaskService;
import org.example.ws_ht.api.TTaskAbstract;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.jbpm.process.workitem.wsht.BlockingAddTaskResponseHandler;
import org.jbpm.task.Group;
import org.jbpm.task.I18NText;
import org.jbpm.task.OrganizationalEntity;
import org.jbpm.task.PeopleAssignments;
import org.jbpm.task.Task;
import org.jbpm.task.TaskData;
import org.jbpm.task.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salaboy
 */
public class JBPM5SmartTaskAdapterTest extends BaseTest{

    @Test
    public void jBPM5ClientWrapperTest() throws Exception {
        HumanTaskService humanTaskService = null;
        try{
            humanTaskService = this.createHumanTaskService();
            humanTaskService.initializeService();
            humanTaskService.setLocale("en-UK");
            
            List<TTaskAbstract> tasks = humanTaskService.getMyTaskAbstracts(null, "Darth Vader", null, null, null, null, null, null, null);
            assertEquals(1, tasks.size());
        
        }finally{
            if (humanTaskService != null){
                humanTaskService.cleanUpService();
            }
        }
    }

    @Test
    public void jBPM5ClientTaskClaimTest() throws Exception {
        HumanTaskService humanTaskService = null;
        try{
            humanTaskService = this.createHumanTaskService();
            humanTaskService.initializeService();
        
            humanTaskService.setAuthorizedEntityId("Darth Vader");
            humanTaskService.setLocale("en-UK");
            
            List<TTaskAbstract> tasks = humanTaskService.getMyTaskAbstracts(null, "Darth Vader", null, null, null, null, null, null, null);
            assertEquals(1, tasks.size());

            TTaskAbstract taskAbstract = tasks.get(0);

            humanTaskService.start(taskAbstract.getId());
            humanTaskService.complete(taskAbstract.getId(), null);

            tasks = humanTaskService.getMyTaskAbstracts(null, "Darth Vader", null, null, null, null, null, null, null);

            assertEquals(0, tasks.size());
        }finally{
            if (humanTaskService != null){
                humanTaskService.cleanUpService();
            }
        }
    }

    private void addSampleTasks() throws Exception {

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
                add(new User("Darth Vader"));
            }
        });
        people.setBusinessAdministrators(new ArrayList<OrganizationalEntity>() {

            {
                add(new Group("crusaders"));
            }
        });
        task1.setPeopleAssignments(people);
        BlockingAddTaskResponseHandler handler = new BlockingAddTaskResponseHandler();

        client.addTask(task1, null, handler);
        System.out.println("Task Created with ID = " + handler.getTaskId());

        BlockingTaskSummaryResponseHandler taskSummaryHandler = new BlockingTaskSummaryResponseHandler();
        client.getTasksAssignedAsPotentialOwner("Darth Vader", "en-UK", taskSummaryHandler);

        assertEquals(1, taskSummaryHandler.getResults().size());


        client.disconnect();

    }
    
    private HumanTaskService createHumanTaskService(){
        HumanTaskServiceConfiguration humanTaskServiceConfiguration = new HumanTaskServiceConfiguration();
        humanTaskServiceConfiguration.addHumanTaskClientConfiguration("JBPM5", new JBPM5HumanTaskClientConfiguration("127.0.0.1", 9123));
        return HumanTaskServiceFactory.newHumanTaskService(humanTaskServiceConfiguration);
    }
}