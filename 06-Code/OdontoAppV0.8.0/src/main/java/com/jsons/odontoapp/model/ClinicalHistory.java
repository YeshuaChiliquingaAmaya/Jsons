package com.jsons.odontoapp.model;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class ClinicalHistory {

    private int id;
    private String name;
    private int age;
    private float weight;
    private float height;
    private String diseaseSymptoms;
    private String cellphone;
    private String systemicDiseases;
    private String patientTreatment;
    private String treatmentDateStart;
    private String treatmentEndDate;
    
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
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
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
    public String getTreatmentDateStart() {
        return treatmentDateStart;
    }

    /**
     * @param treatmentDateStart the treatmentDateStart to set
     */
    public void setTreatmentDateStart(String treatmentDateStart) {
        this.treatmentDateStart = treatmentDateStart;
    }

    /**
     * @return the treatmentEndDate
     */
    public String getTreatmentEndDate() {
        return treatmentEndDate;
    }

    /**
     * @param treatmentEndDate the treatmentEndDate to set
     */
    public void setTreatmentEndDate(String treatmentEndDate) {
        this.treatmentEndDate = treatmentEndDate;
    }

}

