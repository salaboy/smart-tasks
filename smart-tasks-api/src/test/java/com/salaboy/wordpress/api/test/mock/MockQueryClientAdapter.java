/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.salaboy.wordpress.api.test.mock;

import com.wordpress.salaboy.api.TaskDefinition;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import org.example.ws_ht.TOrganizationalEntity;
import org.example.ws_ht.api.TAttachment;
import org.example.ws_ht.api.TAttachmentInfo;
import org.example.ws_ht.api.TComment;
import org.example.ws_ht.api.TStatus;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.TTaskQueryResultSet;
import org.example.ws_ht.api.wsdl.IllegalAccessFault;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalOperationFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
import org.example.ws_ht.api.wsdl.RecipientNotAllowed;
import org.example.ws_ht.api.wsdl.TaskOperations;
import org.example.ws_ht.api.xsd.TTime;

/**
 *
 * @author salaboy
 */
public class MockQueryClientAdapter {
    
    public static TTaskAbstract mockTaskAbstract1 = new TTaskAbstract();
    public static TTaskAbstract mockTaskAbstract2 = new TTaskAbstract();
    //(1,"First Task", "salaboy", "The first Mock Task", new Date(), new Date(), null, 10)
    //new TTaskAbstract(2,"Second Task", "salaboy", "The second Mock Task", new Date(), new Date(), null, 15)
    public static List<TTaskAbstract> mockTasks = new ArrayList<TTaskAbstract>(){{
                    add(mockTaskAbstract1);
                    add(mockTaskAbstract2);
                }};
    
    public static TaskOperations newQueryClient(){
        return new TaskOperations() {
            {
                initializeMockTaskAbstracts();
            }
            // static block
            {
                initializeRenderer();
            }
//            public List<TaskDefinition> getMyTaskAbstracts(String potentialOwner) {
//                
//                return MockQueryClientAdapter.mockTasks;
//            }
//
//            public TaskDefinition getMyTask(long taskId) {
//                for(TaskDefinition task: mockTasks){
//                    if(task.getId() == taskId ){
//                        return task;
//                    }
//                    
//                }
//                return null;
//            }
            private void initializeRenderer(){
                for(TTaskAbstract task : MockQueryClientAdapter.mockTasks){
                    //task.setRendererProvider(new MockRendererProvider(task));
                }
            }

            public void nominate(String identifier, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void getFault(String identifier, Holder<String> faultName, Holder<Object> faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void forward(String identifier, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void deleteOutput(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<QName> getRenderingTypes(Object identifier) throws IllegalArgumentFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<TComment> getComments(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void addAttachment(String identifier, String name, String accessType, Object attachment) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void activate(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setOutput(String identifier, String part, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void start(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public TTaskQueryResultSet query(String selectClause, String whereClause, String orderByClause, Integer maxTasks, Integer taskIndexOffset) throws IllegalArgumentFault, IllegalStateFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void deleteAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<TTaskAbstract> getMyTaskAbstracts(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
                return MockQueryClientAdapter.mockTasks;
            }

            public void skip(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<TAttachment> getAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public String getTaskDescription(String identifier, String contentType) throws IllegalArgumentFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void release(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void remove(String identifier) throws IllegalArgumentFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void suspend(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<TTask> getMyTasks(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setGenericHumanRole(String identifier, String genericHumanRole, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Object getInput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Object getRendering(String identifier, QName renderingType) throws IllegalArgumentFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setFault(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void delegate(String identifier, TOrganizationalEntity organizationalEntity) throws RecipientNotAllowed, IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void stop(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Object getOutput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public List<TAttachmentInfo> getAttachmentInfos(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void suspendUntil(String identifier, TTime time) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void addComment(String identifier, String text) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void complete(String identifier, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setPriority(String identifier, BigInteger priority) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void resume(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void claim(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void fail(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void deleteFault(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            private void initializeMockTaskAbstracts() {
                mockTaskAbstract1.setId("1");
                mockTaskAbstract1.setName(new QName("First Task"));
                mockTaskAbstract1.setPriority(BigInteger.ONE);
                
                 mockTaskAbstract2.setId("2");
                mockTaskAbstract2.setName(new QName("Second Task"));
                mockTaskAbstract2.setPriority(BigInteger.TEN);
                
            }
        };
                
    }
}
