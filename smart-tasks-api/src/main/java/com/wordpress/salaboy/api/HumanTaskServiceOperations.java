/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import org.example.ws_ht.api.wsdl.TaskOperations;

/**
 * Represents all the operations that a human task service must offer.
 * 
 * @author salaboy
 */
public interface HumanTaskServiceOperations extends TaskOperations,
		AuthorizedService, LocalizedService, ManagedService {

	/**
	 * Return the task originator type, to identify who the given task belongs
	 * to.
	 * 
	 * @param taskId
	 * @return
	 */
	public String getTaskOriginatorType(String taskId);
}
