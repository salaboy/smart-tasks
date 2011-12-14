/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.example.ws_ht.api.TTask;
import org.example.ws_ht.api.TTaskAbstract;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.junit.Before;
import org.junit.Test;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.smarttasks.jbpm3wrapper.conf.JBPM3HumanTaskClientConfiguration;

/**
 * 
 * @author calcacuervo
 */
public class JBPM3SmartTaskAdapterTest {

	private JbpmContext ctx;
	@Before
	public void setUp() {
		JbpmConfiguration config = JbpmConfiguration
		.parseInputStream(JBPM3SmartTaskAdapterTest.class
				.getClassLoader().getResourceAsStream("jbpm.cfg.xml"));
		this.ctx = config.createJbpmContext();
	}
	@Test
	public void jBPM3ClientWrapperTest() throws Exception {
		HumanTaskService humanTaskService = null;
		try {
			addSampleTasks();
			humanTaskService = this.createHumanTaskService();
			humanTaskService.initializeService();
			humanTaskService.setLocale("en-UK");

			List<TTaskAbstract> taskAbtracts = humanTaskService.getMyTaskAbstracts(
					null, "salaboy", null, null, null, null, null, null, null);
			assertEquals(1, taskAbtracts.size());
			
			List<TTask> tasks = humanTaskService.getMyTasks(
					null, "salaboy", null, null, null, null, null, null, null);
			assertEquals(1, tasks.size());
			assertEquals("salaboy", tasks.get(0).getActualOwner());
			TTask task = humanTaskService.getTaskInfo(tasks.get(0).getId());
			assertEquals("salaboy", task.getActualOwner());
			assertEquals("change nappy", task.getName().toString());
		} finally {
			if (humanTaskService != null) {
				humanTaskService.cleanUpService();
			}
		}
	}

	private void addSampleTasks() throws Exception {

		ProcessDefinition processDefinition = ProcessDefinition
				.parseXmlString("<process-definition name='the baby process'>"
						+ "  <start-state>"
						+ "    <transition name='baby cries' to='t' />"
						+ "  </start-state>"
						+ "  <task-node name='t'>"
						+ "    <task name='change nappy'>"
						+ "      <assignment class='com.wordpress.salaboy.DummyAssignmentHandler' />"
						+ "    </task>" + "    <transition to='end' />"
						+ "  </task-node>" + "  <end-state name='end' />"
						+ "</process-definition>");
		ctx.deployProcessDefinition(processDefinition);
		ProcessInstance instance = ctx.newProcessInstance("the baby process");
		instance.signal();

	}

	private HumanTaskService createHumanTaskService() {
		HumanTaskServiceConfiguration humanTaskServiceConfiguration = new HumanTaskServiceConfiguration();
		humanTaskServiceConfiguration.addHumanTaskClientConfiguration("JBPM3",
				new JBPM3HumanTaskClientConfiguration(ctx));
		return HumanTaskServiceFactory
				.newHumanTaskService(humanTaskServiceConfiguration);
	}

}