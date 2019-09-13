package com.stackroute.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Rating {
    private String value;
    public Rating()
    {

    }

    public Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
