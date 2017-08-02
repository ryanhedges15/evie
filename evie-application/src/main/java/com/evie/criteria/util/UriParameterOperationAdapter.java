package com.evie.criteria.util;

import com.evie.criteria.util.enumueration.CriteriaOperator;
import javafx.util.Pair;

import static com.evie.criteria.util.enumueration.CriteriaOperator.*;

/**
 * Created by rmhedge on 8/1/17.
 */
public class UriParameterOperationAdapter {

    /** Mimics a query language in REST which allows for complicated queries using URI params which
     * are represented by a multivalue map
     * @param mapKey
     * @param value
     * @return
     */
    public static Pair<CriteriaOperator,String> parseFromUriValue(String mapKey,String value) {
        String key = mapKey.trim();
        String input = value.trim();
        if(input.endsWith(")")){
            input = input.substring(0,input.length()-1);
        }
        if(input.contains("gte(")) {
            return new Pair<>(GREATER_THAN_OR_EQUAL,input);
        }
        else if(input.startsWith("gt(")) {
            return new Pair<>(GREATER_THAN,input);
        }
        else if(input.startsWith("lte(")) {
            return new Pair<>(LESS_THAN_OR_EQUAL,input);
        }
        else if(input.startsWith("lt(")) {
            return new Pair<>(LESS_THAN,input);
        }
        else if(input.contains("*")) {
            return new Pair<>(LIKE,input);
        }
        else if(key.endsWith("!")) {
            return new Pair<>(NOT_EQUAL,input);
        }
        else {
            return new Pair<>(EQUAL,input);
        }
    }

    /**
     * Sometimes it is convenient to have operators appear in the keys to mimic programming conventions
     * We need to String them out in order to make sure we don't change the key
     * @param input
     * @return
     */
    public static String removeKeyOperators(String input) {
        return input.replaceAll("!","");
    }
}
