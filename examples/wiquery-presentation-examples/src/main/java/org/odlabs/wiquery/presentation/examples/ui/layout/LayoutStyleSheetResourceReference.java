package org.odlabs.wiquery.presentation.examples.ui.layout;

import org.apache.wicket.ResourceReference;

/**
 * $Id$
 * <p>
 * References the jQuery UI Layout stylesheet.
 * </p>
 * 
 * @author Julien Roche
 */
public class LayoutStyleSheetResourceReference extends
		ResourceReference {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 4585057795574929263L;

	/** Singleton instance */
	private static LayoutStyleSheetResourceReference instance;

	/**
	 * Builds a new instance of {@link LayoutStyleSheetResourceReference}.
	 */
	private LayoutStyleSheetResourceReference() {
		super(LayoutStyleSheetResourceReference.class, "jquery.layout.css");
	}
	
	/**
	 * @return the instance
	 */
	public static LayoutStyleSheetResourceReference get() {
		if (instance == null) {
			instance = new LayoutStyleSheetResourceReference();
		}
		return instance;
	}
}
