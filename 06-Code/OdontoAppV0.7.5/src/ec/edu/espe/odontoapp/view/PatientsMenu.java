package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.model.Consultory;
import ec.edu.espe.odontoapp.model.Patient;
import ec.edu.espe.odontoapp.model.JsonFile;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class PatientsMenu {
    
    public void showPatientsMenu(Consultory consultory){
        boolean exit = false;
        int option = 0;
        int validator = 0;
        while (!exit) {
            System.out.println("----About Patients----");
            System.out.println("1. Add Patient");
            System.out.println("2. Edit Patient Information");
            System.out.println("3. Delete Patient");
            System.out.println("4. Read Patients Information");
            System.out.println("5. Go back");
            System.out.print("Enter an option: ");
            while(true){
                try{
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                    if(option < 1 || option > 6){
                        System.out.println("That option is not available. Try again: ");    
                    }else{
                        scanner.nextLine(); //limpia bufer se supone
                        break;
                    }
                }catch(Exception e){
                    System.out.println("You just wrote string data. Try again: ");
                }
            }
            switch(option) {
                case 1:
                    addPatients(consultory);
                    validator = 1;
                    break;
                case 2:
                    if(validator == 0){
                        System.out.println("There is nothing to edit, because there are no patients available.");
                    }else{
                        editPatientsInformation(consultory);
                    }
                    break;
                case 3:
                    if(validator == 0){
                        System.out.println("There is nothing to delete, because there are no patients available.");
                    }else{
                        deletePatients(consultory);
                    }
                    break;
                case 4:
                        readPatientsInformation(consultory);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    
    public void addPatients(Consultory consultory){
        int id;
        String name;
        int age;
        float weight;
        float height;
        String diseaseSymptoms;
        String cellPhoneNumber;
        String systemicDiseases;
        String patientTreatment;
        String treatmentDateStart;
        String treatmentEndDate;
        String debtToPay;

        System.out.println("Enter id patient (only positive and int numbers): ");
        while(true){
            int idRepeated = 0;
            try{
                Scanner scanner = new Scanner(System.in);
                id = scanner.nextInt();
                if(id < 1){
                        System.out.println("That id is not a valid number. Try again: ");
                }else if(consultory.getPatients().size() >= 1){
                    for(int i = 0; i < consultory.getPatients().size(); i++){
                        if(id == consultory.getPatients().get(i).getId()){
                            System.out.println("That id is already taken. Try again: ");
                            idRepeated = 1; 
                            break;
                        }
                    }
                }
                if(idRepeated == 0){
                        break;
                }
            }catch(Exception e){
                System.out.println("You just wrote string or float data. Try again: ");
            }
        }
        
        System.out.println("Enter patient name: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient age (only positive and int numbers)");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
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
            }catch(Exception e){
                System.out.println("You just wrote string or float data. Try again: ");
            }
        }

        System.out.println("Enter patient weight (only positive numbers): ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                weight = scanner.nextFloat();
                if(weight < 1){
                    System.out.println("That weight is not a valid number. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch(Exception e){
                System.out.println("You just wrote string data. Try again: ");
            }
        }

        System.out.println("Enter patient height (only positive numbers): ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                height = scanner.nextFloat();
                if(height < 1){
                    System.out.println("That weight is not a valid number. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch(Exception e){
                System.out.println("You just wrote string data. Try again: ");
            }
        }

        System.out.println("Enter patient disease symptoms: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                diseaseSymptoms = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient cell phone number: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                cellPhoneNumber = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.println("Enter patient systemic diseases: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                systemicDiseases = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient treatment: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                patientTreatment = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient treatment date start: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                treatmentDateStart = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient treatment end date: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                treatmentEndDate = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.println("Enter patient debt to pay: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                debtToPay = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        Patient patient = new Patient(id, name, age, height, weight, diseaseSymptoms, cellPhoneNumber, systemicDiseases, patientTreatment, treatmentDateStart, treatmentEndDate, debtToPay, "");

        consultory.getPatients().add(patient);        
    }
    
    public void editPatientsInformation(Consultory consultory){
        int idOption;
        int informationOption;
        int restart = 1;
        EditPatientInformationMenu editPatientInformationMenu = new EditPatientInformationMenu();
        while(true){
            readPatientsInformation(consultory);
            System.out.println("Please, enter a patient id to edit his information (only the availables ones): ");
            try{
                Scanner scanner = new Scanner(System.in);
                idOption = scanner.nextInt();
                for(int i=0;i<=consultory.getPatients().size();i++){
                    if(idOption == consultory.getPatients().get(i).getId()){
                        editPatientInformationMenu.showPatientInformation();
                        while(true){
                            try{
                                Scanner informationScanner = new Scanner(System.in);
                                informationOption = informationScanner.nextInt();
                                editPatientInformationMenu.editPatientInformation(i, informationOption, consultory);
                                restart = editPatientInformationMenu.restartEditingMenu();
                                if(restart == 2){
                                    break;
                                }
                                if(restart == 1){
                                    editPatientInformationMenu.showPatientInformation();
                                }
                            }catch(Exception e){
                                System.out.println("You just wrote a not available option number. Try again: ");
                            }
                        }
                        break;
                    }
                }
                if(restart == 2){
                    break;
                }
            }catch(Exception e){
                System.out.println("You just wrote a not available Id. Try again. ");
            }
        }
    }
    
    
    public void deletePatients(Consultory consultory){
        int idOption;
        int restart = 1;
        boolean patientsAvailable = false;
        DeletePatientMenu deletePatientMenu = new DeletePatientMenu();
        while(true){
            try{
                if(consultory.getPatients().size() == 0){
                    readPatientsInformation(consultory);
                    break;
                }
                
                if(consultory.getPatients().size() == 1){
                    System.out.println("Please, enter a patient id to delete (only the availables ones): ");
                    readPatientsInformation(consultory);
                    Scanner scanner = new Scanner(System.in);
                    idOption = scanner.nextInt();
                    for(int a=0;a<consultory.getPatients().size();a++){
                        if(idOption == consultory.getPatients().get(a).getId()){
                            patientsAvailable = true;
                            deletePatientMenu.deletePatient(a, consultory);
                            restart = deletePatientMenu.restartDeletingMenu();
                            break;
                        }
                    }
                    if(!patientsAvailable){
                        System.out.println("Patient not found.");
                    }
                    if(restart == 2){
                        break;
                    }
                }else{
                    System.out.println("Please, enter a patient id to delete (only the availables ones): ");
                    readPatientsInformation(consultory);
                    for(int b=0;b<consultory.getPatients().size();b++){
                        Scanner scanner = new Scanner(System.in);
                        idOption = scanner.nextInt();
                        if(idOption == consultory.getPatients().get(b).getId()){
                            patientsAvailable = true;
                            deletePatientMenu.deletePatient(b, consultory);
                            restart = deletePatientMenu.restartDeletingMenu();
                            break;
                        }
                    }
                    if(!patientsAvailable){
                        System.out.println("Patient not found.");
                    }
                    if(restart == 2){
                        break;
                    }
                }
            }catch(Exception e){
                System.out.println("You just wrote a not available Id. Try again. ");
            }
            
        }
        
    }
    
    public void readPatientsInformation(Consultory consultory){
        int comparison;
        if(consultory.getPatients().size() == 0){
            System.out.println("There are no patients available.");
        }else if(consultory.getPatients().size() == 1){
            System.out.println(consultory.getPatients().get(0).getId() + 
                    "\t" + consultory.getPatients().get(0).getName() +
                    "\t" + consultory.getPatients().get(0).getAge() +
                    "\t" + consultory.getPatients().get(0).getWeight() +
                    "\t" + consultory.getPatients().get(0).getHeight() +
                    "\t" + consultory.getPatients().get(0).getDiseaseSymptoms() + 
                    "\t" + consultory.getPatients().get(0).getCellPhoneNumber() +
                    "\t" + consultory.getPatients().get(0).getSystemicDiseases() + 
                    "\t" + consultory.getPatients().get(0).getPatientTreatment() +
                    "\t" + consultory.getPatients().get(0).getTreatmentDateStart() + 
                    "\t" + consultory.getPatients().get(0).getTreatmentEndDate() + 
                    "\t" + consultory.getPatients().get(0).getDebtToPay() +
                    "\t" + consultory.getPatients().get(0).getCloseDate() );
        }else{
            for(int i = 0; i < consultory.getPatients().size(); i++){
                Collections.sort(consultory.getPatients(), new Comparator<Patient>() {
                    @Override
                    public int compare(Patient patient1, Patient patient2) {
                        return patient1.getName().compareTo(patient2.getName());
                    }    
                });
            }
            
        }
        if(consultory.getPatients().size() > 1){
            for(int i=0;i<consultory.getPatients().size();i++){
            System.out.println(consultory.getPatients().get(i).getId() + 
                    "\t" + consultory.getPatients().get(i).getName() +
                    "\t" + consultory.getPatients().get(i).getAge() +
                    "\t" + consultory.getPatients().get(i).getWeight() +
                    "\t" + consultory.getPatients().get(i).getHeight() +
                    "\t" + consultory.getPatients().get(i).getDiseaseSymptoms() + 
                    "\t" + consultory.getPatients().get(i).getCellPhoneNumber() +
                    "\t" + consultory.getPatients().get(i).getSystemicDiseases() + 
                    "\t" + consultory.getPatients().get(i).getPatientTreatment() +
                    "\t" + consultory.getPatients().get(i).getTreatmentDateStart() + 
                    "\t" + consultory.getPatients().get(i).getTreatmentEndDate() +
                    "\t" + consultory.getPatients().get(0).getDebtToPay() +
                    "\t" + consultory.getPatients().get(0).getCloseDate());
            }
        }
    
    }
}
