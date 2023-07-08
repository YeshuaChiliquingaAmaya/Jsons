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
        int restart = 1;
        EditPatientInformationMenu editPatientInformationMenu = new EditPatientInformationMenu();
        while(true){    
            System.out.println("Please, enter a patient id to edit his information (only the availables ones): ");
            readPatientsInformation(consultory);
            try{
                Scanner scanner = new Scanner(System.in);
                idOption = scanner.nextInt();
                while(true){
                    for(int i=0;i<=consultory.getPatients().size();i++){
                        if(idOption == consultory.getPatients().get(i).getId()){
                            editPatientInformationMenu.showPatientInformation();
                            while(true){
                                try{
                                    Scanner informationScanner = new Scanner(System.in);
                                    informationOption = informationScanner.nextInt();
                                    editPatientInformationMenu.editPatientInformation(i, informationOption, consultory);
                                    break;
                                }catch(Exception e){
                                    System.out.println("You just wrote a no available Id. Try again: ");
                                }
                            }
                            break;
                        }
                    }
                    restart = editPatientInformationMenu.restartEditingMenu();
                    if(restart != 2){
                        break;
                    }
                }   
            }catch(Exception e){
                System.out.println("You just wrote string or float data. Try again: ");
            }
            if(restart == 2){
                break;
            }
        }
    }
    
    
    public void deletePatients(Consultory consultory){
    
    }
    
    public void readPatientsInformation(Consultory consultory){
        
    }
    
    public void saveInFile(Consultory consultory){
    
    }
}
