package com.wordpress.salaboy.smarttasks.taskform;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.impl.KnowledgeBaseFactoryServiceImpl;
import org.drools.io.ResourceFactory;
import org.jbpm.bpmn2.xml.XmlBPMNProcessDumper;
import org.jbpm.compiler.xml.XmlProcessReader;
import org.jbpm.ruleflow.core.RuleFlowProcess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wordpress.salaboy.smarttasks.Action;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskFormDefinition;
import com.wordpress.salaboy.smarttasks.formbuilder.model.TaskPropertyDefinition;
import com.wordpress.salaboy.smarttasks.taskform.model.HumanTaskIO;

/**
 * Class that receives a bpmn file, gets the input/output information and writes
 * an output file in a form of json.
 */
public class TaskFormJsonGenerator implements Action {

	HumanTaskRepository humanTaskRepository = HumanTaskRepository.getInstance();

	/**
	 * Gets the input output information.
	 * 
	 * @param originalFilename
	 * @param outputFile
	 */
	public void getTaskIOInformation(String originalFilename) {
		try {
			createKnowledgeBase(new File(originalFilename));
		} catch (Exception e) {
			Logger.getLogger(TaskFormJsonGenerator.class.getName()).log(
					Level.SEVERE, "There was an error.", e);
		}
	}

	private KnowledgeBase createKnowledgeBase(File originalFile)
			throws Exception {
		KnowledgeBaseFactory
				.setKnowledgeBaseServiceFactory(new KnowledgeBaseFactoryServiceImpl());
		KnowledgeBuilderConfiguration conf = KnowledgeBuilderFactory
				.newKnowledgeBuilderConfiguration();
		((PackageBuilderConfiguration) conf).initSemanticModules();
		((PackageBuilderConfiguration) conf)
				.addSemanticModule(new HumanTaskSemanticModule(
						humanTaskRepository));
		// ProcessDialectRegistry.setDialect("XPath", new XPathDialect());
		XmlProcessReader processReader = new XmlProcessReader(
				((PackageBuilderConfiguration) conf).getSemanticModules());
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder(conf);
		List<org.drools.definition.process.Process> processes = processReader
				.read(new FileReader(originalFile));
		for (org.drools.definition.process.Process p : processes) {
			RuleFlowProcess ruleFlowProcess = (RuleFlowProcess) p;
			kbuilder.add(ResourceFactory.newReaderResource(new StringReader(
					XmlBPMNProcessDumper.INSTANCE.dump(ruleFlowProcess))),
					ResourceType.BPMN2);
		}
		kbuilder.add(
				ResourceFactory.newReaderResource(new FileReader(originalFile)),
				ResourceType.BPMN2);
		if (!kbuilder.getErrors().isEmpty()) {
			for (KnowledgeBuilderError error : kbuilder.getErrors()) {
				System.err.println(error);
			}
			throw new IllegalArgumentException(
					"Errors while parsing knowledge base");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

	private Collection<TaskFormDefinition> generateTaskFormDefinitions(
			Collection<String> inputs, Collection<String> outputs) {
		Collection<TaskFormDefinition> definitions = new ArrayList<TaskFormDefinition>();
		TaskFormDefinition def = new TaskFormDefinition();
		// def.setProfile("Default");
		List<TaskPropertyDefinition> inputDefinitions = new ArrayList<TaskPropertyDefinition>();
		for (String input : inputs) {
			TaskPropertyDefinition propertyDefinition = new TaskPropertyDefinition();
			propertyDefinition.setName(input);
			propertyDefinition.setSourceExpresion("");
			inputDefinitions.add(propertyDefinition);
		}
		List<TaskPropertyDefinition> outputDefinitions = new ArrayList<TaskPropertyDefinition>();
		for (String output : outputs) {
			TaskPropertyDefinition propertyDefinition = new TaskPropertyDefinition();
			propertyDefinition.setName(output);
			propertyDefinition.setSourceExpresion("in:0");
			outputDefinitions.add(propertyDefinition);
		}
		def.setInputFields(inputDefinitions);
		def.setOutputFields(outputDefinitions);
		definitions.add(def);
		return definitions;
	}

	public void generateJson(String originalFilename, String outputdirectory)
			throws IOException {

		getTaskIOInformation(originalFilename);
		File outputDirectoryFile = new File(outputdirectory);
		if (!outputDirectoryFile.exists() || !outputDirectoryFile.isDirectory()) {
			throw new IllegalArgumentException(
					"The second parameters does not exists or it is not a directory.");
		}
		Collection<HumanTaskIO> tasks = this.humanTaskRepository
				.getHumanTasks();
		for (HumanTaskIO humanTaskIO : tasks) {

			String json = generateJsonFromLists(humanTaskIO.getInputFields(),
					humanTaskIO.getOutputFields());
			FileWriter writer = new FileWriter(new File(outputdirectory
					+ System.getProperty("file.separator")
					+ humanTaskIO.getName().replace(" ", "") + ".config.json"));
			BufferedWriter out = new BufferedWriter(writer);
			out.write(json);
			out.close();
		}
	}

	public String generateJsonFromLists(Collection<String> input,
			Collection<String> output) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this.generateTaskFormDefinitions(input,
				output));
		return json;
	}

	/**
	 * This action generated the .config.json files.
	 */
	@Override
	public void execute(String[] params) {
		// Wrap to the generateJson method.
		try {
			this.generateJson(params[0], params[1]);
		} catch (Exception e) {
			Logger.getLogger(TaskFormJsonGenerator.class.getName()).log(
					Level.SEVERE, "There was an exception.", e);
		}
	}

}
