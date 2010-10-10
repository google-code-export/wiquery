package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class FusionTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("fusion");
	
	private static FusionTheme instance;
	
	
	/**
	 * @param name
	 */
	private FusionTheme() {
		super("Fusion");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static FusionTheme getInstance() {
		if(instance==null) {
			instance = new FusionTheme();
		}
		return instance;
	}

}
