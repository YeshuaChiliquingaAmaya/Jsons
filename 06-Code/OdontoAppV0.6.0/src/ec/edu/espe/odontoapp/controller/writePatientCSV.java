package ec.edu.espe.odontoapp.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class writePatientCSV {
    public void writeFileCSV(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}


