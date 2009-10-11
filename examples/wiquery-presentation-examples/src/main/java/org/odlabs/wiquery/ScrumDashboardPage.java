package org.odlabs.wiquery;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.presentation.examples.scrumdashboard.DashboardCenterPanel;
import org.odlabs.wiquery.presentation.examples.scrumdashboard.DashboardLeftPanel;
import org.odlabs.wiquery.presentation.examples.ui.layout.Layout;

/**
 * Scrum Dashboard
 * @author Julien Roche
 *
 */
public class ScrumDashboardPage extends WebPage {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public ScrumDashboardPage() {
		super();
		
		Layout dashboard = new Layout("dashboard"){
			private static final long serialVersionUID = 1L;

			/* (non-Javadoc)
			 * @see org.odlabs.wiquery.presentation.examples.ui.layout.Layout#getLayoutCenterComponent(java.lang.String)
			 */
			@Override
			public Panel getLayoutCenterComponent(String wicketId) {
				return new DashboardCenterPanel(wicketId);
			}

			/* (non-Javadoc)
			 * @see org.odlabs.wiquery.presentation.examples.ui.layout.Layout#getLayoutEastComponent(java.lang.String)
			 */
			@Override
			public Panel getLayoutEastComponent(String wicketId) {
				return new DashboardLeftPanel(wicketId);
			}
		};
		
		add(dashboard);
	}
}
