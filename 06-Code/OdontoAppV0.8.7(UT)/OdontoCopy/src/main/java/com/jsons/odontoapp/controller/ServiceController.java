package com.jsons.odontoapp.controller;

import com.google.gson.Gson;
import com.jsons.odontoapp.model.Patient;
import com.jsons.odontoapp.model.Service;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Pablo Carrera, Jsons, DCCO-ESPE
 */
public class ServiceController extends ConnectionController{
    
    MongoCollection<Document> collection = super.getDatabase().getCollection("Dentist");
    
    public void add(Patient patient){
        try {
            Document filter = new Document("clinicalHistory.id", patient.getClinicalHistory().getId());
            Gson json = new Gson();
            String patientData = json.toJson(patient);
            Document document = Document.parse(patientData);
            Document newDocument = new Document("$set", document);
            collection.updateOne(filter, newDocument);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
   
}