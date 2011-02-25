/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.model;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTaskDecorator;
import java.util.ArrayList;
import java.util.List;

/**
 * The definition of a TaskList table.
 * @author esteban
 */
public class TaskListTableDefinition {
   public static final String DEFAULT_PROFILE_NAME = "Default";
   private String profile = DEFAULT_PROFILE_NAME;
   private String decorator;
   private List<TaskListTableColumnDefinition> columns = new ArrayList<TaskListTableColumnDefinition>();
   private String[][] rowsMetaData;

    public List<TaskListTableColumnDefinition> getColumns() {
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
