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
public class IdsControler extends ConnectionController{
    private MongoCollection<Document> collection = super.getDatabase().getCollection("Patients");
    private Document selectedDocument;
    private String selectedJson;

    public boolean verifyrIdExist(String id) {
        BasicDBObject query = new BasicDBObject();
        query.put("clinicalHistory.id", Integer.parseInt(id));

        FindIterable<Document> documentos = collection.find(query);

        return documentos.iterator().hasNext();
    }
}