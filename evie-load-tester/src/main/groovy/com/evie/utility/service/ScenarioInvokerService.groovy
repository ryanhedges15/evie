package com.evie.utility.service

import com.evie.utility.domain.OperationType
import com.evie.utility.repository.TestRecordRepository
import com.evie.utility.scenario.ScenarioImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

/**
 * Created by rmhedge on 3/5/16.
 */
@Service
class ScenarioInvokerService {

    private static Logger log = LoggerFactory.getLogger(ScenarioInvokerService);

    @Autowired
    TestRecordRepository testRecordRepository;

    @PostConstruct
    void invoke() {
        Thread t1 = new Thread(new ScenarioImpl(1,1, OperationType.CREATE, testRecordRepository));
        log.info("Starting scenario thread");
        t1.run();
    }
}
