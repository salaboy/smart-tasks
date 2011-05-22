/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.api;

import java.util.Map;

import org.example.ws_ht.api.TTask;

import com.wordpress.salaboy.smarttasks.formbuilder.api.exception.InvalidTaskException;

/**
 * Represents a service to give support to a task interaction.
 * 
 * @author calcacuervo
 * 
 */
public interface TaskFormBuilder {

	/**
	 * Returns a map with the details of the {@link TTask}.
	 * @return a map with the details
	 * @throws InvalidTaskException if the task is not found.
	 */
	public Map<String, String> getTaskInput() throws InvalidTaskException;

	/**
	 * Return the name of the form inputs as the key, and default values as
	 * values of the map.
	 * @throws InvalidTaskException if the task is not found.
	 */
	public Map<String, String> getTaskOutput() throws InvalidTaskException;

	/**
	 * Returns the actions graph as an instance of {@link TaskOperationsDefinition}
	 * @throws InvalidTaskException if the task is not found.
	 */
	public TaskOperationsDefinition getTaskOperations() throws InvalidTaskException;

	/**
	 * Executes the desired action to the task.
	 * @param actionName the name of the action.
	 * @param data data given to this action.
	 * @throws InvalidTaskException if the task is not found.
	 */
	public void executeTaskAction(String actionName, Object data) throws InvalidTaskException;
}
