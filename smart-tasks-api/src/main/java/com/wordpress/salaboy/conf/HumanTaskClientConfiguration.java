/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.conf;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;

/**
 * Represents a single human task client configuration, which has a type, and some operations
 * represented by {@link HumanTaskServiceOperations}.
 * 
 * @author salaboy
 */
public interface HumanTaskClientConfiguration {

	/**
	 * Returns an type for this configuration.
	 * 
	 * @return
	 */
	String getType();

	/**
	 * Returns the {@link HumanTaskServiceOperations} for this client.
	 * 
	 * @return an instance of {@link HumanTaskServiceOperations}.
	 */
	HumanTaskServiceOperations getServiceOperationsImplementation();
}
