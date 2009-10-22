package org.odlabs.wiquery.demo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.odlabs.wiquery.demo.model.Task;
import org.odlabs.wiquery.demo.model.Task.TaskState;

public class TaskService implements Serializable {

	private static final List<Task> DATA = Arrays.asList(
		new Task(1, "Task 1", "Description 1", TaskState.TODO, "", 1.2f),
		new Task(1, "Task 2", "Description 2", TaskState.TODO, "", 1.2f),
		new Task(2, "Task 3", "Description 3", TaskState.TODO, "", 1.2f),
		new Task(1, "Task 4", "Description 4", TaskState.TODO, "", 1.2f),
		new Task(3, "Task 5", "Description 5", TaskState.TODO, "", 1.2f)
	);
	
	public List<Task> list(TaskState taskState) {
		List<Task> result = new ArrayList<Task>();
		for (Task task : DATA) {
			if (taskState.equals(task.getState())) {
				result.add(task);
			}
		}
		return result;
	}
	
	public void changeState(Task task, TaskState taskState) {
		task.setState(taskState);
	}
	
}
