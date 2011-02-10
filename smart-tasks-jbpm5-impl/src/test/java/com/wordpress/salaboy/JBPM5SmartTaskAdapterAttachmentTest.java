/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.ws_ht.api.TAttachment;
import org.example.ws_ht.api.TAttachmentInfo;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.wsdl.IllegalAccessFault;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
import org.jbpm.task.AccessType;
import org.jbpm.task.service.ContentData;
import org.jbpm.process.workitem.wsht.BlockingAddTaskResponseHandler;
import org.jbpm.task.Content;
import org.jbpm.task.Task;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salaboy
 */
public class JBPM5SmartTaskAdapterAttachmentTest extends BaseTest {

    private static final int DEFAULT_WAIT_TIME = 5000;

    @Test
    public void testNewTaskWithContent() throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        HumanTaskService humanTaskService = null;
        try{
            Map  vars = new HashMap();     
            vars.put( "users", users );
            vars.put( "groups", groups );        
            vars.put( "now", new Date() );

            String str = "(with (new Task()) { priority = 55, taskData = (with( new TaskData()) { } ), ";
            str += "peopleAssignments = (with ( new PeopleAssignments() ) { potentialOwners = [users['bobba' ] ], }),";                        
            str += "names = [ new I18NText( 'en-UK', 'This is my task name')] })";

            ContentData data = new ContentData();
            data.setAccessType(AccessType.Inline);
            data.setType("type");
            data.setContent("content".getBytes());
            BlockingAddTaskResponseHandler addTaskResponseHandler = new BlockingAddTaskResponseHandler();
            Task task = ( Task )  eval( new StringReader( str ), vars );
            client.addTask( task, data, addTaskResponseHandler );
            String taskId = String.valueOf(addTaskResponseHandler.getTaskId());

            HumanTaskServiceConfiguration humanTaskServiceConfiguration = new HumanTaskServiceConfiguration();
            humanTaskServiceConfiguration.addHumanTaskClientConfiguration("JBPM5", new JBPM5HumanTaskClientConfiguration("127.0.0.1", 9123));
            humanTaskService = HumanTaskServiceFactory.newHumanTaskService(humanTaskServiceConfiguration);
            humanTaskService.initializeService();

            TTask taskInfo = humanTaskService.getTaskInfo(taskId);

            assertNotNull(taskInfo);

            List<TAttachmentInfo> attachmentInfos = humanTaskService.getAttachmentInfos(taskId);

            assertEquals(1,attachmentInfos.size());

            TAttachmentInfo attachmentInfo = attachmentInfos.get(0);

            List<TAttachment> attachments = humanTaskService.getAttachments(taskId, attachmentInfo.getName());

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
}