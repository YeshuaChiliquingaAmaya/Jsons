package com.jsons.odontoapp.controller;

import com.google.gson.Gson;
import com.jsons.odontoapp.model.Patient;
import com.jsons.odontoapp.model.Service;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Pablo Carrera, Jsons, DCCO-ESPE
 */
public class ServiceController {
    public static void add(Patient patient){
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
                Document filter = new Document("clinicalHistory.id", patient.getClinicalHistory().getId());

                Gson json = new Gson();
                String patientData = json.toJson(patient);
                Document document = Document.parse(patientData);
                Document newDocument = new Document("$set", document);

                database.getCollection("Patients").updateOne(filter, newDocument);
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}