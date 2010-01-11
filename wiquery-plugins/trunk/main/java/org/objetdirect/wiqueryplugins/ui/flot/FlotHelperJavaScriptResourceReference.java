/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.objetdirect.wiqueryplugins.ui.flot;

import org.apache.wicket.markup.html.resources.JavascriptResourceReference;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
public class FlotHelperJavaScriptResourceReference extends JavascriptResourceReference {

    /**
     * Singleton instance.
     */
    private static FlotHelperJavaScriptResourceReference instance;

    /**
     * Builds a new instance of {@link FlotJavaScriptResourceReference}.
     */
    private FlotHelperJavaScriptResourceReference() {
        super(FlotHelperJavaScriptResourceReference.class, "ui.flot.helper.js");
    }

    /**
     * Returns the {@link FlotJavaScriptResourceReference} instance.
     */
    public static FlotHelperJavaScriptResourceReference get() {
        if (instance == null) {
            instance = new FlotHelperJavaScriptResourceReference();
        }
        return instance;
    }
}


