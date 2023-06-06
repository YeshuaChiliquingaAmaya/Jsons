package ec.edu.espe.odontoapp.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.odontoapp.model.Paciente;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Controlador {
    private List<Paciente> pacientes;
    private Gson gson;

    public Controlador() {
        pacientes = new ArrayList<>();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminarPaciente(int indice) {
        if (indice >= 0 && indice < pacientes.size()) {
            pacientes.remove(indice);
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void mostrarPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void guardarPacientesEnArchivo() {
        try (FileWriter writer = new FileWriter("Pacientes.json")) {
            gson.toJson(pacientes, writer);
            System.out.println("Pacientes guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar los pacientes");
            e.printStackTrace();
        }
    }

    public void cargarPacientesDesdeArchivo() {
        try (FileReader reader = new FileReader("Pacientes.json")) {
            Paciente[] pacientesArray = gson.fromJson(reader, Paciente[].class);
            pacientes.clear();
            if (pacientesArray != null) {
                for (Paciente paciente : pacientesArray) {
                    pacientes.add(paciente);
                }
            }
            System.out.println("Pacientes cargados correctamente");
        } catch (IOException e) {
            System.out.println("Error al cargar los pacientes");
            e.printStackTrace();
        }
    }
}
