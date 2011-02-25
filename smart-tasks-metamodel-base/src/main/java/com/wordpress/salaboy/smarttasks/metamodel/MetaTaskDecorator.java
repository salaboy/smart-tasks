/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.metamodel;

import java.util.List;
import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;

/**
 *
 * @author salaboy
 */
public interface MetaTaskDecorator <T extends MetaTask> {
   
    public  List<T> decorateList(List<TTask> tasks);
    
    public  T decorate(TTask tasks);
   
    public  List<T> decorateAbstractList(List<TTaskAbstract> taskAbstracts);
    
    public  T decorateAbstract(TTaskAbstract taskAbstract);
}
