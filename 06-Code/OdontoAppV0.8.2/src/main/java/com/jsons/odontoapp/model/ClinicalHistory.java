package com.jsons.odontoapp.model;

import java.util.Date;


/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class ClinicalHistory {

    private int id;
    private String name;
    private int age;
    private double weight;
    private double height;
    private String diseaseSymptoms;
    private String cellphone;
    private String systemicDiseases;
    private String patientTreatment;
    private Date treatmentDateStart;
    private Date treatmentEndDate;
    

    @Override
    public String toString() {
        return name + "\n" + 
               "id: " + id + "\n" + 
               age + "\n" + 
               weight + "\n" + 
               height + "\n" + 
               diseaseSymptoms + "\n" + 
               cellphone + "\n" + 
               systemicDiseases + "\n" + 
               patientTreatment + "\n" + 
               "Fecha de Inicio de Tratamiento: " + treatmentDateStart.toString() + "\n" + 
               "Fecha de Finalización de Tratamiento: " + treatmentEndDate.toString();
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the diseaseSymptoms
     */
    public String getDiseaseSymptoms() {
        return diseaseSymptoms;
    }

    /**
     * @param diseaseSymptoms the diseaseSymptoms to set
     */
    public void setDiseaseSymptoms(String diseaseSymptoms) {
        this.diseaseSymptoms = diseaseSymptoms;
    }

    /**
     * @return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone the cellphone to set
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * @return the systemicDiseases
     */
    public String getSystemicDiseases() {
        return systemicDiseases;
    }

    /**
     * @param systemicDiseases the systemicDiseases to set
     */
    public void setSystemicDiseases(String systemicDiseases) {
        this.systemicDiseases = systemicDiseases;
    }

    /**
     * @return the patientTreatment
     */
    public String getPatientTreatment() {
        return patientTreatment;
    }

    /**
     * @param patientTreatment the patientTreatment to set
     */
    public void setPatientTreatment(String patientTreatment) {
        this.patientTreatment = patientTreatment;
    }

    /**
     * @return the treatmentDateStart
     */
    public Date getTreatmentDateStart() {
        return treatmentDateStart;
    }

    /**
     * @param treatmentDateStart the treatmentDateStart to set
     */
    public void setTreatmentDateStart(Date treatmentDateStart) {
        this.treatmentDateStart = treatmentDateStart;
    }

    /**
     * @return the treatmentEndDate
     */
    public Date getTreatmentEndDate() {
        return treatmentEndDate;
    }

    /**
     * @param treatmentEndDate the treatmentEndDate to set
     */
    public void setTreatmentEndDate(Date treatmentEndDate) {
        this.treatmentEndDate = treatmentEndDate;
    }

}

