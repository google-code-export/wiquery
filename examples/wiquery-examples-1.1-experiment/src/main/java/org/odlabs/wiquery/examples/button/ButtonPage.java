package org.odlabs.wiquery.examples.button;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.ui.button.Button;
import org.odlabs.wiquery.ui.button.ButtonAjax;
import org.odlabs.wiquery.ui.button.ButtonIcon;
import org.odlabs.wiquery.ui.core.JsScopeUiEvent;

/**
 * ButtonPage
 */
public class ButtonPage extends AbstractExamplePage {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public ButtonPage(final PageParameters parameters) {
		super("Button example");
		
		add(new Button("firstButton", "A button element"));
		add(new Button("secondButton"));
		add(new Button("thirdButton", "An anchor"));
		
		Button fourthButton = new Button("fourthButton", "A label set via Wicket");
		fourthButton.setIcons(new ButtonIcon("ui-icon-gear", "ui-icon-triangle-1-s"));
		fourthButton.setClickEvent(JsScopeUiEvent.quickScope("alert('you click me');"));
		add(fourthButton);
		
		add(new ButtonAjax("fifthButton", "An ajax button") {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.ui.button.ButtonAjax#onClick(org.apache.wicket.ajax.AjaxRequestTarget)
			 */
			@Override
			public void onClick(AjaxRequestTarget target) {
				target.appendJavascript("alert('Ajax call !!');");
			}
		});
	}
}
