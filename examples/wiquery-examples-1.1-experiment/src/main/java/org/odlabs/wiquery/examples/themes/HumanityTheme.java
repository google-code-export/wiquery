package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class HumanityTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("humanity");
	
	private static HumanityTheme instance;
	
	
	/**
	 * @param name
	 */
	private HumanityTheme() {
		super("Humanity");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static HumanityTheme getInstance() {
		if(instance==null) {
			instance = new HumanityTheme();
		}
		return instance;
	}

}
