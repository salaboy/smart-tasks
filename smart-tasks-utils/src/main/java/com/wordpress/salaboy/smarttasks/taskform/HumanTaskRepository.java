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

	/**
	 * @return the humanTasks
	 */
	public Collection<HumanTaskIO> getHumanTasks() {
		return humanTasks;
	}
	
	
}
