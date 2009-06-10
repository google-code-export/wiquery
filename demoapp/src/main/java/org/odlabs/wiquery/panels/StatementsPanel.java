package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.javascript.helper.CssHelper;
import org.odlabs.wiquery.plugin.ChilliPanel;

public class StatementsPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public StatementsPanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		this.add(chilliPlugin);
		final Label label = new Label("example1", "CSS Helper customized me");
		chilliPlugin.add(label);
		label.add(new WiQueryAbstractBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			public JsStatement statement() {
				return new JsQuery(label).$().chain(
						CssHelper.css("border", "1px solid red"));
			}

		});
	}

}
