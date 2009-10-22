package org.odlabs.wiquery.demo.tasks.views;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.LoadableDetachableModel;
import org.odlabs.wiquery.demo.model.Task;
import org.odlabs.wiquery.demo.model.Task.TaskState;
import org.odlabs.wiquery.demo.service.TaskService;
import org.odlabs.wiquery.ui.sortable.SortableAjaxBehavior;

public class TaskList extends WebMarkupContainer {

	private TaskService taskService = new TaskService();	
	
	public TaskList(String id, final TaskState taskState) {
		super(id);
		TaskListView taskListView = new TaskListView(id + "-list", new LoadableDetachableModel<List<Task>>() {

			@Override
			protected List<Task> load() {
				return taskService.list(taskState);
			}
			
		});
		add(taskListView);
		add(new SortableAjaxBehavior() {
			
			@Override
			public void onUpdate(Component sortedComponent, int index,
					AjaxRequestTarget ajaxRequestTarget) {
				System.out.println("drop");
			}
			
			@Override
			public void onRemove(Component sortedComponent,
					AjaxRequestTarget ajaxRequestTarget) {
				System.out.println("drop");
			}
			
			@Override
			public void onReceive(Component sortedComponent, int index,
					Component parentSortedComponent, AjaxRequestTarget ajaxRequestTarget) {
				System.out.println("drop");
			}
		}.getSortableBehavior().setConnectWith(".todo"));
	}

}
