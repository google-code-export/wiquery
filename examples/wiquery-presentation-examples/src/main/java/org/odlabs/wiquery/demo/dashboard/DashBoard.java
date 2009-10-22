package org.odlabs.wiquery.demo.dashboard;

import org.apache.wicket.markup.html.WebPage;

public class DashBoard extends WebPage {

	public DashBoard() {
		super();
		add(new DashBoardPanel("tasks"));
	}

}
