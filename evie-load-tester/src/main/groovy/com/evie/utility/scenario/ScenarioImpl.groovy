package com.evie.utility.scenario

import com.evie.utility.domain.OperationType
import com.evie.utility.domain.Stage
import com.evie.utility.domain.TestRecord
import com.evie.utility.repository.TestRecordRepository
import com.evie.utility.service.ActorGenerator
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
        HashMap<String,String> actors = ActorGenerator.generateActors(1000);
        def numInserted = 0;
        Random rand = new Random(System.currentTimeMillis());
        while(numInserted < numInserts) {
            log.trace("building test records set");
            recordList = generateTestRecords(rand,actors);
            trr.insert(recordList);
            numInserted += recordList.size();
        }
    }

    List<TestRecord> generateTestRecords(Random rand, Map<String,String> actors) {

        def uuid = UUID.randomUUID().toString();
        Random random = new  Random(System.currentTimeMillis());
        List<TestRecord> returnVal = new ArrayList<TestRecord>();
        def name = RandomNameGenerator.pickRandomName();
        for (Stage stage : Stage.values()) {
            int r;
            if(stage!=Stage.START) {
                r = rand.nextInt(40);
            }

            if(r > 36) {
                break;
                log.trace("Forcing out loop");
            }

            TestRecord tr = new TestRecord();
            tr.setTrackingUuid(uuid);
            tr.setName(name);
            tr.setDescription("Some description");
            tr.setStage(stage);

            def key = actors.keySet().getAt(random.nextInt(actors.keySet().size()));
            tr.setActor(key);
            tr.setActorType(actors.get(key));
            tr.setEventTime(getRandomDate(rand));
            returnVal.add(tr);
        }
        return returnVal;
    }

    private Date getRandomDate(Random rand) {



        def day = rand.nextInt(28);
        def month = rand.nextInt(12);
        def hour = rand.nextInt(23);
        def min = rand.nextInt(59);
        def year = 2015;

        log.trace("Month:${month} Day:${day}");
        Calendar cal = new GregorianCalendar(year,month,day,hour,min);
        log.trace(cal.toString());

        return cal.getTime();
    }


}
