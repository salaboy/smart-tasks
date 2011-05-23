package com.wordpress.salaboy.smarttasks.taskform;

import java.util.HashSet;
import java.util.Set;

import org.drools.xml.ExtensibleXmlParser;
import org.drools.xml.Handler;
import org.jbpm.bpmn2.xml.PropertyHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetProcessInputHandler extends PropertyHandler implements Handler {

	/**
	 * To identify the form variables from process input.
	 */
	private static final String PROCESS_INPUT_NAME = "PROCESS_START";
		
	private HumanTaskRepository humanTaskRepository;
	public GetProcessInputHandler(HumanTaskRepository theHumanTaskRepository) {
		super();
		this.humanTaskRepository = theHumanTaskRepository;
	}

	@Override
	public Object start(final String uri, final String localName,
			final Attributes attrs, final ExtensibleXmlParser parser)
			throws SAXException {
		final String id = attrs.getValue("id");
		this.humanTaskRepository.addIncrementalOutput(PROCESS_INPUT_NAME, id);
		return super.start(uri, localName, attrs, parser);
	}

}