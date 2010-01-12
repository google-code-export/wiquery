
package com.kodcu.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.objetdirect.wiqueryplugins.ui.flot.Flot;
import org.objetdirect.wiqueryplugins.ui.flot.FlotData;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
public class FlotSeriesPage extends WebPage {

    public FlotSeriesPage() {
        Flot flotSeries = new Flot("Flot");

        flotSeries.setChartData(getHashMapData());        

        add(flotSeries);

    }

    /**
     * Getting sample data source
     * @return HashMap
     */
    public HashMap<String, List<FlotData>> getHashMapData() {

        HashMap series = new HashMap();
        // lets do first serie
        List<FlotData> serieOneData = new ArrayList<FlotData>();

        FlotData f1 = new FlotData();
        f1.setxValue(0);
        f1.setyValue(2);
        serieOneData.add(f1);

        FlotData f2 = new FlotData();
        f2.setxValue(4);
        f2.setyValue(8);
        serieOneData.add(f2);

        FlotData f3 = new FlotData();
        f3.setxValue(5);
        f3.setyValue(10);
        serieOneData.add(f3);

        FlotData f4 = new FlotData();
        f4.setxValue(6);
        f4.setyValue(2);
        serieOneData.add(f4);

        series.put("d1", serieOneData);

        // lets do second serie

        List<FlotData> serieTwoData = new ArrayList<FlotData>();

        FlotData f10 = new FlotData();
        f10.setxValue(0);
        f10.setyValue(1);
        serieTwoData.add(f10);

        FlotData f11 = new FlotData();
        f11.setxValue(2);
        f11.setyValue(3);
        serieTwoData.add(f11);

        FlotData f12 = new FlotData();
        f12.setxValue(3);
        f12.setyValue(3);
        serieTwoData.add(f12);

        FlotData f13 = new FlotData();
        f13.setxValue(4);
        f13.setyValue(5);
        serieTwoData.add(f13);

        series.put("d2", serieTwoData);

        // lets do third serie

        List<FlotData> serieThreeData = new ArrayList<FlotData>();

        FlotData f20 = new FlotData();
        f20.setxValue(0);
        f20.setyValue(1);
        serieThreeData.add(f20);

        FlotData f21 = new FlotData();
        f21.setxValue(1);
        f21.setyValue(2);
        serieThreeData.add(f21);

        FlotData f22 = new FlotData();
        f22.setxValue(2);
        f22.setyValue(3);
        serieThreeData.add(f22);

        FlotData f23 = new FlotData();
        f23.setxValue(5);
        f23.setyValue(6);
        serieThreeData.add(f23);

        FlotData f24 = new FlotData();
        f24.setxValue(8);
        f24.setyValue(10);
        serieThreeData.add(f24);

        series.put("d3", serieThreeData);

        // lets do forth serie

        List<FlotData> serieFourData = new ArrayList<FlotData>();

        FlotData f30 = new FlotData();
        f30.setxValue(1);
        f30.setyValue(1.5);
        serieFourData.add(f30);

        FlotData f31 = new FlotData();
        f31.setxValue(2);
        f31.setyValue(8.5);
        serieFourData.add(f31);

        FlotData f32 = new FlotData();
        f32.setxValue(3);
        f32.setyValue(10.5);
        serieFourData.add(f32);

        FlotData f33 = new FlotData();
        f33.setxValue(4);
        f33.setyValue(12.5);
        serieFourData.add(f33);

        FlotData f34 = new FlotData();
        f34.setxValue(4);
        f34.setyValue(14.5);
        serieFourData.add(f34);

        FlotData f35 = new FlotData();
        f35.setxValue(9);
        f35.setyValue(15.5);
        serieFourData.add(f35);

        series.put("d4", serieFourData);

        return series;
    }
}
