/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import java.util.Map;

/**
 * Interface that represents the smart tasks service, which composes
 * {@link HumanTaskServiceOperations}, to access transparently to one or many of them.
 * 
 * @author salaboy
 */
public interface HumanTaskService extends HumanTaskServiceOperations {

	/**
	 * Returns a map with the form NameOfImplementation->HumanTaskServiceOperations.
	 * @return
	 */
	public Map<String, HumanTaskServiceOperations> getTaskOperations();

}
