/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
    
    public HumanTaskServiceImpl(List<HumanTaskServiceOperations> taskOperations) {
        this.taskOperations = new HashMap<String, HumanTaskServiceOperations>();
        for (HumanTaskServiceOperations humanTaskServiceOperations : taskOperations) {
            String serviceOperationId = UUID.randomUUID().toString();
            this.taskOperations.put(serviceOperationId, humanTaskServiceOperations);
        }
    }

    @Override
    public Map<String, HumanTaskServiceOperations> getTaskOperations() {
        return this.taskOperations;
    }

    @Override
    public void claim(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        String entityId = this.getEntityId(identifier);
        String taskOperationId = this.getTaskOperationId(identifier);
        this.taskOperations.get(taskOperationId).claim(entityId);
    }
    
    @Override
    public void start(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        String entityId = this.getEntityId(identifier);
        String taskOperationId = this.getTaskOperationId(identifier);
        this.taskOperations.get(taskOperationId).start(entityId);
    }
    
    @Override
    public void complete(String identifier, Object contentData) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        String entityId = this.getEntityId(identifier);
        String taskOperationId = this.getTaskOperationId(identifier);
        this.taskOperations.get(taskOperationId).complete(entityId, contentData);
    }

    @Override
    public List<TTaskAbstract> getMyTaskAbstracts(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
        List<TTaskAbstract> result = new ArrayList<TTaskAbstract>();
        for (Map.Entry<String, HumanTaskServiceOperations> entry : this.taskOperations.entrySet()) {
            //Custom id creation
            List<TTaskAbstract> myTaskAbstracts = entry.getValue().getMyTaskAbstracts(taskType, genericHumanRole, workQueue, status, whereClause, orderByClause, createdOnClause, maxTasks, fromTaskNumber);
            for (TTaskAbstract tTaskAbstract : myTaskAbstracts) {
                tTaskAbstract.setId(this.createUniqueId(entry.getKey(), tTaskAbstract));
                result.add(tTaskAbstract);
            }
        }
        return result;
    }
    
    @Override
    public List<TAttachmentInfo> getAttachmentInfos(String identifier) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        String entityId = this.getEntityId(identifier);
        String taskOperationId = this.getTaskOperationId(identifier);
        return this.taskOperations.get(taskOperationId).getAttachmentInfos(entityId);
    }

    @Override
    public List<TAttachment> getAttachments(String identifier, String attachmentName) throws IllegalArgumentFault, IllegalStateFault, IllegalAccessFault {
        String entityId = this.getEntityId(identifier);
        String taskOperationId = this.getTaskOperationId(identifier);
        return this.taskOperations.get(taskOperationId).getAttachments(entityId, attachmentName);
    }
    
    @Override
    public void setAuthorizedEntityId(String entityId) {
        
        //@FIXME: I'm using the same entityId for all taskOperations
        for (Map.Entry<String, HumanTaskServiceOperations> entry : this.taskOperations.entrySet()) {
            entry.getValue().setAuthorizedEntityId(entityId);
        }
    }

    @Override
    public void setLocale(String locale) {
        //@FIXME: I'm using the same locale for all taskOperations
        for (Map.Entry<String, HumanTaskServiceOperations> entry : this.taskOperations.entrySet()) {
            entry.getValue().setLocale(locale);
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
    
    @Override
    public TTask getTaskInfo(String identifier) throws IllegalArgumentFault {
        String entityId = this.getEntityId(identifier);
        String taskOperationId = this.getTaskOperationId(identifier);
        
        TTask taskInfo = this.taskOperations.get(taskOperationId).getTaskInfo(entityId);
        if (taskInfo != null){
            taskInfo.setId(this.createUniqueId(taskOperationId, taskInfo));
            return taskInfo;
        }
        return null;
    }

    @Override
    public List<TTask> getMyTasks(String taskType, String genericHumanRole, String workQueue, List<TStatus> status, String whereClause, String orderByClause, String createdOnClause, Integer maxTasks, Integer fromTaskNumber) throws IllegalArgumentFault, IllegalStateFault {
        List<TTask> tTasks = new ArrayList<TTask> ();
        for (Map.Entry<String, HumanTaskServiceOperations> entry : this.taskOperations.entrySet()) {
            List<TTask> tasks = entry.getValue().getMyTasks(taskType, genericHumanRole, workQueue, status, whereClause, orderByClause, createdOnClause, maxTasks, fromTaskNumber);
            if (tasks != null){
                for (TTask tTask : tasks) {
                    tTask.setId(this.createUniqueId(entry.getKey(), tTask));
                }
                tTasks.addAll(tasks);
            }
        }
        
        return tTasks;
    }

    private String createUniqueId(String key, TTask task){
        return this.createUniqueId(key, task.getId());
    }
    
    private String createUniqueId(String key, TTaskAbstract taskAbstract){
        return this.createUniqueId(key, taskAbstract.getId());
    }
    
    
    private String createUniqueId(String key, String entityId){
        //simple Unique Id creator. Of course that key should already be unique ;)
        return key+"-@-"+entityId;
    }
    
    private String getEntityId(String uniqueId){
        return uniqueId.split("\\-@\\-")[1];
    }
    
    private String getTaskOperationId(String uniqueId){
        return uniqueId.split("\\-@\\-")[0];
    }
}
