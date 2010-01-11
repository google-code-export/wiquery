/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.objetdirect.wiqueryplugins.ui.flot;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
public class AdvancedFlotData implements Serializable {

    private double yValue ;
    private long xValue;

    private Calendar xValueAsCalendar;
    

    public long getxValue() {
        return xValue;
    }

    /**
     * sets milliseconds 
     * @param xValue
     */
    public void setxValue(long xValue) {
        this.xValue = xValue;
    }
   
    /**
     * sets Calendar object
     * @param xValueAsCalendar
     */
    public void setxValue(Calendar xValueAsCalendar) {
        this.xValueAsCalendar = xValueAsCalendar;
        GregorianCalendar lGmtCalendar = new GregorianCalendar(new SimpleTimeZone(0,"GMT+0"));
        lGmtCalendar.setTimeInMillis(this.xValueAsCalendar.getTimeInMillis());
        this.xValue  = lGmtCalendar.getTimeInMillis();
    }

   

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double yValue) {
        this.yValue = yValue;
    }

}
