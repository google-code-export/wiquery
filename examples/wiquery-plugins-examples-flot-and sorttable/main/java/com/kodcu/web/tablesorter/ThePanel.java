package com.kodcu.web.tablesorter;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.objetdirect.wiqueryplugins.ui.tablesorter.TableSorter;

import com.kodcu.data.Project;

public class ThePanel extends Panel {
	
	private DataView<Project> dataView;
	
	public ThePanel(String id) { 
		super(id);
		
		AjaxLink hi = new AjaxLink("Hi") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				
			}
			
			
		};
		add(hi);
		
		TableSorter tableSorter = new TableSorter("myTable");

		dataView = new DataView<Project>("projectList",
				new ListDataProvider<Project>(DataGenerator.getData())) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<Project> item) {
				Project projectItem = item.getModelObject();
				
				item.add(new Label("id", projectItem.getId() + ""));
				item.add(new Label("projectName", projectItem
								.getProjectName()));
				item.add(new Label("creator", projectItem.getCreator()));

			}

		};

		tableSorter.add(dataView);
		add(tableSorter);
		
	}

}
