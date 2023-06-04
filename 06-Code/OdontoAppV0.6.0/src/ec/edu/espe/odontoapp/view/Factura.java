package ec.edu.espe.odontoapp.view;

import ec.edu.espe.odontoapp.model.Servicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Factura {
    private ArrayList<Servicio> servicios;
    private float total;

    public Factura() {
        servicios = new ArrayList<>();
        total = 0;
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
        total += servicio.getPrecio();
    }

    public void eliminarServicio(Servicio servicio) {
        servicios.remove(servicio);
        total -= servicio.getPrecio();
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public float getTotal() {
        return total;
    }
    
    
}



