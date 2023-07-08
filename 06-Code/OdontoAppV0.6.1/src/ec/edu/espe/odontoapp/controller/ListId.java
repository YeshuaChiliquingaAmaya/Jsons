package ec.edu.espe.odontoapp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class ListId {
    public void ListId(){
        String csvFile = "Patients.csv";

        // Leer el archivo CSV y cargar los datos en una lista
        List<String[]> rows = readCSVFile(csvFile);

        // Actualizar las filas con la enumeración
        updateEnumeratedRows(rows);

        // Guardar los datos actualizados en el archivo CSV
        saveCSVFile(rows, csvFile);

        //System.out.println("Archivo CSV actualizado correctamente con la enumeración.");
    }

    private static List<String[]> readCSVFile(String fileName) {
        List<String[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }

    private static void saveCSVFile(List<String[]> rows, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String[] row : rows) {
                String line = String.join(",", row);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateEnumeratedRows(List<String[]> rows) {
        int enumeration = 1;

        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            row[0] = String.valueOf(enumeration++);
        }
    }
}