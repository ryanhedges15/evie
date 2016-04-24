package com.evie.utility.processors

import com.evie.utility.domain.MonitoringRecord

/**
 * Created by rmhedge on 4/9/16.
 */
interface LineProcessor {


    MonitoringRecord processLine(String line);


}
