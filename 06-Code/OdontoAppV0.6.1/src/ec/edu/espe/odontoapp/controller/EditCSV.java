package ec.edu.espe.odontoapp.controller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */

public class EditCSV {
    public void EditCSV() throws IOException{
        ReadPatientsCSV read = new ReadPatientsCSV();
        read.ReadPatientsCSV();
        String csvFile = "Patients.csv"; // Ruta del archivo CSV

        // Leer el archivo CSV existente y cargar los datos en una lista
        List<String[]> rows = readCSVFile(csvFile);

        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el número de fila y columna a editar
        System.out.print("Ingrese el numero de id del paciente a editar (1-" + (rows.size() - 1) + "): ");
        int rowIndex = scanner.nextInt();
        System.out.println("\n"
                + "1. Nombre\n"
                + "2. Edad\n"
                + "3. Peso\n"
                + "4. Altura\n"
                + "5. Síntomas de enfermedad\n"
                + "6. Numero de celular\n"
                + "7. Enfermedades Sistémicas\n"
                + "8. Fecha de inicio del tratamiento\n"
                + "9. Fecha de finalización del tratamiento");
        System.out.print("Ingrese el número de columna a editar (1-" + (rows.get(rowIndex).length) + "): ");
        int columnIndex = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer

        if (isValidIndex(rowIndex, columnIndex, rows)) {
            // Solicitar al usuario el nuevo valor para la celda
            System.out.print("Ingresa el nuevo dato: ");
            String newValue = scanner.nextLine();

            // Actualizar el valor de la celda seleccionada en la lista
            rows.get(rowIndex)[columnIndex] = newValue;

            // Guardar los datos actualizados en el archivo CSV
            saveCSVFile(rows, csvFile);

            System.out.println("Actualizado en archivo.");
        } else {
            System.out.println("Numero de columna invalido.");
        }
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

    private static boolean isValidIndex(int rowIndex, int columnIndex, List<String[]> rows) {
        return rowIndex >= 0 && rowIndex < rows.size() && columnIndex >= 0 && columnIndex < rows.get(rowIndex).length;
    }

    
}
