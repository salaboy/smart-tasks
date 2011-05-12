/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.conf;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration for human tasks service. Basically, it is a container of
 * {@link HumanTaskClientConfiguration}.
 * 
 * @author salaboy
 */
public class HumanTaskServiceConfiguration {
	
	/**
	 * Map with the form ConfigurationName-> {@link HumanTaskClientConfiguration}.
	 */
	private Map<String, HumanTaskClientConfiguration> clientConfs = new HashMap<String, HumanTaskClientConfiguration>();

	/**
	 * Adds a new {@link HumanTaskClientConfiguration}.
	 * @param name the name of the configuration.
	 * @param conf the configuration to add.
	 */
	public void addHumanTaskClientConfiguration(String name,
			HumanTaskClientConfiguration conf) {
		clientConfs.put(name, conf);
	}

	/**
	 * Returns the map of configurations.
	 * @return the map of configurations.
	 */
	public Map<String, HumanTaskClientConfiguration> getHumanTaskClientConfigurations() {
		return this.clientConfs;
	}

}
