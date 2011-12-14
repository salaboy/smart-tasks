package com.wordpress.salaboy.smarttasks.jbpm3wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.example.ws_ht.api.TTask;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.wordpress.salaboy.api.TaskAdapter;

public class JBPM3TaskAdapter implements  TaskAdapter<TTask, TaskInstance> {

	public TTask adapt(TaskInstance taskInstance) {
		TTask task = new TTask();
		task.setName(new QName(taskInstance.getName()));
		task.setId(String.valueOf(taskInstance.getId()));
		task.setPresentationName(taskInstance.getName());
		task.setStatus(new JBPM3StatusAdapter().adapt(taskInstance));
		task.setActualOwner(taskInstance.getActorId());
		return task;
	}
	
	public List<TTask> adaptCollection(List<TaskInstance> jbpm3Tasks) {
		List<TTask> tasks = new ArrayList<TTask>();
		for (TaskInstance taskInstance : jbpm3Tasks) {
			tasks.add(this.adapt(taskInstance));
		}
		return tasks;
	}
}
