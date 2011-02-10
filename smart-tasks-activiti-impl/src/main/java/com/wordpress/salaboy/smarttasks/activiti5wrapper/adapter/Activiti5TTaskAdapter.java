/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.activiti5wrapper.adapter;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.wordpress.salaboy.api.TaskAdapter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.namespace.QName;
import org.activiti.engine.task.Task;
import org.example.ws_ht.api.TTask;

/**
 *
 * @author salaboy
 */
public class Activiti5TTaskAdapter implements TaskAdapter<TTask, Task>{
    
    private static Activiti5TTaskAdapter adapter;

    private Activiti5TTaskAdapter() {
    }
    
    public static Activiti5TTaskAdapter getInstance(){
        if(adapter == null){
            adapter = new Activiti5TTaskAdapter();
        }
        return adapter;
    }
    
    
    public List<TTask> adaptCollection(List<Task> vendorTasks) {
        List<TTask> tasks = new ArrayList<TTask>();
        for(Task task : vendorTasks){
            tasks.add(adapt(task));
        }
        return tasks;
    }

    public TTask adapt(Task vendorTask) {
        TTask task = new TTask();
        task.setId(vendorTask.getId());
        task.setName(new QName(vendorTask.getName()));
        task.setActualOwner(vendorTask.getAssignee());
        task.setPresentationName(vendorTask.getDescription());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(vendorTask.getCreateTime());
        task.setCreatedOn(new XMLGregorianCalendarImpl(calendar));
        task.setPriority(BigInteger.valueOf(vendorTask.getPriority()));                       
        return task;                        
                                  
                                  
    }

}
