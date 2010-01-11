/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.objetdirect.wiqueryplugins.ui.flot;

import java.io.Serializable;

/**
 *
 * @author Altug Bilgin ALTINTAS
 */
public class FlotData implements Serializable {

    private double xValue;
    private double yValue;

    public double getxValue() {
        return xValue;
    }

    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double yValue) {
        this.yValue = yValue;
    }


}
