package com.evie.domain

import groovy.transform.EqualsAndHashCode

/**
 * Created by rmhedge on 3/18/17.
 */
@EqualsAndHashCode
class MongoCollection {

    private String collectonName;
    private String collectionSize;
    private String collectionCount;

    private boolean sharded;String getCollectonName() {
        return collectonName
    }

    void setCollectonName(String collectonName) {
        this.collectonName = collectonName
    }

    String getCollectionSize() {
        return collectionSize
    }

    void setCollectionSize(String collectionSize) {
        this.collectionSize = collectionSize
    }

    String getCollectionCount() {
        return collectionCount
    }

    void setCollectionCount(String collectionCount) {
        this.collectionCount = collectionCount
    }

    boolean getSharded() {
        return sharded
    }

    void setSharded(boolean sharded) {
        this.sharded = sharded
    }
}
