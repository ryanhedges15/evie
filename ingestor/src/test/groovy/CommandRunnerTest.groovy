import com.evie.util.CommandBuilder
import com.evie.utility.processors.MongoStatLineProcessor
import com.evie.utility.service.LongRunningCommandRunner
import org.junit.Test

/**
 * Created by rmhedge on 4/9/16.
 */
class CommandRunnerTest {


    @Test
    public void testCommandBuilderHappyDay() {
        String commandName = "mongostat";
        def port = 27017
        String arg1 = "--port";
        String arg2 = port;
        String arg3 = "--json";
        def discovery = '--discover';
        //TODO make this a spring property
        def discoveryOn = false;
        String[] command;
        if(discoveryOn) {
            command = CommandBuilder.build(commandName,arg1,arg2,arg3,discovery);
        }
        else {
            command = CommandBuilder.build(commandName,arg1,arg2,arg3);
        }





        Runnable t1 = new LongRunningCommandRunner();
        t1.setLineProcessor(new MongoStatLineProcessor());
        t1.setCommand(command);
        t1.run();

    }


}
