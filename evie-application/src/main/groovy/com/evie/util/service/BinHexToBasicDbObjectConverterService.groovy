package com.evie.util.service

import groovy.util.logging.Slf4j;

import java.util.Map;

/**
 * Created by rmhedge on 7/29/17.
 */
@Slf4j
public class BinHexToBasicDbObjectConverterService {

    public Map<String,Map<String,Object>> deconstructShellCommand(String base64) {
        String originalCommand = base64.decodeBase64()
        log.info("Submitted command was ${originalCommand}")
        return null;
    }
}
