package ec.edu.espe.odontoapp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class Header {
    public void Header(){
        String file = "Patients.csv";
        String header = "Id,Name,Age,Weight,Height,Disease Symptoms,Cell Phone Number,Systemic Diseases,Treatment Start Date,End Date of Treatment";

        try {
            File inputFile = new File(file);
            File tempFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            // Verificar si el archivo ya tiene un encabezado
            boolean hasHeader = false;
            String firstLine = reader.readLine();
            if (firstLine != null && firstLine.equals(header)) {
                hasHeader = true;
            }

            // Agregar el encabezado solo si no está presente
            if (!hasHeader) {
                writer.write(header);
                writer.newLine();
            }

            // Copiar el contenido original del archivo al archivo temporal
            writer.write(firstLine); // Escribir la primera línea leída previamente
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            // Reemplazar el archivo original con el archivo temporal
            if (inputFile.delete()) {
                if (tempFile.renameTo(inputFile)) {
                    //System.out.println("Header added successfully.");
                } else {
                    System.out.println("Failed to rename temp file.");
                }
            } else {
                System.out.println("Failed to delete input file.");
            }

        } catch (IOException e) {
            System.out.println("Error adding header: " + e.getMessage());
        }
    }
}