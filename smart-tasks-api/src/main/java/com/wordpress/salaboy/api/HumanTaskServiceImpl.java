/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.example.ws_ht.api.TStatus;
import org.example.ws_ht.api.TTaskAbstract;
import org.example.ws_ht.api.wsdl.IllegalAccessFault;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;

/**
 *
 * @author salaboy
 */
public class HumanTaskServiceImpl extends AuthorizedTaskOperationsDefault implements HumanTaskService{
    private Map<String, AuthorizedTaskOperations> taskOperations;
    
    public HumanTaskServiceImpl(Map<String, AuthorizedTaskOperations> taskOperations) {
        
        this.taskOperations = taskOperations;
        
    }

    public Map<String, AuthorizedTaskOperations> getTaskOperations() {
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
        for (Map.Entry<String, AuthorizedTaskOperations> entry : this.taskOperations.entrySet()) {
            result.addAll(entry.getValue().getMyTaskAbstracts(taskType, genericHumanRole, workQueue, status, whereClause, orderByClause, createdOnClause, maxTasks, fromTaskNumber));
        }
        return result;
    }

    @Override
    public void setAuthorizedEntityId(String entityId) {
        
        //@FIXME: I'm using the same entityId for all taskOperations
        for(String key : this.taskOperations.keySet()){
            this.taskOperations.get(key).setAuthorizedEntityId(entityId);
        }
    }

    
    
    

}
