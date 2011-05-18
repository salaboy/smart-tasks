package com.wordpress.salaboy.smarttasks.formbuilder.model;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.DirectFieldAccessor;

import com.wordpress.salaboy.smarttasks.formbuilder.model.GraphTaskOperations;

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
		Assert.assertEquals(7, list.size());
		Assert.assertTrue(list.contains("claim"));
		Assert.assertTrue(list.contains("start"));
		Assert.assertTrue(list.contains("complete"));
		Assert.assertTrue(list.contains("fail"));
		Assert.assertTrue(list.contains("release"));
		Assert.assertTrue(list.contains("suspend"));
		Assert.assertTrue(list.contains("stop"));
	}

	@Test
	public void getOperations() {
		List<String> tasks = operations.getOperations("READY");
		Assert.assertEquals(2, tasks.size());
		Assert.assertTrue(tasks.contains("claim"));
		Assert.assertTrue(tasks.contains("suspend"));
	}
	
}
