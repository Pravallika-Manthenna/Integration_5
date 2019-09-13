package com.stackroute.Repository;

import com.stackroute.model.Movie;
import com.stackroute.model.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    @Query("MATCH (m)-[r]-(connected) WHERE {node} in labels(m) AND type(r) = {relation} RETURN connected as name")
    Collection<Node> findData(@Param("node") String node, @Param("relation") String relation);
    @Query("MATCH (m)-[relation:ACTED_IN]-(connected),(connected)-[r:PRODUCED_BY]-(p) WHERE {node1} in labels(m) AND {node2} in labels(p) AND m.name=\"Vijay\" AND p.name=\"AlluArjun\" RETURN connected as name")
    Collection<Node> findDoubleData(@Param("node1")String node1,@Param("node2") String node2);
}
