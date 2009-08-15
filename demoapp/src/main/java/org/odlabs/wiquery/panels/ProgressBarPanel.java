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

	private static final long serialVersionUID = 1L;

	public ProgressBarPanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		this.add(chilliPlugin);
		Button button = new Button("increaseProgress");

		final ProgressBar pgbar = new ProgressBar("progress");
		pgbar.setValue(0);
		button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {

			private static final long serialVersionUID = 1L;

			@Override
			public JsScope callback() { // increase progress bar value by 13

				pgbar.setValue(13);
				return JsScope.quickScope(pgbar.update().render());
			}

		}));
		// must be done here, otherwise overridden by the callback method
		pgbar.setValue(0);
		chilliPlugin.add(pgbar);
		chilliPlugin.add(button);
		pgbar.setValue(0);
	}

}
