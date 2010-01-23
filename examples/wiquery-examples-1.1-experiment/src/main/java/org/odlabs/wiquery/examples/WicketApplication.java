package org.odlabs.wiquery.examples;

import groovy.lang.GroovyShell;

import java.net.URL;

import org.apache.wicket.MetaDataKey;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.Session;
import org.odlabs.wiquery.ui.themes.IThemableApplication;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;
import org.odlabs.wiquery.utils.WiQueryWebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see war.Start#main(String[])
 */
//@WiQueryMergedResources(enable=true)
public class WicketApplication extends WiQueryWebApplication implements IThemableApplication {
	// Constants
	/** 
	 * meta data for WiQueryCoreHeaderContributor. 
	 */
	private static final MetaDataKey<ResourceReference> WIQUERY_THEME_KEY = new MetaDataKey<ResourceReference>() {
		private static final long serialVersionUID = 1L;
	};
	
	// Properties
	/** Groovy Shell */
	private GroovyShell groovyShell;
	
	/**
	 * Constructor
	 */
	public WicketApplication() {
		super();
	}

	/**
	 * @return the Groovy Shell
	 */
	public GroovyShell getGroovyShell() {
		return groovyShell;
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.ui.themes.IThemableApplication#getTheme(org.apache.wicket.Session)
	 */
	public ResourceReference getTheme(Session session) {
		if(session.getMetaData(WIQUERY_THEME_KEY) == null){
			session.setMetaData(WIQUERY_THEME_KEY, new WiQueryCoreThemeResourceReference("fusion"));
		}
		
		return session.getMetaData(WIQUERY_THEME_KEY);
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	protected void init() {
		super.init();
		groovyShell = new GroovyShell();
		
		ClassLoader myClassLoader = Thread.currentThread().getContextClassLoader();
		URL file = myClassLoader.getResource("groovy/security/groovy.policy");
		System.setProperty("java.security.policy", file.toString());
		System.setSecurityManager(new SecurityManager());
	}
	
	/**
	 * Change the current theme
	 * @param theme
	 */
	public void setTheme(ResourceReference theme) {
		Session.get().setMetaData(WIQUERY_THEME_KEY, theme);
	}
}
