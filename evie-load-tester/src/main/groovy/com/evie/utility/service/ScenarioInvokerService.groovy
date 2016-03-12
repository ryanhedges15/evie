package com.evie.utility.service

import com.evie.utility.domain.OperationType
import com.evie.utility.domain.ScenarioInvocation
import com.evie.utility.exception.ScenarioInvocationException
import com.evie.utility.repository.TestRecordRepository
import com.evie.utility.scenario.ScenarioImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by rmhedge on 3/5/16.
 */
@Service
class ScenarioInvokerService {

    private static Logger log = LoggerFactory.getLogger(ScenarioInvokerService);

    @Autowired
    TestRecordRepository testRecordRepository;

    void invokeScenario(ScenarioInvocation scenarioInvocation) {

        long collectionCount = testRecordRepository.count();

        if (collectionCount < (scenarioInvocation.getNumberDeletes() - scenarioInvocation.getNumberInserts())) {
            log.info("Could not satisfy scenario, deletes exceeded the collection count plus the numbber of solicited inserts");
            throw new ScenarioInvocationException("Unable to delete the requested number of records due to lack of items in te collection ")
        }

        Thread insertThread = new Thread(new ScenarioImpl(scenarioInvocation.getNumberInserts(), OperationType.CREATE, testRecordRepository));
        insertThread.run();
        Thread insertThread1 = new Thread(new ScenarioImpl(scenarioInvocation.getNumberInserts(), OperationType.CREATE, testRecordRepository));
        insertThread.run();
        Thread insertThread2 = new Thread(new ScenarioImpl(scenarioInvocation.getNumberInserts(), OperationType.CREATE, testRecordRepository));
        insertThread.run();
        Thread insertThread3 = new Thread(new ScenarioImpl(scenarioInvocation.getNumberInserts(), OperationType.CREATE, testRecordRepository));
        insertThread.run();

        Thread deleteThread = new Thread(new ScenarioImpl(scenarioInvocation.getNumberDeletes(), OperationType.DELETE, testRecordRepository));
        deleteThread.run();

        Thread updateThread = new Thread(new ScenarioImpl(scenarioInvocation.getNumberUpdates(), OperationType.UPDATE, testRecordRepository));
        updateThread.run();

        Thread queryThread = new Thread(new ScenarioImpl(scenarioInvocation.getNumberQueries(), OperationType.QUERY, testRecordRepository));
        queryThread.run();

    }


}
