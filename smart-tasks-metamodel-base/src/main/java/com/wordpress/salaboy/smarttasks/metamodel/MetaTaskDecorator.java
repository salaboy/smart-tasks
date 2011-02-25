/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.metamodel;

import java.util.List;
import org.example.ws_ht.api.TTask;

/**
 *
 * @author salaboy
 */
public interface MetaTaskDecorator <T extends MetaTask> {
   
    public  List<T> decorateList(List<TTask> tasks);
    
    public  T decorate(TTask tasks);
   
    
}
