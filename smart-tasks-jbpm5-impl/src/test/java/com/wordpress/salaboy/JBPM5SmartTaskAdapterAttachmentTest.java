/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.example.ws_ht.api.TAttachment;
import org.example.ws_ht.api.TAttachmentInfo;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;
import org.jbpm.process.workitem.wsht.BlockingAddTaskResponseHandler;
import org.jbpm.task.AccessType;
import org.jbpm.task.Content;
import org.jbpm.task.I18NText;
import org.jbpm.task.OrganizationalEntity;
import org.jbpm.task.PeopleAssignments;
import org.jbpm.task.Task;
import org.jbpm.task.TaskData;
import org.jbpm.task.User;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;
import org.junit.Test;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5MinaHumanTaskClientConfiguration;

/**
 *
 * @author salaboy
 */
public class JBPM5SmartTaskAdapterAttachmentTest extends BaseTest {

    private static final int DEFAULT_WAIT_TIME = 5000;

    @Test
    public void testNewTaskWithContent() throws Exception {
        HumanTaskService humanTaskService = null;
        try{
            this.addSampleTasks();
            humanTaskService = this.createHumanTaskService();
            humanTaskService.initializeService();
        
            humanTaskService.setAuthorizedEntityId("Darth Vader");
            humanTaskService.setLocale("en-UK");
            
            
            List<TTaskAbstract> myTasks = humanTaskService.getMyTaskAbstracts(null, "Darth Vader", null, null, null, null, null, null, null);
            assertEquals(1, myTasks.size());
            
            TTaskAbstract tTaskAbstract = myTasks.get(0);
            
            TTask taskInfo = humanTaskService.getTaskInfo(tTaskAbstract.getId());

            assertNotNull(taskInfo);

            List<TAttachmentInfo> attachmentInfos = humanTaskService.getAttachmentInfos(tTaskAbstract.getId());

            assertEquals(1,attachmentInfos.size());

            TAttachmentInfo attachmentInfo = attachmentInfos.get(0);

            List<TAttachment> attachments = humanTaskService.getAttachments(tTaskAbstract.getId(), attachmentInfo.getName());

            assertEquals(1, attachments.size());

            TAttachment attachment = attachments.get(0);
            assertTrue(attachment.getValue() instanceof Content);

            Content content = (Content) attachment.getValue();

            assertEquals("content", new String(content.getContent()));
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
                add(new User("Administrator"));
            }
        });
        task1.setPeopleAssignments(people);
        
        
        ContentData data = new ContentData();
        data.setAccessType(AccessType.Inline);
        data.setType("type");
        data.setContent("content".getBytes());
        
        BlockingAddTaskResponseHandler handler = new BlockingAddTaskResponseHandler();

        client.addTask(task1, data, handler);
        System.out.println("Task Created with ID = " + handler.getTaskId());

        BlockingTaskSummaryResponseHandler taskSummaryHandler = new BlockingTaskSummaryResponseHandler();
        client.getTasksAssignedAsPotentialOwner("Darth Vader", "en-UK", taskSummaryHandler);

        assertEquals(1, taskSummaryHandler.getResults().size());


        client.disconnect();

    }
    
    private HumanTaskService createHumanTaskService(){
        HumanTaskServiceConfiguration humanTaskServiceConfiguration = new HumanTaskServiceConfiguration();
        humanTaskServiceConfiguration.addHumanTaskClientConfiguration("JBPM5", new JBPM5MinaHumanTaskClientConfiguration("127.0.0.1", 9123));
        return HumanTaskServiceFactory.newHumanTaskService(humanTaskServiceConfiguration);
    }
}