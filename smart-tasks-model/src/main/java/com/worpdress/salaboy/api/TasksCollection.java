/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.api;

import java.util.List;



/**
 *
 * @author salaboy
 */
public class TasksCollection {
    
    private List<TaskDefinition> tasks;

    public TasksCollection(List<TaskDefinition> tasks) {
        this.tasks = tasks;
    }

    public List<TaskDefinition> getTasks() {
        return tasks;
    }
    
    
    
    
    
}
