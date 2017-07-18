package com.evie.service;

import com.evie.domain.EvieMongoCollection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmhedge on 7/18/17.
 */
@Service
public class CollectionMetadataService {

    public List<EvieMongoCollection> findCollectionsByDatabaseName(String databaseName) {
        EvieMongoCollection mongoCollection = new EvieMongoCollection();
        mongoCollection.setNamespace("one");
        mongoCollection.setCollectionSize("100");
        mongoCollection.setCollectionCount("100");

        EvieMongoCollection mongoCollection2 = new EvieMongoCollection();
        mongoCollection2.setNamespace("two");
        mongoCollection2.setCollectionSize("200");
        mongoCollection2.setCollectionCount("200");

        List<EvieMongoCollection> retVal = new ArrayList<>();
        retVal.add(mongoCollection);
        retVal.add(mongoCollection2);
        return retVal;

    }
    public EvieMongoCollection findCollectionByDatabaseAndCollectionName(String databaseName,String collectionName) {
        EvieMongoCollection mongoCollection = new EvieMongoCollection();
        mongoCollection.setCollectonName(collectionName);
        mongoCollection.setNamespace("one");
        mongoCollection.setCollectionSize("100");
        mongoCollection.setCollectionCount("100");
        return mongoCollection;
    }
}
