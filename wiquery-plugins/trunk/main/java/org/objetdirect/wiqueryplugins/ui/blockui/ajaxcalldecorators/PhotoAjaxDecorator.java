package org.objetdirect.wiqueryplugins.ui.blockui.ajaxcalldecorators;

import org.apache.wicket.ajax.calldecorator.AjaxCallDecorator;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsStatement;

/**
 * User: Altug Bilgin ALTINTAS
 * Date: 06.May.2010
 * Time: 00:45:51
 */
public class PhotoAjaxDecorator extends AjaxCallDecorator implements IWiQueryPlugin {

    private final String blockMessage;

    public PhotoAjaxDecorator() {

        this.blockMessage = "Please wait...";
    }

    public PhotoAjaxDecorator(String blockMessage) {
        this.blockMessage = blockMessage;
    }

    @Override
    public CharSequence decorateScript(CharSequence script) {

        return script + "$.blockUI({ message: '<h1>" + blockMessage + "</h1>', css: { border: 'none', padding: '15px', backgroundColor: '#000', '-webkit-border-radius': '10px', '-moz-border-radius': '10px', opacity: .5, color: '#fff'   } });";
    }


    @Override
    public CharSequence decorateOnSuccessScript(CharSequence script) {

        return script + "$.unblockUI();";
    }

    public void contribute(WiQueryResourceManager wiQueryResourceManager) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public JsStatement statement() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

