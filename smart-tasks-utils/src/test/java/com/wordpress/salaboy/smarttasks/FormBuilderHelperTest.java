package com.wordpress.salaboy.smarttasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskFormDefinition;

/**
 * Unit test for simple App.
 */
public class FormBuilderHelperTest {
	File inputFile;
	File outputDir;

	@Before
	public void setupDir() {
		inputFile = new File("src/test/resources/sample-emergency.bpmn");
		outputDir = new File("target" + System.getProperty("file.separator")
				+ "output" + System.currentTimeMillis());
		outputDir.mkdir();

	}

	@Test
	public void getSampleConfiguration() {
		try {
			outputDir.getAbsolutePath();
			String[] params = new String[3];
			params[0] = "taskformconfig";
			params[1] = inputFile.getAbsolutePath();
			params[2] = outputDir.getAbsolutePath();
			UtilsExecutor.main(params);
			String[] children = outputDir.list();
			Assert.assertEquals(3, children.length);
			for (int i = 0; i < children.length; i++) {
				String filename = children[i];
				FileReader fileReader = new FileReader(
						outputDir.getAbsolutePath()
								+ System.getProperty("file.separator")
								+ filename);
				BufferedReader input = new BufferedReader(fileReader);

				Gson gson = new Gson();
				Collection<TaskFormDefinition> definitions = gson.fromJson(
						input, new TypeToken<Collection<TaskFormDefinition>>() {
						}.getType());
				Assert.assertNotNull(definitions);
				Assert.assertEquals(1, definitions.size());
				TaskFormDefinition def = definitions.iterator().next();
				Assert.assertEquals(def.getProfile(), "Default");

			}
		} catch (FileNotFoundException e) {
			Assert.fail(e.getMessage());
		}
	}

	@After
	public void finishTest() {
		String[] children = outputDir.list();
		for (int i = 0; i < children.length; i++) {
			String filename = children[i];
			File f = new File(outputDir.getAbsoluteFile() + System.getProperty("file.separator") + filename);
			f.delete();
		}
		outputDir.delete();
	}
}
