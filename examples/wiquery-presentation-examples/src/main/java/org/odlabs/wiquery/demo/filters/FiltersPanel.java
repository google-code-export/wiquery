package org.odlabs.wiquery.demo.filters;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.effects.EffectSpeed;
import org.odlabs.wiquery.core.effects.fading.FadeOut;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.demo.dashboard.DashBoard;
import org.odlabs.wiquery.ui.themes.ThemeUiHelper;

public class FiltersPanel extends Panel {

	public FiltersPanel(String id) {
		super(id);
		Button button = new Button("filter-hide-todos");
		ThemeUiHelper.buttonRounded(button);
		add(button);
		button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public JsScope callback() {
				// getting totos pane
				DashBoard dashBoard = FiltersPanel.this.findParent(DashBoard.class);
				Component component = dashBoard.get("dashboard:tasks:todos");
				// hide effect on todos panel
				JsStatement hideStatement = 
					new JsQuery(component).$().chain(new FadeOut(EffectSpeed.MEDIUM));
				return JsScope.quickScope(hideStatement.render());
			}
		}));
	}

}
