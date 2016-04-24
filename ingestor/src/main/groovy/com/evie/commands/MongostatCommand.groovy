package com.evie.commands

import com.evie.utility.processors.LineProcessor
import com.evie.utility.processors.MongoStatLineProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import javax.validation.Valid

/**
 * Created by rmhedge on 4/22/16.
 */
@Component
class MongostatCommand extends Command {



    @Value('${mongostat.port}')
    private String port;

    @Value('${mongostat.discover}')
    private boolean discover;

    @Value('${mongostat.delay}')
    private String delay;

    public MongostatCommand() {
        super.commandString = 'mongostat';
    }


    String[] getAsArray() {
        if(discover) {
            return super.getAsArray(delay,"--port", port,"--discover","--json");
        }
        else {
            return super.getAsArray(delay,"--port", port,"--json");
        }
    }

    @Value('${mongostat.run}')
    public setConfiguredToRun(boolean run) {
        super.configuredToRun = run;
    }

    public LineProcessor getLineProcessor() {
        return new MongoStatLineProcessor();
    }






}
