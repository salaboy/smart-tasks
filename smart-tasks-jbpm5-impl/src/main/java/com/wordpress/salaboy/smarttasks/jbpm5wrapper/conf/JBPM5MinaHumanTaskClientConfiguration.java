package com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf;

import java.util.Properties;

import org.drools.SystemEventListenerFactory;
import org.jbpm.task.service.TaskClientConnector;
import org.jbpm.task.service.mina.MinaTaskClientConnector;
import org.jbpm.task.service.mina.MinaTaskClientHandler;

/**
 * 
 * @author marianbuenosayres
 */
public class JBPM5MinaHumanTaskClientConfiguration extends JBPM5HumanTaskClientConfiguration {

	public JBPM5MinaHumanTaskClientConfiguration(String host, int port,
			Properties extraInfo) {
		super(host, port, extraInfo);
	}

	public JBPM5MinaHumanTaskClientConfiguration(String host, int port) {
		super(host, port);
	}
	
	public TaskClientConnector createConnector() {
    	return new MinaTaskClientConnector("jbpm5TaskClient", 
        	new MinaTaskClientHandler(
        		SystemEventListenerFactory.getSystemEventListener()
        	)
        );
	}
}
