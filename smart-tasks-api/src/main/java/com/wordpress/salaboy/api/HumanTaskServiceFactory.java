/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.api;

import com.wordpress.salaboy.conf.HumanTaskClientConfiguration;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory class to create a Human Task Service, given some
 * {@link HumanTaskServiceConfiguration}.
 * 
 * @author salaboy
 */
public class HumanTaskServiceFactory {

	/**
	 * Creates a new {@link HumanTaskService} instance, given a configuration.
	 * It simply gets the {@link HumanTaskClientConfiguration}s from the given
	 * {@link HumanTaskServiceConfiguration}, and creates the
	 * {@link HumanTaskService} with these {@link HumanTaskServiceOperations}
	 * for this configurations.
	 * 
	 * @param config
	 * @return a new {@link HumanTaskService} instance.
	 * @throws IllegalStateException
	 */
	public static HumanTaskService newHumanTaskService(
			HumanTaskServiceConfiguration config) throws IllegalStateException {
		List<HumanTaskServiceOperations> clientConfigs = new ArrayList<HumanTaskServiceOperations>();

		for (HumanTaskClientConfiguration humanTaskClientConfiguration : config
				.getHumanTaskClientConfigurations().values()) {
			clientConfigs.add(humanTaskClientConfiguration
					.getServiceOperationsImplementation());
		}

		HumanTaskService humanTaskService = new HumanTaskServiceImpl(
				clientConfigs);

		return humanTaskService;
	}

}
