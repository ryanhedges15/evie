package com.evie.repository;

import com.evie.criteria.util.enumueration.AccumulatorOperator;
import org.bson.BsonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Created by rmhedge on 7/30/17.
 */
public class MongoMetricsRespository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<BsonDocument> findAndProduceMetrics(String collectionName,MultiValueMap<String,String> multiValueMap,List<String> groupingFields, AccumulatorOperator operator) {
//        Aggregation agg = Aggregation.newAggregation(
//                Aggregation.match(Criteria.where("_id").lt(10)),
//                Aggregation.group("hosting").count().as("total"),
//                Aggregation.project("total").and("hosting").previousOperation(),
//                Aggregation.sort(Sort.Direction.DESC, "total")
//        return null
        return null;
    }



}
