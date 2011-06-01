package com.wordpress.salaboy.smarttasks.formbuilder.api.output;

import java.io.Serializable;
import java.util.Map;

/**
 * This class will keep the information about the task form output, which will be
 * serialized to be sent with YAML.
 * @author calcacuervo
 *
 */
public class TaskFormOutput implements Serializable {
    /**
     * The UID
     */
    private static final long serialVersionUID = 7809804080757523693L;

    /**
     * The ysdk form output.
     */
    public Map<String, Object> outputs;

    /**
     * Default constructor. Used by YAML to deserialize.
     */
    public TaskFormOutput() {
        // needed for yaml.
    }

    public TaskFormOutput(Map<String, Object> outputs) {
        this.outputs = outputs;
    }

    /**
     * @return the outputs
     */
    public Map<String, Object> getOutputs() {
        return outputs;
    }

    /**
     * @param outputs
     *            the outputs to set
     */
    public void setOutputs(Map<String, Object> outputs) {
        this.outputs = outputs;
    }

}
