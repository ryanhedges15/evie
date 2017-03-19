package com.evie.domain

import groovy.transform.EqualsAndHashCode

/**
 * Created by rmhedge on 3/18/17.
 */
@EqualsAndHashCode
class MongoDatabase {

    private String databaseName;
    private int databaseSizeInBytes;
    private List<MongoCollection> mongoCollections;
    private String version;

    String getDatabaseName() {
        return databaseName
    }

    void setDatabaseName(String databaseName) {
        this.databaseName = databaseName
    }

    int getDatabaseSizeInBytes() {
        return databaseSizeInBytes
    }

    void setDatabaseSizeInBytes(int databaseSizeInBytes) {
        this.databaseSizeInBytes = databaseSizeInBytes
    }

    List<MongoCollection> getMongoCollections() {
        return mongoCollections
    }

    void setMongoCollections(List<MongoCollection> mongoCollections) {
        this.mongoCollections = mongoCollections
    }

    String getVersion() {
        return version
    }

    void setVersion(String version) {
        this.version = version
    }
}
