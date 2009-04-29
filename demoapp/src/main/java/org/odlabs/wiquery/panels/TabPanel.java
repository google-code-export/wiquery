package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.plugin.ChilliPanel;
import org.odlabs.wiquery.ui.tabs.Tabs;

/**
 * @author lionel
 */
public class TabPanel extends Panel {

	public TabPanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		add(chilliPlugin);
		chilliPlugin.add(new Tabs("tabs"));
	}

}

