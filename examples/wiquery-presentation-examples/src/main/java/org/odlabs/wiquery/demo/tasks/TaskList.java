package org.odlabs.wiquery.demo.tasks;

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
	
	private TaskState taskState;
	
	public TaskList(String id, final TaskState taskState) {
		super(id);
		this.taskState = taskState;
		TaskListView taskListView = new TaskListView(id + "-list", new LoadableDetachableModel<List<Task>>() {

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
		add(sortableAjaxBehavior);
		add(taskListView);
	}

}
