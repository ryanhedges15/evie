package evie.commands.scheduled

import com.evie.commands.scheduled.Command
import com.evie.util.processors.LineProcessor
import com.evie.util.processors.MongoStatLineProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

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
        Object.commandString = 'mongostat';
    }


    String[] getAsArray() {
        if(discover) {
            return Object.getAsArray(delay,"--port", port,"--discover","--json");
        }
        else {
            return Object.getAsArray(delay,"--port", port,"--json");
        }
    }

    @Value('${mongostat.run}')
    public setConfiguredToRun(boolean run) {
        Object.configuredToRun = run;
    }

    public LineProcessor getLineProcessor() {
        return new MongoStatLineProcessor();
    }






}
