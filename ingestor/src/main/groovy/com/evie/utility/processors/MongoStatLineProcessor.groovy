package com.evie.utility.processors

import com.evie.utility.domain.MongostatRecord
import com.evie.utility.domain.MonitoringRecord
import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap

import javax.management.monitor.Monitor

/**
 * Created by rmhedge on 4/9/16.
 */
class MongoStatLineProcessor implements LineProcessor {

    JsonSlurper slurper = new JsonSlurper();

    public MongoStatLineProcessor() {

    }

    @Override
    MonitoringRecord processLine(String line) {
        def result = slurper.parseText(line);
        MongostatRecord msr = new MongostatRecord();

        result.each { it ->
            def curr = it.value
            curr.keySet().each { currSubKey ->
                if(currSubKey.equals("ar|aw")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("command")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("conn")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("delete")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("flushes")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("getmore")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("host")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("insert")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("netIn")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("netOut")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("qr|qw")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("query")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("res")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("time")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("update")) {
                    println(curr.get(currSubKey));
                }
                else if(currSubKey.equals("vsize")) {
                    println(curr.get(currSubKey));
                }

            }




        }
        return null;
    }






}
