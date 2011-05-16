package com.wordpress.salaboy.smarttasks;

/**
 * Represents an action to be executed with some parameters.
 * @author calcacuervo
 *
 */
public interface Action {

	/**
	 * Executes an action.
	 * @param params an string array.
	 */
	public void execute(String[] params);
}
