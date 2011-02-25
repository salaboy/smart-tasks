/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.metamodel;

import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;

/**
 *
 * @author salaboy
 */
public class MetaTask {
   private Long id;
   private TTask task;
   private TTaskAbstract taskAbstract;
   
    public MetaTask(TTask task) {
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TTask getTask() {
        return task;
    }

    public void setTask(TTask task) {
        this.task = task;
    }

    public TTaskAbstract getTaskAbstract() {
        return taskAbstract;
    }

    public void setTaskAbstract(TTaskAbstract taskAbstract) {
        this.taskAbstract = taskAbstract;
    }

    public String getStringRepresentation() {
        return "id: "+id+" - meta: "+"base meta - "+"ttask:"+task.toString();
    }
    
    
   
         
}
