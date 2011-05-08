package com.wordpress.salaboy.smarttasks.uihelper.model;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.DirectFieldAccessor;

/**
 * Tests for {@link GraphTaskOperations}
 * @author calcacuervo
 *
 */
public class GraphTaskOperationsTest {

	private static GraphTaskOperations operations;

	@Before
	public void init() {
		File root = new File(Thread.currentThread().getContextClassLoader()
				.getResource(("operations/testOperations.config.json"))
				.getFile());
		try {
			operations = new GraphTaskOperations(root);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		DirectFieldAccessor field = new DirectFieldAccessor(operations);
		Assert.assertNotNull(field.getPropertyValue("definition"));
	}

	@Test
	public void getOperationsList() {
		List<String> list = operations.getOperationsList();
		Assert.assertEquals(8, list.size());
		Assert.assertTrue(list.contains("Claim"));
		Assert.assertTrue(list.contains("Start"));
		Assert.assertTrue(list.contains("Complete"));
		Assert.assertTrue(list.contains("Fail"));
		Assert.assertTrue(list.contains("Release"));
		Assert.assertTrue(list.contains("Suspend"));
		Assert.assertTrue(list.contains("Stop"));
		Assert.assertTrue(list.contains("Resume"));
	}

	@Test
	public void getNextTask() {
		List<String> tasks = operations.getNextTasks("Claim");
		Assert.assertEquals(3, tasks.size());
		Assert.assertTrue(tasks.contains("Start"));
		Assert.assertTrue(tasks.contains("Release"));
		Assert.assertTrue(tasks.contains("Suspend"));
	}
	
	@Test
	public void getRoots() {
		List<String> tasks = operations.getRootOperations();
		Assert.assertEquals(1, tasks.size());
		Assert.assertTrue(tasks.contains("Claim"));
	}
}
