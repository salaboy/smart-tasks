package com.wordpress.salaboy.smarttasks.jbpm3wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.example.ws_ht.api.TTaskAbstract;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.wordpress.salaboy.api.TaskAdapter;

public class JBPM3TaskAbstractAdapter implements  TaskAdapter<TTaskAbstract, TaskInstance> {

	public TTaskAbstract adapt(TaskInstance taskInstance) {
		TTaskAbstract task = new TTaskAbstract();
		task.setName(new QName(taskInstance.getName()));
		task.setId(String.valueOf(taskInstance.getId()));
		task.setPresentationName(taskInstance.getName());
		task.setStatus(new JBPM3StatusAdapter().adapt(taskInstance));
		return task;
	}
	
	public List<TTaskAbstract> adaptCollection(List<TaskInstance> jbpm3Tasks) {
		List<TTaskAbstract> tasks = new ArrayList<TTaskAbstract>();
		for (TaskInstance taskInstance : jbpm3Tasks) {
			tasks.add(this.adapt(taskInstance));
		}
		return tasks;
	}
}
