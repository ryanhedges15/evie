package com.evie.commands.builder;

import javafx.util.Pair;

/**
 * Created by Shannon Hedges 7/29/17.
 */

public class GetIndexes extends AbstractCommandBuilder {

    private String collName = null;

    public GetIndexes(String getIndexes){
        super();
        this.collName = getIndexes;
    }


    public Pair<String,String> getCommandPair() {
        return new Pair<String,String>("listIndexes", collName);
    }

}
