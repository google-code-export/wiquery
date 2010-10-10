package org.odlabs.wiquery.plugin.layout;

import org.odlabs.wiquery.core.javascript.JsScopeContext;

/**
 * Default implementation of the JsScopeLayoutEvent
 * @author Julien Roche
 * @since 1.0
 */
public class DefaultJsScopeLayoutEvent extends JsScopeLayoutEvent {
	//Constants
	/**	Constant of serialization */
	private static final long serialVersionUID = 1L;
	
	// Properties
	private CharSequence javascriptCode;
	
	public DefaultJsScopeLayoutEvent(CharSequence javascriptCode) {
		super();
		this.javascriptCode = javascriptCode;
	}
	
	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.javascript.JsScope#execute(org.odlabs.wiquery.core.javascript.JsScopeContext)
	 */
	@Override
	protected final void execute(JsScopeContext scopeContext) {
		scopeContext.append(javascriptCode);
	}

}
