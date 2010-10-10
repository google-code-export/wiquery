package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class BlackTieTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("black-tie");
	
	private static BlackTieTheme instance;
	
	
	/**
	 * @param name
	 */
	private BlackTieTheme() {
		super("Black-tie");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static BlackTieTheme getInstance() {
		if(instance==null) {
			instance = new BlackTieTheme();
		}
		return instance;
	}

}
