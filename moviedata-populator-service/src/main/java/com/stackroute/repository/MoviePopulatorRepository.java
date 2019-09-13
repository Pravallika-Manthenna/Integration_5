package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePopulatorRepository extends Neo4jRepository<Movie, Long> {

    // method to save the data from csv file to neo4j

   @Query("LOAD CSV WITH HEADERS FROM\n" +
           " \"https://raw.githubusercontent.com/stackroute/ibm-wave7-web-knowledge-generator/movieData-populator-service/moviedata.csv\"\n" +
           "AS data WITH data WHERE NOT (data.Title=\"N/A\") \n" +
           "MERGE (movie:Movie {title: data.Title, imdbId:data.imdbID, summary:data.Plot, awards:data.Awards})\n" +
           "WITH data WHERE NOT (data.Actors=\"N/A\") UNWIND split(data.Actors, ',') AS actor\n" +
           "MERGE (actornew:Actor {name: actor})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "UNWIND split(data.Actors, ',') AS actor1\n" +
           "MATCH (actor1new:Actor {name: actor1})\n" +
           "MERGE (movie)-[r:HAS_ACTOR]->(actor1new)\n" +
           "MERGE (movie)<-[rb:ACTED_IN]-(actor1new)\n" +
           "WITH data\n" +
           "WHERE NOT (data.Year=\"N/A\")\n" +
           "MERGE (year:ReleasedYear {year: data.Year})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "MATCH (year:ReleasedYear {year: data.Year})\n" +
           "MERGE (movie)-[r:RELEASED_IN]->(year)\n" +
           "MERGE (movie)<-[rb:HAS_MOVIE]-(year)\n" +
           "WITH data\n" +
           "WHERE NOT (data.Genre=\"N/A\")\n" +
           "UNWIND split(data.Genre, ',') AS genre\n" +
           "MERGE (genrenew:Genre {type: genre})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "UNWIND split(data.Genre, ',') AS genre1\n" +
           "MATCH (genre1new:Genre {type: genre1})\n" +
           "MERGE (movie)-[r:HAS_GENRE]->(genre1new)\n" +
           "MERGE (movie)<-[rb:IN_GENRE]-(genre1new)\n" +
           "WITH data\n" +
           "WHERE NOT (data.Language=\"N/A\")\n" +
           "MERGE (lang:Language {language: data.Language})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "MATCH (lang:Language {language: data.Language})\n" +
           "MERGE (movie)-[r:IN_LANGUAGE]->(lang)\n" +
           "MERGE (movie)<-[rb:IS_LANGUAGE_OF]-(lang)\n" +
           "WITH data\n" +
           "WHERE NOT (data.Country=\"N/A\")\n" +
           "MERGE (country:Country {name: data.Country})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "MATCH (country:Country {name: data.Country})\n" +
           "MERGE (movie)-[r:MADE_IN]->(country)\n" +
           "MERGE (movie)<-[rb:CONSIST_OF]-(country)\n" +
           "WITH data\n" +
           "WHERE NOT (data.Director=\"N/A\")\n" +
           "UNWIND split(data.Director, ',') AS director\n" +
           "MERGE (directornew:Director {name: director})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "UNWIND split(data.Director, ',') AS director1\n" +
           "MATCH (director1new:Director {name: director1})\n" +
           "MERGE (movie)-[r:DIRECTED_BY]->(director1new)\n" +
           "MERGE (movie)<-[rb:DIRECTED]-(director1new)\n" +
           "WITH data\n" +
           "WHERE NOT (data.Production=\"N/A\")\n" +
           "MERGE (production:Production {company: data.Production})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "MATCH (production:Production {company: data.Production})\n" +
           "MERGE (movie)-[r:PRODUCED_BY]->(production)\n" +
           "MERGE (movie)<-[rb:PRODUCED]-(production)\n" +
           "WITH data\n" +
           "WHERE NOT (data.imdbRating=\"N/A\")\n" +
           "MERGE (rating:Rating {value: data.imdbRating})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "MATCH (rating:Rating {value: data.imdbRating})\n" +
           "MERGE (movie)-[r:HAS_RATING]->(rating)\n" +
           "MERGE (movie)<-[rb:RATING_OF]-(rating)\n" +
           "WITH data\n" +
           "WHERE NOT (data.Writer=\"N/A\")\n" +
           "UNWIND split(data.Writer, ',') AS writer\n" +
           "MERGE (writernew:Writer {name: writer})\n" +
           "WITH data\n" +
           "MATCH (movie:Movie {title: data.Title})\n" +
           "UNWIND split(data.Writer, ',') AS writer1\n" +
           "MATCH (writer1new:Writer {name: writer1})\n" +
           "MERGE (movie)-[r:WRITTEN_BY]->(writer1new)\n" +
           "MERGE (movie)<-[rb:WRITTEN]-(writer1new);\n")
    void saveMovie();
}
