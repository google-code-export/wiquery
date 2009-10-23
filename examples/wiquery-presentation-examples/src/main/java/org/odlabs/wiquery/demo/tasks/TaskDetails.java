package org.odlabs.wiquery.demo.tasks;

import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.demo.model.Task;

public class TaskDetails extends Panel {

	private Task task;

	public TaskDetails(String id, Task task) {
		super(id);
		this.task = task;
	}

		
}
