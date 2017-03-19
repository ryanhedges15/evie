package com.evie.repository;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by rmhedge on 3/18/17.
 */
public class MongoDatabaseRepository {

    @Autowired
    MongoClient mongoClient;

    public void findAllDatabases() {
        mongoClient.getDatabaseNames();
        mongoClient.getUsedDatabases();
    }
}
