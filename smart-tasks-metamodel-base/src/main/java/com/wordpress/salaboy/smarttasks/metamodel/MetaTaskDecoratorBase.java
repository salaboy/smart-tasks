/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.metamodel;

import java.util.ArrayList;
import java.util.List;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;

/**
 *
 * @author salaboy
 */
public class MetaTaskDecoratorBase implements MetaTaskDecorator<MetaTask>{

   
    
    
    public  List<MetaTask> decorateList(List<TTask> tasks) {
        List<MetaTask> decoratedList = new ArrayList<MetaTask>(tasks.size());
        for(TTask task : tasks){
            decoratedList.add(new MetaTask(task));
        }
        return decoratedList;
    }

    
    public  MetaTask decorate(TTask task) {
        return new MetaTask(task);
    }

    public List<MetaTask> decorateAbstractList(List<TTaskAbstract> taskAbstracts) {
       List<MetaTask> decoratedList = new ArrayList<MetaTask>(taskAbstracts.size());
        for(TTaskAbstract taskAbstract : taskAbstracts){
            decoratedList.add(new MetaTask(taskAbstract));
        }
        return decoratedList;
    }

    public MetaTask decorateAbstract(TTaskAbstract taskAbstract) {
        return new MetaTask(taskAbstract);
    }
    
}
