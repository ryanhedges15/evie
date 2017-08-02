package com.evie.criteria.util;

import com.evie.criteria.util.enumueration.CriteriaOperator;
import javafx.util.Pair;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rmhedge on 7/31/17.
 */
public class CriteriaUtil {

    /**
     * Generates Criteria where each key is anded together but multiple values are OR'd together. This is useful
     * for web requests
     *
     * @param multiValueMap
     * @return
     */
    public static Map<String, MultiValueMap<CriteriaOperator, String>> normalizeQueryParameters(MultiValueMap<String, String> multiValueMap) {
        Map<String, MultiValueMap<CriteriaOperator, String>> allKeys = new HashMap<>();

        /*First we'll go over each parameter and identify the type of operation that will be done
         We'll organize the query into operations by key so we can support queries that use more than one
         operation on the same key*/

        for (String key : multiValueMap.keySet()) {
            List<String> objects = multiValueMap.get(key);
            MultiValueMap<CriteriaOperator, String> similarOperations = new LinkedMultiValueMap<>();
            for (String val : objects) {
                Pair<CriteriaOperator, String> operation = UriParameterOperationAdapter.parseFromUriValue(key, val);
                similarOperations.add(operation.getKey(), operation.getValue());
            }
            allKeys.put(UriParameterOperationAdapter.removeKeyOperators(key),similarOperations);

        }
        return allKeys;
    }

    private Criteria generateKeyCriteriaFromMap(String key,MultiValueMap<CriteriaOperator,String> uriCriteria) {
        Criteria criteria = null;
        if(uriCriteria.get(CriteriaOperator.EQUAL)!=null) {

        }

    }

    private Criteria generateEqualCriteria(String key,List<String> values) {

    }

    private treatAs() {

    }

    /**
     * Certain operations like regex should only be supported by text values
     *
     * @return
     */
    public boolean isText(List<String> values) {
        for (String val : values) {
            if (!NumberUtils.isCreatable(val)) {
                //If there is any case where this is a String we will always treat the key as a String
                return true;
            }
        }
        return false;
    }




}
