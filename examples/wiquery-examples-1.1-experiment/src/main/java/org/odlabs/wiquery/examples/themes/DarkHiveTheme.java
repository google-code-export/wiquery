package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class DarkHiveTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("dark-hive");
	
	private static DarkHiveTheme instance;
	
	
	/**
	 * @param name
	 */
	private DarkHiveTheme() {
		super("Dark-hive");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static DarkHiveTheme getInstance() {
		if(instance==null) {
			instance = new DarkHiveTheme();
		}
		return instance;
	}

}
