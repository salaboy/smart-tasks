/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.api.TaskAdapter;

import com.wordpress.salaboy.smarttasks.jbpm5wrapper.util.XMLDataTypeUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.example.ws_ht.api.TTaskAbstract;
import org.jbpm.task.query.TaskSummary;

/**
 *
 * @author salaboy
 * @author esteban
 */

public class JBPM5TTaskAbstractAdapter implements TaskAdapter<TTaskAbstract, TaskSummary> {


    private static JBPM5TTaskAbstractAdapter adapter;

    private JBPM5TTaskAbstractAdapter() {
    }

    public static JBPM5TTaskAbstractAdapter getInstance() {
        if (adapter == null) {
            return new JBPM5TTaskAbstractAdapter();
        }
        return adapter;
    }

    public List<TTaskAbstract> adaptCollection(List<TaskSummary> vendorTasks) {
        List<TTaskAbstract> tasks = new ArrayList<TTaskAbstract>();
        for (TaskSummary taskSum : vendorTasks) {
            tasks.add(adapt(taskSum));
        }
        return tasks;
    }

    public TTaskAbstract adapt(TaskSummary vendorTaskSummary) {
        TTaskAbstract taskAbstract = new TTaskAbstract();
        taskAbstract.setActivationTime(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorTaskSummary.getActivationTime()));
        //taskAbstract.setCompleteByExists();
        taskAbstract.setCreatedOn(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorTaskSummary.getCreatedOn()));
        //taskAbstract.setDeadlinesInfo();
        //taskAbstract.setEscalated();
        taskAbstract.setExpirationTime(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorTaskSummary.getExpirationTime()));
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
    }
}
