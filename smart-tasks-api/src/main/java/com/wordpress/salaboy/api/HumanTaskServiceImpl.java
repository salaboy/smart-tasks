/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.example.ws_ht.api.TAttachment;
import org.example.ws_ht.api.TAttachmentInfo;
import org.example.ws_ht.api.TStatus;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalAccessFault;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceImpl extends HumanTaskOperationsDefault implements HumanTaskService{
    private Map<String, HumanTaskServiceOperations> taskOperations;
    private Map<String, ServiceLifeCycleManager> serviceLifeCycleManagers;
    
    public HumanTaskServiceImpl(Map<String, HumanTaskServiceOperations> taskOperations) {
        
        this.taskOperations = taskOperations;
        
    }

    public Map<String, HumanTaskServiceOperations> getTaskOperations() {
        return this.taskOperations;
    }

    @Override
    public void claim(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        //@FIXME: this call should be performed according to some pattern in the id
        //that identifies the real taskOperation
        this.taskOperations.entrySet().iterator().next().getValue().claim(identifier);
    }
    
    @Override
    public void start(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        //@FIXME: this call should be performed according to some pattern in the id
        //that identifies the real taskOperation
        this.taskOperations.entrySet().iterator().next().getValue().start(identifier);
    }
    
    @Override
    public void complete(String identifier, Object contentData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        //@FIXME: this call should be performed according to some pattern in the id
        //that identifies the real taskOperation
        this.taskOperations.entrySet().iterator().next().getValue().complete(identifier, contentData);
    }

    @Override
    public List<TTaskAbstract> getMyTaskAbstracts(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
        List<TTaskAbstract> result = new ArrayList<TTaskAbstract>();
        for (Map.Entry<String, HumanTaskServiceOperations> entry : this.taskOperations.entrySet()) {
            result.addAll(entry.getValue().getMyTaskAbstracts(taskType, genericHumanRole, workQueue, status, whereClause, orderByClause, createdOnClause, maxTasks, fromTaskNumber));
        }
        return result;
    }
    
    @Override
    public List<TAttachmentInfo> getAttachmentInfos(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        //@FIXME: this call should be performed according to some pattern in the id
        //that identifies the real taskOperation
        return this.taskOperations.entrySet().iterator().next().getValue().getAttachmentInfos(identifier);
    }

    @Override
    public List<TAttachment> getAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        //@FIXME: this call should be performed according to some pattern in the id
        //that identifies the real taskOperation
        return this.taskOperations.entrySet().iterator().next().getValue().getAttachments(identifier, attachmentName);
    }
    
    @Override
    public void setAuthorizedEntityId(String entityId) {
        
        //@FIXME: I'm using the same entityId for all taskOperations
        for(String key : this.taskOperations.keySet()){
            this.taskOperations.get(key).setAuthorizedEntityId(entityId);
        }
    }

    @Override
    public void setLocale(String locale) {
        //@FIXME: I'm using the same locale for all taskOperations
        for(String key : this.taskOperations.keySet()){
            this.taskOperations.get(key).setLocale(locale);
        }
    }

  
    @Override
    public void initializeService() {
       
        for(String key : this.taskOperations.keySet()){
            this.taskOperations.get(key).initializeService();
        }
        
    }

    @Override
    public void cleanUpService() {
        
        for(String key : this.taskOperations.keySet()){
            this.taskOperations.get(key).cleanUpService();
        }
        
    }
    public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
        //@FIXME: We should ask to the correct taskOperations
        for(String key : this.taskOperations.keySet()){
            TTask taskInfo = this.taskOperations.get(key).getTaskInfo(identifier);
            if (taskInfo != null){
                return taskInfo;
            }
        }
        
        return null;
    }

}
