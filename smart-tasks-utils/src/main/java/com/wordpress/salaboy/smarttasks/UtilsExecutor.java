package com.wordpress.salaboy.smarttasks;

import java.util.HashMap;
import java.util.Map;

import com.wordpress.salaboy.smarttasks.taskform.TaskFormJsonGenerator;

/**
 * Main executor of the utils. It contains the action names to execute different
 * utils, and executes them.
 * 
 * @author calcacuervo
 * 
 */
public class UtilsExecutor {

	/**
	 * The mapping between the action names and the action to execute.
	 */
	private Map<String, Action> actionNamesMapping = new HashMap<String, Action>();

	/**
	 * Starts an action, given, its name and an string array of parameters. It
	 * will throw an {@link IllegalArgumentException} if it does not find an
	 * action for the given name.
	 * 
	 * @param name
	 *            the action name.
	 * @param params
	 *            the parameters to pass to the selected action.
	 */
	public void startAction(String name, String[] params) {
		Action action = actionNamesMapping.get(name);
		if (action == null) {
			throw new IllegalArgumentException(
					"There is no action associated to this action name");
		}
		action.execute(params);
	}

	/**
	 * Adds a new name-action mapping.
	 * @param name the action name.
	 * @param action the action to execute.
	 */
	private void addMapping(String name, Action action) {
		this.actionNamesMapping.put(name, action);
	}

	/**
	 * Utils class method to move elements in an array. 
	 * @param array the array.
	 * @param movements the movements.
	 * @return the string with the shifted elements.
	 */
	private static String[] moveElements(String[] array, int movements) {
		String[] newArray = new String[array.length + movements];
		for (int i = 0; i < array.length; i++) {
			String elem = array[i];
			if (i + movements >= 0) {
				newArray[i + movements] = elem;
			}
		}
		return newArray;
	}

	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		UtilsExecutor executor = new UtilsExecutor();
		executor.addMapping("taskformconfig", new TaskFormJsonGenerator());
		try {
			if (args[0] == null) {
				System.out.println("Could not find the given action.");
				usage();
			}
			executor.startAction(args[0], moveElements(args, -1));
		} catch (IllegalArgumentException e) {
			System.out.println("Could not find the given action.");
			usage();
		}
	}

	/**
	 * It will print the usage of the tool.
	 */
	private static void usage() {
		System.out
				.println("**************************USAGE*************************");
		System.out.println("java -jar thejar.jar <<actionName>> <<params>>");
		System.out.println("**Current actions:**");
		System.out
				.println("java -jar smart-tasks-console-utils-1.0-SNAPSHOT-jar-with-dependencies.jar taskformconfig full_path_of_bpmn directory_to_put_output");
	}
}
