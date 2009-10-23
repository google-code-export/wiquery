package org.odlabs.wiquery.demo.dashboard;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.odlabs.wiquery.demo.filters.FiltersPanel;
import org.odlabs.wiquery.demo.model.Task;
import org.odlabs.wiquery.demo.plugin.LayoutPlugin;
import org.odlabs.wiquery.demo.plugin.LayoutPlugin.LayoutPosition;
import org.odlabs.wiquery.demo.tasks.TaskDetails;
import org.odlabs.wiquery.ui.dialog.Dialog;

public class DashBoard extends WebPage {

	private Dialog dialog;
	
	public DashBoard() {
		super();
		LayoutPlugin layout = new LayoutPlugin("dashboard");
		layout.add(new DashBoardPanel("tasks"), LayoutPosition.CENTER);
		layout.add(new FiltersPanel("filters"), LayoutPosition.EAST);
		add(layout);
		
		dialog = new Dialog("window-details");
		dialog.setAutoOpen(false);
		EmptyPanel emptyPanel = new EmptyPanel("dialog-contents");
		emptyPanel.setOutputMarkupId(true);
		dialog.add(emptyPanel);
		layout.add(dialog);
	}

	public void displayTaskDetails(Task task, AjaxRequestTarget ajaxRequestTarget) {
		TaskDetails taskDetails = new TaskDetails("dialog-contents", task);
		taskDetails.setOutputMarkupId(true);
		dialog.addOrReplace(taskDetails);
		ajaxRequestTarget.addComponent(taskDetails);
		ajaxRequestTarget.appendJavascript(dialog.open().render().toString());
	}
	
}
