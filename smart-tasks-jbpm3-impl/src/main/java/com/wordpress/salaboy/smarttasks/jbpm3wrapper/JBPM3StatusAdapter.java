package com.wordpress.salaboy.smarttasks.jbpm3wrapper;

import java.util.ArrayList;
import java.util.List;

import org.example.ws_ht.api.TStatus;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.wordpress.salaboy.api.TStatusAdapter;

public class JBPM3StatusAdapter implements TStatusAdapter<TaskInstance>{

	public TStatus adapt(TaskInstance taskInstance) {
		TStatus st = null;

		if (taskInstance.isSuspended()) {
			st = TStatus.SUSPENDED;
		}
		else if (taskInstance.getEnd() != null) {
			st = TStatus.COMPLETED;
		}
		else if (taskInstance.getStart() != null) {
			st = TStatus.RESERVED;
		}
		else if (taskInstance.getCreate() != null) {
			st = TStatus.CREATED;
		}
		return st;
	}
	
	public List<TStatus> adaptCollection(List<TaskInstance> instances) {
		List<TStatus> statuses = new ArrayList<TStatus>();
		for (TaskInstance taskInstance : instances) {
			statuses.add(this.adapt(taskInstance));
		}
		return statuses;
	}
	
}
