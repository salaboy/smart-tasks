package com.wordpress.salaboy.smarttasks.formbuilder.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.example.ws_ht.api.wsdl.TaskOperations;

import com.wordpress.salaboy.api.HumanTaskService;

/**
 * This utility class helps to execute a {@link TaskOperations} action.
 * 
 * @author calcacuervo
 * 
 */
public class ActionExecutionHelper {

	/**
	 * Executes a {@link TaskOperations} method given its name and parameters.
	 * 
	 * @param methodName
	 *            the method name.
	 * @param service
	 *            the {@link HumanTaskService} that will execute the action.
	 * @param tasksId
	 *            the task id. This will be one of the parameters.
	 * @param data
	 *            the data to pass.
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void executeAction(String methodName,
			HumanTaskService service, String tasksId, Object data)
			throws IOException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		Method[] methods = TaskOperations.class.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().equalsIgnoreCase(methodName)) {
				if (method.getName().equalsIgnoreCase("complete")) {
					// two parameters
					method.invoke(service, tasksId, data);
				}
				else if (method.getName().equalsIgnoreCase("fail")) {
					// three parameters
					// TODO check this parameters
					method.invoke(service, tasksId, "fail", null);
				}
				else {
					method.invoke(service, tasksId);
				}
			}
		}

	}
}
