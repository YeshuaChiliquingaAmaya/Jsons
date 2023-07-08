package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.model.Consultory;
import ec.edu.espe.odontoapp.model.Patient;
import java.util.Scanner;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class Menu {
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

        System.out.println("Enter id patient (only positive and int numbers): ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                id = scanner.nextInt();
                if(id < 1){
                    System.out.println("That id is not a valid number. Try again: ");
                }else{
                    scanner.nextLine();
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

        Patient patient = new Patient(id, name, age, height, weight, diseaseSymptoms, cellPhoneNumber, systemicDiseases, patientTreatment, treatmentDateStart, treatmentEndDate);

        consultory.getPatients().add(patient);        
    }
    
    public void editPatientsInformation(Consultory consultory){
        int idOption;
        int informationOption;
        EditPatientInformationMenu editPatientInformationMenu = new EditPatientInformationMenu();
        System.out.println("Please, enter a patient id to edit his information (only the availables ones): ");
        while(true){    
            readPatientsInformation(consultory);
            try{
                Scanner scanner = new Scanner(System.in);
                idOption = scanner.nextInt();
                for (int i=0;i<consultory.getPatients().size();i++) {
                    if(idOption == consultory.getPatients().indexOf(i)){
                        editPatientInformationMenu.showPatientInformation();
                        while(true){
                            //there must be a break in this component
                            try{
                                Scanner informationScanner = new Scanner(System.in);
                                informationOption = informationScanner.nextInt();
                            }catch(Exception e){
                                System.out.println("You just wrote string or float data. Try again");
                            }
                        }
                    }else{
                        System.out.println("Id not found. Try again: ");
                    }
                }
            }catch(Exception e){
                System.out.println("You just wrote string or float data. Try again: ");
            }
                
            /*while(true){
                try{
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                    if(option < 1 || option > 2){
                        System.out.println("That option is not a valid number. Try again: ");
                    }else{
                        scanner.nextLine();
                        break;
                    }
                }catch(Exception e){
                    System.out.println("You just wrote a number. Try again: ");
                }
            }*/
        }
    }
    
    
    public void deletePatients(Consultory consultory){
    
    }
    
    public void readPatientsInformation(Consultory consultory){
        
    }
    
    public void saveInFile(Consultory consultory){
    
    }
}
