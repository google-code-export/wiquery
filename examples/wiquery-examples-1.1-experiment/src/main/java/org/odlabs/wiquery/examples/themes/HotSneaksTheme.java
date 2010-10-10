package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class HotSneaksTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("hot-sneaks");
	
	private static HotSneaksTheme instance;
	
	
	/**
	 * @param name
	 */
	private HotSneaksTheme() {
		super("Hot-sneaks");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static HotSneaksTheme getInstance() {
		if(instance==null) {
			instance = new HotSneaksTheme();
		}
		return instance;
	}

}
