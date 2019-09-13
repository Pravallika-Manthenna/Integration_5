package com.stackroute.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Writer {
    private String name;
    public Writer()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Writer(String name) {
        this.name = name;
    }

}
