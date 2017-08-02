package com.evie.controller;

import com.evie.domain.DbStats;
import com.evie.domain.EvieMongoCollection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by rmhedge on 7/30/17.
 */
@Api("Database Metrics")
@RestController("/api/dbstats/")
public class DbStatsContoller {

    @ApiOperation(value = "DbStats Metrics", nickname = "Shows metrics for databases over time")
    @RequestMapping(value = "/{databaseName}", method = RequestMethod.GET)
    public List<DbStats> findCollectionsByDatabase(@PathVariable("databaseName") String name) {
        return null;
    }

}
