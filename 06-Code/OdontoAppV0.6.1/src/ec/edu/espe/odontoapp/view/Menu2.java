package ec.edu.espe.odontoapp.view;


import ec.edu.espe.odontoapp.controller.ReadPatientsCSV;
import ec.edu.espe.odontoapp.model.Servicio;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Menu2 {
    private ArrayList<Servicio> serviciosDisponibles;
    private Factura factura;

    public Menu2() {
        serviciosDisponibles = new ArrayList<>();
        serviciosDisponibles.add(new Servicio("Profilaxis (limpieza dental):", 25));
        serviciosDisponibles.add(new Servicio("Profilaxis + Fluorización (especialmente para niños):", 20));
        serviciosDisponibles.add(new Servicio("Restauraciones simples:", 20));
        serviciosDisponibles.add(new Servicio("Restauraciones complejas", 25));
        serviciosDisponibles.add(new Servicio("Restauraciones para niños (empastes para niños):", 25));
        serviciosDisponibles.add(new Servicio("Extracciones (extracción de un diente):", 20));
        serviciosDisponibles.add(new Servicio("Extracciones complicadas:", 30));
        serviciosDisponibles.add(new Servicio("Tratamiento de un conducto (incisivos o dientes frontales):", 60));
        serviciosDisponibles.add(new Servicio("Tratamiento de dos conductos (premolares):", 80));
        serviciosDisponibles.add(new Servicio("Tratamiento de tres conductos (molares):", 100));
        factura = new Factura();
    }

    public void mostrarMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarOpciones();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarServicios(serviciosDisponibles);
                    int servicioAgregar = scanner.nextInt();
                    if (servicioAgregar >= 0 && servicioAgregar < serviciosDisponibles.size()) {
                        Servicio servicio = serviciosDisponibles.get(servicioAgregar);
                        factura.agregarServicio(servicio);
                        System.out.println("Servicio agregado a la factura.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 2:
                    mostrarFactura();
                    break;

                case 3:
                    mostrarServicios(factura.getServicios());
                    int servicioEliminar = scanner.nextInt();
                    if (servicioEliminar >= 0 && servicioEliminar < factura.getServicios().size()) {
                        Servicio servicio = factura.getServicios().get(servicioEliminar);
                        factura.eliminarServicio(servicio);
                        System.out.println("Servicio eliminado de la factura.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }

    private void mostrarOpciones() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Agregar servicio a la factura");
        System.out.println("2. Mostrar factura");
        System.out.println("3. Eliminar servicio de la factura");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private void mostrarServicios(ArrayList<Servicio> servicios) {
        System.out.println("Servicios disponibles:");
        for (int i = 0; i < servicios.size(); i++) {
            Servicio servicio = servicios.get(i);
            System.out.println(i + ". " + servicio.getNombre() + " - $" + servicio.getPrecio());
        }
        System.out.print("Seleccione un servicio: ");
    }

    private void mostrarFactura() throws IOException {
        ReadPatientsCSV mostrar = new ReadPatientsCSV();
        mostrar.ReadPatientsCSV();
        System.out.print("Ingrese el paciente al que va a Facturar: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
        System.out.println("========== FACTURA ==========");
        System.out.println("A nombre de: " + name);
        ArrayList<Servicio> servicios = factura.getServicios();
        for (int i = 0; i < servicios.size(); i++) {
            Servicio servicio = servicios.get(i);
            System.out.println(i + 1 + ". " + servicio.getNombre() + " - $" + servicio.getPrecio());
        }
        System.out.println("Total: $" + factura.getTotal());
    }
}