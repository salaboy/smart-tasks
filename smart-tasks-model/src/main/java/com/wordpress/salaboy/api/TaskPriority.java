/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

/**
 *
 * @author salaboy
 */
public class TaskPriority {
    private String description;
    private int severity;

    public TaskPriority(String description, int severity) {
        this.description = description;
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public int getSeverity() {
        return severity;
    }
    
    
}
