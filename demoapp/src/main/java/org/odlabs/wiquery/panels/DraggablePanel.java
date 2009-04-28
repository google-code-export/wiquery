package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.plugin.ChilliPanel;
import org.odlabs.wiquery.ui.draggable.DraggableBehavior;

/**
 * @author lionel
 */
public class DraggablePanel extends Panel {

	public DraggablePanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		add(chilliPlugin);
		final Label label = new Label("example1", "Drag me !");
		chilliPlugin.add(label);
		label.add(new DraggableBehavior());
	}

}

