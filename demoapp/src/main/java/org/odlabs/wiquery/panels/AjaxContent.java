package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.ui.tabs.Tabs;

/**
 * @author lionel
 */
public class AjaxContent extends Panel {

	public AjaxContent(String id) {
		super(id);
		add(new Tabs("tabs"));
	}

}

