package com.evie.service;

import com.evie.commands.builder.CollectionStatsCommandBuilder;
import com.evie.commands.builder.DbStatsCommandBuilder;
import com.evie.domain.DbStats;
import com.evie.domain.EvieMongoDatabase;
import com.evie.repository.DbStatsMongoRepository;
import com.evie.repository.MongoDatabaseRepository;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shannon Hedges on 7/29/17.
 */
@Service
public class CollectionStatsCommandService {

    Logger log = LoggerFactory.getLogger(DbStatsCommandService.class);

  // @Autowired
    //CollectionStatsMongoRepository collectionStatsMongoRepository;

    @Autowired
    MongoDatabaseRepository mongoDatabaseRepository;

    //Run a CollectionStats command on an interval.
    //for each database use findCollectionsByDatabaseName(String databaseName)
    //db.getCollectionNames().forEach(function(collname)

    public void pullCurrentCollectionStats() {
        List<EvieMongoDatabase> databaseList = mongoDatabaseRepository.findAllDatabases();
        for(EvieMongoDatabase database:databaseList) {
            BasicCollectionObject command = new CollectionStatsCommandBuilder(database.getDatabaseName()).build();
            Document result = mongoDatabaseRepository.executeCommand(database.getDatabaseName(),command);
            CollectionStats curr = convertCollectionStatsToDomainObject(result);
            collectionStatsMongoRepository.save(curr);

        }
    }


//    private CollectionStats convertCollectionStatsToDomainObject(Document doc) {
//        log.info(doc.toString());
//        CollectionStats stats = new CollectionStats();
//        stats.setDatbaseName(doc.getString("db"));
//        stats.setAverageObjectSize(doc.getDouble("avgObjSize"));
//        stats.setSizeInBytes(doc.getDouble("dataSize"));
//        stats.setStorageSize(doc.getDouble("storageSize"));
//        stats.setNumIndexes(doc.getInteger("indexes"));
//        stats.setIndexSizeInBytes(doc.getDouble("indexSize"));
//        return stats;
//    }



}
