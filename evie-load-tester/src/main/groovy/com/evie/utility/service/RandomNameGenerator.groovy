package com.evie.utility.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

/**
 * Created by rmhedge on 3/6/16.
 */
class RandomNameGenerator {

    static Logger log = LoggerFactory.getLogger(RandomNameGenerator.class);

    static String wordsFile = '/usr/share/dict/words';

    static List<String> words = new ArrayList<>();

    static Random rand;

    /** Read a dictionary into memory to be used in document generation **/
    static {
        File wordsFile = new File(wordsFile);
        wordsFile.eachLine { line ->
            words.add(line);
        }
        log.info("Name generator initialized with ${wordsFile.size()} values");

        rand = new Random(System.currentTimeMillis());
    }

    /**
     *
     * @param indexCap represents the maximum index allowed. Used to increase data density on the name key.
     * @return
     */
    static String pickRandomName(int indexCap) {
        int cap = indexCap;
        if(indexCap<words.size()) {
            log.trace("IndexCap was larger than the size of the index, using collection size");
        }
        cap = words.size()-1;
        int index = rand.nextInt(cap);
        return words.get(index);
    }

    static String pickRandomName() {
        return pickRandomName(words.size()-1);
    }
}
