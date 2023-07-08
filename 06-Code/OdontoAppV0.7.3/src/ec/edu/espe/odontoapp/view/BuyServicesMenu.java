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
public class BuyServicesMenu {
    public int showAvailableServices(){
        boolean exit = false;
        int option = 0;
        int result = 0;
        while (!exit) {
            System.out.println("----Choose a service(s) or go back----");
            System.out.println("1. Profilaxis + Fluorizacion (especialmente para niños): 20 dolares");
            System.out.println("2. Restauraciones simples: 20 dolares");
            System.out.println("3. Restauraciones complejas: 25");
            System.out.println("4. Restauraciones para niños (empastes para niños): 25 dolares");
            System.out.println("5. Extracciones (extraccion de un diente): 20 dolares");
            System.out.println("6. Extracciones complicadas: 30 dolares");
            System.out.println("7. Tratamiento de un conducto (incisivos o dientes frontales): 60 dolares");
            System.out.println("8. Tratamiento de tres conductos (molares): 100 dolares");
            System.out.println("9. Go back");
            while(!exit){
                try{
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                    if(option < 1 || option > 9){
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
                    result = result + 20;
                    break;
                case 2:
                    result = result + 20;
                    break;
                case 3:
                    result = result + 25;
                    break;
                case 4:
                    result = result + 25;
                    break;
                case 5:
                    result = result + 20;
                    break;
                case 6:
                    result = result + 30;
                    break;
                case 7:
                    result = result + 60;
                    break;
                case 8:
                    result = result + 100;
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        return result;
    }
    
    public void assignDebtToPatient(int result, PatientsMenu patientsMenu, Consultory consultory){
        int idOption;
        int validator = 0;
        String finalResult = String.valueOf(result);
        while(true){
            patientsMenu.readPatientsInformation(consultory);
            System.out.println("Please, enter a patient id to assign his debt (only the availables ones): ");
            try{
                Scanner scanner = new Scanner(System.in);
                idOption = scanner.nextInt();
                for(int i = 0; i < consultory.getPatients().size(); i++){
                    if(idOption == consultory.getPatients().get(i).getId()){
                        consultory.getPatients().get(i).setDebtToPay(finalResult);
                        System.out.println("Added!");
                        System.out.println("For the patient " + consultory.getPatients().get(i).getName() + " has been added a debt of " + finalResult);
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
