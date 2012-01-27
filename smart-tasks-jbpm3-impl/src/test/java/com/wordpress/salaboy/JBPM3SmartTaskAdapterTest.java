/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.util.List;

import junit.framework.Assert;

import org.example.ws_ht.api.TAttachment;
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
			assertEquals("review doc jbpm 3", task.getName().toString());
			List<TAttachment> attachments = humanTaskService.getAttachments(task.getId(), null);
			Assert.assertEquals(1, attachments.size());
			Assert.assertEquals("the doc", attachments.get(0).getValue());
		} finally {
			if (humanTaskService != null) {
				humanTaskService.cleanUpService();
			}
		}
	}

	private void addSampleTasks() throws Exception {
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("processdefinition.xml");
		ctx.deployProcessDefinition(processDefinition);
		ProcessInstance instance = ctx.newProcessInstance("document review");
		instance.getContextInstance().setVariable("doc", "the doc");
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