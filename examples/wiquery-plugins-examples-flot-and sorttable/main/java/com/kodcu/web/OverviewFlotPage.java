
package com.kodcu.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.objetdirect.wiqueryplugins.ui.flot.AdvancedFlot;
import org.objetdirect.wiqueryplugins.ui.flot.AdvancedFlotData;
import org.objetdirect.wiqueryplugins.ui.flot.Overview;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
public class OverviewFlotPage extends WebPage {

    public OverviewFlotPage() {
        AdvancedFlot advancedFlot = new AdvancedFlot("MyFlot");

        List<AdvancedFlotData> dataCollection = new ArrayList<AdvancedFlotData>();
        getData(dataCollection);// fill with data

        advancedFlot.setChartData(dataCollection);// set data to chart

        // create Overview component
        Overview overview = new Overview("Overview",advancedFlot);
        advancedFlot.setOverview(overview); // bind overview and Flot

        add(advancedFlot);
        add(overview);      

    }

    private void getData(List<AdvancedFlotData> dataCollection ) {
        
       Calendar calendar = Calendar.getInstance();

        AdvancedFlotData data1 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 2);
        data1.setxValue(calendar);
        data1.setyValue(1);
        dataCollection.add(data1);

        AdvancedFlotData data2 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 8);
        data2.setxValue(calendar);
        data2.setyValue(2);
        dataCollection.add(data2);

        AdvancedFlotData data3 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 16);
        data3.setxValue(calendar);
        data3.setyValue(3);
        dataCollection.add(data3);

        AdvancedFlotData data4 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 25);
        data4.setxValue(calendar);
        data4.setyValue(8);
        dataCollection.add(data4);

        AdvancedFlotData data5 = new AdvancedFlotData();
        calendar.set(2009, Calendar.DECEMBER, 28);
        data5.setxValue(calendar);
        data5.setyValue(2);
        dataCollection.add(data5);

        AdvancedFlotData data6 = new AdvancedFlotData();
        calendar.set(2010, Calendar.JANUARY, 5);
        data6.setxValue(calendar);
        data6.setyValue(15.8);
        dataCollection.add(data6);

        AdvancedFlotData data7 = new AdvancedFlotData();
        calendar.set(2010, Calendar.JANUARY, 10);
        data7.setxValue(calendar);
        data7.setyValue(10.8);
        dataCollection.add(data7);

        AdvancedFlotData data8 = new AdvancedFlotData();
        calendar.set(2010, Calendar.JANUARY, 12);
        data8.setxValue(calendar);
        data8.setyValue(7.1);
        dataCollection.add(data8);

        AdvancedFlotData data9 = new AdvancedFlotData();
        calendar.set(2010, Calendar.JANUARY, 17);
        data9.setxValue(calendar);
        data9.setyValue(17.7);
        dataCollection.add(data9);

        AdvancedFlotData data10 = new AdvancedFlotData();
        calendar.set(2010, Calendar.JANUARY, 25);
        data10.setxValue(calendar);
        data10.setyValue(21.0);
        dataCollection.add(data10);

    }

}
