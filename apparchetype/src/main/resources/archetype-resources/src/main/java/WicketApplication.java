#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import  org.odlabs.wiquery.utils.WiQueryWebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see ${package}.Start${symbol_pound}main(String[])
 */
public class WicketApplication extends WiQueryWebApplication {

	/**
	 * Constructor
	 */
	public WicketApplication() {
		super();
	}

	/**
	 * @see org.apache.wicket.Application${symbol_pound}init()
	 */
	@Override
	protected void init() {
		super.init();
	}

	/**
	 * @see org.apache.wicket.Application${symbol_pound}getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

}
