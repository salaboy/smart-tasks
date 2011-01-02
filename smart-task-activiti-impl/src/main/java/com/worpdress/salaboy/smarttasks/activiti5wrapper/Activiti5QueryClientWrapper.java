/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smarttasks.activiti5wrapper;

import com.wordpress.salaboy.api.HumanTaskQueryClientWrapper;
import com.worpdress.salaboy.api.TaskDefinition;
import java.util.List;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 *
 * @author salaboy
 */
public class Activiti5QueryClientWrapper implements HumanTaskQueryClientWrapper{

    private TaskService taskService;

    public Activiti5QueryClientWrapper(TaskService taskService) {
        this.taskService = taskService;
    }
    
    
    public List<TaskDefinition> getMyTaskAbstracts(String potentialOwner) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(potentialOwner).list();
        return Activiti5TaskDefinitionAdapter.getInstance().adaptCollection(tasks);
    }

    public TaskDefinition getMyTask(long taskId) {
        Task task = taskService.createTaskQuery().taskId(""+taskId).singleResult();
        return Activiti5TaskDefinitionAdapter.getInstance().adapt(task);
    }

}
