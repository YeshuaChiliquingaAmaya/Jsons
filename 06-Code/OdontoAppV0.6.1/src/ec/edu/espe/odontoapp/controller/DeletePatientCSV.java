package ec.edu.espe.odontoapp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class DeletePatientCSV {
    public void DeletePatientCSV() throws IOException{
        ReadPatientsCSV read = new ReadPatientsCSV();
        read.ReadPatientsCSV();
        String csvFile = "Patients.csv";

        // Leer el archivo CSV existente y cargar los datos en una lista
        List<String> lines = readCSVFile(csvFile);

        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el índice de la fila a eliminar
        System.out.print("Ingrese el numero de id del paciente a eliminar (1-" + (lines.size() - 1) + "): ");
        int rowIndex = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer

        if (rowIndex >= 0 && rowIndex < lines.size()) {
            // Eliminar la fila seleccionada de la lista
            lines.remove(rowIndex);

            // Guardar los datos actualizados en el archivo CSV
            saveCSVFile(lines, csvFile);

            System.out.println("Paciente removido del archivo.");
        } else {
            System.out.println("Numero de id invalido.");
        }
    }

    private static List<String> readCSVFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    private static void saveCSVFile(List<String> lines, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
