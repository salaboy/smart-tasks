/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.worpdress.salaboy.api.TaskDefinition;
import java.util.List;

/**
 *
 * @author salaboy
 */
public interface TaskDefinitionAdapter<T,U> {
    public List<TaskDefinition> adaptCollection(List<T> vendorTasks);
    public TaskDefinition adapt(U vendorTask);
}
