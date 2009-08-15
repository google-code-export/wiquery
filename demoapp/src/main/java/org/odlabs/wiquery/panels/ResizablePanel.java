package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.plugin.ChilliPanel;
import org.odlabs.wiquery.ui.resizable.ResizableBehavior;

/**
 * @author lionel
 */
public class ResizablePanel extends Panel {

	private static final long serialVersionUID = 1L;

	public ResizablePanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		this.add(chilliPlugin);
		final Label label = new Label("example1", "Resize me!");
		chilliPlugin.add(label);
		label.add(new ResizableBehavior());
	}

}
