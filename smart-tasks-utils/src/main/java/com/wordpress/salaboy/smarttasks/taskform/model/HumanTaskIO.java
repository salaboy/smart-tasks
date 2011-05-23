package com.wordpress.salaboy.smarttasks.taskform.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Represents the information of a human task input/output.
 * @author calcacuervo
 *
 */
public class HumanTaskIO {

	/**
	 * The name of the human task.
	 */
	private String name;
	
	/**
	 * The input fields name of a human task.
	 */
	private Collection<String> inputFields = new HashSet<String>();

	/**
	 * The output fields name of a human task.
	 */
	private Collection<String> outputFields = new HashSet<String>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the inputFields
	 */
	public Collection<String> getInputFields() {
		return inputFields;
	}

	/**
	 * @param inputFields the inputFields to set
	 */
	public void setInputFields(Collection<String> inputFields) {
		this.inputFields = inputFields;
	}

	/**
	 * @return the outputFields
	 */
	public Collection<String> getOutputFields() {
		return outputFields;
	}

	/**
	 * @param outputFields the outputFields to set
	 */
	public void setOutputFields(Collection<String> outputFields) {
		this.outputFields = outputFields;
	}
	
	public void addOutputField(String output) {
		this.outputFields.add(output);
	}
	
	public void addInputField(String input) {
		this.inputFields.add(input);
	}

	public boolean equals(Object o) {
		if (!(o instanceof HumanTaskIO)) {
			return false;
		}
		HumanTaskIO otherTaskIO = (HumanTaskIO) o;
		if (this == otherTaskIO) {
			return true;
		}
		return this.getName().endsWith(otherTaskIO.getName());
	}
	
	

}
