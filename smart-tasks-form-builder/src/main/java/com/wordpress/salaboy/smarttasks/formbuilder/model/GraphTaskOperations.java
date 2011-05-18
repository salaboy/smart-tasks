package com.wordpress.salaboy.smarttasks.formbuilder.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.wordpress.salaboy.smarttasks.formbuilder.api.TaskOperationsDefinition;

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
	 * Returns a list with all possible operations.
	 */
	@Override
	public List<String> getOperationsList() {
		Set<String> operationsList = new HashSet<String>();
		for (OperationsDefinition def : this.definition) {
			if ((def.getTransitions() != null)) {
				for (DestinationDefinition destination : def.getTransitions()) {
					operationsList.add(destination.getAction());
				}
			}
		}
		return new ArrayList<String>(operationsList);
	}

	/**
	 * Returns the operations for a given state.
	 */
	@Override
	public List<String> getOperations(String state) {
		List<String> operationsList = new ArrayList<String>();
		for (OperationsDefinition def : this.definition) {
			if (state.equals(def.getName())) {
				if ((def.getTransitions() != null)) {
					for (DestinationDefinition operations : def
							.getTransitions()) {
						operationsList.add(operations.getAction());
					}
				}
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

		private Collection<DestinationDefinition> transitions;

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
		public Collection<DestinationDefinition> getTransitions() {
			return transitions;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setTransitions(Collection<DestinationDefinition> transitions) {
			this.transitions = transitions;
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

		private String action;

		private String methodMapping;

		/**
		 * @param methodMapping
		 *            the methodMapping to set
		 */
		public void setMethodMapping(String methodMapping) {
			this.methodMapping = methodMapping;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

	}
}
