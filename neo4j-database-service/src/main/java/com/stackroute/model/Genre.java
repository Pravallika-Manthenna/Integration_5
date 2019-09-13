package com.stackroute.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Genre {
  private String type;
  public Genre()
  {

  }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Genre(String type) {
        this.type = type;
    }
}
