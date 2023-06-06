package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.controller.Controlador;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class OdontoApp {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Vista vista = new Vista(controlador);
        vista.mostrarMenu();
    }
}

