package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.controller.Controlador;
import ec.edu.espe.odontoapp.model.Paciente;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Vista {
    private Scanner scanner;
    private Controlador controlador;

    public Vista(Controlador controlador) {
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
}
