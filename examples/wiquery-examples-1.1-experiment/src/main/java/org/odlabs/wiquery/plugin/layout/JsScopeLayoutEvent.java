package org.odlabs.wiquery.plugin.layout;

import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsScopeContext;


/**
 * This class represent a JsScope event for the jQuery UI layout
 * The javascript representation will be like this:
 * <p>
 * 	function(paneName, paneElement, paneState, paneOptions, layoutName) { ... }
 * </p>
 * @author Julien Roche
 * @since 1.0
 */
public abstract class JsScopeLayoutEvent extends JsScope {
	//Constants
	/**	Constant of serialization */
	private static final long serialVersionUID = 1L;
	
	/**Default constructor
	 */
	public JsScopeLayoutEvent() {
		super("paneName", "paneElement", "paneState", "paneOptions", "layoutName");
	}
	
	/**
	 * Creates a default {@link JsScopeLayoutEvent} to execute the given statement.
	 * 
	 * @param javascriptCode
	 *            the JavaScript statement to execute with the scope.
	 * @return the created {@link JsScopeLayoutEvent}.
	 */
	public static JsScopeLayoutEvent quickScope(final CharSequence javascriptCode) {
		return new JsScopeLayoutEvent() {
			private static final long serialVersionUID = 1L;

			/* (non-Javadoc)
			 * @see org.odlabs.wiquery.core.javascript.JsScope#execute(org.odlabs.wiquery.core.javascript.JsScopeContext)
			 */
			@Override
			protected void execute(JsScopeContext scopeContext) {
				scopeContext.append(javascriptCode);
			}

		};
	}
}
