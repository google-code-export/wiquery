package org.odlabs.wiquery.plugin.layout;

import org.apache.wicket.ResourceReference;

/**
 * 
 * @author exterb
 *
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
		super(LayoutStyleSheetResourceReference.class, "layout.css");
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
