package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.controller.AddPatient;
import ec.edu.espe.odontoapp.controller.DeletePatientCSV;
import ec.edu.espe.odontoapp.controller.EditCSV;
import ec.edu.espe.odontoapp.controller.Header;
import ec.edu.espe.odontoapp.controller.ListId;
import ec.edu.espe.odontoapp.controller.ReadPatientsCSV;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Menu {
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        

        while (!exit) {
            Header head = new Header();
            head.Header();
            ListId list = new ListId();
            list.ListId();
            System.out.println("*******Welcome to Odonto App********");
            System.out.println("1. Add Patient");
            System.out.println("2. Edit Patient Information");
            System.out.println("3. Delete Patient");
            System.out.println("4. Read Patients Information");
            System.out.println("5. Exit");
            System.out.print("Enter an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // clean the búfer

            switch (option) {
                case 1:
                    AddPatient add = new AddPatient();
                    add.AddPatient();
                    break;
                case 2:
                    EditCSV edit = new EditCSV();
                    edit.EditCSV();
                    break;
                case 3:
                    DeletePatientCSV delete = new DeletePatientCSV();
                    delete.DeletePatientCSV();
                    break;
                case 4:
                    ReadPatientsCSV read = new ReadPatientsCSV();
                    read.ReadPatientsCSV();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
