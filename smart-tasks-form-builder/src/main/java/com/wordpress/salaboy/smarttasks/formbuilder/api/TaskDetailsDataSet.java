package com.wordpress.salaboy.smarttasks.formbuilder.api;

import java.util.Map;

/**
 * Represents a set of information about a task.
 * 
 * @author calcacuervo
 * 
 */
public interface TaskDetailsDataSet {

	/**
	 * Returns details and input of a task in a form of a {@link Map}.
	 * 
	 * @return a map with task details.
	 */
	Map<String, String> getTaskInputs();

	/**
	 * Returns needed task output in a form of a {@link Map}. The key will be
	 * the output name and the value, a default value.
	 * 
	 * @return a {@link Map}
	 */
	Map<String, String> getTaskOutputs();
}
