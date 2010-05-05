package org.objetdirect.wiqueryplugins.ui.blockui;

import org.apache.wicket.markup.html.resources.JavascriptResourceReference;

/**
 * User: Altug Bilgin ALTINTAS
 * Date: 05.May.2010
 * Time: 21:21:13
 */
public class AjaxLinkBlockUIJavaScriptResourceReference extends JavascriptResourceReference {

    /**
     * Singleton instance.
     */
    private static AjaxLinkBlockUIJavaScriptResourceReference instance;

    public AjaxLinkBlockUIJavaScriptResourceReference() {
        super(AjaxLinkBlockUIJavaScriptResourceReference.class, "ui.blockui.js");

    }

    /**
     * Returns AjaxLinkBlockUIJavaScriptResourceReference instance
     */
    public static AjaxLinkBlockUIJavaScriptResourceReference get() {
        if (instance == null) {
            instance = new AjaxLinkBlockUIJavaScriptResourceReference();
        }
        return instance;
    }
}
