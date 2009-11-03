package org.odlabs.wiquery;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.odlabs.wiquery.demo.dashboard.DashBoard;
import org.odlabs.wiquery.ui.themes.IThemableApplication;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;
import org.odlabs.wiquery.utils.WiQueryWebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see org.odlabs.wiquery.Start#main(String[])
 */
public class WicketApplication extends WiQueryWebApplication implements IThemableApplication
{    
	
	private ResourceReference theme;
	
    /**
     * Constructor
     */
	public WicketApplication()
	{
		theme = new WiQueryCoreThemeResourceReference("fusion");
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<? extends WebPage> getHomePage()
	{
		return DashBoard.class;
	}
	
	public void setTheme(ResourceReference resourceReference) {
		this.theme = resourceReference;
	}

	public ResourceReference getTheme(Session session) {
		return theme;
	}

}
