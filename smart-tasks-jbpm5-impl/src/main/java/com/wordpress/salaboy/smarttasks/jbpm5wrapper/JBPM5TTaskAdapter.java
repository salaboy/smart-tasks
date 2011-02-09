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
import org.example.ws_ht.api.TTask;
import org.jbpm.task.Task;

/**
 *
 * @author esteban
 */
public class JBPM5TTaskAdapter implements TaskAdapter<TTask, Task> {

    private static JBPM5TTaskAdapter adapter;

    private JBPM5TTaskAdapter() {
    }

    public static JBPM5TTaskAdapter getInstance() {
        if (adapter == null) {
            return new JBPM5TTaskAdapter();
        }
        return adapter;
    }

    public List<TTask> adaptCollection(List<Task> vendorTasks) {
        List<TTask> tasks = new ArrayList<TTask>();
        for (Task vendorTask : vendorTasks) {
            tasks.add(adapt(vendorTask));
        }
        return tasks;
    }

    public TTask adapt(Task vendorTask) {
        TTask task = new TTask();
        //task.setActivationTime();
        task.setActualOwner(vendorTask.getTaskData().getActualOwner().getId());
        task.setBusinessAdministrators(new JBPM5TOrganizationalEntityAdapter().adapt(vendorTask.getPeopleAssignments().getBusinessAdministrators()));
        //task.setCompleteByExists()
        if (vendorTask.getTaskData().getCreatedBy() != null){
            task.setCreatedBy(vendorTask.getTaskData().getCreatedBy().getId());
        }
        task.setCreatedOn(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorTask.getTaskData().getCreatedOn()));
        task.setDeadlinesInfo(new JBPM5TDeadlinesInfoAdapter().adapt(vendorTask.getDeadlines()));
        //task.setEscalated();
        task.setExpirationTime(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorTask.getTaskData().getExpirationTime()));
        task.setHasAttachments(vendorTask.getTaskData().getDocumentContentId() > 0 || !vendorTask.getTaskData().getAttachments().isEmpty());
        task.setHasComments(!vendorTask.getTaskData().getComments().isEmpty());
        //Rely on faultType to check if has fault or not
        task.setHasFault(vendorTask.getTaskData().getFaultType() != null && !vendorTask.getTaskData().getFaultType().isEmpty());
        //Rely on outputType to check if has output or not
        task.setHasOutput(vendorTask.getTaskData().getOutputType() != null && !vendorTask.getTaskData().getOutputType().isEmpty());
        task.setHasPotentialOwners(!vendorTask.getPeopleAssignments().getPotentialOwners().isEmpty());
        task.setId(String.valueOf(vendorTask.getId()));
        task.setIsSkipable(vendorTask.getTaskData().isSkipable());
        //@FIXME: Only getting the first I18N name!
        task.setName(new QName(vendorTask.getNames().get(0).getText()));
        task.setNotificationRecipients(new JBPM5TOrganizationalEntityAdapter().adapt(vendorTask.getPeopleAssignments().getRecipients()));
        task.setPotentialOwners(new JBPM5TOrganizationalEntityAdapter().adapt(vendorTask.getPeopleAssignments().getPotentialOwners()));
        //@FIXME: Only getting the first I18N name!. By the way, what presentation name is?
        task.setPresentationName(vendorTask.getNames().get(0).getText());
        //@FIXME: Only getting the first I18N name!
        if (!vendorTask.getSubjects().isEmpty()){
            task.setPresentationSubject(vendorTask.getSubjects().get(0).getText());
        }
        //task.setPrimarySearchBy();
        task.setPriority(BigInteger.valueOf(vendorTask.getPriority()));
        //task.setRenderingMethodExists();
        //task.setStartByExists();
        task.setStatus(new JBPM5TStatusAdapter().adapt(vendorTask.getTaskData().getStatus()));
        if (vendorTask.getPeopleAssignments().getTaskInitiator() != null){
            task.setTaskInitiator(vendorTask.getPeopleAssignments().getTaskInitiator().getId());
        }
        task.setTaskStakeholders(new JBPM5TOrganizationalEntityAdapter().adapt(vendorTask.getPeopleAssignments().getTaskStakeholders()));
        //task.setTaskType();

        return task;
    }
}
