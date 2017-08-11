package com.evie.criteria.util.controller;

import com.evie.criteria.util.UriParameterUtil;
import com.evie.criteria.util.enumueration.CriteriaOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.BsonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by rmhedge on 8/8/17.
 */
@Api("Generic document filter")
@Controller("/api/documents/find")
public class GenericDocumentController {

    @Autowired
    private UriParameterUtil uriParameterUtil;

    @ApiOperation(value = "Document Filter Controller")
    @RequestMapping(value = "/{collection}", method = RequestMethod.GET)
    public List<BsonDocument> find(@PathVariable("collection") String collection, @RequestParam MultiValueMap<String,String> parameters) {
        Map<String, MultiValueMap<CriteriaOperator, String>> normalizedFilter = uriParameterUtil.normalizeQueryParameters(parameters);
        return null;
    }

}
