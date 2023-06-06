package ec.edu.espe.odontoapp.view;

import com.google.gson.Gson;
import ec.edu.espe.odontoapp.model.JsonFile;
import ec.edu.espe.odontoapp.model.Consultory;
import ec.edu.espe.odontoapp.model.Patient;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espe.odontoapp.view.PatientsMenu;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class OdontoApp {
    public static void main(String[] args){
        PatientsMenu patientsMenu = new PatientsMenu();
        ArrayList<Patient> patients = new ArrayList<Patient>();
        Consultory consultory = new Consultory(patients);
        BuyServicesMenu buyServicesMenu = new BuyServicesMenu();
        int result;
        AssignDatesMenu assignDatesMenu = new AssignDatesMenu();
        boolean exit = false;
        int option = 0;
        Gson gson = new Gson();
        JsonFile jsonFile = new JsonFile();
        while (!exit) {
            System.out.println("----Welcome to OdontoApp----");
            System.out.println("1. About Patients");
            System.out.println("2. Buy Services");
            System.out.println("3. Assign Dates");
            System.out.println("4. Donations");
            System.out.println("5. Save in File");
            System.out.println("6. Exit");
            System.out.print("Enter an option: ");
            while(true){
                try{
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                    if(option < 1 || option > 7){
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
                    patientsMenu.showPatientsMenu(consultory);
                    break;
                case 2:
                    if(consultory.getPatients().size() < 1){
                        System.out.println("There are no patients available, so add first before adding a service to one.");
                    }else{
                        result = buyServicesMenu.showAvailableServices();
                        buyServicesMenu.assignDebtToPatient(result, patientsMenu, consultory);
                    }
                    break;
                case 3:
                    if(consultory.getPatients().size() < 1){
                        System.out.println("There are no patients available, so add first before adding a date to one.");
                    }else{
                        assignDatesMenu.assignDates(patientsMenu, consultory);
                    }
                    break;
                case 4:
                    //TODO DONATIOS IMPLEMENTATION
                    Donations donar = new Donations();
                    donar.ProgramaDonaciones();
                    break;
                case 5:                   
                    jsonFile.writeJsonFile(gson, consultory);
                    System.out.println("Succesfully saved.");
                    break;
                case 6:
                    System.out.println("See you soon");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
