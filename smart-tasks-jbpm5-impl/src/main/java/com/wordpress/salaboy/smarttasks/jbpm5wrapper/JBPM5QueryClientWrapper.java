/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.api.HumanTaskQueryClientWrapper;
import com.worpdress.salaboy.api.TaskDefinition;
import java.util.List;
import org.jbpm.task.Task;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.responsehandlers.BlockingGetTaskResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;

/**
 *
 * @author salaboy
 */
public class JBPM5QueryClientWrapper implements HumanTaskQueryClientWrapper {

    public TaskClient client;

    public JBPM5QueryClientWrapper(TaskClient client) {
        this.client = client;
    }
    
    
    
    public List<TaskDefinition> getMyTaskAbstracts(String potentialOwner) {
        BlockingTaskSummaryResponseHandler handler  = new BlockingTaskSummaryResponseHandler();
        client.getTasksAssignedAsPotentialOwner(potentialOwner, "en-UK", handler);
        List<TaskSummary> results = handler.getResults();
        return JBPM5TaskDefinitionAdapter.getInstance().adaptCollection(results);
        
    }

    public TaskDefinition getMyTask(long taskId) {
        BlockingGetTaskResponseHandler handler  = new BlockingGetTaskResponseHandler();
        client.getTask(taskId, handler);
        Task result = handler.getTask();
        return JBPM5TaskDefinitionAdapter.getInstance().adapt(result);
    }

}
