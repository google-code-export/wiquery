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

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;

/**
 *
 * Plot a simple Flot Graph.
 * 
 * into wiquery
 * 
 * @author Altug Bilgin ALTINTAS
 */
@WiQueryUIPlugin
public class Flot extends WebMarkupContainer implements IWiQueryPlugin {

   
    private String id;
    private JsStatement statement = new JsStatement();
    private Options options;

    public Flot(String id) {
        super(id);
        this.id = id;
        this.options = new Options();
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    /**
     * sets lots of series
     * 
     * HashMap key : serie name - String
     * HassMap value : List of FlotData
     * @param data HashMap object
     */
    public void setChartData(HashMap<String, List<FlotData>> data) {
        if (data != null) {
            String keyNames = "";
            Set<String> keys = data.keySet();
            for (String key : keys) {
                List<FlotData> values = data.get(key);
                keyNames += key +",";
                String varValue = key;
                statement.append("var " + varValue + "= [");
                int counter = 0 ;
                for (FlotData flotData : values) {
                    statement.append("[" + flotData.getxValue() + "," + flotData.getyValue() + "]");
                    if (!(counter == values.size() - 1)) {
                        statement.append(",");
                    }
                    counter++;
                }
                statement.append("]; ");
            }

            keyNames = keyNames.substring(0, keyNames.length()-1); // don't take the last ","
            statement.append(" $.plot(" + new JsQuery(this).$().append("," + "[" + keyNames + "]" + ")").render());
        } else {
            throw new IllegalArgumentException("data is null !");
        }
    }

    /**
     * sets single serie with double[][] array.
     * 
     * @param data two dimension array
     */
    public void setChartData(double[][] data) {

        if (data != null) {

            String varValue = "d1";
            statement.append("var " + varValue + "= [");
            for (int i = 0; i < data.length; i++) {
                double[] ds = data[i];
                statement.append("[" + ds[0] + "," + ds[1] + "]");
                if (!(i == data.length - 1)) {
                    statement.append(",");
                }
            }
            statement.append("]; ");

            statement.append(" $.plot(" + new JsQuery(this).$().append("," + "[" + varValue + "]" + ")").render());


        }
    }

    public void contribute(WiQueryResourceManager wiQueryResourceManager) {
        wiQueryResourceManager.addJavaScriptResource(FlotJavaScriptResourceReference.get());
        wiQueryResourceManager.addJavaScriptResource(ExCanvasJavaScriptResourceReference.get());
    }

    public JsStatement statement() {
        return this.statement;
    }
}
