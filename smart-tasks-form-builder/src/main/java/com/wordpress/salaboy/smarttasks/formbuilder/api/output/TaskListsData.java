package com.wordpress.salaboy.smarttasks.formbuilder.api.output;

import java.io.Serializable;

/**
 * This class will keep the information about the task list, which will be
 * serialized to be sent with YAML.
 * 
 * @author calcacuervo
 * 
 */
public class TaskListsData implements Serializable {

	/**
	 * The UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The task list data.
	 */
	private String[][] data;

	/**
	 * Default constructor used by yaml.
	 */
	public TaskListsData() {
		// Needed for deserialize with yaml.
	}

	public TaskListsData(final String[][] data, final String[] columnHeaders) {
		this.data = data;
		this.columnHeaders = columnHeaders;
	}

	/**
	 * The column headler of a task list.
	 */
	private String[] columnHeaders;

	/**
	 * @return the data
	 */
	public String[][] getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String[][] data) {
		this.data = data;
	}

	/**
	 * @return the columnHeaders
	 */
	public String[] getColumnHeaders() {
		return columnHeaders;
	}

	/**
	 * @param columnHeaders
	 *            the columnHeaders to set
	 */
	public void setColumnHeaders(String[] columnHeaders) {
		this.columnHeaders = columnHeaders;
	}

}
