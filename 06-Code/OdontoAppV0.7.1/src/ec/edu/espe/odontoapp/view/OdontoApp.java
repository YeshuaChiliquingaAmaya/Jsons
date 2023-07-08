package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.controller.Controlador;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class OdontoApp {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        generateBill vista = new generateBill(controlador);
        vista.mostrarMenu();
    }
}

