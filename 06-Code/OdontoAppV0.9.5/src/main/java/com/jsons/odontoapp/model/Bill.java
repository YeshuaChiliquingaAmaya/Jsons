/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsons.odontoapp.model;

import java.util.Date;

/**
 *
 * @author yeshualinux
 */
public class Bill {
    private Date date;
    private double value;

    @Override
    public String toString() {
        return "Bill{" + "date=" + getDate() + ", value=" + getValue() + '}';
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
