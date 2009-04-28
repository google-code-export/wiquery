package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsScopeContext;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.javascript.helper.CssHelper;
import org.odlabs.wiquery.plugin.ChilliPanel;

public class StatementsPanel extends Panel {

	public StatementsPanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		add(chilliPlugin);
		final Label label = new Label("example1", "CSS Helper curtomized me");
		chilliPlugin.add(label);
		label.add(new WiQueryAbstractBehavior() {
		
			@Override
			public JsStatement statement() {
				return new JsQuery(label).$().chain(CssHelper.css("border", "1px solid red"));
			}
		
		});
	}

}

