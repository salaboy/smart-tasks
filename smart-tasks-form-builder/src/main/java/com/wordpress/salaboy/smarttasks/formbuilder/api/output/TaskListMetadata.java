package com.wordpress.salaboy.smarttasks.formbuilder.api.output;

import java.io.Serializable;

/**
 * This class will keep the information about the task list metadata, which will be
 * serialized yo be sent with YAML.
 * @author calcacuervo
 *
 */
public class TaskListMetadata implements Serializable {

    /**
     * The UID.
     */
    private static final long serialVersionUID = 7116654274925961182L;
    
    /**
     * This represents the metadata.
     */
    private Object[][] data;

    /**
     * Default Constructor used by yaml.
     */
    public TaskListMetadata() {
        // needed for yaml.
    }

    public TaskListMetadata(Object[][] data) {
        this.data = data;
    }

    /**
     * @return the data
     */
    public Object[][] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object[][] data) {
        this.data = data;
    }

}
