package org.odlabs.wiquery.panels;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.plugin.ChilliPanel;
import org.odlabs.wiquery.ui.progressbar.ProgressBar;

/**
 * @author lionel
 */
public class ProgressBarPanel extends Panel {

	public ProgressBarPanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		add(chilliPlugin);
		Button button = new Button("increaseProgress");
		chilliPlugin.add(button);
		final ProgressBar pgbar = new ProgressBar("progress");
		pgbar.setValue(0);
		button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
		
			@Override
			public JsScope callback() {
				pgbar.setValue(13);
				return JsScope.quickScope(pgbar.update().render());
			}
		
		}));
		chilliPlugin.add(pgbar);
	}

}

