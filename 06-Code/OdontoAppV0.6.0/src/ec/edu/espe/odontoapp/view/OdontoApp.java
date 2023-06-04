package ec.edu.espe.odontoapp.view;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class OdontoApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1. Realizar una Factura");
        System.out.println("2. Editar Pacientes");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Menu2 factura = new Menu2();
                factura.mostrarMenu();
                break;

            case 2:
                Menu paciente = new Menu();
                paciente.start();
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }

        scanner.close();
    }
}
