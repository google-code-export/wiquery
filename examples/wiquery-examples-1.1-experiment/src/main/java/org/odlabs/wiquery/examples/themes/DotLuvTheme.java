package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class DotLuvTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("dot-luv");
	
	private static DotLuvTheme instance;
	
	
	/**
	 * @param name
	 */
	private DotLuvTheme() {
		super("Dot-luv");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static DotLuvTheme getInstance() {
		if(instance==null) {
			instance = new DotLuvTheme();
		}
		return instance;
	}

}
