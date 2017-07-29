package com.evie.repository

import com.evie.commands.builder.DbStatsCommandBuilder
import com.evie.commands.builder.GetIndexes
import com.evie.commands.scheduled.bson.DbStatsCommand
import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by rmhedge on 3/19/17.
 */
@ContextConfiguration
@SpringBootTest
class MongoDatabaseRepositoryIntegrationSpec extends Specification {

    @Autowired
    MongoDatabaseRepository mongoDatabaseRepository

    @Autowired
    MongoClient mongoClient

    def "test to see if"() {

        when:
        def results = mongoDatabaseRepository.findCollectionsByDatabaseName("test")
        def statsCommand = new DbStatsCommandBuilder("test").scale(1024).build()
        def getIndex = new GetIndexes("test").build();
        def res = mongoDatabaseRepository.executeCommand("test",statsCommand);

        then:
        true==true
    }
}
