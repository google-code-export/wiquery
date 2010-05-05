package org.objetdirect.wiqueryplugins.ui.tablesorter;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;

@WiQueryUIPlugin
public class TableSorter extends WebMarkupContainer implements IWiQueryPlugin {


    private static final long serialVersionUID = 1L;

    private JsStatement statement = new JsStatement();

    public TableSorter(String id) {
        super(id);


    }

    public void contribute(WiQueryResourceManager wiQueryResourceManager) {
        wiQueryResourceManager.addJavaScriptResource(TableSorterJavaScriptResourceReference.get());
    }

    public JsStatement statement() {
        this.statement.append(new JsQuery(this).$().append(".tablesorter({sortList:[[0,0],[2,1]], widgets: ['zebra']})").render());
        return this.statement;

    }

}
