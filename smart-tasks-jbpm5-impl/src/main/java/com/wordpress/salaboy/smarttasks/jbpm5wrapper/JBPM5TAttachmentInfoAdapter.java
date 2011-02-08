/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import com.wordpress.salaboy.api.TAttachmentInfoAdapter;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.util.XMLDataTypeUtils;
import java.util.ArrayList;
import java.util.List;
import org.example.ws_ht.api.TAttachmentInfo;
import org.jbpm.task.Attachment;

/**
 *
 * @author esteban
 */
public class JBPM5TAttachmentInfoAdapter implements TAttachmentInfoAdapter<Attachment> {

    public List<TAttachmentInfo> adaptCollection(List<Attachment> vendorAttachments) {
        List<TAttachmentInfo> tAttachmentsList = new ArrayList<TAttachmentInfo>();
        for (Attachment attachment : vendorAttachments) {
            tAttachmentsList.add(this.adapt(attachment));
        }
        return tAttachmentsList;
    }

    public TAttachmentInfo adapt(Attachment vendorAttachment) {
        TAttachmentInfo tAttachmentInfo = new TAttachmentInfo();
        tAttachmentInfo.setAccessType(vendorAttachment.getAccessType().name());
        tAttachmentInfo.setAttachedAt(XMLDataTypeUtils.convertDateToGregorianCalendar(vendorAttachment.getAttachedAt()));
        tAttachmentInfo.setAttachedBy(vendorAttachment.getAttachedBy().getId());
        tAttachmentInfo.setContentType(vendorAttachment.getContentType());
        tAttachmentInfo.setName(vendorAttachment.getName());
        
        return tAttachmentInfo;
    }

}
