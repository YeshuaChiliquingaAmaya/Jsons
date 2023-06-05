package ec.edu.espe.odontoapp.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class ReadPatientsCSV {
    public void readPatientsCSV(Consultory consultory) throws IOException{
        try {
            FileWriter fileWriter = new FileWriter("D:\\patientsData.csv", true);
            BufferedWriter bufferedFileWriterHeader = new BufferedWriter(fileWriter);
            PrintWriter printerWriter = new PrintWriter(bufferedFileWriterHeader);
            printerWriter.append((CharSequence) consultory.getPatients());
            printerWriter.flush();
            printerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
