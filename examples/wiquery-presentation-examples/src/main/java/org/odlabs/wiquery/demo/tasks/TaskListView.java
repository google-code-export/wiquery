package org.odlabs.wiquery.demo.tasks;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryAjaxEventBehavior;
import org.odlabs.wiquery.demo.dashboard.DashBoard;
import org.odlabs.wiquery.demo.model.Task;
import org.odlabs.wiquery.ui.themes.ThemeUiHelper;

public class TaskListView extends ListView<Task> {

	public TaskListView(String id,
			IModel<? extends List<? extends Task>> model) {
		super(id, model);
	}

	private static final long serialVersionUID = -70973850486736793L;

	@Override
	protected void populateItem(ListItem<Task> item) {
		final Task task = item.getModelObject();
		item.setOutputMarkupId(true);
		item.setModel(new CompoundPropertyModel<Task>(task));
		Label label = new Label("title");
		item.add(label);
		item.add(new Label("priority"));
		ThemeUiHelper.buttonRounded(item);
		item.add(new WiQueryAjaxEventBehavior(MouseEvent.DBLCLICK) {
			
			@Override
			protected void onEvent(AjaxRequestTarget target) {
				DashBoard dashBoard = TaskListView.this.findParent(DashBoard.class);
				dashBoard.displayTaskDetails(task, target);
			}
		});
	}

}
