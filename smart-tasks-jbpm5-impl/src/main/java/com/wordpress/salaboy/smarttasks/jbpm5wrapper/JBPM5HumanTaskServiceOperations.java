/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import org.example.ws_ht.TGrouplist;
import org.example.ws_ht.TOrganizationalEntity;
import org.example.ws_ht.TUserlist;
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
import org.jbpm.task.AccessType;
import org.jbpm.task.Attachment;
import org.jbpm.task.Comment;
import org.jbpm.task.Content;
import org.jbpm.task.I18NText;
import org.jbpm.task.Task;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.service.FaultData;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.responsehandlers.BlockingAddAttachmentResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingAddCommentResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingDeleteAttachmentResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingGetContentResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingGetTaskResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskOperationResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.api.OutputData;
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
    	/*List<OrganizationalEntity> potentialOwners = new ArrayList<OrganizationalEntity>();
    	List<String> users = organizationalEntity.getUsers() == null ? new ArrayList<String>() : organizationalEntity.getUsers().getUser();
    	for (String user : users) {
    		potentialOwners.add(new User(user));
    	}
    	List<String> groups = organizationalEntity.getGroups() == null ? new ArrayList<String>() : organizationalEntity.getGroups().getGroup();
    	for (String group : groups) {
    		potentialOwners.add(new Group(group));
    	}
    	
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.nominate(Long.parseLong(identifier), potentialOwners, responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());*/
    	throw new UnsupportedOperationException("Nos supported yet.");
    }

    public void getFault(String identifier, Holder<String> faultName, Holder<Object> faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
    	Task task = this.getTask(identifier);
    	
    	BlockingGetContentResponseHandler responseHandler = new BlockingGetContentResponseHandler();
    	client.getContent(task.getTaskData().getFaultContentId(), responseHandler);
    	Content content = responseHandler.getContent();
    	
    	faultName.value = task.getTaskData().getFaultName();
    	faultData.value = content.getContent();
    }

    public void forward(String identifier, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	Task task = this.getTask(identifier);
    	String targetEntityId = null;
    	if (organizationalEntity.getUsers() != null) {
    		List<String> users = organizationalEntity.getUsers().getUser();
    		if (!users.isEmpty()) {
    			targetEntityId = users.iterator().next();
    		}
    	} 
    	if (targetEntityId == null && organizationalEntity.getGroups() != null) {
    		List<String> groups = organizationalEntity.getGroups().getGroup();
    		if (!groups.isEmpty()) {
    			targetEntityId = groups.iterator().next();
    		}
    	}
    	if (targetEntityId == null) {
    		throw new IllegalArgumentFault("organizationalEntity must have at least one user or group");
    	}
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.forward(task.getId(), getActiveUserId(), targetEntityId, responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());
    }

    public void deleteOutput(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	/*long taskId = Long.parseLong(identifier);
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.deleteOutput(taskId, getActiveUserId(), responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());*/
    	throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<QName> getRenderingTypes(Object identifier) throws IllegalArgumentFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TComment> getComments(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	Task task = this.getTask(identifier);
    	List<Comment> comments = task.getTaskData().getComments();
    	return JBPM5TCommentAdapter.getInstance().adaptCollection(comments);
    }

    public void addAttachment(String identifier, String name, String accessType, Object attachment) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	Task task = this.getTask(identifier);
    	
    	Attachment jbpm5Attachment = new Attachment();
    	jbpm5Attachment.setAccessType(AccessType.valueOf(accessType));
    	jbpm5Attachment.setName(name);
    	jbpm5Attachment.setAttachedAt(new Date());
    	jbpm5Attachment.setAttachedBy(task.getTaskData().getActualOwner());
    	
        Content content = new Content();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout;
        try {
			oout = new ObjectOutputStream(bout);
			oout.writeObject(attachment);
			oout.close();
			content.setContent(bout.toByteArray());
		} catch (IOException e) {
			throw new IllegalArgumentFault("attachment not an object", e);
		}

		BlockingAddAttachmentResponseHandler responseHandler = new BlockingAddAttachmentResponseHandler();
        client.addAttachment(task.getId(), jbpm5Attachment, content, responseHandler);
        responseHandler.waitTillDone(configuration.getTimeout());
    }

    public void activate(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	/*long taskId = Long.parseLong(identifier);
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
		client.activate(taskId, getActiveUserId(), responseHandler);
		responseHandler.waitTillDone(configuration.getTimeout());*/
    	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setOutput(String identifier, String part, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	/*long taskId = Long.parseLong(identifier);
    	ContentData outputContentData = new ContentData();
    	String userId = this.getActiveUserId();
    	outputContentData.setContent(taskData.toString().getBytes());
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.setOutput(taskId, userId, outputContentData, responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());*/
    	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void start(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        Long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.start(taskId, userId , blockingTaskOperationResponseHandler);
        blockingTaskOperationResponseHandler.waitTillDone(configuration.getTimeout());
    }

    public TTaskQueryResultSet query(String selectClause, String whereClause, String orderByClause, Integer maxTasks, Integer taskIndexOffset) throws IllegalArgumentFault, IllegalStateFault {
    	/*String qlString = "select " + selectClause + 
    		" from Task t left join t.taskData.createdBy" +
    		" left join t.taskData.actualOwner" +
    		" left join t.subjects as subject, I18NText names, I18NText subjects," +
    		" I18NText descriptions, OrganizationalEntity potentialOwners" +
    		" where " + whereClause +
    		" order by " + orderByClause;
    	BlockingQueryGenericResponseHandler responseHandler = new BlockingQueryGenericResponseHandler(); 
    	client.query(qlString, maxTasks, taskIndexOffset, responseHandler);
    	List<Object> results = (List<Object>) responseHandler.getResults();
    	TTaskQueryResultSet resultSet = new TTaskQueryResultSet();
    	resultSet.getRow().addAll(JBPM5TTaskQueryResultAdapter.getInstance().adaptCollection(results));
        return resultSet;*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	
    	Task task = this.getTask(identifier);
    	
    	List<Attachment> attachments = task.getTaskData().getAttachments();
    	Attachment toRemove = null;
    	for (Attachment attachment : attachments) {
    		if (attachmentName != null && attachmentName.equals(attachment.getName())) {
    			toRemove = attachment;
    			break;
    		}
    	}
    	
    	if (toRemove != null) {
    		BlockingDeleteAttachmentResponseHandler responseHandler = new BlockingDeleteAttachmentResponseHandler();
    		client.deleteAttachment(task.getId(), toRemove.getId(), toRemove.getAttachmentContentId(), responseHandler);
    		responseHandler.waitTillDone(configuration.getTimeout());
    	} else {
    		throw new IllegalArgumentFault("attachment of name " + attachmentName + " not found");
    	}
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
        blockingTaskOperationResponseHandler.waitTillDone(configuration.getTimeout());
    }

    public List<TAttachment> getAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        Task task = this.getTask(identifier);

        List<JBPM5TAttachmentInfo> taskTAttachmentInfo = new JBPM5TAttachmentInfoAdapter().getTaskTAttachmentInfo(task, attachmentName);

        List<TAttachment> tAttachments = new ArrayList<TAttachment>();
        for (JBPM5TAttachmentInfo tAttachmentInfo : taskTAttachmentInfo) {
            TAttachment tAttachment = new TAttachment();
            tAttachment.setAttachmentInfo(tAttachmentInfo);
            BlockingGetContentResponseHandler blockingGetContentResponseHandler = new BlockingGetContentResponseHandler();
            client.getContent(tAttachmentInfo.getId(), blockingGetContentResponseHandler);
            Content content = blockingGetContentResponseHandler.getContent();
            try {
            	ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(content.getContent()));
            	tAttachment.setValue(oin.readObject());
            } catch (IOException e) {
            	throw new IllegalAccessFault("unreadable object inside attachment", e);
            } catch (ClassNotFoundException e) {
            	throw new IllegalAccessFault("unknown object inside attachment", e);
            }
            tAttachments.add(tAttachment);
        }


        return tAttachments;
    }

    public String getTaskDescription(String identifier, String contentType) throws IllegalArgumentFault {
    	Task task = this.getTask(identifier);
		List<I18NText> descriptions = task.getDescriptions();
    	if (!descriptions.isEmpty()) {
    		return descriptions.iterator().next().getText();
    	}
    	return null;
    }

    public void release(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.release(taskId, userId, blockingTaskOperationResponseHandler);
        blockingTaskOperationResponseHandler.waitTillDone(configuration.getTimeout());
    }

    public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
        Task task = this.getTask(identifier);
        return JBPM5TTaskAdapter.getInstance().adapt(task);
    }

    public void remove(String identifier) throws IllegalArgumentFault, IllegalAccessFault {
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.release(Long.parseLong(identifier), getActiveUserId(), responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());
    }

    public void suspend(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.suspend(taskId, userId, blockingTaskOperationResponseHandler);
        blockingTaskOperationResponseHandler.waitTillDone(configuration.getTimeout());
    }

    public List<TTask> getMyTasks(String taskType, String genericHumanRole, String workQueue, 
    		List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, 
    		Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
   
    	/*String qlString = "select t from Task t left join t.taskData.actualOwner left join t.taskData.status where " + whereClause;
    	if (createdOnClause != null && !"".equals(createdOnClause)) {
    		qlString += " and " + createdOnClause;
    	}
    	if (genericHumanRole != null && !"".equals(genericHumanRole)) {
    		qlString += " and t.taskData.actualOwner.id = '" + genericHumanRole + "'";
    	}
    	if (status != null && !status.isEmpty()) {
    		String statusInline = "";
    		for (TStatus stat : status) {
    			statusInline += stat.name() + ",";
    		}
    		statusInline = statusInline.substring(0, statusInline.length() - 1);
    		qlString += " and status in (" + statusInline + ")";
    	}
    	qlString += " and t.taskData.expirationTime is null order by " + orderByClause;

    	BlockingQueryGenericResponseHandler responseHandler = new BlockingQueryGenericResponseHandler();
        client.query(qlString, maxTasks, fromTaskNumber, responseHandler);
        List<?> results = responseHandler.getResults();
        List<TTask> tasks = new ArrayList<TTask>(results.size());
        for (Object obj : results) {
        	tasks.add(JBPM5TTaskAdapter.getInstance().adapt((Task) obj));
        }
        return tasks;*/
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
    	/*long taskId = Long.parseLong(identifier);
    	FaultData fault = new FaultData();
    	fault.setContent(faultData == null ? null : faultData.toString().getBytes());
    	fault.setFaultName(faultName);
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.setFault(taskId, getActiveUserId(), fault, responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());*/
    	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delegate(String identifier, TOrganizationalEntity organizationalEntity) throws RecipientNotAllowed, IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {

    	Task task = this.getTask(identifier);
    	
    	TGrouplist tgroups = organizationalEntity.getGroups();
    	TUserlist tusers = organizationalEntity.getUsers();
    	List<String> users = tusers == null ? new ArrayList<String>() : tusers.getUser();
    	List<String> groups = tgroups == null ? new ArrayList<String>() : tgroups.getGroup();
    	
    	long taskId = task.getId();
    	String userId = task.getTaskData().getActualOwner() == null ? null : task.getTaskData().getActualOwner().getId();
    	
    	//Handling all responseHandlers together
    	List<BlockingTaskOperationResponseHandler> handlers = new ArrayList<BlockingTaskOperationResponseHandler>(users.size() + groups.size());
    	for (String targetUserId : users) {
    		BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	   	client.delegate(taskId, userId, targetUserId, responseHandler);
    	   	handlers.add(responseHandler);
    	}
    	for (String targetGroupId : groups) {
    		BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	   	client.delegate(taskId, userId, targetGroupId, responseHandler);
    	   	handlers.add(responseHandler);
    	}
    	
    	for (BlockingTaskOperationResponseHandler responseHandler : handlers) { 
    		responseHandler.waitTillDone(configuration.getTimeout());
    	}
    }

    public void stop(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.stop(taskId, userId, blockingTaskOperationResponseHandler);
        blockingTaskOperationResponseHandler.waitTillDone(configuration.getTimeout());
    }

    public Object getOutput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	Task task = this.getTask(identifier);
    	
    	BlockingGetContentResponseHandler responseHandler = new BlockingGetContentResponseHandler();
    	client.getContent(task.getTaskData().getOutputContentId(), responseHandler);
    	Content content = responseHandler.getContent();
    	
    	Map<String, Object> data = new HashMap<String, Object>();
    	data.put("accessType", task.getTaskData().getOutputAccessType().name());
    	data.put("type", task.getTaskData().getOutputType());
    	data.put("id", task.getTaskData().getOutputContentId());
    	data.put("content", content.getContent());
    	return new OutputData(data);
    }

    public List<TAttachmentInfo> getAttachmentInfos(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        Task task = this.getTask(identifier);

        return new ArrayList<TAttachmentInfo>(new JBPM5TAttachmentInfoAdapter().getTaskTAttachmentInfo(task));
    }

    public void suspendUntil(String identifier, TTime time) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addComment(String identifier, String text) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	
    	Task task = this.getTask(identifier);
    	
    	Comment comment = new Comment();
    	comment.setAddedAt(new Date());
    	comment.setAddedBy(task.getTaskData().getActualOwner());
    	comment.setText(text);
    	
    	BlockingAddCommentResponseHandler responseHandler = new BlockingAddCommentResponseHandler();
    	client.addComment(task.getId(), comment, responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());
    }

    public void complete(String identifier, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.complete(taskId, userId, (ContentData) taskData, blockingTaskOperationResponseHandler);
        blockingTaskOperationResponseHandler.waitTillDone(configuration.getTimeout());
    }

    public void setPriority(String identifier, BigInteger priority) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	/*BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.setPriority(Long.parseLong(identifier), getActiveUserId(), priority.intValue(), responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());*/
    	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void resume(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.resume(Long.parseLong(identifier), getActiveUserId(), responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());
    }

    public void claim(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        long taskId = Long.parseLong(identifier);
        String userId = this.getActiveUserId();

        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        client.claim(taskId, userId, blockingTaskOperationResponseHandler);
        blockingTaskOperationResponseHandler.waitTillDone(configuration.getTimeout());
    }

    public void fail(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
    	
    	long taskId = Long.parseLong(identifier);
    	String userId = getActiveUserId();
    	FaultData data = new FaultData();
    	data.setFaultName(faultName);
    	data.setContent(faultData.toString().getBytes());
    	
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.fail(taskId, userId, data, responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());
    }

    public void deleteFault(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    	/*Long taskId = Long.parseLong(identifier);
    	BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
    	client.deleteFault(taskId, getActiveUserId(), responseHandler);
    	responseHandler.waitTillDone(configuration.getTimeout());*/
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
