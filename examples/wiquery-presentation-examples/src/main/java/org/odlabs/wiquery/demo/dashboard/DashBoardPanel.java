package org.odlabs.wiquery.demo.dashboard;

import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.demo.model.Task.TaskState;
import org.odlabs.wiquery.demo.service.TaskService;
import org.odlabs.wiquery.demo.tasks.views.TaskList;

public class DashBoardPanel extends Panel {

	private TaskService taskService = new TaskService();

	public DashBoardPanel(String id) {
		super(id);
		add(new TaskList("todos", TaskState.TODO));
		add(new TaskList("progress", TaskState.IN_PROGRESS));
		add(new TaskList("done", TaskState.DONE));
		
//		final TaskListView todos = new TaskListView("todos", new LoadableDetachableModel<List<Task>>() {
//
//			@Override
//			protected List<Task> load() {
//				return taskService.list(TaskState.TODO);
//			}
//			
//		});
//		final WebMarkupContainer todosWrapper = new WebMarkupContainer("todos-wrapper");
//		add(todosWrapper);
//		todosWrapper.add(todos);
//		todosWrapper.setOutputMarkupId(true);
//		todosWrapper.add(new SortableBehavior());
//		
//		TaskListView progress = new TaskListView("progress", new LoadableDetachableModel<List<Task>>() {
//
//			@Override
//			protected List<Task> load() {
//				return taskService.list(TaskState.IN_PROGRESS);
//			}
//			
//		});
//		final WebMarkupContainer proggressWrapper = new WebMarkupContainer("progress-wrapper");
//		add(proggressWrapper);
//		proggressWrapper.add(progress);
//		proggressWrapper.add(new SortableAjaxBehavior() {
//			
//			@Override
//			public void onUpdate(Component sortedComponent, int index,
//					AjaxRequestTarget ajaxRequestTarget) {
//				
//			}
//			
//			@Override
//			public void onRemove(Component sortedComponent,
//					AjaxRequestTarget ajaxRequestTarget) {
//				
//			}
//			
//			@Override
//			public void onReceive(Component sortedComponent, int index,
//					Component parentSortedComponent, AjaxRequestTarget ajaxRequestTarget) {
//				Task droppedTask = (Task) sortedComponent.getDefaultModelObject();
//				taskService.changeState(droppedTask, TaskState.IN_PROGRESS);
////				ajaxRequestTarget.addComponent(todosWrapper);
////				ajaxRequestTarget.addComponent(proggressWrapper);				
//			}
//		});
//		proggressWrapper.add(new DroppableAjaxBehavior() {
//			
//			@Override
//			public void onDrop(Component droppedComponent,
//					AjaxRequestTarget ajaxRequestTarget) {
//			}
//		});
//		
//		TaskListView done = new TaskListView("done", new LoadableDetachableModel<List<Task>>() {
//
//			@Override
//			protected List<Task> load() {
//				return taskService.list(TaskState.DONE);
//			}
//			
//		});
//		WebMarkupContainer doneWrapper = new WebMarkupContainer("done-wrapper");
//		add(doneWrapper);
//		doneWrapper.add(done);
//		doneWrapper.add(new DroppableBehavior());
	}

}
