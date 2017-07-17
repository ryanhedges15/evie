package com.evie.commands.scheduled.bson;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by rmhedge on 4/4/17.
 */
public class EvieBsonCommand {

    protected Map<String,Object> keyValPairs;

    public EvieBsonCommand() {
        keyValPairs = new HashMap<String,Object>();
    }

    public BasicDBObject generateBasicDbObject() {
       return (BasicDBObject)BasicDBObjectBuilder.start(keyValPairs).get();
    }

    public String commandKey() {
        return "DEFAULT_KEY";
    }

}
