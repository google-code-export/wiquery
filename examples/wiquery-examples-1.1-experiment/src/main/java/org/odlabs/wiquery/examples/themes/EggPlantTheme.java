package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class EggPlantTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("eggplant");
	
	private static EggPlantTheme instance;
	
	
	/**
	 * @param name
	 */
	private EggPlantTheme() {
		super("Eggplant");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static EggPlantTheme getInstance() {
		if(instance==null) {
			instance = new EggPlantTheme();
		}
		return instance;
	}

}
