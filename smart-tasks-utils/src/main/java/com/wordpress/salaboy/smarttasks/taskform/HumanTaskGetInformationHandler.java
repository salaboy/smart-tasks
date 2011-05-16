package com.wordpress.salaboy.smarttasks.taskform;

import java.util.HashSet;
import java.util.Map;

import org.jbpm.bpmn2.xml.UserTaskHandler;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class HumanTaskGetInformationHandler extends UserTaskHandler {

	HumanTaskRepository repository = null;

	/**
	 * Creates a new {@link HumanTaskGetInformationHandler} instance.
	 * 
	 * @param humanTaskRepository
	 *            the {@link HumanTaskRepository}.
	 */
	public HumanTaskGetInformationHandler(
			HumanTaskRepository humanTaskRepository) {
		this.repository = humanTaskRepository;
	}

	/**
	 * Reads the io specification and put the information in the
	 * {@link HumanTaskRepository}.
	 */
	protected void readIoSpecification(org.w3c.dom.Node xmlNode,
			Map<String, String> dataInputs, Map<String, String> dataOutputs) {
		super.readIoSpecification(xmlNode, dataInputs, dataOutputs);
		NamedNodeMap map = xmlNode.getParentNode().getAttributes();
		Node nodeName = map.getNamedItem("name");
		String name = nodeName.getNodeValue();
		this.repository.addHumanTaskIO(name, new HashSet<String>(dataInputs.values()),
				new HashSet<String>(dataOutputs.values()));
	}

}
