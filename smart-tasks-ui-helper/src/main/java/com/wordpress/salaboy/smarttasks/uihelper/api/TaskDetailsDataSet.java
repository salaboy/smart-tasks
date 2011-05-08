package com.wordpress.salaboy.smarttasks.uihelper.api;

import java.util.Map;

/**
 * Represents a set of information about a task.
 * 
 * @author calcacuervo
 * 
 */
public interface TaskDetailsDataSet {

	/**
	 * Returns details of a task in a form of a {@link Map}.
	 * 
	 * @return a map with task details.
	 */
	Map<String, String> getTaskDetails();
}
