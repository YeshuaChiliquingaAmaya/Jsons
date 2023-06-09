package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.model.Consultory;
import ec.edu.espe.odontoapp.model.Patient;
import ec.edu.espe.odontoapp.model.ReadPatientsCSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class OdontoApp {
    public static void main(String[] args){
        Menu menu = new Menu();
        ArrayList<Patient> patients = new ArrayList<Patient>();
        Consultory consultory = new Consultory(patients);
        boolean exit = false;
        int option = 0;
        int validator = 0;
        while (!exit) {
            System.out.println("**Welcome to Odonto App***");
            System.out.println("1. Add Patient");
            System.out.println("2. Edit Patient Information");
            System.out.println("3. Delete Patient");
            System.out.println("4. Read Patients Information");
            System.out.println("5. Save in File");
            System.out.println("6. Exit");
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
                    menu.addPatients(consultory);
                    validator = 1;
                    break;
                case 2:
                    if(validator == 0){
                        System.out.println("There is nothing to edit, because there are no patients available.");
                    }else{
                        menu.editPatientsInformation(consultory);
                    }
                    break;
                case 3:
                    if(validator == 0){
                        System.out.println("There is nothing to delete, because there are no patients available.");
                    }else{
                        menu.deletePatients(consultory);
                    }
                    break;
                case 4:
                        menu.readPatientsInformation(consultory);
                    break;
                case 5:
                    if(validator == 0){
                        System.out.println("There is nothing to delete, because there are no patients available.");
                    }else{
                        menu.readPatientsInformation(consultory);
                    }
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
