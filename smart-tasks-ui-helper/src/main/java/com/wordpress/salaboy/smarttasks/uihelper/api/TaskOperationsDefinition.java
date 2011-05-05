package com.wordpress.salaboy.smarttasks.uihelper.api;

import java.util.List;

/**
 * Represents a service that gives information about the possible actions to a
 * task.
 * 
 * @author calcacuervo
 * 
 */
public interface TaskOperationsDefinition {

	/**
	 * Returns the name of the initial operations of tasks.
	 * 
	 * @return
	 */
	public List<String> getRootOperations();

	/**
	 * Returns the operations list.
	 * 
	 * @return
	 */
	public List<String> getOperationsList();

	/**
	 * Given a task, returns the next tasks in the graph.
	 * 
	 * @param task
	 *            the origin.
	 * @return the destinations from the origin.
	 */
	public List<String> getNextTasks(String task);

}
