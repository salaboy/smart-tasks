/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.api;

import java.util.Map;

import org.example.ws_ht.api.TTask;

/**
 * Represents a service to give support to a task interaction.
 * 
 * @author calcacuervo
 * 
 */
public interface TaskFormBuilder {

	/**
	 * Returns a map with the details of the {@link TTask}.
	 */
	public Map<String, String> getTaskInput();

	/**
	 * Return the name of the form inputs as the key, and default values as
	 * values of the map.
	 */
	public Map<String, String> getTaskOutput();

	/**
	 * Returns the actions graph as an instance of {@link TaskOperationsDefinition}
	 */
	public TaskOperationsDefinition getTaskOperations();

	/**
	 * Executes the desired action to the task.
	 * @param actionName the name of the action.
	 * @param data data given to this action.
	 */
	public void executeTaskAction(String actionName, Object data);
}
