/**
 * 
 */
package org.odlabs.wiquery.examples;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;
import org.odlabs.wiquery.examples.themes.RedmondTheme;
import org.odlabs.wiquery.examples.themes.UITheme;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class DemoSession extends WebSession {

	private static final long serialVersionUID = 1L;

	private UITheme theme;
	
	/**
	 * @param request
	 */
	public DemoSession(Request request) {
		super(request);
		theme = RedmondTheme.getInstance();
	}

	public UITheme getTheme() {
		return theme;
	}

	public void setTheme(UITheme theme) {
		this.theme = theme;
	}
	
	/**
	 * Returns the session.
	 * @return
	 */
	public static DemoSession getSession() {
		return (DemoSession)get();
	}

}
