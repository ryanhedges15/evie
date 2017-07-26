package com.evie.controller;

import com.evie.domain.EvieMongoCollection;
import com.evie.domain.EvieMongoDatabase;
import com.evie.service.CollectionMetadataService;
import com.evie.service.MongoDatabaseDescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**Describes the collections of the cluster
 * Created by rmhedge on 3/18/17.
 */
@Api
@RestController
public class MongoCollectionDescriptorController {

    @Autowired
    CollectionMetadataService collectionMetadataService;

    @ApiOperation(value = "describe", nickname = "Describes all collections and databases")
    @RequestMapping(value = "/collections/", method = RequestMethod.GET)
    public List<EvieMongoCollection> findCollectionsByDatabase(@RequestParam("databaseName") String name) {
       return collectionMetadataService.findCollectionsByDatabaseName(name);
    }


}
