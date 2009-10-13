package org.odlabs.wiquery.presentation.examples.scrumdashboard;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * The left panel of the Scrum Dashboard
 * @author Julien Roche
 *
 */
public class DashboardLeftPanel extends Panel {
	// Constants
	/**	Constant of serialization */
	private static final long serialVersionUID = 7866119675491826404L;

	/**
	 * Constructor
	 * @param id Wicket identifiant
	 * @param scrumDashboardPage
	 */
	public DashboardLeftPanel(String id, ScrumDashboardPage scrumDashboardPage) {
		super(id);
		this.setOutputMarkupId(true);
	}
}
