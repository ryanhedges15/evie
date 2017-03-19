package com.evie.util.service

import com.evie.commands.scheduled.Command
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct
import java.sql.Timestamp

/**
 * Created by rmhedge on 4/22/16.
 */
@Service
public class CommandTrackingService {

    Logger logger = LoggerFactory.getLogger(CommandTrackingService.class)

    @Autowired
    List<Command> allCommands;

    List<LongRunningCommandRunner> commandRunnerList;

    @PostConstruct
    public void init() {
        commandRunnerList = new ArrayList<LongRunningCommandRunner>()
        allCommands.each { command ->
            logger.info("Initiaiting command " + command.getAsArray()[0]);
            Runnable commandRunner = new LongRunningCommandRunner(command);
            Thread t1 = new Thread(commandRunner).start();
            commandRunnerList.add(commandRunner);

        }

    }

    @Scheduled(fixedDelay = 900000L)
    public void logAllRunningCommands() {
        commandRunnerList.each { commandRunner ->
                String name = commandRunner.getCommand()[0];
                Timestamp lastRun = commandRunner.getLastRun();
                logger.info("Command ${name} was last run at ${lastRun}");
        }
    }
}
