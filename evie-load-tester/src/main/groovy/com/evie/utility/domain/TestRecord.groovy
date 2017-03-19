package com.evie.util.domain

import org.springframework.data.annotation.Id

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient

/**
 * Created by rmhedge on 12/6/15.
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement
class TestRecord {

    @XmlTransient
    @Id
    private String id;

    private Date eventTime;

    String name;
    String actor;
    String ActorType;
    String description;
    String trackingUuid;
    Stage stage;
    long count;


    public String getName() {
        return name
    }

    public void setName(String name) {
        this.name = name
    }
    public String getDescription() {
        return description
    }

    public void setDescription(String description) {
        this.description = description
    }

    String getTrackingUuid() {
        return trackingUuid
    }

    void setTrackingUuid(String trackingUuid) {
        this.trackingUuid = trackingUuid
    }

    Stage getStage() {
        return stage
    }

    void setStage(Stage stage) {
        this.stage = stage
    }

    long getCount() {
        return count
    }

    void setCount(long count) {
        this.count = count
    }

    String getActor() {
        return actor
    }

    void setActor(String actor) {
        this.actor = actor
    }

    String getActorType() {
        return ActorType
    }

    void setActorType(String actorId) {
        this.ActorType = actorId
    }

    Date getEventTime() {
        return eventTime
    }

    void setEventTime(Date eventTime) {
        this.eventTime = eventTime
    }
}
