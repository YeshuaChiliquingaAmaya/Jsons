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
        
        System.out.print("Ingrese el nombre del Paciente: ");
        String name = "";
        while(true){
            try{
                
                name = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Ingrese la edad del Paciente: ");
        int age = 0;
        while(true){
            try{
                age = scanner.nextInt();
                if(age == 0){
                    System.out.println("Esa edad no es un dato valido, intente de nuevo: ");
                }
                else if(age < 1){
                    System.out.println("Esa edad no es un dato valido, intente de nuevo: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch (InputMismatchException e1) {
                System.out.println("Esa edad no es un dato valido, intente de nuevo: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }catch (NumberFormatException e2) {
                System.out.println("Esa edad no es un dato valido, intente de nuevo: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }
        }
        
        System.out.print("Ingrese el peso del Paciente: ");
        float weight = 0;
        while(true){
            try{
                weight = scanner.nextFloat();
                if(weight < 1){
                    System.out.println("Ese peso no es un dato valido, intente de nuevo: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch (InputMismatchException e1) {
                System.out.println("Ese peso no es un dato valido, intente de nuevo: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }catch (NumberFormatException e2) {
                System.out.println("Ese peso no es un dato valido, intente de nuevo: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }
        }
        
        System.out.print("Ingrese la altura del Paciente: ");
        float height = 0;
        while(true){
            try{
                
                height = scanner.nextFloat();
                if(height < 1){
                    System.out.println("Esa altura no es un dato valido, intente de nuevo: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch (InputMismatchException e1) {
                System.out.println("Esa altura no es un dato valido, intente de nuevo: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }catch (NumberFormatException e2) {
                System.out.println("Esa altura no es un dato valido, intente de nuevo: ");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }
        }
        
        System.out.print("Ingrese Síntomas de enfermedad del Paciente: ");
        String diseaseSymptoms = "";
        while(true){
            try{
                diseaseSymptoms = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Ingrese el Numero de celular del Paciente: ");
        String cellPhone = "";
        while(true){
            try{
                cellPhone = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Ingrese Enfermedades Sistémicas del Paciente:  ");
        String systemicDiseases = "";
        while(true){
            try{
                systemicDiseases = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Ingrese Fecha de inicio del tratamiento del Paciente: ");
        String treatmentStartDate = "";
        while(true){
            try{
                treatmentStartDate = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.print("Ingrese Fecha de finalizacion del tratamiento del Paciente: ");
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

        System.out.println("Archivo guardado.");
    }
    
    
    
}
