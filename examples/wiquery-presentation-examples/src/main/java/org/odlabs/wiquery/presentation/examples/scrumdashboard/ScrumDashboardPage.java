package org.odlabs.wiquery.presentation.examples.scrumdashboard;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.presentation.examples.ui.layout.Layout;
import org.odlabs.wiquery.ui.dialog.Dialog;

/**
 * Scrum Dashboard
 * @author Julien Roche
 *
 */
public class ScrumDashboardPage extends WebPage {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 1L;
	
	// Wicket components
	private Dialog taskDialog;
	private Panel centerPanel;
	private Panel leftPanel;
	
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
				centerPanel = new DashboardCenterPanel(wicketId, ScrumDashboardPage.this);
				return centerPanel;
			}

			/* (non-Javadoc)
			 * @see org.odlabs.wiquery.presentation.examples.ui.layout.Layout#getLayoutEastComponent(java.lang.String)
			 */
			@Override
			public Panel getLayoutEastComponent(String wicketId) {
				leftPanel = new DashboardLeftPanel(wicketId, ScrumDashboardPage.this);
				return leftPanel;
			}
		};
		
		add(dashboard);
		
		taskDialog = new Dialog("taskDialog");
		taskDialog.setMarkupId(taskDialog.getId());
		add(taskDialog);
	}
	
	/**
	 * @return the task dialog
	 */
	public Dialog getTaskDialog() {
		return taskDialog;
	}
	
	/**
	 * @return the centered panel
	 */
	public Panel getCenterPanel() {
		return centerPanel;
	}
	
	/**
	 * @return the left panel
	 */
	public Panel getLeftPanel() {
		return leftPanel;
	}
}
