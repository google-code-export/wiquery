package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.ui.tabs.Tabs;

/**
 * @author lionel
 */
public class AjaxContent extends Panel {

	private static final long serialVersionUID = 1L;

	public AjaxContent(String id) {
		super(id);
		this.add(new Tabs("tabs"));
	}

}
