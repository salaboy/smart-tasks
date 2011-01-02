/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.worpdress.salaboy.api.TaskDefinition;
import java.util.ArrayList;
import java.util.List;
import org.jbpm.task.Task;
import org.jbpm.task.query.TaskSummary;

/**
 *
 * @author salaboy
 */
public class JBPM5TaskDefinitionAdapter implements TaskDefinitionAdapter<TaskSummary, Task> {

    private static JBPM5TaskDefinitionAdapter adapter;

    private JBPM5TaskDefinitionAdapter() {
    }
    
    public static JBPM5TaskDefinitionAdapter getInstance(){
        if(adapter == null){
            return new JBPM5TaskDefinitionAdapter();
        }
        return adapter;
    } 
    
    public  List<TaskDefinition> adaptCollection(List<TaskSummary> vendorTasks) {
        List<TaskDefinition> tasks = new ArrayList<TaskDefinition>();
        for(TaskSummary taskSum : vendorTasks){
            tasks.add(adaptTaskSummary(taskSum));
        }
        return tasks;
    }

    public  TaskDefinition adapt(Task vendorTask) {
        return new TaskDefinition(vendorTask.getId(), 
                                  vendorTask.getNames().get(0).getText(), 
                                  vendorTask.getPeopleAssignments().getPotentialOwners().get(0).getId(),
                                  vendorTask.getDescriptions().get(0).getText(),
                                  vendorTask.getTaskData().getCreatedOn(),
                                  null,
                                  vendorTask.getTaskData().getExpirationTime(),
                                  vendorTask.getPriority());
    }

    private TaskDefinition adaptTaskSummary(TaskSummary vendorTask) {
       return new TaskDefinition(vendorTask.getId(), 
                                  vendorTask.getName(), 
                                  vendorTask.getActualOwner().getId(),
                                  vendorTask.getDescription(),
                                  vendorTask.getCreatedOn(),
                                  vendorTask.getActivationTime(),
                                  vendorTask.getExpirationTime(),
                                  vendorTask.getPriority());
    }
    

}
