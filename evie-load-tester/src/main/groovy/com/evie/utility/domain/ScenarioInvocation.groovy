package com.evie.util.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by rmhedge on 3/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true, value = ["MetaClass", "MetaMethod"])
class ScenarioInvocation {

    /** About the number of inserts desired. There are 5 stages that get populated and the number inserted will always be within 5**/
    private numberInserts;
    private numberQueries;
    private numberUpdates;
    private numberDeletes;

    def getNumberQueries() {
        return numberQueries
    }

    void setNumberQueries(numberQueries) {
        this.numberQueries = numberQueries
    }

    def getNumberUpdates() {
        return numberUpdates
    }

    void setNumberUpdates(numberUpdates) {
        this.numberUpdates = numberUpdates
    }

    def getNumberDeletes() {
        return numberDeletes
    }

    void setNumberDeletes(numberDeletes) {
        this.numberDeletes = numberDeletes
    }

    def getNumberInserts() {
        return numberInserts
    }

    void setNumberInserts(numberInserts) {
        this.numberInserts = numberInserts
    }
}

