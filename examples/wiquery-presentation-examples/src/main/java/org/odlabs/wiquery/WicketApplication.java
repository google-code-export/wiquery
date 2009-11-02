package org.odlabs.wiquery;

import org.apache.wicket.markup.html.WebPage;
import org.odlabs.wiquery.demo.dashboard.DashBoard;
import org.odlabs.wiquery.utils.WiQueryWebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see org.odlabs.wiquery.Start#main(String[])
 */
public class WicketApplication extends WiQueryWebApplication
{    
    /**
     * Constructor
     */
	public WicketApplication()
	{
//		WiQueryCoreHeaderContributor.setTheme(new WiQueryCoreThemeResourceReference("mintchoc"));
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<? extends WebPage> getHomePage()
	{
		return DashBoard.class;
	}

}
