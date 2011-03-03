package com.wordpress.salaboy.smarttasks.jbpm5wrapper;

import org.drools.SystemEventListenerFactory;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.hornetq.HornetQTaskClientConnector;
import org.jbpm.task.service.hornetq.HornetQTaskClientHandler;

import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5HumanTaskClientConfiguration;

/**
 * 
 * @author marianbuenosayres
 */
public class JBPM5HornetQHumanTaskServiceOperations extends
		JBPM5HumanTaskServiceOperations {

	public JBPM5HornetQHumanTaskServiceOperations(
			JBPM5HumanTaskClientConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	protected TaskClient createTaskClient(
			JBPM5HumanTaskClientConfiguration configuration) {
		HornetQTaskClientConnector hornetqTaskClientConnector = 
            new HornetQTaskClientConnector("jBPM5TaskClient", 
                new HornetQTaskClientHandler(SystemEventListenerFactory.getSystemEventListener()));
    	return new TaskClient(hornetqTaskClientConnector);
	}

}
