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
    public void EditCSV() {
        String csvFile = "Patients.csv"; // Ruta del archivo CSV
        List<String[]> lines = new ArrayList<>();

        try {
            // Leer el archivo CSV existente
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                lines.add(data);
            }
            reader.close();

            // Realizar modificaciones en los datos
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el índice de la fila a editar (0-" + (lines.size() - 1) + "): ");
            int rowIndex = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer
            if (rowIndex >= 0 && rowIndex < lines.size()) {
                System.out.println("Datos actuales: " + String.join(", ", lines.get(rowIndex)));
                System.out.println("Ingrese los nuevos datos separados por comas: ");
                
                //String[] newDataArray = newData.split(",");
                AddPatient write = new AddPatient();
                write.AddPatient();
                
                
            } else {
                System.out.println("Índice de fila inválido.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
