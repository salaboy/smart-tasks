package com.wordpress.salaboy.smarttasks.formbuilder.api.output;

import java.io.Serializable;
import java.util.Map;

/**
 * This class will keep the information about the task form input, which will be
 * serialized yo be sent with YAML.
 * 
 * @author calcacuervo
 * 
 */
public class TaskForm implements Serializable {

    /**
     *  The UID.
     */
    private static final long serialVersionUID = -4314574459848148630L;

    /**
     * The inputs map.
     */
    public Map<String, Object> inputs;

    /**
     * The outputs map.
     */
    public Map<String, Object> outputs;
    public TaskForm() {
        // needed for yaml.
    }

    public TaskForm(Map<String, Object> inputs) {
        this.inputs = inputs;
    }

    /**
     * @return the inputs
     */
    public Map<String, Object> getInputs() {
        return inputs;
    }

    /**
     * @param inputs
     *            the inputs to set
     */
    public void setInputs(Map<String, Object> inputs) {
        this.inputs = inputs;
    }

	/**
	 * @return the outputs
	 */
	public Map<String, Object> getOutputs() {
		return outputs;
	}

	/**
	 * @param outputs the outputs to set
	 */
	public void setOutputs(Map<String, Object> outputs) {
		this.outputs = outputs;
	}

}
