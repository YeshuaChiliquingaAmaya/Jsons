package com.jsons.odontoapp.model;

import java.util.ArrayList;



/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class Dentist {
    
    int id;
    
    ArrayList<Bill> factures = new ArrayList<>();

  


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Bill> getFactures() {
        return factures;
    }

    public void setFactures(ArrayList<Bill> factures) {
        this.factures = factures;
    }
    
    
}