package org.odlabs.wiquery;

import org.odlabs.wiquery.presentation.examples.scrumdashboard.ScrumDashboardPage;
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
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<ScrumDashboardPage> getHomePage()
	{
		return ScrumDashboardPage.class;
	}

}
