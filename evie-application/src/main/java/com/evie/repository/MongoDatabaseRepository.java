package com.evie.repository;


import com.evie.domain.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmhedge on 3/18/17.
 */
@Repository
public class MongoDatabaseRepository {

    @Autowired
    MongoClient mongoClient;

    /**
     * Finds all databases in a given mongo instance
     * @return
     */
    public List<EvieMongoDatabase> findAllDatabases() {
       ListDatabasesIterable<Document> listDatabasesIterable = mongoClient.listDatabases();
       List<EvieMongoDatabase> databases = new ArrayList<>();
       for(Document curr : listDatabasesIterable) {
           EvieMongoDatabase mongoDatabase = new EvieMongoDatabase();
           mongoDatabase.setDatabaseName(curr.getString("name"));
           mongoDatabase.setDatabaseSizeInBytes((curr.getDouble("sizeOnDisk").intValue()));
           mongoDatabase.setEmpty(curr.getBoolean("empty"));
           databases.add(mongoDatabase);
       }

       return databases;
    }

    public Document executeCommand(String dbName, BasicDBObject command) {
       MongoDatabase database = mongoClient.getDatabase(dbName);
       return database.runCommand(command);
    }


    /**
     * Finds the all of the collections in a database
     * @param database
     * @return
     */
    public List<EvieMongoCollection> getCollectionsByDatabaseName(String database) {
        List<EvieMongoCollection> mongoCollections  = new ArrayList<>();
        MongoIterable<Document> collections = mongoClient.getDatabase(database).listCollections();
        for(Document document: collections) {
            EvieMongoCollection curr = new EvieMongoCollection();
            curr.setCollectonName(document.getString("name"));
            MongoCollection<Document> currCollection = mongoClient.getDatabase(database).getCollection(curr.getCollectonName());
            curr.setNamespace(currCollection.getNamespace().getFullName());
            getCollectionInformation("foo");
            mongoCollections.add(curr);
        }
        return mongoCollections;

    }

    private EvieMongoCollection getCollectionInformation(String key) {
        DB db = mongoClient.getDB("test");
        String bar;
        return null;
    }

    //TODO this method
    public List<Object> findIndexesByCollection(String database, String collection) {
        MongoIterable indexes = mongoClient.getDatabase(database).getCollection(collection).listIndexes();
        return null;

    }


}
