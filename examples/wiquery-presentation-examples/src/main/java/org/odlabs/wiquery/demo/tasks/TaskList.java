package org.odlabs.wiquery.demo.tasks;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.demo.model.Task;
import org.odlabs.wiquery.demo.model.Task.TaskState;
import org.odlabs.wiquery.demo.service.TaskService;
import org.odlabs.wiquery.ui.sortable.SortableAjaxBehavior;
import org.odlabs.wiquery.ui.themes.ThemeUiHelper;

public class TaskList extends Panel {

	private TaskService taskService = new TaskService();	
	
	public TaskList(String id, final TaskState taskState) {
		super(id);
		Label label = new Label("title", Model.of(taskState.toString()));
		ThemeUiHelper.titleComponent(label);
		add(label);
		TaskListView taskListView = new TaskListView("list", new LoadableDetachableModel<List<Task>>() {

			@Override
			protected List<Task> load() {
				return taskService.list(taskState);
			}
			
		});
		SortableAjaxBehavior sortableAjaxBehavior = new SortableAjaxBehavior() {
			
			@Override
			public void onUpdate(Component sortedComponent, int index,
					AjaxRequestTarget ajaxRequestTarget) {
			}
			
			@Override
			public void onRemove(Component sortedComponent,
					AjaxRequestTarget ajaxRequestTarget) {
			}
			
			@Override
			public void onReceive(Component sortedComponent, int index,
					Component parentSortedComponent, AjaxRequestTarget ajaxRequestTarget) {
				Task task = (Task) sortedComponent.getDefaultModelObject();
				taskService.changeState(task, taskState);
			}
			
		};
		sortableAjaxBehavior.getSortableBehavior().setConnectWith(".tasks");
		WebMarkupContainer listContainer = new WebMarkupContainer("draggable");
		add(listContainer);
		listContainer.add(taskListView);
		listContainer.add(sortableAjaxBehavior);
	}

}
