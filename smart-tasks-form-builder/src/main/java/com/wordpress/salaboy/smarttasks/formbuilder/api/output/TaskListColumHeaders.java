package com.wordpress.salaboy.smarttasks.formbuilder.api.output;

import java.io.Serializable;

/**
 * This class will keep the information about the task list column headers, which will be
 * serialized to be sent with YAML.
 * @author calcacuervo
 *
 */
public class TaskListColumHeaders implements Serializable {

    /**
     * The UID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The column headler of a task list.
     */
    private String[] columnHeaders;

    /**
     * Default constructor. Used by YAML.
     */
    public TaskListColumHeaders() {
        // Needed for yaml.
    }

    public TaskListColumHeaders(final String[] columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    /**
     * @return the columnHeaders
     */
    public String[] getColumnHeaders() {
        return columnHeaders;
    }

    /**
     * @param columnHeaders
     *            the columnHeaders to set
     */
    public void setColumnHeaders(String[] columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

}
