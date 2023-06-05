package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.model.Consultory;
import ec.edu.espe.odontoapp.model.Patient;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class EditPatientInformationMenu {
    public void showPatientInformation(){
        System.out.println("Edit Information");
        System.out.println("1. Id");
        System.out.println("2. Name");
        System.out.println("3. Age");
        System.out.println("4. Weight");
        System.out.println("5. Height");
        System.out.println("6. Disease Symptoms");
        System.out.println("7. Cell Phone Number");
        System.out.println("7. Systemic Diseases");
        System.out.println("9. Patient Treatment");
        System.out.println("10. Treatment Start Date");
        System.out.println("11. End Date of Treatment");
        System.out.println("Enter an option: ");
    }
    public void editPatientInformation(int indexOfPatient, int informationOption, Consultory consultory){
        switch(informationOption) {
            case 1:
                int id;
                System.out.println("Enter new patient id: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        id = scanner.nextInt();
                        if(id < 1){
                            System.out.println("That id is not a valid number. Try again: ");
                        }else{
                            scanner.nextLine();
                            System.out.println("Change successfully made.");
                            break;
                        }
                    }catch(Exception e){
                        System.out.println("You just wrote string or float data. Try again: ");
                    }
                }
                consultory.getPatients().get(indexOfPatient).setId(id);
                break;
            case 2:
                String name;
                System.out.println("Enter new patient name: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        name = scanner.nextLine();
                        System.out.println("Change successfully made.");
                        break;
                    }catch(Exception e){
                        System.out.println("Error: " + e);
                    }
                }
                consultory.getPatients().get(indexOfPatient).setName(name);
                break;
            case 3:
                int age;
                System.out.println("Enter new patient age (only positive and int numbers)");
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
                                System.out.println("Change successfully made.");
                                break;
                            }
                        }catch(Exception e){
                            System.out.println("You just wrote string or float data. Try again: ");
                        }
                    }
                consultory.getPatients().get(indexOfPatient).setAge(age);    
                break;
            case 4:
                float weight;
                System.out.println("Enter new patient weight (only positive numbers): ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        weight = scanner.nextFloat();
                        if(weight < 1){
                            System.out.println("That weight is not a valid number. Try again: ");
                        }else{
                            scanner.nextLine();
                            System.out.println("Change successfully made.");
                            break;
                        }
                    }catch(Exception e){
                        System.out.println("You just wrote string data. Try again: ");
                    }
                }
                consultory.getPatients().get(indexOfPatient).setWeight(weight);
                break;
            case 5:
                float height;
                System.out.println("Enter new patient height (only positive numbers): ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        height = scanner.nextFloat();
                        if(height < 1){
                            System.out.println("That weight is not a valid number. Try again: ");
                        }else{
                            scanner.nextLine();
                            System.out.println("Change successfully made.");
                            break;
                        }
                    }catch(Exception e){
                        System.out.println("You just wrote string data. Try again: ");
                    }
                }
                consultory.getPatients().get(indexOfPatient).setHeight(height);
                break;
            case 6:
                String diseaseSymptoms;
                System.out.println("Enter new patient disease symptoms: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        diseaseSymptoms = scanner.nextLine();
                        System.out.println("Change successfully made.");
                        break;
                    }catch(Exception e){
                        System.out.println("Error: " + e);
                    }
                }
                consultory.getPatients().get(indexOfPatient).setDiseaseSymptoms(diseaseSymptoms);
                break;
            case 7:
                String cellPhoneNumber;
                System.out.println("Enter new patient cell phone number: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        cellPhoneNumber = scanner.nextLine();
                        System.out.println("Change successfully made.");
                        break;
                    }catch(Exception e){
                        System.out.println("Error: " + e);
                    }
                }
                consultory.getPatients().get(indexOfPatient).setCellPhoneNumber(cellPhoneNumber);
                break;
            case 8:
                String systemicDiseases;
                System.out.println("Enter new patient systemic diseases: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        systemicDiseases = scanner.nextLine();
                        System.out.println("Change successfully made.");
                        break;
                    }catch(Exception e){
                        System.out.println("Error: " + e);
                    }
                }
                consultory.getPatients().get(indexOfPatient).setSystemicDiseases(systemicDiseases);
                break;
            case 9:
                String patientTreatment;
                System.out.println("Enter new patient treatment: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        patientTreatment = scanner.nextLine();
                        System.out.println("Change successfully made.");
                        break;
                    }catch(Exception e){
                        System.out.println("Error: " + e);
                    }
                }
                consultory.getPatients().get(indexOfPatient).setPatientTreatment(patientTreatment);
                break;
            case 10:
                String treatmentDateStart;
                System.out.println("Enter new patient treatment date start: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        treatmentDateStart = scanner.nextLine();
                        System.out.println("Change successfully made.");
                        break;
                    }catch(Exception e){
                        System.out.println("Error: " + e);
                    }
                }
                consultory.getPatients().get(indexOfPatient).setTreatmentDateStart(treatmentDateStart);
                break;
            case 11:
                String treatmentEndDate;
                System.out.println("Enter new patient treatment end date: ");
                while(true){
                    try{
                        Scanner scanner = new Scanner(System.in);
                        treatmentEndDate = scanner.nextLine();
                        System.out.println("Change successfully made.");
                        break;
                    }catch(Exception e){
                        System.out.println("Error: " + e);
                    }
                }
                consultory.getPatients().get(indexOfPatient).setTreatmentEndDate(treatmentEndDate);
                break;
            default:
                break;
        }
    }
    public int restartEditingMenu(){
        System.out.println("What do you want to do?");
        System.out.println("1. Change another patient data");
        System.out.println("2. Go back to the principal menu");
        int option;
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();
                if(option < 1 || option > 2){
                    System.out.println("That id is not a valid number. Try again: ");
                }else{
                    break;
                }
            }catch(Exception e){
                System.out.println("You just wrote string or float data. Try agaim:");
            }
        }
        return option;
    }
}
