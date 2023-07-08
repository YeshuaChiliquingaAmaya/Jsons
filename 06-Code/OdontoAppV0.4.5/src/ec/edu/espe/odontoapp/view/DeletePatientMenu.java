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
public class DeletePatientMenu {
    public void deletePatient(int indexOfPatient, Consultory consultory){
        System.out.println("Deleted");
        consultory.getPatients().remove(indexOfPatient);
    }
    public int restartDeletingMenu(){
        System.out.println("What do you want to do?");
        System.out.println("1. Delete another patient");
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
