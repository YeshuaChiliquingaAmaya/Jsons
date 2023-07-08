package ec.edu.espe.odontoapp.model;

import java.util.ArrayList;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class Consultory {

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
    
    private  ArrayList<Patient> patients;
    
    public Consultory(ArrayList<Patient> patients) {
        this.patients = patients;
    }
    
    public void addPatient(){
        
    }
    public void editPatientInformation(){
    
    }
    public void deletePatientInformation(){
    
    }
    public void readPatientsInformation(){
    
    }
    public void saveInFile(){
    }
}
