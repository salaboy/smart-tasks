package com.wordpress.salaboy.smarttasks.server.jbpm5;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.SystemEventListenerFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.impl.ClassPathResource;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.jbpm.process.workitem.wsht.WSHumanTaskHandler;
import org.jbpm.task.User;
import org.jbpm.task.service.TaskServer;
import org.jbpm.task.service.TaskService;
import org.jbpm.task.service.TaskServiceSession;
import org.jbpm.task.service.mina.MinaTaskServer;

import com.wordpress.salaboy.smarttasks.server.SampleInstanceManager;

public class JBPM5TaskManager implements SampleInstanceManager {
	private KnowledgeRuntimeLogger logger;
	private StatefulKnowledgeSession ksession;
	private boolean running;
	private TaskServer taskServer;

	public JBPM5TaskManager() {
		this.running = false;
	}

	public void startService() {
		if (isRunning())
			throw new IllegalStateException("Server is already started");
		this.running = true;
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("org.drools.task");
		TaskService taskService = new TaskService(entityManagerFactory,
				SystemEventListenerFactory.getSystemEventListener());
		TaskServiceSession taskSession = taskService.createSession();
		MockUserInfo userInfo = new MockUserInfo();
		taskService.setUserinfo(userInfo);

		for (String userName : getDefaultUsers()) {
			taskSession.addUser(new User(userName));
		}

		taskServer = new MinaTaskServer(taskService);
		Thread thread = new Thread(taskServer);
		thread.start();
	}

	public void startSampleInstance() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();

		kbuilder.add(new ClassPathResource("process/jbpm5/humanTask.bpmn"),
				ResourceType.BPMN2);
		System.out.println("Compiling resources");
		if (kbuilder.hasErrors()) {
			if (kbuilder.getErrors().size() > 0) {
				for (KnowledgeBuilderError error : kbuilder.getErrors()) {
					System.out.println("Error building kbase: "
							+ error.getMessage());
				}
			}
			throw new RuntimeException("Error building kbase!");
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		ksession = kbase.newStatefulKnowledgeSession();
		logger = KnowledgeRuntimeLoggerFactory.newConsoleLogger(ksession);
		ksession.getWorkItemManager().registerWorkItemHandler("Human Task",
				new WSHumanTaskHandler());
		ksession.startProcess("org.plugtree.training.jbpm.humantasks.client",
				null);

	}

	public void stopService() {
		if (!isRunning())
			return;
		try {
			taskServer.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isRunning() {
		return running;
	}

	private String[] getDefaultUsers() {
		return new String[] { "salaboy", "translator", "reviewer",
				"Administrator" };
	}

}
