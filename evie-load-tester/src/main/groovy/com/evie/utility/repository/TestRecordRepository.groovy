package com.evie.utility.repository

import com.evie.utility.domain.TestRecord
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRecordRepository extends MongoRepository<TestRecord, String> {

    public TestRecord findByName(String name);
    public long count();

}