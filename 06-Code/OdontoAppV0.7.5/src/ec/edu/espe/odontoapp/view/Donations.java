package ec.edu.espe.odontoapp.view;

import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Donations  {
    private static double totalDonaciones = 0.0;

    public static void ProgramaDonaciones() {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("----- Menú de Donaciones -----");
            System.out.println("1. Realizar una donación");
            System.out.println("2. Ver total de donaciones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de la donación: ");
                    double cantidad = scanner.nextDouble();
                    realizarDonacion(cantidad);
                    System.out.println("¡Donación realizada con éxito!");
                    break;
                case 2:
                    System.out.println("El total de donaciones recibidas es: $" + totalDonaciones);
                    break;
                case 3:
                    salir = true;
                    System.out.println("¡Gracias por utilizar el programa de donaciones!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void realizarDonacion(double cantidad) {
        totalDonaciones += cantidad;
    }
}