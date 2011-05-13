/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.configuration.mock;

import java.math.BigInteger;
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
import org.example.ws_ht.api.xsd.TTime;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.api.ServiceLifeCycleManager;

/**
 *
 * @author esteban
 */
public class MockHumanTaskServiceOperations implements HumanTaskServiceOperations {
	public String getTaskOriginatorType(String taskId) {
		return "Mock";
	}
    @Override
    public void nominate(String identifier, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void getFault(String identifier, Holder<String> faultName, Holder<Object> faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
    }

    @Override
    public void forward(String identifier, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void deleteOutput(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public List<QName> getRenderingTypes(Object identifier) throws IllegalArgumentFault {
        return null;
    }

    @Override
    public List<TComment> getComments(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        return null;
    }

    @Override
    public void addAttachment(String identifier, String name, String accessType, Object attachment) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void activate(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void setOutput(String identifier, String part, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void start(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public TTaskQueryResultSet query(String selectClause, String whereClause, String orderByClause, Integer maxTasks, Integer taskIndexOffset) throws IllegalArgumentFault, IllegalStateFault {
        return null;
    }

    @Override
    public void deleteAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public List<TTaskAbstract> getMyTaskAbstracts(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
        return null;
    }

    @Override
    public void skip(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
    }

    @Override
    public List<TAttachment> getAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        return null;
    }

    @Override
    public String getTaskDescription(String identifier, String contentType) throws IllegalArgumentFault {
        return null;
    }

    @Override
    public void release(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
        return null;
    }

    @Override
    public void remove(String identifier) throws IllegalArgumentFault, IllegalAccessFault {
    }

    @Override
    public void suspend(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public List<TTask> getMyTasks(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
        return null;
    }

    @Override
    public void setGenericHumanRole(String identifier, String genericHumanRole, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public Object getInput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        return null;
    }

    @Override
    public Object getRendering(String identifier, QName renderingType) throws IllegalArgumentFault {
        return null;
    }

    @Override
    public void setFault(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
    }

    @Override
    public void delegate(String identifier, TOrganizationalEntity organizationalEntity) throws RecipientNotAllowed, IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void stop(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public Object getOutput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        return null;
    }

    @Override
    public List<TAttachmentInfo> getAttachmentInfos(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        return null;
    }

    @Override
    public void suspendUntil(String identifier, TTime time) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void addComment(String identifier, String text) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void complete(String identifier, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void setPriority(String identifier, BigInteger priority) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void resume(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void claim(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void fail(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
    }

    @Override
    public void deleteFault(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
    }

    @Override
    public void setAuthorizedEntityId(String entityId) {
    }

    @Override
    public String getAuthorizedEntityId() {
        return null;
    }
    

    @Override
    public void setLocale(String locale) {
    }

    @Override
    public void initializeService() {
    }

    @Override
    public void cleanUpService() {
    }

    @Override
    public void setServiceLifeCycle(String name, ServiceLifeCycleManager serviceLifeCycle) {
    }

}
