package ec.edu.espe.odontoapp.model;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Patient {
    int id;
    String name;
    int age;
    float weight;
    float height;
    String diseaseSymptoms;
    String cellPhone;
    String systemicDiseases;
    String treatmentStartDate;
    String treatmentEndDate;

    public Patient(int id, String name, int age, float weight, float height, String diseaseSymptoms, String cellPhone, String systemicDiseases, String treatmentStartDate, String treatmentEndDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.diseaseSymptoms = diseaseSymptoms;
        this.cellPhone = cellPhone;
        this.systemicDiseases = systemicDiseases;
        this.treatmentStartDate = treatmentStartDate;
        this.treatmentEndDate = treatmentEndDate;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", nombre=" + name + ", edad=" + age + ", peso=" + weight + ", altura=" + height + ", Síntomas de enfermedad=" + diseaseSymptoms + ", Numero de celular=" + cellPhone + ", Enfermedades Sistémicas=" + systemicDiseases + ", Fecha de inicio del tratamiento=" + treatmentStartDate + ", Fecha de finalización del tratamiento=" + treatmentEndDate + '}';
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

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getSystemicDiseases() {
        return systemicDiseases;
    }

    public void setSystemicDiseases(String systemicDiseases) {
        this.systemicDiseases = systemicDiseases;
    }

    public String getTreatmentStartDate() {
        return treatmentStartDate;
    }

    public void setTreatmentStartDate(String treatmentStartDate) {
        this.treatmentStartDate = treatmentStartDate;
    }

    public String getTreatmentEndDate() {
        return treatmentEndDate;
    }

    public void setTreatmentEndDate(String treatmentEndDate) {
        this.treatmentEndDate = treatmentEndDate;
    }
    
}
