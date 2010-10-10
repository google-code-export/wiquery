package org.odlabs.wiquery.examples;

import groovy.lang.GroovyShell;

import java.net.URL;

import org.apache.wicket.Request;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.HttpSessionStore;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.session.ISessionStore;
import org.odlabs.wiquery.core.commons.IWiQuerySettings;
import org.odlabs.wiquery.core.commons.WiQuerySettings;
import org.odlabs.wiquery.examples.themes.UITheme;
import org.odlabs.wiquery.ui.themes.IThemableApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see war.Start#main(String[])
 */
public class WicketApplication extends WebApplication implements IThemableApplication, IWiQuerySettings {
	// Constants
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WicketApplication.class);

	
	// Properties
	/** Groovy Shell */
	private GroovyShell groovyShell;
	
	/**
	 * Constructor
	 */
	public WicketApplication() {
		super();
	}

	public static WicketApplication getApp() {
		return (WicketApplication)get();
	}
	
	/**
	 * @return the Groovy Shell
	 */
	public GroovyShell getGroovyShell() {
		return groovyShell;
	}

	@Override
	public Session newSession(Request request, Response response) {
		// TODO Auto-generated method stub
		return new DemoSession(request);
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
		return ((DemoSession)session).getTheme().getTheme();
	}

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.commons.IWiQuerySettings#getWiQuerySettings()
	 */
	public WiQuerySettings getWiQuerySettings() {
		WiQuerySettings settings = new WiQuerySettings();
		//settings.setEnableResourcesMerging(true);
		
		return settings;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	protected void init() {
		super.init();
		groovyShell = new GroovyShell();
		
		try{
			ClassLoader myClassLoader = Thread.currentThread().getContextClassLoader();
			URL file = myClassLoader.getResource("groovy/security/groovy.policy");
			System.setProperty("java.security.policy", file.toString());
			System.setSecurityManager(new SecurityManager());
			
		} catch(Exception e){
			LOGGER.error("Can't apply security policy");
		}
		
		//remove thread monitoring from resource watcher
		this.getResourceSettings().setResourcePollFrequency(null);
	}

	/**
	 * Change the current theme
	 * @param theme
	 */
	public void setTheme(UITheme theme) {
		DemoSession.getSession().setTheme(theme);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.apache.wicket.protocol.http.WebApplication#newSessionStore()
	 */
	@Override
	protected ISessionStore newSessionStore() {
		return new HttpSessionStore(this);
	}
}
