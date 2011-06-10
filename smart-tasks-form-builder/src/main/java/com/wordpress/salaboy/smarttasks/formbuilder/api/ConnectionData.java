/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.api;

import java.util.Locale;

/**
 *
 * @author esteban
 */
public class ConnectionData {

    private String entityId;
    private Locale locale = Locale.US;

    public ConnectionData(String entityId) {
        super();
        this.entityId = entityId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    
    
}
