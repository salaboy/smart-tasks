/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.configuration.mock;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.api.ServiceLifeCycleManager;
import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
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

/**
 *
 * @author esteban
 */
public class MockHumanTaskClientConfiguration implements HumanTaskClientConfiguration {
    public final static String TYPE = "MOCK";
    private String attr1;
    private String attr2;

    public static class MockHumanTaskServiceOperations implements HumanTaskServiceOperations{

        
        @Override
        public void nominate(String identifier, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void getFault(String identifier, Holder<String> faultName, Holder<Object> faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void forward(String identifier, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void deleteOutput(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<QName> getRenderingTypes(Object identifier) throws IllegalArgumentFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<TComment> getComments(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void addAttachment(String identifier, String name, String accessType, Object attachment) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void activate(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setOutput(String identifier, String part, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void start(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public TTaskQueryResultSet query(String selectClause, String whereClause, String orderByClause, Integer maxTasks, Integer taskIndexOffset) throws IllegalArgumentFault, IllegalStateFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void deleteAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<TTaskAbstract> getMyTaskAbstracts(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void skip(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<TAttachment> getAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getTaskDescription(String identifier, String contentType) throws IllegalArgumentFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void release(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void remove(String identifier) throws IllegalArgumentFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void suspend(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<TTask> getMyTasks(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setGenericHumanRole(String identifier, String genericHumanRole, TOrganizationalEntity organizationalEntity) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Object getInput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Object getRendering(String identifier, QName renderingType) throws IllegalArgumentFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setFault(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void delegate(String identifier, TOrganizationalEntity organizationalEntity) throws RecipientNotAllowed, IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void stop(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Object getOutput(String identifier, String part) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<TAttachmentInfo> getAttachmentInfos(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void suspendUntil(String identifier, TTime time) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void addComment(String identifier, String text) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void complete(String identifier, Object taskData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setPriority(String identifier, BigInteger priority) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void resume(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void claim(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void fail(String identifier, String faultName, Object faultData) throws IllegalArgumentFault, IllegalStateFault, IllegalOperationFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void deleteFault(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setAuthorizedEntityId(String entityId) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getAuthorizedEntityId() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setLocale(String locale) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void initializeService() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void cleanUpService() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setServiceLifeCycle(String name, ServiceLifeCycleManager serviceLifeCycle) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public HumanTaskServiceOperations getServiceOperationsImplementation() {
        return new MockHumanTaskServiceOperations();
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
    
}
