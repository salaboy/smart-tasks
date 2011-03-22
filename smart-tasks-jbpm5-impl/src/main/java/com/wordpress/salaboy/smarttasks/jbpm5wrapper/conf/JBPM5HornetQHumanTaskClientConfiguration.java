package com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf;

import com.wordpress.salaboy.api.HumanTaskServiceOperations;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.JBPM5HumanTaskServiceOperations;
import java.util.Properties;

import org.drools.SystemEventListenerFactory;
import org.jbpm.task.service.TaskClientConnector;
import org.jbpm.task.service.hornetq.HornetQTaskClientConnector;
import org.jbpm.task.service.hornetq.HornetQTaskClientHandler;

/**
 * 
 * @author marianbuenosayres
 */
public class JBPM5HornetQHumanTaskClientConfiguration extends JBPM5HumanTaskClientConfiguration {

	public JBPM5HornetQHumanTaskClientConfiguration(String host, int port,
			Properties extraInfo) {
		super(host, port, extraInfo);
	}

	public JBPM5HornetQHumanTaskClientConfiguration(String host, int port) {
		super(host, port);
	}
	
	public TaskClientConnector createConnector() {
		return new HornetQTaskClientConnector(
			"jbpm5TaskClient",
			new HornetQTaskClientHandler(
				SystemEventListenerFactory.getSystemEventListener()
			)
		);
	}

    @Override
    public HumanTaskServiceOperations getServiceOperationsImplementation() {
        return new JBPM5HumanTaskServiceOperations(this);
    }
}
