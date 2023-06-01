package ec.edu.espe.odontoapp.model;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class Patient {

    private int id;
    private String name;
    private int age;
    private float weight;
    private float height;
    private String diseaseSymptoms;
    private String cellPhoneNumber;
    private String systemicDiseases;
    private String patientTreatment;
    private String treatmentDateStart;
    private String treatmentEndDate;
    
    public Patient(int id, String name, int age, float weight, float height, String diseaseSymptoms, String cellPhoneNumber, String systemicDiseases, String patientTreatment, String treatmentDateStart, String treatmentEndDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.diseaseSymptoms = diseaseSymptoms;
        this.cellPhoneNumber = cellPhoneNumber;
        this.systemicDiseases = systemicDiseases;
        this.patientTreatment = patientTreatment;
        this.treatmentDateStart = treatmentDateStart;
        this.treatmentEndDate = treatmentEndDate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getDiseaseSymptoms() {
        return diseaseSymptoms;
    }

    public void setDiseaseSymptoms(String diseaseSymptoms) {
        this.diseaseSymptoms = diseaseSymptoms;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getSystemicDiseases() {
        return systemicDiseases;
    }

    public void setSystemicDiseases(String systemicDiseases) {
        this.systemicDiseases = systemicDiseases;
    }

    public String getPatientTreatment() {
        return patientTreatment;
    }

    public void setPatientTreatment(String patientTreatment) {
        this.patientTreatment = patientTreatment;
    }

    public String getTreatmentDateStart() {
        return treatmentDateStart;
    }

    public void setTreatmentDateStart(String treatmentDateStart) {
        this.treatmentDateStart = treatmentDateStart;
    }

    public String getTreatmentEndDate() {
        return treatmentEndDate;
    }

    public void setTreatmentEndDate(String treatmentEndDate) {
        this.treatmentEndDate = treatmentEndDate;
    }
}
