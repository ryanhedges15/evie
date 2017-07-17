package com.evie.commands.scheduled.bson;

/**
 * Created by rmhedge on 4/4/17.
 */
public class DbStatsCommand extends EvieBsonCommand {

    public DbStatsCommand(int scale){
        super();
        this.keyValPairs.put("dbStats",scale);
        this.keyValPairs.put("scale",1);
    }

    @Override
    public String commandKey() {
        return "dbStats";
    }

}
