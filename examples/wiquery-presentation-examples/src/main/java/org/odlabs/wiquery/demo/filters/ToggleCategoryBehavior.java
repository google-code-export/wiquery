package org.odlabs.wiquery.demo.filters;

import org.apache.wicket.Component;
import org.odlabs.wiquery.core.effects.basic.Toggle;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.demo.dashboard.DashBoard;

public class ToggleCategoryBehavior extends WiQueryEventBehavior {

	public ToggleCategoryBehavior(final FiltersPanel filtersPanel, final String category) {
		super(new Event(MouseEvent.CLICK) {

			private static final long serialVersionUID = 1L;

			@Override
			public JsScope callback() {
				// getting totos pane
				DashBoard dashBoard = filtersPanel.findParent(DashBoard.class);
				Component component = dashBoard.get("dashboard:tasks:" + category);
				// hide effect on todos panel
				JsStatement hideStatement = 
					new JsQuery(component).$().chain(new Toggle());
				return JsScope.quickScope(hideStatement.render());
			}
			
		});
	}

}
