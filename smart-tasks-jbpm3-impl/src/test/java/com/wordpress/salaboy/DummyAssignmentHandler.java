package com.wordpress.salaboy;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.def.AssignmentHandler;
import org.jbpm.taskmgmt.exe.Assignable;

public class DummyAssignmentHandler implements AssignmentHandler {

	public void assign(Assignable a, ExecutionContext arg1) throws Exception {
		a.setActorId("salaboy");
	}
}
