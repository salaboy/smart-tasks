package com.wordpress.salaboy.smarttasks.taskform;

import org.jbpm.bpmn2.xml.BPMNSemanticModule;

/**
 * Simple extention of {@link BPMNSemanticModule} which adds a customer handler.
 * 
 * @author calcacuervo
 * 
 */
public class HumanTaskSemanticModule extends BPMNSemanticModule {

	/**
	 * Will add a new handler, an instance of
	 * {@link HumanTaskGetInformationHandler}.
	 */
	public HumanTaskSemanticModule(HumanTaskRepository humanTaskRepository) {
		addHandler("userTask", new HumanTaskGetInformationHandler(humanTaskRepository));
		addHandler("property", new GetProcessInputHandler(humanTaskRepository));
	}
}
