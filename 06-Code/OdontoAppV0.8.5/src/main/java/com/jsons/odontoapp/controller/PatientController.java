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
import com.jsons.odontoapp.model.Appointment;
import com.jsons.odontoapp.model.ClinicalHistory;
import com.jsons.odontoapp.model.Patient;
import com.jsons.odontoapp.model.Service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;


/**
 *
 * @author Pablo Carrera, Jsons, DCCO-ESPE
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
                    
                    ArrayList<Document> servicesDocuments = (ArrayList<Document>) document.get("acquiredServices");
                    ArrayList<Service> services = new ArrayList<Service>();
                    Iterator<Document> serviceIterator = servicesDocuments.iterator();
                    int i = 0;
                    while(serviceIterator.hasNext()){
                        Document serviceDocument = serviceIterator.next();
                        Service service = new Service();
                        service.setType(serviceDocument.getString("type"));
                        service.setValue(serviceDocument.getDouble("value"));
                        services.add(i, service);
                        i++;
                    }
                    
                    patient.setAcquiredServices(services);
                    
                    ArrayList<Document> appointmentsDocuments = (ArrayList<Document>) document.get("appointments");
                    ArrayList<Appointment> appointments = new ArrayList<Appointment>();
                    Iterator<Document> appointmentIterator = appointmentsDocuments.iterator();
                    int j = 0;
                    while(appointmentIterator.hasNext()){
                        Document appointmentDocument = appointmentIterator.next();
                        Appointment appointment = new Appointment();
                        appointment.setHour(appointmentDocument.getString("hour"));
                        appointment.setService(appointmentDocument.getString("service"));
                        
                        String appointmentString = appointmentDocument.getString("date");
                        appointmentString = appointmentString.replace(" ", " ");

                        DateFormat appointmentFormat = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a", Locale.ENGLISH);

                        try {
                            Date appointmentDate = appointmentFormat.parse(appointmentString);
                            appointment.setDate(appointmentDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        
                        appointments.add(j, appointment);
                        j++;
                    }
                    
                    patient.setAppointments(appointments);
                    
                    patients.add(patient);
                }
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
        
        return patients;
    }
    
    public static void update(int patientId, Patient newPatient) {
        
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
                Document filter = new Document("clinicalHistory.id", patientId);

                Gson json = new Gson();
                String patientData = json.toJson(newPatient);
                Document document = Document.parse(patientData);
                Document newDocument = new Document("$set", document);

                database.getCollection("Patients").updateOne(filter, newDocument);
            } catch (MongoException e) {
                e.printStackTrace();
            }
        } 
    }   

    public static void delete(int patientId){
    
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
                Document filter = new Document("clinicalHistory.id", patientId);

                database.getCollection("Patients").deleteOne(filter);
            } catch (MongoException e) {
                e.printStackTrace();
            }
        } 
        
    }
    
}