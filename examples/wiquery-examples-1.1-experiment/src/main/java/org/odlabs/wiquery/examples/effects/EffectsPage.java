package org.odlabs.wiquery.examples.effects;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.effects.Effect;
import org.odlabs.wiquery.core.effects.EffectBehavior;
import org.odlabs.wiquery.core.effects.basic.Hide;
import org.odlabs.wiquery.core.effects.basic.Show;
import org.odlabs.wiquery.core.effects.basic.Toggle;
import org.odlabs.wiquery.core.effects.sliding.SlideToggle;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.examples.AbstractExamplePage;

/**
 * EffectsPage
 */
public class EffectsPage extends AbstractExamplePage implements IWiQueryPlugin {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public EffectsPage(final PageParameters parameters) {
		super("Effects");
		
		// Hide on load
		WebMarkupContainer hideTextOnLoad = new WebMarkupContainer("hideTextOnLoad");
		hideTextOnLoad.add(new EffectBehavior(new Hide()));
		add(hideTextOnLoad);
		
		// Hide effect
		addButtonWithEffect("hideButton", "hideText", new Hide());
		
		// Show effect
		addButtonWithEffect("showButton", "showText", new Show());
		
		// Toggle effect
		addButtonWithEffect("toggleButton", "toggleText", new Toggle());
		
		// slideToggle effect
		addButtonWithEffect("slideToggleButton", "slideToggleText", new SlideToggle());
	}

	/**
	 * Method inserting a button with effect on a text
	 * @param buttonId
	 * @param textId
	 * @param effect
	 */
	private void addButtonWithEffect(String buttonId, final String textId, final Effect effect) {
		WebMarkupContainer button = new WebMarkupContainer(buttonId);
		
		button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.core.events.Event#callback()
			 */
			@Override
			public JsScope callback() {
				return JsScope.quickScope(new JsStatement().$(null, "#" + textId).chain(effect).render());
			}
		}));
		
		add(button);
	}

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#contribute(org.odlabs.wiquery.core.commons.WiQueryResourceManager)
	 */
	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		// Nothing to do
	}

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#statement()
	 */
	public JsStatement statement() {
		return new JsStatement();
	}
}
