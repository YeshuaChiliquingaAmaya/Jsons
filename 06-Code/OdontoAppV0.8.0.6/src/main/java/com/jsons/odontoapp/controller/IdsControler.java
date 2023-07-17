package com.jsons.odontoapp.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Pablo Carrera, Jsons, DCCO-ESPE
 */
public class IdsControler {
    private static final String CONNECTION_STRING = "mongodb+srv://RBenavides:RBenavides@cluster0.js2ve9m.mongodb.net/";

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;
    private Document selectedDocument;
    private String selectedJson;

    public IdsControler() {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("OdontoApp");
        collection = database.getCollection("Patients");
        System.out.println("ingreso a la base de datos");
    }

    public boolean verificarIdExistente(String id) {
        BasicDBObject query = new BasicDBObject();
        query.put("clinicalHistory.id", Integer.parseInt(id));

        FindIterable<Document> documentos = collection.find(query);

        return documentos.iterator().hasNext();
    }
}