package com.evie.util.processors

import com.evie.util.domain.MonitoringRecord

/**
 * Created by rmhedge on 4/9/16.
 */
interface LineProcessor {
    MonitoringRecord processLine(String line);
}
