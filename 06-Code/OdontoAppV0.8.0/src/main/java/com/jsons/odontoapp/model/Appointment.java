package com.jsons.odontoapp.model;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class Appointment {

    private boolean fullfilled;
    private String date;
    
    /**
     * @return the fullfilled
     */
    public boolean isFullfilled() {
        return fullfilled;
    }

    /**
     * @param fullfilled the fullfilled to set
     */
    public void setFullfilled(boolean fullfilled) {
        this.fullfilled = fullfilled;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
}