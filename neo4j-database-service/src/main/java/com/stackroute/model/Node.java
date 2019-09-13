package com.stackroute.model;

import org.neo4j.ogm.annotation.Id;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class Node {

    @Id
    private Object name;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name=" + name +
                '}';
    }
}
