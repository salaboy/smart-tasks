/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.metamodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;

/**
 *
 * @author salaboy
 */
public class MetaTaskDecoratorService {
    
    private static MetaTaskDecoratorService instance = new MetaTaskDecoratorService();
    private Map<String, MetaTaskDecorator> decorators = new HashMap<String, MetaTaskDecorator>();
    public static MetaTaskDecoratorService getInstance(){
        return instance;
    }
    
    
    public void registerDecorator(String name, MetaTaskDecorator decorator){
        decorators.put(name, decorator);
    }
    
    public List<MetaTask> decorateList(String decorator, List<TTask> tasks){
        return decorators.get(decorator).decorateList(tasks);
    }
    
    public MetaTask decorate(String decorator, TTask task){
        return decorators.get(decorator).decorate(task);
    }
    public List<MetaTask> decorateAbstractList(String decorator, List<TTaskAbstract> taskAbstracts){
        return decorators.get(decorator).decorateAbstractList(taskAbstracts);
    }
    
    public MetaTask decorateAbstract(String decorator, TTaskAbstract taskAbstract){
        return decorators.get(decorator).decorateAbstract(taskAbstract);
    }
    
    
}
