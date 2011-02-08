/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smarttasks.activiti5wrapper.adapter;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.wordpress.salaboy.api.TaskAdapter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.namespace.QName;
import org.activiti.engine.task.Task;
import org.example.ws_ht.api.TTaskAbstract;

/**
 *
 * @author salaboy
 */
public class Activiti5TTaskAbstractAdapter implements TaskAdapter<TTaskAbstract, Task>{
    
    private static Activiti5TTaskAbstractAdapter adapter;

    private Activiti5TTaskAbstractAdapter() {
    }
    
    public static Activiti5TTaskAbstractAdapter getInstance(){
        if(adapter == null){
            adapter = new Activiti5TTaskAbstractAdapter();
        }
        return adapter;
    }
    
    
    public List<TTaskAbstract> adaptCollection(List<Task> vendorTasks) {
        List<TTaskAbstract> tasks = new ArrayList<TTaskAbstract>();
        for(Task task : vendorTasks){
            tasks.add(adapt(task));
        }
        return tasks;
    }

    public TTaskAbstract adapt(Task vendorTask) {
        TTaskAbstract taskAbstract = new TTaskAbstract();
        taskAbstract.setId(vendorTask.getId());
        taskAbstract.setName(new QName(vendorTask.getName()));
        //taskAbstract.set ->  vendorTask.getAssignee()
        taskAbstract.setPresentationName(vendorTask.getDescription());///not sure about this
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(vendorTask.getCreateTime());
        taskAbstract.setCreatedOn(new XMLGregorianCalendarImpl(calendar));
        taskAbstract.setPriority(BigInteger.valueOf(vendorTask.getPriority()));
                                 
        return taskAbstract;                        
                                  
                                  
    }

}
