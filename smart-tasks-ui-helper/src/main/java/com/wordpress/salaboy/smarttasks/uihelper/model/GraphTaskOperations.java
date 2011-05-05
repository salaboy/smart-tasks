package com.wordpress.salaboy.smarttasks.uihelper.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.wordpress.salaboy.smarttasks.uihelper.api.TaskOperationsDefinition;

/**
 * Represents the task operations as a graph which is generated from a json
 * file.
 * 
 * @author calcacuervo
 * 
 */
public class GraphTaskOperations implements TaskOperationsDefinition {

	/**
	 * The root definitions. Each definition has its children internally.
	 */
	private Collection<OperationsDefinition> definition;

	/**
	 * Creates a new instance of {@link GraphTaskOperations}, and reads the
	 * definition from a given json file.
	 * 
	 * @param graphConfigurationFile
	 *            the json configuration file.
	 * @throws JsonParseException
	 *             if it was not able to parse the json file.
	 * @throws FileNotFoundException
	 *             if json config file was not found.
	 */
	public GraphTaskOperations(File graphConfigurationFile)
			throws JsonParseException, FileNotFoundException {
		Gson gson = new Gson();

		this.definition = gson.fromJson(new FileReader(graphConfigurationFile),
				new TypeToken<Collection<OperationsDefinition>>() {
				}.getType());

	}

	/**
	 * Returns the next tasks given a task. It returns null if its was not able
	 * to find it.
	 */
	@Override
	public List<String> getNextTasks(String task) {
		for (OperationsDefinition def : this.definition) {
			if (task.equalsIgnoreCase(def.getName())) {
				List<String> nextTasks = new ArrayList<String>();
				if (def.getNext() != null) {
					for (DestinationDefinition destination : def.getNext()) {
						nextTasks.add(destination.getName());
					}
				}
				return nextTasks;
				
			}
		}
		return null;
	}

	/**
	 * Returns a list with all possible operations.
	 */
	@Override
	public List<String> getOperationsList() {
		List<String> operationsList = new ArrayList<String>();
		for (OperationsDefinition def : this.definition) {
			operationsList.add(def.getName());
		}
		return operationsList;
	}

	/**
	 * Returns the starting operations.
	 */
	@Override
	public List<String> getRootOperations() {
		List<String> operationsList = new ArrayList<String>();
		for (OperationsDefinition def : this.definition) {
			if (def.isRoot()) {
				operationsList.add(def.getName());
			}
		}
		return operationsList;
	}

	/**
	 * Class used to define the structure of the graph. It is internal to
	 * {@link GraphTaskOperations}
	 * 
	 * @author calcacuervo
	 * 
	 */
	private static class OperationsDefinition {
		
		private String name;

		private Collection<DestinationDefinition> next;

		private boolean isRoot;

		private boolean isEnd;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 * 
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the next
		 */
		public Collection<DestinationDefinition> getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(Collection<DestinationDefinition> next) {
			this.next = next;
		}

		/**
		 * @return the isRoot
		 */
		public boolean isRoot() {
			return isRoot;
		}

		/**
		 * @param isRoot
		 *            the isRoot to set
		 */
		public void setRoot(boolean isRoot) {
			this.isRoot = isRoot;
		}

		/**
		 * @return the isEnd
		 */
		public boolean isEnd() {
			return isEnd;
		}

		/**
		 * @param isEnd
		 *            the isEnd to set
		 */
		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}

	}
	
	/**
	 * Definition of a destination node.
	 *
	 * @author calcacuervo
	 *
	 */
	private static class DestinationDefinition {
		
		private String name;

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
		
	}
}
