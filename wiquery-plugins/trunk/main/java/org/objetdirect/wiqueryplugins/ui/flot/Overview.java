/*
 * Copyright (c) 2009 WiQuery team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.objetdirect.wiqueryplugins.ui.flot;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.objetdirect.wiqueryplugins.core.javascript.JsStatementWrapper;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
@WiQueryUIPlugin
public class Overview  extends WebMarkupContainer implements IWiQueryPlugin{

    private AdvancedFlot advancedFlot ;
    private StringBuffer ownJavaScriptStatementPartOne = new StringBuffer();
    private StringBuffer ownJavaScriptStatementPartTwo = new StringBuffer();

    public StringBuffer getOwnJavaScriptStatementPartOne() {
        return ownJavaScriptStatementPartOne;
    }

    public StringBuffer getOwnJavaScriptStatementPartTwo() {
        return ownJavaScriptStatementPartTwo;
    }
    
    public Overview(String id, AdvancedFlot advancedFlot) {
        super(id);
        this.advancedFlot = advancedFlot;
    }


    protected void execute() {
        this.ownJavaScriptStatementPartOne.append(" var overview = $.plot("+new JsStatementWrapper(new JsQuery(this).$()).getStatement()+", [d], { ");
        this.ownJavaScriptStatementPartOne.append(" lines: { show: true, lineWidth: 1 }, ");
        this.ownJavaScriptStatementPartOne.append(" shadowSize: 1, ");
        this.ownJavaScriptStatementPartOne.append(" xaxis: { ticks: [], mode: \"time\" }, ");
        this.ownJavaScriptStatementPartOne.append(" yaxis: { ticks: [], min: "+this.advancedFlot.getMinYvalue()+", max: "+this.advancedFlot.getMaxYValue()+" }, ");
        this.ownJavaScriptStatementPartOne.append(" selection: { mode: \"x\" } }); ");

        this.ownJavaScriptStatementPartTwo.append(new JsStatementWrapper(new JsQuery(this).$()).getStatement()+".bind(\"plotselected\", function (event, ranges) {");
        this.ownJavaScriptStatementPartTwo.append("plot.setSelection(ranges); });");

    }

    public void contribute(WiQueryResourceManager wiQueryResourceManager) {
       // no need to contribute any javascript resource
    }

    public JsStatement statement() {
        return new JsStatement(); // no need to return anything.
    }

}
