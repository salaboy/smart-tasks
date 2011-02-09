/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.jbpm5wrapper.model;

import org.example.ws_ht.api.TAttachmentInfo;

/**
 *
 * @author esteban
 */
public class JBPM5TAttachmentInfo extends TAttachmentInfo {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
