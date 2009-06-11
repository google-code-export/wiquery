package org.odlabs.wiquery.plugin;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;

public class ChilliPanel extends WebMarkupContainer implements IWiQueryPlugin {

	private static final long serialVersionUID = 1L;

	public ChilliPanel(String id) {
		super(id);
	}

	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		wiQueryResourceManager.addJavaScriptResource(ChilliPanel.class,
				"jquery.chili-2.2.js");
		wiQueryResourceManager.addJavaScriptResource(ChilliPanel.class,
				"recipes.js");
	}

	public JsStatement statement() {
		return new JsQuery(this).$("code").chain("chili");
	}

}
