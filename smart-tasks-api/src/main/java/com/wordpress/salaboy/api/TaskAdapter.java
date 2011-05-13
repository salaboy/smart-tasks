/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.List;

import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;

/**
 * Adapter to adapt a task or collection of tasks T in a task U. It is useful
 * for the {@link HumanTaskServiceOperations} implementations to convert from
 * its specific task to an instance of {@link TTask} ot {@link TTaskAbstract}.
 * 
 * @author salaboy
 */
public interface TaskAdapter<T, U> {
	
	/**
	 * Adapts a collection of tasks.
	 * @param vendorTasks the tasks to adapt
	 * @return the adapter tasks.
	 */
	public List<T> adaptCollection(List<U> vendorTasks);

	/**
	 * Adapts a tasks in another task. 
	 * @param vendorTask
	 * @return
	 */
	public T adapt(U vendorTask);
}
