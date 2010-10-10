package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class ExciteBikeTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("excite-bike");
	
	private static ExciteBikeTheme instance;
	
	
	/**
	 * @param name
	 */
	private ExciteBikeTheme() {
		super("Excite-bike");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static ExciteBikeTheme getInstance() {
		if(instance==null) {
			instance = new ExciteBikeTheme();
		}
		return instance;
	}

}
