/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.smarttasks.jbpm5wrapper.model.JBPM5TAttachmentInfo;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.util.XMLDataTypeUtils;
import java.util.ArrayList;
import java.util.List;
import org.jbpm.task.Attachment;
import org.jbpm.task.Task;

/**
 *
 * @author esteban
 */
public class JBPM5TAttachmentInfoAdapter{

    public List<JBPM5TAttachmentInfo> getTaskTAttachmentInfo(Task jbpm5Task){
        return this.getTaskTAttachmentInfo(jbpm5Task, null);
    }
    
    public List<JBPM5TAttachmentInfo> getTaskTAttachmentInfo(Task jbpm5Task, String attachmentName){
        List<JBPM5TAttachmentInfo> tAttachmentsList = new ArrayList<JBPM5TAttachmentInfo>();
        
        JBPM5TAttachmentInfo taskDocument = this.adaptTaskDocument(jbpm5Task, attachmentName);
        if (taskDocument != null){
            tAttachmentsList.add(taskDocument);
        }
        
        if (jbpm5Task.getTaskData().getAttachments() != null){
            tAttachmentsList.addAll(this.adaptCollection(jbpm5Task.getTaskData().getAttachments(), attachmentName));
        }
        
        return tAttachmentsList;
    }
    
    /**
     * Avoid using this method directly, use {@link #getTaskTAttachmentInfo(org.jbpm.task.Task) }
     * @param vendorAttachments
     * @return 
     */
    public List<JBPM5TAttachmentInfo> adaptCollection(List<Attachment> vendorAttachments) {
        return this.adaptCollection(vendorAttachments, null);
    }
    
    private List<JBPM5TAttachmentInfo> adaptCollection(List<Attachment> vendorAttachments, String attachmentName) {
        List<JBPM5TAttachmentInfo> tAttachmentsList = new ArrayList<JBPM5TAttachmentInfo>();
        for (Attachment attachment : vendorAttachments) {
            if (attachmentName == null || (attachmentName!= null && attachment.getName().equals(attachmentName))){
                tAttachmentsList.add(this.adapt(attachment));
            }
        }
        return tAttachmentsList;
    }

    public JBPM5TAttachmentInfo adapt(Attachment vendorAttachment) {
        JBPM5TAttachmentInfo tAttachmentInfo = new JBPM5TAttachmentInfo();
        tAttachmentInfo.setAccessType(vendorAttachment.getAccessType().name());
        tAttachmentInfo.setAttachedAt(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorAttachment.getAttachedAt()));
        tAttachmentInfo.setAttachedBy(vendorAttachment.getAttachedBy().getId());
        tAttachmentInfo.setContentType(vendorAttachment.getContentType());
        tAttachmentInfo.setName(vendorAttachment.getName());
        tAttachmentInfo.setId(vendorAttachment.getId());
        
        return tAttachmentInfo;
    }
    
    private JBPM5TAttachmentInfo adaptTaskDocument(Task jbpm5Task, String attachmentName) {
        //@FIXME: propbably a bad name!
        String taskDocumentAttachmentName = "JBPM5TaskDocument"; 
                
        if (jbpm5Task.getTaskData().getDocumentContentId() <= 0){
            return null;
        }
        
        if (attachmentName != null && !taskDocumentAttachmentName.equals(attachmentName)){
            return null;
        }
        
        JBPM5TAttachmentInfo tAttachmentInfo = new JBPM5TAttachmentInfo();
        tAttachmentInfo.setAccessType(jbpm5Task.getTaskData().getDocumentAccessType().toString());
        //@FIXME: createdOn is not the same as attachedAt
        tAttachmentInfo.setAttachedAt(XMLDataTypeUtils.convertDateToGregorianCalendar(jbpm5Task.getTaskData().getCreatedOn()));
        //@FIXME: createdBy is not the same as attachedBy
        if (jbpm5Task.getTaskData().getCreatedBy() != null){
            tAttachmentInfo.setAttachedBy(jbpm5Task.getTaskData().getCreatedBy().getId());
        }
        tAttachmentInfo.setContentType(jbpm5Task.getTaskData().getDocumentType());
        tAttachmentInfo.setName(taskDocumentAttachmentName);
        
        tAttachmentInfo.setId(jbpm5Task.getTaskData().getDocumentContentId());
        
        return tAttachmentInfo;
    }

}
