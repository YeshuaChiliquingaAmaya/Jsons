/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.model.Consultory;
import java.util.Scanner;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class AssignDatesMenu {
    public void assignDates(PatientsMenu patientsMenu, Consultory consultory){
        int idOption;
        int validator = 0;
        String date = "";
        while(true){
            patientsMenu.readPatientsInformation(consultory);
            System.out.println("Please, enter a patient id to assign his or her close date (only the availables ones): ");
            try{
                Scanner scanner = new Scanner(System.in);
                idOption = scanner.nextInt();
                for(int i = 0; i < consultory.getPatients().size(); i++){
                    if(idOption == consultory.getPatients().get(i).getId()){
                        try{
                            System.out.println("Write the corresponding date: ");
                            Scanner dateScanner = new Scanner(System.in);
                            date = dateScanner.nextLine();
                            //break;
                        }catch(Exception e){
                            System.out.println("Error");
                        }
                        consultory.getPatients().get(i).setCloseDate(date);
                        System.out.println("Added!");
                        System.out.println("For the patient " + consultory.getPatients().get(i).getName() + " has been added the date of " + date);
                        validator = 1;
                        break;
                    }
                }
                if(validator == 1){
                    break;
                }else{
                    System.out.println("Id not found");
                }
            }catch(Exception e){
                System.out.println("You just wrote a not available Id. Try again. ");
            }
        }
    }
}
