package com.wordpress.salaboy.smarttasks.formbuilder.api.output;

import java.io.Serializable;

/**
 * This class will keep the information about the task list, which will be
 * serialized to be sent with YAML.
 * @author calcacuervo
 *
 */
public class TaskListsData implements Serializable {

    /**
     * The UID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The task list data.
     */
    private Object[][] data;
    
    /**
     * Default constructor used by yaml.
     */
    public TaskListsData() {
      //Needed for deserialize with yaml.
    }
    public TaskListsData(final Object[][] data) {
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
