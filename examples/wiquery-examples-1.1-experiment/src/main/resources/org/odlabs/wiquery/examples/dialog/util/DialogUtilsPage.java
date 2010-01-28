package org.odlabs.wiquery.examples.dialog.util;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.ui.dialog.util.DialogResourcesBehavior;
import org.odlabs.wiquery.ui.dialog.util.DialogUtils;
import org.odlabs.wiquery.ui.dialog.util.WaitDialogStatements;

/**
 * DialogUtilsPage
 */
public class DialogUtilsPage extends AbstractExamplePage {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public DialogUtilsPage(final PageParameters parameters) {
		super("DialogUtils example");
		add(new DialogResourcesBehavior());
		
		WebMarkupContainer simpleDialog = new WebMarkupContainer("simpleDialog");
		simpleDialog.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope(DialogUtils.simpleDialog(null, "A title", "My message"));
			}
		}));
		add(simpleDialog);
		
		WebMarkupContainer errorDialog = new WebMarkupContainer("errorDialog");
		errorDialog.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope(DialogUtils.errorDialog(null, "An error message"));
			}
		}));
		add(errorDialog);
		
		WebMarkupContainer questionDialog = new WebMarkupContainer("questionDialog");
		questionDialog.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope(DialogUtils.questionDialog(null, "A question message"));
			}
		}));
		add(questionDialog);
		
		WebMarkupContainer warningDialog = new WebMarkupContainer("warningDialog");
		warningDialog.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope(DialogUtils.warningDialog(null, "A warning message"));
			}
		}));
		add(warningDialog);
		
		WebMarkupContainer waitDialog = new WebMarkupContainer("waitDialog");
		waitDialog.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				WaitDialogStatements wait = DialogUtils.waitDialog(null);
				return JsScope.quickScope(wait.getOpen().render()
						+ "setTimeout(function() {"
						+ wait.getClose().render()
						+ " }, 5000)");
			}
		}));
		add(waitDialog);
	}
}
