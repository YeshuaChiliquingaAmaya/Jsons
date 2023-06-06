package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.controller.Controlador;
import ec.edu.espe.odontoapp.model.Paciente;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class generateBill {
    private Scanner scanner;
    private Controlador controlador;

    public generateBill(Controlador controlador) {
        scanner = new Scanner(System.in);
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("3. Mostrar pacientes");
            System.out.println("4. Guardar pacientes en archivo");
            System.out.println("5. Cargar pacientes desde archivo");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer

            switch (opcion) {
                case 1:
                    agregarPaciente();
                    break;
                case 2:
                    eliminarPaciente();
                    break;
                case 3:
                    mostrarPacientes();
                    break;
                case 4:
                    guardarPacientesEnArchivo();
                    break;
                case 5:
                    cargarPacientesDesdeArchivo();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    private void agregarPaciente() {
        System.out.println("\n----- Agregar Paciente -----");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();

        Paciente paciente = new Paciente(nombre, apellido, telefono);
        controlador.agregarPaciente(paciente);
        generarFactura(paciente);

        System.out.println("Paciente agregado correctamente");
    }

    private void eliminarPaciente() {
        System.out.println("\n----- Eliminar Paciente -----");
        System.out.print("Ingrese el índice del paciente a eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer

        controlador.eliminarPaciente(indice);
    }

    private void mostrarPacientes() {
        System.out.println("\n----- Pacientes Registrados -----");
        controlador.mostrarPacientes();
    }

    private void guardarPacientesEnArchivo() {
        controlador.guardarPacientesEnArchivo();
    }

    private void cargarPacientesDesdeArchivo() {
        controlador.cargarPacientesDesdeArchivo();
    }
    
    private void generarFactura(Paciente paciente) {
    System.out.println("\n----- Generar Factura -----");
    System.out.println("Servicios disponibles:");
    System.out.println("1. Profilaxis + Fluorización (especialmente para niños) - $20");
    System.out.println("2. Restauraciones simples - $20");
    System.out.println("3. Restauraciones complejas - $25");
    System.out.println("4. Restauraciones para niños (empastes para niños) - $25");
    System.out.println("5. Extracciones (extracción de un diente) - $20");
    System.out.println("6. Extracciones complicadas - $30");
    System.out.println("7. Tratamiento de un conducto (incisivos o dientes frontales) - $60");
    System.out.println("8. Tratamiento de tres conductos (molar) - $80");
    System.out.print("Ingrese el número del servicio seleccionado: ");
    int opcion = scanner.nextInt();
    scanner.nextLine(); // Limpiar el búfer

    double precio = 0;

    switch (opcion) {
        case 1:
        case 2:
            precio = 20;
            break;
        case 3:
        case 4:
            precio = 25;
            break;
        case 5:
            precio = 20;
            break;
        case 6:
            precio = 30;
            break;
        case 7:
            precio = 60;
            break;
        case 8:
            precio = 80;
            break;
        default:
            System.out.println("Opción inválida");
            return;
    }

    System.out.println("\nFactura generada para " + paciente.getNombre() + " " + paciente.getApellido());
    System.out.println("Servicio seleccionado: " + opcion);
    System.out.println("Precio: $" + precio);
    // Puedes realizar más cálculos o generar el reporte de factura según tus necesidades
}
    
}
