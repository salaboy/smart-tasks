package com.wordpress.salaboy.smarttasks.server.activiti;

import java.sql.SQLException;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.h2.tools.Server;

import com.wordpress.salaboy.smarttasks.server.SampleInstanceManager;

public class ActivitiHumanTaskManagement implements SampleInstanceManager {

	ProcessEngine processEngine;

	public void startService() {
		try {
			Server.createTcpServer(
					new String[] { "-tcpAllowOthers" }).start();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRepositoryService().createDeployment()
				.addClasspathResource("process/activiti/humanTask.xml.bpmn20.xml")
				.deploy();

	}

	public void stopService() {
		try {
			Server.shutdownTcpServer("tcp://localhost", "", true, false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void startSampleInstance() {
		processEngine.getRuntimeService().startProcessInstanceByKey(
				"adhoc_test");
	}
}
