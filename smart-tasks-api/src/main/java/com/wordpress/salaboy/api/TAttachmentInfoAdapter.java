/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.List;
import org.example.ws_ht.api.TAttachmentInfo;

/**
 *
 * @author esteban
 */
public interface TAttachmentInfoAdapter<T> {
    public List<TAttachmentInfo> adaptCollection(List<T> vendorAttachments);
    public TAttachmentInfo adapt(T vendorAttachment);
}
