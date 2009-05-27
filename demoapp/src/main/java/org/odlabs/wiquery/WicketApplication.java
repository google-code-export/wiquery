package org.odlabs.wiquery;

import org.apache.wicket.ResourceReference;
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
		super();
	}
	
	
	
	@Override
	protected void init() {
		super.init();
//		this.setTheme(new ResourceReference(WicketApplication.class, 
//			"sampleTheme/jquery-ui-1.7.1.custom.css"));
	}



	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

}
