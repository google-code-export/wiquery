package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class BlitzerTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("blitzer");
	
	private static BlitzerTheme instance;
	
	
	/**
	 * @param name
	 */
	private BlitzerTheme() {
		super("Blitzer");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static BlitzerTheme getInstance() {
		if(instance==null) {
			instance = new BlitzerTheme();
		}
		return instance;
	}

}
