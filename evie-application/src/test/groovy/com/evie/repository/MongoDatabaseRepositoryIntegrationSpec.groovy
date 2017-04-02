package com.evie.repository

import com.evie.Application
import groovy.swing.factory.BeanFactory
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

/**
 * Created by rmhedge on 3/19/17.
 */
@ContextConfiguration
@SpringBootTest
class MongoDatabaseRepositoryIntegrationSpec extends Specification {

    @Autowired
    MongoDatabaseRepository mongoDatabaseRepository;

    def "test to see if"() {
        when:
        def results = mongoDatabaseRepository.getCollectionsByDatabaseName("test")

        then:
        def foo;

    }
}
