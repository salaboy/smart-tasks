package com.wordpress.salaboy.smarttasks.formbuilder.api.output;

import java.io.Serializable;

/**
 * This class will keep the information about the task list metadata keys, which
 * will be serialized yo be sent with YAML.
 * 
 * @author calcacuervo
 * 
 */
public class TaskListRowMetadataKeys implements Serializable {

    /**
     *  The UID-
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The keys.
     */
    private String[] keys;

    /**
     * Default constructor used by yaml.
     */
    public TaskListRowMetadataKeys() {
        // Needed for yaml.
    }

    public TaskListRowMetadataKeys(final String[] theKeys) {
        this.keys = theKeys;
    }

    /**
     * @return the keys
     */
    public String[] getKeys() {
        return keys;
    }

    /**
     * @param keys
     *            the keys to set
     */
    public void setKeys(String[] keys) {
        this.keys = keys;
    }

}
