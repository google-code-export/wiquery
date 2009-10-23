package org.odlabs.wiquery.demo.dashboard;

import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.demo.model.Task.TaskState;
import org.odlabs.wiquery.demo.service.TaskService;
import org.odlabs.wiquery.demo.tasks.TaskList;

public class DashBoardPanel extends Panel {

	private TaskService taskService = new TaskService();

	public DashBoardPanel(String id) {
		super(id);
		add(new TaskList("todos", TaskState.TODO));
		add(new TaskList("progress", TaskState.IN_PROGRESS));
		add(new TaskList("done", TaskState.DONE));
	}

}
