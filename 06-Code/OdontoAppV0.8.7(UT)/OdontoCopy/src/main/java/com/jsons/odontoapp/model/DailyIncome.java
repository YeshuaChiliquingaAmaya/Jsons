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
public class DailyIncome {
    private Date date;
    private double income;

    @Override
    public String toString() {
        return "DailyIncome{" + "date=" + date + ", income=" + income + '}';
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
    
}
