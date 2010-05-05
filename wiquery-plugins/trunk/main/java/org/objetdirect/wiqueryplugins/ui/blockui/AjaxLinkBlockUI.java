package org.objetdirect.wiqueryplugins.ui.blockui;

import org.apache.wicket.ajax.IAjaxCallDecorator;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsStatement;

/**
 * @author: Altug Bilgin ALTINTAS
 * Date: 05.May.2010
 */
public abstract class AjaxLinkBlockUI extends AjaxLink implements IWiQueryPlugin {

    private String id;

    private IAjaxCallDecorator ajaxCallDecorator;

    public AjaxLinkBlockUI(String id, IAjaxCallDecorator ajaxCallDecorator) {
        super(id);
        this.id = id;
        this.ajaxCallDecorator = ajaxCallDecorator;

    }

    protected IAjaxCallDecorator getAjaxCallDecorator() {
        return this.ajaxCallDecorator;
    }


    public void contribute(WiQueryResourceManager wiQueryResourceManager) {
        wiQueryResourceManager.addJavaScriptResource(AjaxLinkBlockUIJavaScriptResourceReference.get());
    }

    public JsStatement statement() {
        return new JsStatement();
    }

    public void setAjaxCallDecorator(IAjaxCallDecorator ajaxCallDecorator) {
        this.ajaxCallDecorator = ajaxCallDecorator;
    }
}
