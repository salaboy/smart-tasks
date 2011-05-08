/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The definition of a Task table.
 * @author esteban
 */
public class TaskTableDefinition {
   public static final String DEFAULT_PROFILE_NAME = "Default";
   private String profile = DEFAULT_PROFILE_NAME;
   private String decorator;
   private List<TaskPropertyDefinition> columns = new ArrayList<TaskPropertyDefinition>();
   private String[][] rowsMetaData;

    public List<TaskPropertyDefinition> getColumns() {
        return columns;
    }

    public String getProfile() {
        return profile;
    }

    public void setDecorator(String decorator) {
        this.decorator = decorator;
    }

    
    
    public String getDecorator() {
        return decorator;
    }
    
    
    public String[][] getRowsMetaData() {
        return this.rowsMetaData;
    }
   
}
