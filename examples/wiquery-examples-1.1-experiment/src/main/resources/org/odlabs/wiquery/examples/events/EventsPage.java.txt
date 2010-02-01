package org.odlabs.wiquery.examples.events;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.StateEvent;
import org.odlabs.wiquery.core.events.WiQueryAjaxEventBehavior;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.examples.AbstractExamplePage;

/**
 * EventsPage
 */
public class EventsPage extends AbstractExamplePage {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public EventsPage(final PageParameters parameters) {
		super("Events");
		
		TextField<String> blurField = new TextField<String>("blurField");
		TextField<String> changeField = new TextField<String>("changeField");
		Button clickButton = new Button("clickButton");
		Button ajaxClickButton = new Button("ajaxClickButton");
		WebMarkupContainer mouseOutContainer = new WebMarkupContainer("mouseOutContainer");
		
		add(blurField);
		add(changeField);
		add(clickButton);
		add(ajaxClickButton);
		add(mouseOutContainer);
		
		blurField.add(new WiQueryEventBehavior(new Event(StateEvent.BLUR) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope("alert('blur done');");
			}
		}));
		
		changeField.add(new WiQueryEventBehavior(new Event(StateEvent.CHANGE) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope("alert('change done');");
			}
		}));
		
		clickButton.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope("alert('click done');");
			}
		}));
		
		mouseOutContainer.add(new WiQueryEventBehavior(new Event(MouseEvent.MOUSEOUT) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope("alert('mouse out done');");
			}
		}));
		
		ajaxClickButton.add(new WiQueryAjaxEventBehavior(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.WiQueryAjaxEventBehavior#onEvent(org.apache.wicket.ajax.AjaxRequestTarget)
			 */
			@Override
			protected void onEvent(AjaxRequestTarget target) {
				target.appendJavascript("alert('ajax click done');");
			}
		});
	}
}
