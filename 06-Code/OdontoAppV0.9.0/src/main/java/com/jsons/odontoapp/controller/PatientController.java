package com.jsons.odontoapp.controller;

import com.mongodb.MongoException;
import org.bson.Document;
import com.google.gson.Gson;
import com.jsons.odontoapp.model.Appointment;
import com.jsons.odontoapp.model.ClinicalHistory;
import com.jsons.odontoapp.model.Patient;
import com.jsons.odontoapp.model.Service;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
public class PatientController extends ConnectionController{
    
    MongoCollection<Document> collection = super.getDatabase().getCollection("Patients");
    
    public void add(Patient patient){
            try {
                Gson json = new Gson();
                String patientData = json.toJson(patient);
                Document document = Document.parse(patientData);
                collection.insertOne(document);
            } catch (MongoException e) {
                e.printStackTrace();
            }
        
    }
    
    public ArrayList<Patient> show(){
        
        ArrayList<Patient> patients = new ArrayList<Patient>();
            try {
                Gson json = new Gson();
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
        return patients;
    }
    
    public void update(int patientId, Patient newPatient) {
            try {
                Document filter = new Document("clinicalHistory.id", patientId);

                Gson json = new Gson();
                String patientData = json.toJson(newPatient);
                Document document = Document.parse(patientData);
                Document newDocument = new Document("$set", document);
                collection.updateOne(filter, newDocument);
            } catch (MongoException e) {
                e.printStackTrace();
            }
    }   

    public void delete(int patientId){
        try {
            Document filter = new Document("clinicalHistory.id", patientId);
            collection.deleteOne(filter);
        } catch (MongoException e) {
            e.printStackTrace();
        } 
        
    }
    
    public ArrayList<Appointment> getAppointmentsByPatientId(int patientId) {
        ArrayList<Appointment> appointments = new ArrayList<>();
            try {
                Gson json = new Gson();
                Document query = new Document("clinicalHistory.id", patientId);
                FindIterable<Document> result = collection.find(query);
                for (Document document : result) {
                    Patient patient = json.fromJson(document.toJson(), Patient.class);
                    if (patient.getClinicalHistory().getId() == patientId) {
                        appointments.addAll(patient.getAppointments());
                        break;
                    }
                }
            } catch (MongoException e) {
                e.printStackTrace();
            }
        return appointments;
    }
    
    public ArrayList<Appointment> showAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
            try {
                Gson json = new Gson();
                MongoCursor<Document> cursor = collection.find().iterator();
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    ArrayList<Document> appointmentsDocuments = (ArrayList<Document>) document.get("appointments");
                    Iterator<Document> appointmentIterator = appointmentsDocuments.iterator();
                    while (appointmentIterator.hasNext()) {
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

                        appointments.add(appointment);
                    }
                }
            } catch (MongoException e) {
                e.printStackTrace();
            }
        return appointments;
    }

}