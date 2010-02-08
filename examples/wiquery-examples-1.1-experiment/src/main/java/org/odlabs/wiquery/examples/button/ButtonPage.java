package org.odlabs.wiquery.examples.button;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.ui.button.Button;
import org.odlabs.wiquery.ui.button.ButtonAjax;
import org.odlabs.wiquery.ui.button.ButtonBehavior;
import org.odlabs.wiquery.ui.button.ButtonCheckSet;
import org.odlabs.wiquery.ui.button.ButtonElement;
import org.odlabs.wiquery.ui.button.ButtonIcon;
import org.odlabs.wiquery.ui.button.ButtonRadioSet;
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
		
		// Behavior button
		AjaxLink<String> wicketLink = new AjaxLink<String> ("wicketLink") {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.apache.wicket.ajax.markup.html.AjaxLink#onClick(org.apache.wicket.ajax.AjaxRequestTarget)
			 */
			@Override
			public void onClick(AjaxRequestTarget target) {
				target.appendJavascript("alert('Ajax link');");
			}
		};
		ButtonBehavior buttonBehavior = new ButtonBehavior();
		buttonBehavior.setLabel("An ajax link with wicket");
		wicketLink.add(buttonBehavior);
		add(wicketLink);
		
		// Classic buttons
		add(new Button("firstButton", "A button element"));
		add(new Button("secondButton"));
		add(new Button("thirdButton", "An anchor"));
		
		Button fourthButton = new Button("fourthButton", "A label set via Wicket");
		fourthButton.setIcons(new ButtonIcon("ui-icon-gear", "ui-icon-triangle-1-s"));
		fourthButton.setClickEvent(JsScopeUiEvent.quickScope("alert('you click me');"));
		add(fourthButton);
		
		// Ajax button
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
		
		// Radio & check set
		List<ButtonElement<String>> elements = new ArrayList<ButtonElement<String>>();
		elements.add(new ButtonElement<String>(new Model<String>("button1"), new Model<String>("Button One")));
		elements.add(new ButtonElement<String>(new Model<String>("button2"), new Model<String>("Button Two")));
		elements.add(new ButtonElement<String>(new Model<String>("button3"), new Model<String>("Button Three")));
		
		add(new ButtonRadioSet<String>("radioSet", elements));
		add(new ButtonCheckSet<String>("checkSet", elements));
	}
}
