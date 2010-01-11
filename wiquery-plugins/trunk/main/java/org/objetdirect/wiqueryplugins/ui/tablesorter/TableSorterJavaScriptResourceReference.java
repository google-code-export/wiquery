package org.objetdirect.wiqueryplugins.ui.tablesorter;

import org.apache.wicket.markup.html.resources.JavascriptResourceReference;
import org.objetdirect.wiqueryplugins.ui.flot.FlotHelperJavaScriptResourceReference;
import org.objetdirect.wiqueryplugins.ui.flot.FlotJavaScriptResourceReference;

public class TableSorterJavaScriptResourceReference extends JavascriptResourceReference {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -752186803057423373L;
	/**
     * Singleton instance.
     */
    private static TableSorterJavaScriptResourceReference instance;
    
	
	/**
     * Builds a new instance of {@link FlotJavaScriptResourceReference}.
     */
    private TableSorterJavaScriptResourceReference() {
        super(TableSorterJavaScriptResourceReference.class, "ui.tablesorter.js");
    }

    /**
     * Returns the {@link FlotJavaScriptResourceReference} instance.
     */
    public static TableSorterJavaScriptResourceReference get() {
        if (instance == null) {
            instance = new TableSorterJavaScriptResourceReference();
        }
        return instance;
    }
}
