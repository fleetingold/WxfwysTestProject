package com.wxfwys.service.impl;

import com.mongodb.client.*;
import com.wxfwys.service.MongoDBService;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "mongoDBService")
public class MongoDBServiceImpl implements MongoDBService {
    private String url = "mongodb+srv://fleetingold:abc-123@fleetingold-mongodb-clu.lwenx.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
    private MongoClient mongoClient;

    public MongoDBServiceImpl() {
        mongoClient = MongoClients.create(url);
    }

    public MongoDatabase getMongoDatabase(String databaseName) {
        //哪种设计模式?
        return mongoClient.getDatabase(databaseName);
    }

    public void createCollection(String databaseName, String collectionName) {
        MongoDatabase database = getMongoDatabase(databaseName);
        database.createCollection(collectionName);
    }

    public MongoCollection<Document> getCollection(String databaseName, String collectionName) {
        MongoDatabase database = getMongoDatabase(databaseName);
        return database.getCollection(collectionName);
    }

    public void insertMany(String databaseName, String collectionName, List<Document> documents) {
        MongoCollection<Document> mongoCollection = getCollection(databaseName, collectionName);
        mongoCollection.insertMany(documents);
    }

    public List<Document> getDocument(String databaseName, String collectionName) {
        MongoDatabase database = getMongoDatabase(databaseName);
        FindIterable<Document> findIterable = database.getCollection(collectionName).find();
        List<Document> documents = new ArrayList<>();
        for (Document document : findIterable) {
            documents.add(document);
        }
        return documents;
    }
}