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
import com.jsons.odontoapp.model.Appointment;
import com.jsons.odontoapp.model.ClinicalHistory;
import com.jsons.odontoapp.model.Patient;
import com.jsons.odontoapp.model.Service;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class PatientController {
    
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
                Gson json = new Gson();
                String patientData = json.toJson(patient);
                Document document = Document.parse(patientData);
                database.getCollection("Patients").insertOne(document);
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static ArrayList<Patient> show(){
        
        String connectionString = "mongodb+srv://RBenavides:RBenavides@cluster0.js2ve9m.mongodb.net/";

        ServerApi serverApi = ServerApi.builder()
        .version(ServerApiVersion.V1)
        .build();
        
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        
        ArrayList<Patient> patients = new ArrayList<Patient>();
        
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                MongoDatabase database = mongoClient.getDatabase("OdontoApp");
                Gson json = new Gson();
                MongoCollection<Document> collection = database.getCollection("Patients");
                MongoCursor<Document> cursor = collection.find().iterator();
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    Patient patient = new Patient();

                    Document clinicalHistoryDocument = (Document) document.get("clinicalHistory");
                    ClinicalHistory clinicalHistory = new ClinicalHistory();
                    
                    clinicalHistory.setId(clinicalHistoryDocument.getInteger("id"));
                    clinicalHistory.setName(clinicalHistoryDocument.getString("name"));
                    clinicalHistory.setAge(clinicalHistoryDocument.getInteger("age"));
                    clinicalHistory.setWeight(clinicalHistoryDocument.getDouble("weight"));
                    clinicalHistory.setHeight(clinicalHistoryDocument.getDouble("height"));
                    clinicalHistory.setDiseaseSymptoms(clinicalHistoryDocument.getString("diseaseSymptoms"));
                    clinicalHistory.setSystemicDiseases(clinicalHistoryDocument.getString("systemicDiseases"));
                    clinicalHistory.setCellphone(clinicalHistoryDocument.getString("cellphone"));
                    clinicalHistory.setPatientTreatment(clinicalHistoryDocument.getString("patientTreatment"));
                    
                    String treatmentDateStartString = clinicalHistoryDocument.getString("treatmentDateStart");
                    treatmentDateStartString = treatmentDateStartString.replace(" ", " ");
                    
                    String treatmentEndDateString = clinicalHistoryDocument.getString("treatmentEndDate");
                    treatmentEndDateString = treatmentEndDateString.replace(" ", " ");
                    
                    DateFormat format = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a", Locale.ENGLISH);

                    try {
                        Date treatmentDateStart = format.parse(treatmentDateStartString);
                        clinicalHistory.setTreatmentDateStart(treatmentDateStart);
                        Date treatmentEndDate = format.parse(treatmentEndDateString);
                        clinicalHistory.setTreatmentEndDate(treatmentEndDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    
                    patient.setClinicalHistory(clinicalHistory);
                    
                    patients.add(patient);
                }
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
        
        return patients;
    }
    
}
