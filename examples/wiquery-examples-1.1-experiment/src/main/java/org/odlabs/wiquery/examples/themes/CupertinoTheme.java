package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class CupertinoTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("cupertino");
	
	private static CupertinoTheme instance;
	
	
	/**
	 * @param name
	 */
	private CupertinoTheme() {
		super("Cupertino");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static CupertinoTheme getInstance() {
		if(instance==null) {
			instance = new CupertinoTheme();
		}
		return instance;
	}

}
