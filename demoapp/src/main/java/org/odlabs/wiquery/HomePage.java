package org.odlabs.wiquery;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.odlabs.wiquery.core.behavior.WiQueryAbstractBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.helper.AttributesHelper;
import org.odlabs.wiquery.panels.CorePanel;
import org.odlabs.wiquery.plugin.ChilliPanel;
import org.odlabs.wiquery.ui.accordion.Accordion;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {
    	// simple toggle script
    	JsQuery jsq = new JsQuery();
    	jsq.$(".source .toggle").chain("bind", "'click'", JsScope.quickScope("$(this).parent().toggleClass('visible')").render());
    	jsq.contribute(this);
    	
    	// left menu
    	Accordion accordion = new Accordion("leftMenu");
		add(accordion);
		// content
    	add(new CorePanel("content"));
    }
}
