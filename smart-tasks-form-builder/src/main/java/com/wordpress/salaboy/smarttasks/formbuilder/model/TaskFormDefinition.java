/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The definition of a Task view.
 * @author esteban
 */
public class TaskFormDefinition implements CustomizableDefinition {
   public static final String DEFAULT_PROFILE_NAME = "Default";
   private String profile = DEFAULT_PROFILE_NAME;
   private String decorator;
   private List<TaskPropertyDefinition> inputFields = new ArrayList<TaskPropertyDefinition>();
   private List<TaskPropertyDefinition> outputFields = new ArrayList<TaskPropertyDefinition>();
   private String[][] rowsMetaData;


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

	/**
	 * @return the inputFields
	 */
	public List<TaskPropertyDefinition> getInputFields() {
		return inputFields;
	}

	/**
	 * @param inputFields the inputFields to set
	 */
	public void setInputFields(List<TaskPropertyDefinition> inputFields) {
		this.inputFields = inputFields;
	}

	/**
	 * @return the outputFields
	 */
	public List<TaskPropertyDefinition> getOutputFields() {
		return outputFields;
	}

	/**
	 * @param outputFields the outputFields to set
	 */
	public void setOutputFields(List<TaskPropertyDefinition> outputFields) {
		this.outputFields = outputFields;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
    
}
