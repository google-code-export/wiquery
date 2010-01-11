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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.objetdirect.wiqueryplugins.core.javascript.JsStatementWrapper;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
@WiQueryUIPlugin
public class AdvancedFlot extends Flot {

    private Overview overview ;
    private Options options;
    private JsStatement statement = new JsStatement();
    private String varValue;
    private String xaxis = "time";
    private String selection = "x";
    private ArrayList<Double> numberSerie = new ArrayList<Double>();
    private double maxYValue;
    private double minYvalue;
    private boolean sorted = false;

   

    public AdvancedFlot(String id) {
        super(id);
        options = super.getOptions();
        options.put("xaxis", "mode: \"" + xaxis + "\"");
        options.put("selection", "mode: \"" + selection + "\"");
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
        this.overview.execute(); //  process the statements
    }

    /**     
     * Sets X axis value, default value is "time"
     * @param value
     * @return AdvancedFlot
     */
    public AdvancedFlot setXaxis(String value) {
        if (value != null && value.length() > 0) {
            options.removeOption(xaxis); // remove the default one
            options.put(xaxis, "mode: \"" + value + "\"");
            return this;
        } else {
            throw new IllegalArgumentException("xaxis value is null or empty !");
        }

    }

    /**
     * Sets selection, default value is "x"
     * @param value
     * @return AdvancedFlot
     */
    public AdvancedFlot setSelection(String value) {
        if (value != null && value.length() > 0) {
            options.removeOption(selection); // remove the default one
            options.put(selection, "mode: \"" + "x" + "\"");
            return this;
        } else {
            throw new IllegalArgumentException("selection value is null or empty !");
        }
    }

    /**
     * sets the chart data
     * @param data List of AdvancedFlotData objects
     */
    public void setChartData(List<AdvancedFlotData> data) {
        if (data != null && data.size() > 0) {
            varValue = "d";
            statement.append("var " + varValue + "= [");
            int i = 0;
            for (AdvancedFlotData advancedFlotData : data) {
                statement.append("[" + advancedFlotData.getxValue() + "," + advancedFlotData.getyValue() + "]");
                numberSerie.add(advancedFlotData.getyValue());
                // checks if we come to the end of the serie, if yes don't put ";" 
                if (!(i == data.size() - 1)) {
                    statement.append(",");
                }
                i++;
            }

            statement.append("];");
            statement.append(" ");

        } else {
            throw new IllegalArgumentException("flot chart data is null or collection is empty ! ");
        }
    }

    @Override
    public JsStatement statement() {

        statement.append(" var options = { " +
                " xaxis : { " + options.get("xaxis") + "}," +
                " selection : { " + options.get("selection") + "},  " +
                " grid: { markings: weekendAreas } };");


        statement.append(" var plot = $.plot(" + new JsQuery(this).$().append("," + "[" + varValue + "]" + ", options " + ") ").render());
        if (this.overview != null) {
            statement.append(this.overview.getOwnJavaScriptStatementPartOne() + " ");
        }

        JsStatement stepOneStatement = new JsQuery(this).$().append(".bind(\"plotselected\", function (event, ranges) { plot = ");
        statement.append( new JsStatementWrapper( stepOneStatement ).getStatement());
        statement.append(" $.plot(" + new JsStatementWrapper( new JsQuery(this).$()).getStatement() + ", [" + varValue + "] , $.extend(true, {}, options, {");
        statement.append(" xaxis: { min: ranges.xaxis.from, max: ranges.xaxis.to } ");
        statement.append(" })); ");

        
        if (this.overview != null) {

            statement.append(" overview.setSelection(ranges, true); }); ");
            statement.append(this.overview.getOwnJavaScriptStatementPartTwo() + " ");
        } else {
            statement.append(" }); ");
        }

        return statement;
    }

    @Override
    public void contribute(WiQueryResourceManager wiQueryResourceManager) {
        super.contribute(wiQueryResourceManager);
        wiQueryResourceManager.addJavaScriptResource(FlotHelperJavaScriptResourceReference.get());
    }


     protected double getMaxYValue() {
        sortNumberSerie();
        return maxYValue;
    }

    protected double getMinYvalue() {
        sortNumberSerie();
        return minYvalue;
    }

    private void sortNumberSerie() {
        if (numberSerie != null && numberSerie.size() > 0) {
            if (!sorted) {
                Collections.sort(this.numberSerie);
                this.minYvalue = this.numberSerie.get(0);
                this.maxYValue = this.numberSerie.get(this.numberSerie.size() - 1);
                this.sorted = true;
            }
        }
    }
}
