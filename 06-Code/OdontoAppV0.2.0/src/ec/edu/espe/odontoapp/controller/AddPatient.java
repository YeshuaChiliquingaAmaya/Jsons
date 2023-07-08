package ec.edu.espe.odontoapp.controller;

import ec.edu.espe.odontoapp.model.Patient;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class AddPatient {
    public void AddPatient(){
        Scanner scanner = new Scanner(System.in);
               
        //Patient patient;
        ArrayList<Patient> patients = new ArrayList<>();
        //Imput Patient Information  
        int id = 0 ;
        System.out.print("Enter name of Patient: ");
        String name = scanner.nextLine();
        System.out.print("Enter age of Patient: ");
        int age = scanner.nextInt();
        System.out.print("Enter weight of Patient: ");
        float weight = scanner.nextFloat();
        System.out.print("Enter height of Patient: ");
        float height = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter Disease Syntoms: ");
        String diseaseSymptoms = scanner.nextLine();
        System.out.print("Enter cell Phone number: ");
        String cellPhone = scanner.nextLine();
        System.out.print("Enter Systematic Diseases: ");
        String systemicDiseases = scanner.nextLine();
        System.out.print("Enter Start Date of Treatment: ");
        String treatmentStartDate = scanner.nextLine();
        System.out.print("Enter End Date of Treatment: ");
        String treatmentEndDate = scanner.nextLine();
        

        Patient patient = new Patient(id, name, age, weight, height, diseaseSymptoms, cellPhone, systemicDiseases, 
                treatmentStartDate, treatmentEndDate);
        patients.add(patient);
        System.out.println("los valores son: " + patients);
        
        String data = id + "," + name + "," + age + "," + weight + "," + height + "," + 
                diseaseSymptoms + "," + cellPhone + "," + systemicDiseases + "," + treatmentStartDate + "," + treatmentEndDate;

        // Guardar los datos en un archivo CSV
        writePatientCSV writer = new writePatientCSV();
        writer.writeFileCSV(data, "Patients.csv");

        System.out.println("Data saved successfully.");
    }
    
    
    
}
