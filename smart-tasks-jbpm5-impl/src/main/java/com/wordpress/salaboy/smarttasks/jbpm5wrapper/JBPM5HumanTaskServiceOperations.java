/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import org.example.ws_ht.api.xsd.TTime;
import org.jbpm.task.Task;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.responsehandlers.BlockingGetContentResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingGetTaskResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskOperationResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.api.ServiceLifeCycleManager;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.model.JBPM5TAttachmentInfo;

/**
 *
 * @author salaboy
 */
public class JBPM5HumanTaskServiceOperations implements HumanTaskServiceOperations {

    private TaskClient client;
    private String authorizedEntityId;
    private String locale = "en-UK";
    private final JBPM5HumanTaskClientConfiguration configuration;

    public JBPM5HumanTaskServiceOperations(JBPM5HumanTaskClientConfiguration configuration) {
        //Create the taskClient
        this.client = createTaskClient(configuration);
        this.configuration = configuration;
    }

    protected TaskClient createTaskClient(JBPM5HumanTaskClientConfiguration configuration) {
        return new TaskClient(configuration.createConnector());
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
        Long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.start(taskId, userId, blockingTaskOperationResponseHandler);
        //@FIXME: how much time do I need to wait?
        blockingTaskOperationResponseHandler.waitTillDone(1000);
    }

    public TTaskQueryResultSet query(String selectClause, String whereClause, String orderByClause, Integer maxTasks, Integer taskIndexOffset) throws IllegalArgumentFault, IllegalStateFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TTaskAbstract> getMyTaskAbstracts(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
        BlockingTaskSummaryResponseHandler handler = new BlockingTaskSummaryResponseHandler();
        client.getTasksAssignedAsPotentialOwner(genericHumanRole, this.locale, handler);
        List<TaskSummary> results = handler.getResults();
        return JBPM5TTaskAbstractAdapter.getInstance().adaptCollection(results);
    }

    public void skip(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
        Task task = this.getTask(identifier);
        if (!task.getTaskData().isSkipable()) {
            throw new IllegalOperationFault();
        }

        String userId = this.getActiveUserId();


        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.skip(task.getId(), userId, blockingTaskOperationResponseHandler);
        //@FIXME: how much time do I need to wait?
        blockingTaskOperationResponseHandler.waitTillDone(1000);
    }

    public List<TAttachment> getAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        Task task = this.getTask(identifier);

        List<JBPM5TAttachmentInfo> taskTAttachmentInfo = new JBPM5TAttachmentInfoAdapter().getTaskTAttachmentInfo(task, attachmentName);

        List<TAttachment> tAttachments = new ArrayList<TAttachment>();
        for (JBPM5TAttachmentInfo tAttachmentInfo : taskTAttachmentInfo) {
            TAttachment tAttachment = new TAttachment();
            tAttachment.setAttachmentInfo(tAttachmentInfo);
            //@FIXME: is this the way to get the attachment content?
            BlockingGetContentResponseHandler blockingGetContentResponseHandler = new BlockingGetContentResponseHandler();
            client.getContent(tAttachmentInfo.getId(), blockingGetContentResponseHandler);
            tAttachment.setValue(blockingGetContentResponseHandler.getContent());
            tAttachments.add(tAttachment);
        }


        return tAttachments;
    }

    public String getTaskDescription(String identifier, String contentType) throws IllegalArgumentFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.release(taskId, userId, blockingTaskOperationResponseHandler);
        //@FIXME: how much time do I need to wait?
        blockingTaskOperationResponseHandler.waitTillDone(1000);

    }

    public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
        Task task = this.getTask(identifier);
        return JBPM5TTaskAdapter.getInstance().adapt(task);
    }

    public void remove(String identifier) throws IllegalArgumentFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void suspend(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.suspend(taskId, userId, blockingTaskOperationResponseHandler);
        //@FIXME: how much time do I need to wait?
        blockingTaskOperationResponseHandler.waitTillDone(1000);
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
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.stop(taskId, userId, blockingTaskOperationResponseHandler);
        //@FIXME: how much time do I need to wait?
        blockingTaskOperationResponseHandler.waitTillDone(1000);
    }

    public Object getOutput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TAttachmentInfo> getAttachmentInfos(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        Task task = this.getTask(identifier);

        return new ArrayList<TAttachmentInfo>(new JBPM5TAttachmentInfoAdapter().getTaskTAttachmentInfo(task));
    }

    public void suspendUntil(String identifier, TTime time) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addComment(String identifier, String text) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void complete(String identifier, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.complete(taskId, userId, (ContentData) taskData, blockingTaskOperationResponseHandler);
        //@FIXME: how much time do I need to wait?
        blockingTaskOperationResponseHandler.waitTillDone(1000);
    }

    public void setPriority(String identifier, BigInteger priority) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void resume(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void claim(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.claim(taskId, userId, blockingTaskOperationResponseHandler);
        //@FIXME: how much time do I need to wait?
        blockingTaskOperationResponseHandler.waitTillDone(1000);


    }

    public void fail(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteFault(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String getActiveUserId() {
        //@FIXME: I'm getting the first user of the entity... It would be better
        //if this class provide us with the active user. 
        return this.authorizedEntityId;
    }

    private Task getTask(String identifier) {
        Long taskId = Long.parseLong(identifier);
        BlockingGetTaskResponseHandler blockingGetTaskResponseHandler = new BlockingGetTaskResponseHandler();
        client.getTask(taskId, blockingGetTaskResponseHandler);
        return blockingGetTaskResponseHandler.getTask();
    }

    public void setAuthorizedEntityId(String entityId) {
        this.authorizedEntityId = entityId;
    }

    public String getAuthorizedEntityId() {
        return this.authorizedEntityId;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void initializeService() {
        this.client.connect(this.configuration.getHost(), this.configuration.getPort());
    }

    public void cleanUpService() {
        try {
            this.client.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(JBPM5HumanTaskServiceOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setServiceLifeCycle(String name, ServiceLifeCycleManager serviceLifeCycle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
