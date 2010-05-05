package org.objetdirect.wiqueryplugins.ui.blockui.ajaxcalldecorators;

import org.apache.wicket.ajax.calldecorator.AjaxCallDecorator;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsStatement;

/**
 * User: Altug Bilgin ALTINTAS
 * Date: 06.May.2010
 * Time: 02:16:56
 */
public class GrowlAjaxDecorator extends AjaxCallDecorator implements IWiQueryPlugin {
    private final String bigMessage;
    private final String smallMessage;

    public GrowlAjaxDecorator(String bigMessage, String smallMessage) {
        this.bigMessage = bigMessage;
        this.smallMessage = smallMessage;
    }

    @Override
    public CharSequence decorateScript(CharSequence script) {
        return script + "$.growlUI('" + bigMessage + "', '" + smallMessage + "');";
    }


    @Override
    public CharSequence decorateOnSuccessScript(CharSequence script) {
        return script;
    }

    public void contribute(WiQueryResourceManager wiQueryResourceManager) {

    }

    public JsStatement statement() {
        return new JsStatement();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
