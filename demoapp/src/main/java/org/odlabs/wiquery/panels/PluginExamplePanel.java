/**
 * 
 */
package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.plugin.flexigrid.FlexigridPanel;

/**
 * @author pierre
 * 
 */
public class PluginExamplePanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public PluginExamplePanel(String id) {
		super(id);
		FlexigridPanel flexigridPlugin = new FlexigridPanel("examples");
		this.add(flexigridPlugin);

	}

}
