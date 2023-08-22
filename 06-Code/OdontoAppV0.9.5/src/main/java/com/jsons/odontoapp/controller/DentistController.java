package com.jsons.odontoapp.controller;

import com.google.gson.Gson;
import com.jsons.odontoapp.model.Bill;
import com.jsons.odontoapp.model.Dentist;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.bson.Document;



/**
 *
 * @author Ruben Benavides, Jsons, DCCO-ESPE
 */
public class DentistController {
    public static void upload(int id, Dentist dentist){
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
                Document filter = new Document("id", id);
                
                
                Gson json = new Gson();
                String dentistData = json.toJson(dentist);
                Document document = Document.parse(dentistData);
                Document newDocument = new Document("$set", document);

                database.getCollection("Dentist").updateOne(filter, newDocument);
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Dentist get() throws ParseException{
        String connectionString = "mongodb+srv://RBenavides:RBenavides@cluster0.js2ve9m.mongodb.net/";
        Dentist dentist = new Dentist();
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
                MongoCollection<Document> collection = database.getCollection("Dentist");
                MongoCursor<Document> cursor = collection.find().iterator();
                
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    
                    
                    ArrayList<Document> facturesDocuments = (ArrayList<Document>) document.get("factures");
                    ArrayList<Bill> factures = new ArrayList<Bill>();
                    Iterator<Document> serviceIterator = facturesDocuments.iterator();
                    int i = 0;
                    while (serviceIterator.hasNext()) {
                        Document dateDocument = serviceIterator.next();
                        Bill bill = new Bill();

                        String dateString = dateDocument.getString("date");
                        dateString = dateString.replace(" ", " ");

                        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a", Locale.ENGLISH);

                        try {
                            Date date = dateFormat.parse(dateString);
                            bill.setDate(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        double total = dateDocument.getDouble("value");
                        bill.setValue(total);
                        factures.add(i, bill);
                        i++;
                    }
                    dentist.setFactures(factures);
                    int id = document.getInteger("id");
                    dentist.setId(id);
                }
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
        return dentist;
    }
}
