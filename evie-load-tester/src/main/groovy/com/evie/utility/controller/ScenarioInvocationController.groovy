package com.evie.utility.controller

import com.evie.utility.domain.ScenarioInvocation
import com.evie.utility.service.ScenarioInvokerService
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by rmhedge on 3/5/16.
 */
@RestController
class ScenarioInvocationController {

    @Autowired
    ScenarioInvokerService scenarioInvokerService;

    private static Logger log = LoggerFactory.getLogger(ScenarioInvocationController.class);

    @ApiOperation(value = "produceLoad", nickname = "Produces load on the mongo cluster")
    @RequestMapping(value = "/scenario-invoker", method = RequestMethod.POST)
    public void executeScenario(@RequestBody ScenarioInvocation invocation) {
        log.info("Inserts: ${invocation.numberInserts}");
        scenarioInvokerService.invokeScenario(invocation);
    }


}
