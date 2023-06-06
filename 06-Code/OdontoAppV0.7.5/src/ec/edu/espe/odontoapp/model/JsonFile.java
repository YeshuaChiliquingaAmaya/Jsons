package ec.edu.espe.odontoapp.model;

import com.google.gson.Gson;
import java.io.*;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class JsonFile {    
    public void writeJsonFile(Gson gson, Consultory consultory) {
        String data = gson.toJson(consultory.getPatients());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.json", false))) {
            writer.newLine();
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
