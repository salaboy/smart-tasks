/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smarttasks.activiti5wrapper;

import com.wordpress.salaboy.api.TaskDefinitionAdapter;
import com.worpdress.salaboy.api.TaskDefinition;
import java.util.ArrayList;
import java.util.List;
import org.activiti.engine.task.Task;

/**
 *
 * @author salaboy
 */
public class Activiti5TaskDefinitionAdapter implements TaskDefinitionAdapter<Task, Task>{
    
    private static Activiti5TaskDefinitionAdapter adapter;

    private Activiti5TaskDefinitionAdapter() {
    }
    
    public static Activiti5TaskDefinitionAdapter getInstance(){
        if(adapter == null){
            adapter = new Activiti5TaskDefinitionAdapter();
        }
        return adapter;
    }
    
    
    public List<TaskDefinition> adaptCollection(List<Task> vendorTasks) {
        List<TaskDefinition> tasks = new ArrayList<TaskDefinition>();
        for(Task task : vendorTasks){
            tasks.add(adapt(task));
        }
        return tasks;
    }

    public TaskDefinition adapt(Task vendorTask) {
        return new TaskDefinition(Long.parseLong(vendorTask.getId()), 
                                  vendorTask.getName(), 
                                  vendorTask.getAssignee(),
                                  vendorTask.getDescription(),
                                  vendorTask.getCreateTime(),
                                  null,
                                  null,
                                  vendorTask.getPriority());
    }

}
