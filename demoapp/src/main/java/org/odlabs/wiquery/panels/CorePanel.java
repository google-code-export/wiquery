package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsScopeContext;
import org.odlabs.wiquery.core.javascript.helper.CssHelper;
import org.odlabs.wiquery.plugin.ChilliPanel;

public class CorePanel extends Panel {

	public CorePanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		add(chilliPlugin);
		Label example1 = new Label("example1", "Click to run example 1");
		example1.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
		
			@Override
			public JsScope callback() {
				return new JsScope() {
				
					@Override
					protected void execute(JsScopeContext scopeContext) {
						scopeContext.self().chain(CssHelper.css("border", "1px solid red"));
					}
				
				};
			}
		
		}));
		chilliPlugin.add(example1);
	}

}

