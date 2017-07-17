package com.evie.repository

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
    MongoDatabaseRepository mongoDatabaseRepository;

    @Autowired
    MongoClient mongoClient;

    def "test to see if"() {

        when:
        def results = mongoDatabaseRepository.getCollectionsByDatabaseName("test")
        def res = mongoDatabaseRepository.executeCommand("test",new DbStatsCommand(1024).generateBasicDbObject());

        then:
        results.size()==5
    }
}
