package org.odlabs.wiquery.demo.tasks.views;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.odlabs.wiquery.demo.model.Task;

public class TaskListView extends ListView<Task> {

	public TaskListView(String id,
			IModel<? extends List<? extends Task>> model) {
		super(id, model);
	}

	private static final long serialVersionUID = -70973850486736793L;

	@Override
	protected void populateItem(ListItem<Task> item) {
		Task task = item.getModelObject();
		item.setModel(new CompoundPropertyModel<Task>(task));
		item.add(new Label("title"));
		item.add(new Label("priority"));
	}

}
