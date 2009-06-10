package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.plugin.ChilliPanel;

/**
 * @author lionel
 */
public class EventsPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public EventsPanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		this.add(chilliPlugin);
		final Label label = new Label("example1",
				"Click here to alert something");
		chilliPlugin.add(label);
		label.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {

			private static final long serialVersionUID = 1L;

			@Override
			public JsScope callback() {
				return JsScope.quickScope("alert('something :)')");
			}

		}));
	}

}
