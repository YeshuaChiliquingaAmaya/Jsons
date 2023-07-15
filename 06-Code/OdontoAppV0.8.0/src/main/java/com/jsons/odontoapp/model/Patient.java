package com.jsons.odontoapp.model;

import java.util.ArrayList;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class Patient {

    private ClinicalHistory clinicalHistory;

    public ArrayList<Service> getAcquiredServices() {
        return acquiredServices;
    }

    public void setAcquiredServices(ArrayList<Service> acquiredServices) {
        this.acquiredServices = acquiredServices;
    }
    private ArrayList<Service> acquiredServices;
    private ArrayList<Appointment> appointments;
    
    /**
     * @return the clinicalHistory
     */
    public ClinicalHistory getClinicalHistory() {
        return clinicalHistory;
    }

    public String OnlyPatientsToString() {
        return clinicalHistory.toString();
    }
    
    /**
     * @param clinicalHistory the clinicalHistory to set
     */
    public void setClinicalHistory(ClinicalHistory clinicalHistory) {
        this.clinicalHistory = clinicalHistory;
    }

    /**
     * @return the appointments
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * @param appointments the appointments to set
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
    
}

