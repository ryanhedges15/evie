package com.evie.utility.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by rmhedge on 3/8/16.
 */
public class ActorGenerator {

    private static String[] actorTypes =  {"APPLE","ORANGE","PEAR","BANANA"};
    private static Random rand = new Random(System.currentTimeMillis());

    public static Map<String,String> generateActors(int numActors) {
        Map<String,String> retVal = new HashMap<String,String>();
        for(int i = 0;i<numActors-1;i++){
            retVal.put(UUID.randomUUID().toString(),actorTypes[rand.nextInt(actorTypes.length)]);
        }
        return retVal;

    }



}
