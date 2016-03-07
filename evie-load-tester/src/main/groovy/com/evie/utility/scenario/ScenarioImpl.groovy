package com.evie.utility.scenario

import com.evie.utility.domain.OperationType
import com.evie.utility.domain.Stage
import com.evie.utility.domain.TestRecord
import com.evie.utility.repository.TestRecordRepository
import com.evie.utility.service.RandomNameGenerator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by rmhedge on 3/5/16.
 */
class ScenarioImpl implements Scenario {

    public static final Logger log = LoggerFactory.getLogger(ScenarioImpl.class);

    OperationType operationType;
    int numberOfOperations;

    TestRecordRepository trr;


    public ScenarioImpl(int numberOfOperations, OperationType type, TestRecordRepository recordRepository) {
        operationType = OperationType.CREATE;
        this.numberOfOperations = numberOfOperations;
        trr = recordRepository;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    void run() {
        log.info("Run invoked with ${numberOfOperations} runs")
        if (operationType == OperationType.CREATE) {
            log.info("Creating records");
            doInserts(numberOfOperations);
        }
    }

    void doInserts(int numInserts) {
        List<TestRecord> recordList;
        def numInserted = 0;
        Random rand = new Random(System.currentTimeMillis());
        while(numInserted < numInserts) {
            log.info("building test records set");
            recordList = generateTestRecords(rand);
            recordList.each { record ->
                log.info("Inserting test records")
                trr.insert(record);
            }
            numInserted += recordList.size();
        }
    }

    List<TestRecord> generateTestRecords(def rand) {
        def uuid = UUID.randomUUID().toString();
        List<TestRecord> returnVal = new ArrayList<TestRecord>();
        def name = RandomNameGenerator.pickRandomName();
        for (Stage stage : Stage.values()) {
            int r;
            if(stage!=Stage.START) {
                r = rand.nextInt(40);
            }

            if(r > 36) {
                break;
                log.info("Forcing out loop");
            }

            TestRecord tr = new TestRecord();
            tr.setTrackingUuid(uuid);
            tr.setName(name);
            tr.setDescription("Some description");
            tr.setStage(stage);
            returnVal.add(tr);
        }
        return returnVal;
    }
}
