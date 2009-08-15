/**
 * 
 */
package org.odlabs.wiquery.plugin.flexigrid;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;

/**
 * @author PMARGUER
 * 
 */
public class FlexigridPanel extends WebMarkupContainer implements
		IWiQueryPlugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlexigridPanel(String id) {
		super(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.odlabs.wiquery.core.commons.IWiQueryPlugin#contribute(org.odlabs.
	 * wiquery.core.commons.WiQueryResourceManager)
	 */
	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		wiQueryResourceManager.addJavaScriptResource(FlexigridPanel.class,
				"flexigrid.pack.js");
		wiQueryResourceManager.addCssResource(FlexigridPanel.class,
				"css/flexigrid/flexigrid.css");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#statement()
	 */
	public JsStatement statement() {
		return new JsQuery(this).$(".flexme").chain("flexigrid");
	}

}
