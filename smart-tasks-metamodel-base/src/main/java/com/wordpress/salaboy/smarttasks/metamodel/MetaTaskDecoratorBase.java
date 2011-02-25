/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.metamodel;

import java.util.ArrayList;
import java.util.List;
import org.example.ws_ht.api.TTask;

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
    
}
