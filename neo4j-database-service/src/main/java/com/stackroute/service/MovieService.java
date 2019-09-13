package com.stackroute.service;

import com.stackroute.model.Node;

import java.util.Collection;

public interface MovieService {

    public Collection<Node> getData(String nodelabel, String relation);

    public Collection<Node> getDataforDoubleNode(String nodelabel1,String nodelabel2);
}
