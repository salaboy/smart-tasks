package com.wordpress.salaboy.smarttasks.taskform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import com.wordpress.salaboy.smarttasks.taskform.model.HumanTaskIO;

/**
 * Internal repository to manage information a human task. It is a singleton.
 * 
 * @author calcacuervo
 * 
 */
public class HumanTaskRepository {

	/**
	 * Instance to use.
	 */
	private static HumanTaskRepository instance = null;


	Collection<HumanTaskIO> humanTasks;
	
	/**
	 * Creates a new {@link HumanTaskRepository} . It is private.
	 */
	private HumanTaskRepository() {
		this.humanTasks = new ArrayList<HumanTaskIO>();
	}

	/**
	 * Returns an instance {@link HumanTaskRepository}. I will create a new
	 * instance the first time, other times it will return the same instance.
	 * 
	 * @return
	 */
	public static HumanTaskRepository getInstance() {
		if (instance == null) {
			instance = new HumanTaskRepository();
		}
		return instance;
	}
	
	public void addHumanTaskIO(String name, Collection<String> inputs, Collection<String> outputs) {
		HumanTaskIO newIo = new HumanTaskIO();
		newIo.setInputFields(inputs);
		newIo.setName(name);
		newIo.setOutputFields(outputs);
		this.humanTasks.add(newIo);
	}
	
	public void addIncrementalOutput(String name, String output) {
		for (HumanTaskIO taskIo : this.humanTasks) {
			if (name.equals(taskIo.getName())) {
				//exists...
				taskIo.addOutputField(output);
				return;
			}
		}
		//not exists
		HumanTaskIO newTaskIO = new HumanTaskIO();
		newTaskIO.setName(name);
		newTaskIO.addOutputField(output);
		this.humanTasks.add(newTaskIO);
	}

	public void addIncrementalInput(String name, String input) {
		for (HumanTaskIO taskIo : this.humanTasks) {
			if (name.equals(taskIo.getName())) {
				//exists...
				taskIo.addInputField(input);
				return;
			}
		}
		HumanTaskIO newTaskIO = new HumanTaskIO();
		newTaskIO.setName(name);
		newTaskIO.addInputField(input);
		this.humanTasks.add(newTaskIO);
	}
	/**
	 * @return the humanTasks
	 */
	public Collection<HumanTaskIO> getHumanTasks() {
		return humanTasks;
	}
	
	
}
