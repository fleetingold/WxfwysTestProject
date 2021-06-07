package com.wxfwys.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public interface MongoDBService {
    MongoDatabase getMongoDatabase(String databaseName);

    void createCollection(String databaseName, String collectionName);

    MongoCollection<Document> getCollection(String databaseName, String collectionName);

    void insertMany(String databaseName, String collectionName, List<Document> documents);

    List<Document> getDocument(String databaseName, String collectionName);
}
