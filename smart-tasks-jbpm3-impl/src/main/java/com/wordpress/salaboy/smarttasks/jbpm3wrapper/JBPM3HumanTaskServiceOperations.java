/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.jbpm3wrapper;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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
import org.jbpm.JbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.api.ServiceLifeCycleManager;

/**
 *
 * @author salaboy
 */
public class JBPM3HumanTaskServiceOperations implements HumanTaskServiceOperations {


	private JbpmContext jbpmContext;
    public JBPM3HumanTaskServiceOperations(final JbpmContext ctx) {
    	this.jbpmContext = ctx;
    }

	public void nominate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void getFault(String identifier, Holder<String> faultName,
			Holder<Object> faultData) throws IllegalArgumentFault,
			IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void forward(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void deleteOutput(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public List<QName> getRenderingTypes(Object identifier)
			throws IllegalArgumentFault {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TComment> getComments(String identifier)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAttachment(String identifier, String name,
			String accessType, Object attachment) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void activate(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void setOutput(String identifier, String part, Object taskData)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void start(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		this.jbpmContext.getTaskInstance(Long.parseLong(identifier)).start();
	}

	public TTaskQueryResultSet query(String selectClause, String whereClause,
			String orderByClause, Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalStateFault {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAttachments(String identifier, String attachmentName)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public List<TTaskAbstract> getMyTaskAbstracts(String taskType,
			String genericHumanRole, String workQueue, List<TStatus> status,
			String whereClause, String orderByClause, String createdOnClause,
			Integer maxTasks, Integer fromTaskNumber)
			throws IllegalArgumentFault, IllegalStateFault {
		List<TaskInstance> jbpm3Tasks = this.jbpmContext.getTaskList(genericHumanRole);
		return new JBPM3TaskAbstractAdapter().adaptCollection(jbpm3Tasks);
	}

	public void skip(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public List<TAttachment> getAttachments(String identifier,
			String attachmentName) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		TaskInstance task = this.jbpmContext.getTaskInstance(Long.parseLong(identifier));
		Map vars = task.getVariableInstances();
		for (Object var : vars.keySet()) {
			TAttachment att = new TAttachment();
			TAttachmentInfo info = new TAttachmentInfo();
			info.setName(var.toString());
			att.setValue(vars.get(var));
			att.setAttachmentInfo(info);
		}
		return null;
	}

	public String getTaskDescription(String identifier, String contentType)
			throws IllegalArgumentFault {
		// TODO Auto-generated method stub
		return null;
	}

	public void release(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
		TaskInstance task = this.jbpmContext.getTaskInstance(Long.parseLong(identifier));
		return new JBPM3TaskAdapter().adapt(task);
	}

	public void remove(String identifier) throws IllegalArgumentFault,
			IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void suspend(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public List<TTask> getMyTasks(String taskType, String genericHumanRole,
			String workQueue, List<TStatus> status, String whereClause,
			String orderByClause, String createdOnClause, Integer maxTasks,
			Integer fromTaskNumber) throws IllegalArgumentFault,
			IllegalStateFault {
		List<TaskInstance> jbpm3Tasks = this.jbpmContext.getTaskList(genericHumanRole);
		return new JBPM3TaskAdapter().adaptCollection(jbpm3Tasks);
	}

	public void setGenericHumanRole(String identifier, String genericHumanRole,
			TOrganizationalEntity organizationalEntity)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public Object getInput(String identifier, String part)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRendering(String identifier, QName renderingType)
			throws IllegalArgumentFault {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFault(String identifier, String faultName, Object faultData)
			throws IllegalArgumentFault, IllegalStateFault,
			IllegalOperationFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void delegate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws RecipientNotAllowed, IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void stop(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public Object getOutput(String identifier, String part)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TAttachmentInfo> getAttachmentInfos(String identifier)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		return null;
	}

	public void suspendUntil(String identifier, TTime time)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void addComment(String identifier, String text)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void complete(String identifier, Object taskData)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		this.jbpmContext.getTaskInstance(Long.parseLong(identifier));
	}

	public void setPriority(String identifier, BigInteger priority)
			throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void resume(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void claim(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void fail(String identifier, String faultName, Object faultData)
			throws IllegalArgumentFault, IllegalStateFault,
			IllegalOperationFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void deleteFault(String identifier) throws IllegalArgumentFault,
			IllegalStateFault, IllegalAccessFault {
		// TODO Auto-generated method stub
		
	}

	public void setAuthorizedEntityId(String entityId) {
		// TODO Auto-generated method stub
		
	}

	public String getAuthorizedEntityId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLocale(String locale) {
		// TODO Auto-generated method stub
		
	}

	public void initializeService() {
		// TODO Auto-generated method stub
		
	}

	public void cleanUpService() {
		// TODO Auto-generated method stub
		
	}

	public void setServiceLifeCycle(String name,
			ServiceLifeCycleManager serviceLifeCycle) {
		// TODO Auto-generated method stub
		
	}

	public String getTaskOriginatorType(String taskId) {
		// TODO Auto-generated method stub
		return null;
	}

   }
