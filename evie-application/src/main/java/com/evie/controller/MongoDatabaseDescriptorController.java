package com.evie.controller;

import com.evie.domain.EvieMongoDatabase;
import com.evie.service.MongoDatabaseDescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**Describes the database and collections of the cluster
 * Created by rmhedge on 3/18/17.
 */
@Api
@RestController
public class MongoDatabaseDescriptorController {

    @Autowired
    MongoDatabaseDescriptionService mongoDatabaseDescriptionService;

    @ApiOperation(value = "describe", nickname = "Describes all collections and databases")
    @RequestMapping(value = "databases/all", method = RequestMethod.GET)
    public List<EvieMongoDatabase> showDatabases() {
       return mongoDatabaseDescriptionService.retrieveAllDatabasses();
    }


}
