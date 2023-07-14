package com.jsons.odontoapp.controller;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jsons.odontoapp.model.Patient;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class PatientController {
    public static void add(){
        
        String connectionString = "mongodb+srv://RBenavides:RBenavides@cluster0.js2ve9m.mongodb.net/";
        
                ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                MongoDatabase database = mongoClient.getDatabase("OdontoApp");
               
                Gson json = new Gson();
                String patientData = json.toJson(catchPatient());
                Document document = Document.parse(patientData);
                database.getCollection("Patients").insertOne(document);
                
                //todo anadir paciente
                
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
            
        }
    }
    
    public static Patient catchPatient(){
        
        int id;
        String name;
        int age;
        Float weight;
        Float height;
        String diseaseSymptoms;
        String cellPhone;
        String systemicDiseases;
        String patientTreatment;
        Date treatmentDateStart;
        Date treatmentEndDate;
        
        
        System.out.println("Enter id patient (only positive and int numbers): ");
        while(true){
            int idRepeated = 0;
            try{
                Scanner scanner = new Scanner(System.in);
                id = scanner.nextInt();
                break;
            }catch(Exception e){
                System.out.println("You just wrote string or float data. Try again: ");
            }
        }
        
        System.out.println("Enter patient name: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient age (only positive and int numbers)");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                age = scanner.nextInt();
                if(age == 0){
                    System.out.println("That age is not a valid number, there is no 0 age. Try again: ");
                }
                else if(age < 1){
                    System.out.println("That age is not a valid number, there is no negative ages. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch(Exception e){
                System.out.println("You just wrote string or float data. Try again: ");
            }
        }

        System.out.println("Enter patient weight (only positive numbers): ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                weight = scanner.nextFloat();
                if(weight < 1){
                    System.out.println("That weight is not a valid number. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch(Exception e){
                System.out.println("You just wrote string data. Try again: ");
            }
        }

        System.out.println("Enter patient height (only positive numbers): ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                height = scanner.nextFloat();
                if(height < 1){
                    System.out.println("That weight is not a valid number. Try again: ");
                }else{
                    scanner.nextLine();
                    break;
                }
            }catch(Exception e){
                System.out.println("You just wrote string data. Try again: ");
            }
        }

        System.out.println("Enter patient disease symptoms: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                diseaseSymptoms = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient cell phone number: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                cellPhone = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        System.out.println("Enter patient systemic diseases: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                systemicDiseases = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient treatment: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                patientTreatment = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient treatment date start: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                //treatmentDateStart = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Enter patient treatment end date: ");
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                //treatmentEndDate = scanner.nextLine();
                break;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        
        Patient patient = new Patient();
    
        return patient;
        
    }
    
    
}
