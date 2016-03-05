package com.evie.utility.scenario

import com.evie.utility.domain.OperationType
import com.evie.utility.domain.Stage
import com.evie.utility.domain.TestRecord
import com.evie.utility.repository.TestRecordRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by rmhedge on 3/5/16.
 */
class ScenarioImpl implements Scenario {

    public static final Logger log = LoggerFactory.getLogger(ScenarioImpl.class);

    OperationType operationType;
    int numberOfRuns;

    TestRecordRepository trr;


    public ScenarioImpl(int level, int numberOfRuns, OperationType type, TestRecordRepository recordRepository) {
        operationType = OperationType.CREATE;
        if (level > 100 || level < 1) {
            log.info("Logging level was out of scenario boundaries: Found ${level} expection between 1 and 100")
        }
        this.numberOfRuns = numberOfRuns;
        trr = recordRepository;

    }

    //@Override
    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    void run() {
        log.info("Run invoked with ${numberOfRuns} runs")
        for (int i = 0; i < numberOfRuns; i++) {
            if (operationType == OperationType.CREATE) {
                log.info("Creating records");
                doInserts(250000);
            }
        }
    }

    void doInserts(int numInserts) {
        List<TestRecord> recordList;
        for (int i = 0; i < numInserts; i++) {
            log.info("building test records: ${i}");
            recordList = generateTestRecords();
            recordList.each { record ->
                log.info("Inserting test records")
                trr.insert(record);
            }

        }

    }

    List<TestRecord> generateTestRecords() {
        def uuid = UUID.randomUUID().toString();
        List<TestRecord> returnVal = new ArrayList<TestRecord>();

        for (Stage stage : Stage.values()) {
            TestRecord tr = new TestRecord();
            tr.setTrackingUuid(uuid);
            tr.setName("insert");
            tr.setDescription("Some description");
            tr.setStage(stage);
            returnVal.add(tr);
        }
        return returnVal;
    }
}
