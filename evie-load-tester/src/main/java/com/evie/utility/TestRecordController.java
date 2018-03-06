package com.evie.utility;

import com.evie.utility.repository.TestRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evie.utility.domain.TestRecord;
import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class TestRecordController {

    private Logger log = LoggerFactory.getLogger(TestRecordController.class);

    @Autowired
    private TestRecordRepository testRecordRepository;

    @PostConstruct
    void invoke() {
        log.debug("Building fake record");
        TestRecord testRecord = new TestRecord();
        testRecord.setName("one");
        testRecord.setDescription("two");
        testRecordRepository.save(testRecord);
    }

    @RequestMapping(value = "/TestRecord", method = RequestMethod.GET)
    public List<TestRecord> getTestRecord() {
        return testRecordRepository.findAll();
    }

    @RequestMapping(value = "/TestRecord", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public TestRecord submitTestRecord(@RequestBody TestRecord TestRecord) {
        log.debug("TestRecord:"+TestRecord.getName());
        TestRecord testRecord = new TestRecord();
        testRecord = TestRecord;
        return TestRecord;
    }
}
