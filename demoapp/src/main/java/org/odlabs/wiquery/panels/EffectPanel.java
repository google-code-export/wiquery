/**
 * 
 */
package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.plugin.ChilliPanel;

/**
 * @author pierre
 * 
 */
public class EffectPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public EffectPanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		this.add(chilliPlugin);

		Label example1 = new Label("example1", "Click to run example 1");
		final MultiLineLabel example1P = new MultiLineLabel("example1P",
				"Text to animate");
		example1.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public JsScope callback() {
				return JsScope.quickScope(new JsQuery(example1P).$().append(
						".slideToggle('slow')").render());
			}

		}));
		chilliPlugin.add(example1);

		chilliPlugin.add(example1P);
	}

}
