/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.api.TaskAdapter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.example.ws_ht.api.TTaskAbstract;
import org.jbpm.task.query.TaskSummary;

/**
 *
 * @author salaboy
 * @author esteban
 */
public class JBPM5TTaskAbstractAdapter implements TaskAdapter<TTaskAbstract, TaskSummary>{

    private static JBPM5TTaskAbstractAdapter adapter;

    private JBPM5TTaskAbstractAdapter() {
    }
    
    public static JBPM5TTaskAbstractAdapter getInstance(){
        if(adapter == null){
            return new JBPM5TTaskAbstractAdapter();
        }
        return adapter;
    } 
    
    public  List<TTaskAbstract> adaptCollection(List<TaskSummary> vendorTasks) {
        List<TTaskAbstract> tasks = new ArrayList<TTaskAbstract>();
        for(TaskSummary taskSum : vendorTasks){
            tasks.add(adapt(taskSum));
        }
        return tasks;
    }

    public  TTaskAbstract adapt(TaskSummary vendorTaskSummary) {
        try {
            TTaskAbstract taskAbstract = new TTaskAbstract();
            taskAbstract.setActivationTime(this.convertDateToGregorianCalendar(vendorTaskSummary.getActivationTime()));
            //taskAbstract.setCompleteByExists();
            taskAbstract.setCreatedOn(this.convertDateToGregorianCalendar(vendorTaskSummary.getCreatedOn()));
            //taskAbstract.setDeadlinesInfo();
            //taskAbstract.setEscalated();
            taskAbstract.setExpirationTime(this.convertDateToGregorianCalendar(vendorTaskSummary.getExpirationTime()));
            //taskAbstract.setHasAttachments();
            //taskAbstract.setHasComments();
            //taskAbstract.setHasFault();
            //taskAbstract.setHasOutput();
            //taskAbstract.setHasPotentialOwners();
            taskAbstract.setId(String.valueOf(vendorTaskSummary.getId()));
            taskAbstract.setIsSkipable(vendorTaskSummary.isSkipable());
            taskAbstract.setName(new QName(vendorTaskSummary.getName()));
            taskAbstract.setPresentationName(vendorTaskSummary.getName());
            taskAbstract.setPresentationSubject(vendorTaskSummary.getSubject());
            taskAbstract.setPriority(BigInteger.valueOf(vendorTaskSummary.getPriority()));
            //taskAbstract.setRenderingMethodExists();
            //taskAbstract.setStartByExists();
            taskAbstract.setStatus(new JBPM5TStatusAdapter().adapt(vendorTaskSummary.getStatus()));
            //taskAbstract.setTaskType();
            
            return taskAbstract;
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(JBPM5TTaskAbstractAdapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException(ex);
        }
    }

    private XMLGregorianCalendar convertDateToGregorianCalendar(Date date) throws DatatypeConfigurationException{
        if (date == null){
            return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
}
