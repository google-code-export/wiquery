package org.odlabs.wiquery.demo.tasks;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.odlabs.wiquery.demo.model.Task;

public class TaskDetails extends Panel {

	public TaskDetails(String id, Task task) {
		super(id, new CompoundPropertyModel<Task>(task));
		add(new Label("title"));
		add(new Label("description"));
		add(new Label("state"));
		add(new Label("duration"));
	}

}
