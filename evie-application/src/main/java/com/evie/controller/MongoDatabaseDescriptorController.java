package com.evie.controller;

import com.evie.domain.EvieMongoDatabase;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**Describes the database and collections of the cluster
 * Created by rmhedge on 3/18/17.
 */
@RestController("/describe")
public class MongoDatabaseDescriptorController {

    @ApiOperation(value = "describeAll", nickname = "Describes all collections and databases")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<EvieMongoDatabase> showDatabases() {
        return null;
    }


}
