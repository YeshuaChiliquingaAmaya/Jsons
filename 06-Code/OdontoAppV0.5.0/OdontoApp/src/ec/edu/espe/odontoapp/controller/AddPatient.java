package ec.edu.espe.odontoapp.controller;

import ec.edu.espe.odontoapp.model.Patient;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        
        int id = 0;
        
        System.out.print("Enter name of Patient: ");
        String name = "";
        while(true){
            try{
                
                name = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Enter age of Patient: ");
        int age = 0;
        while(true){
            try{
                age = scanner.nextInt();
                if(age == 0){
                    System.out.println("That age is not a valid number, there is no 0 age. Try again: ");
                }
                else if(age < 1){
                    System.out.println("That age is not a valid number, there is no negative ages. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch (InputMismatchException e1) {
                System.out.println("You entered a non-integer value. Try again: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }catch (NumberFormatException e2) {
                System.out.println("Error: The value entered is not a valid integer number.");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }
        }
        
        System.out.print("Enter weight of Patient: ");
        float weight = 0;
        while(true){
            try{
                weight = scanner.nextFloat();
                if(weight < 1){
                    System.out.println("That weight is not a valid number. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch (InputMismatchException e1) {
                System.out.println("You entered a non-integer value. Try again: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }catch (NumberFormatException e2) {
                System.out.println("Error: The value entered is not a valid integer number.");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }
        }
        
        System.out.print("Enter height of Patient: ");
        float height = 0;
        while(true){
            try{
                
                height = scanner.nextFloat();
                if(height < 1){
                    System.out.println("That weight is not a valid number. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch (InputMismatchException e1) {
                System.out.println("You entered a non-integer value. Try again: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }catch (NumberFormatException e2) {
                System.out.println("Error: The value entered is not a valid integer number.");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }
        }
        
        System.out.print("Enter Disease Syntoms: ");
        String diseaseSymptoms = "";
        while(true){
            try{
                diseaseSymptoms = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Enter cell Phone number: ");
        String cellPhone = "";
        while(true){
            try{
                cellPhone = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Enter Systematic Diseases: ");
        String systemicDiseases = "";
        while(true){
            try{
                systemicDiseases = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Enter Start Date of Treatment: ");
        String treatmentStartDate = "";
        while(true){
            try{
                treatmentStartDate = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Enter End Date of Treatment: ");
        String treatmentEndDate = "";
        while(true){
            try{
                treatmentEndDate = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        

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
