package com.stackroute.model;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Dictionaryy {

    ArrayList<String> movie = new ArrayList<String>();
    ArrayList<String> starring = new ArrayList<String>();
    ArrayList<String> director = new ArrayList<String>();
    ArrayList<String> releasedyear = new ArrayList<String>();
    ArrayList<String> productionhouse = new ArrayList<String>();
    ArrayList<String> producer = new ArrayList<String>();
    ArrayList<String> moviename = new ArrayList<String>();
    ArrayList<String> actorname = new ArrayList<String>();
    ArrayList<String> directorname = new ArrayList<String>();
    ArrayList<String> producername = new ArrayList<String>();
    ArrayList<String> releaseyear = new ArrayList<String>();
    ArrayList<String> productionhousename = new ArrayList<String>();


    public HashMap<String,String> mapvalue(LinkedList<String> list) {
        movie.add("Movie");
        movie.add("cinema");
        movie.add("motion picture");
        movie.add("picture");
        movie.add("film");
        movie.add("movie projector");
        movie.add("photographic film");
        movie.add("photographic film");
        movie.add("television");
        movie.add("motion picture");
        movie.add("filmmaking");
        movie.add("documentary");
        movie.add("movie theater");
        movie.add("photography");
        movie.add("screenplay");
        movie.add("microfilm");
        movie.add("episode");
        movie.add("telefilm");
        movie.add("cinematography");
        movie.add("silver screen");
        movie.add("videotape");
        movie.add("scene");
        movie.add("computer animation");
        movie.add("film noir");
        moviename.add("Kiss.of.Fire");


        //star cast dictionary
        starring.add("Starring");
        starring.add("CAST");
        starring.add("casting");
        starring.add("casted");
        starring.add("actor");
        starring.add("actress");
        starring.add("star");
        starring.add("act");
        starring.add("performer");
        starring.add("character");
        starring.add("player");
        starring.add("comedian");
        starring.add("tragedian");
        starring.add("villain");
        starring.add("supporting actor");
        starring.add("supporting actress");
        starring.add("hero");
        starring.add("heroine");
        starring.add("heroic");
        starring.add("protagonist");
        starring.add("leader");
        starring.add("superstar");
        starring.add("fighter");
        starring.add("superhero");
        starring.add("man");
        starring.add("women");
        starring.add("stars");
        starring.add("acting");
        starring.add("acted");
        starring.add("action");
        starring.add("actors");
        starring.add("heroes");
        starring.add("actresses");
        actorname.add("Delia.Scala");
        actorname.add("Barbara.Rush");

        // director dictionary

        director.add("Director");
        director.add("DIRECTED");
        director.add("manager");
        director.add("administrator");
        director.add("assistant");
        director.add("executive");
        director.add("assistant director");
        director.add(" managing director");
        director.add("music director");
        director.add("supervisor");
        director.add("manager");
        director.add("directing");
        director.add("direct");
        director.add("manager");
        director.add("shoot");
        director.add("shooted");

        director.add("direction");

        //producer dictionary

        producer.add("Producer");
        producer.add("PRODUCED");
        producer.add("filmmaker");
        producer.add("manufacturer");
        producer.add("maker");
        producer.add("promoter");
        producer.add("creator");
        producer.add("Producers");
        producer.add("arranger");
        producer.add("studio");
        producer.add("coproduce");
        producer.add("generate");
        producer.add("producing");

        //production house dictionary
        productionhouse.add("ProductionHouse");
        productionhouse.add("PRODUCTION");
        productionhouse.add("company");
        productionhouse.add("production house");
        productionhouse.add("house");
        productionhouse.add("production company");
        productionhouse.add("production");
        productionhouse.add("produced");
        productionhouse.add("made");
        productionhouse.add("making");

        // released year dictionary
        releasedyear.add("ReleasedYear");
        releasedyear.add("RELEASES");
        releasedyear.add("year");
        releasedyear.add("date");
        releasedyear.add("released");
        releasedyear.add("releasing");
        releasedyear.add("Released in");
        releasedyear.add("release");
        releasedyear.add("release date");
        releasedyear.add("release date");
        releasedyear.add("releases");
        releasedyear.add("latest");
        releasedyear.add("first");
        releasedyear.add("last");

        moviename.add("The.Girl.Rush");
        actorname.add("Rosalind.Russell");
        actorname.add("Eddie.Albert");
        directorname.add("Robert.Pirosh");
        producername.add("?");
        releaseyear.add("1955");
        moviename.add("Guns.Don't.Argue");
        actorname.add("Jean.Harvey");
        actorname.add("Paul.Dubov");
        directorname.add("Bill.Karn");
        producername.add("?");
        productionhousename.add("Visual.Drama.inc");
        releaseyear.add("1957");
        moviename.add("Hi-Jack.Highway");
        actorname.add("Jean.Gabin");
        actorname.add("Gaby.Basset");
        directorname.add("Gilles.Grangier");
        producername.add("?");
        releaseyear.add("1955");

        String relation1;
        ArrayList<Object> mergelist = new ArrayList<Object>();
//        ArrayList<String> relationlist = new ArrayList<String>();
//        ArrayList<String> valuelist = new ArrayList<String>();
        HashMap<String, String> relationlist = new HashMap<String, String>();
        HashMap<String, String> valuelist = new HashMap<String, String>();
        HashMap<String, String> nodelist = new HashMap<String, String>();
//        HashMap<String,Object> mergelist = new HashMap<String,Object>();
        HashMap<String,String> result = new HashMap<String,String>();

        System.out.println(list);
        int index1=1;
        int index2=1;
        int index3=1;
        System.out.println(relationlist.size());
        System.out.println(valuelist.size());
        System.out.println(nodelist.size());

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) != null) {

                System.out.println(starring.get(1));


                for (String item : movie) {

                    if (list.get(i).equalsIgnoreCase(item)) {
                        nodelist.put("node"+(index1++),movie.get(0));

                    }
                    break;

                }
                for (String item12 : moviename) {
                    if (list.get(i).equalsIgnoreCase(item12)) {
                        nodelist.put("node"+(index1++),movie.get(0));
                        valuelist.put("value"+(index3++),item12);
                    }


                }

                for (int j = 0; j < starring.size(); j++) {
                    System.out.println("starring");
                    if (list.get(i).equalsIgnoreCase(starring.get(j))) {
                        nodelist.put("nodestar"+(index1++),starring.get(0));
                        relationlist.put("relation"+(index2++),starring.get(1));

                    }
                    break;
                }
                for (String item13 : actorname) {
                    if (list.get(i).equalsIgnoreCase(item13)) {
                        nodelist.put("nodeactor"+(index1++),starring.get(0));
                        valuelist.put("value"+(index3++),item13);
                        relationlist.put("relation"+(index2++),starring.get(1));

                    }

                }
                for (String item2 : director) {
                    if (list.get(i).equalsIgnoreCase(item2)) {
                        nodelist.put("node"+(index1++),director.get(0));

                        relationlist.put("relation"+(index2++),director.get(1));

                    }
                    break;
                }
                for (String item14 : directorname) {
                    if (list.get(i).equalsIgnoreCase(item14)) {
                        nodelist.put("node"+(index1++),director.get(0));
                        valuelist.put("value"+(index3++),item14);
                        relationlist.put("relation"+(index2++),director.get(1));

                    }

                }
                for (String item3 : producer) {
                    if (list.get(i).equalsIgnoreCase(item3)) {
                        nodelist.put("node"+(index1++),producer.get(0));

                        relationlist.put("relation"+(index2++),producer.get(1));

                    }

                }
                for (String item15 : producername) {
                    if (list.get(i).equalsIgnoreCase(item15)) {
                        nodelist.put("node"+(index1++),producer.get(0));
                        valuelist.put("value"+(index3++),item15);
                        relationlist.put("relation"+(index2++),producer.get(1));

                    }
                    break;

                }
                for (String item4 : productionhouse) {
                    if (list.get(i).equalsIgnoreCase(item4)) {
                        nodelist.put("node"+(index1++),productionhouse.get(0));

                        relationlist.put("relation"+(index2++),productionhouse.get(1));


                    }
                }
                for (String item16 : productionhousename) {
                    if (list.get(i).equalsIgnoreCase(item16)) {
                        nodelist.put("node"+(index1++),productionhouse.get(0));
                        valuelist.put("value"+(index3++),item16);
                        relationlist.put("relation"+(index2++),productionhouse.get(1));

                    }


                }
                for (String item5 : releasedyear) {
                    if (list.get(i).equalsIgnoreCase(item5)) {
                        nodelist.put("nodereleasedyear"+(index1++),releasedyear.get(0));

                        relationlist.put("relation"+(index2++),releasedyear.get(1));


                    }
                    break;
                }
                for (String item17 : releaseyear) {
                    if (list.get(i).equalsIgnoreCase(item17)) {
                        nodelist.put("nodereleases"+(index1++),releasedyear.get(0));
                        valuelist.put("value"+(index3++),item17);
                        relationlist.put("relation"+(index2++),releasedyear.get(1));

                    }

                }
//
            }
        }

     
        System.out.println(nodelist);
        System.out.println(relationlist);
        System.out.println(valuelist);

        for (Map.Entry<String,String> entry : nodelist.entrySet()){
            result.put(entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String,String> entry : relationlist.entrySet()){
            result.put(entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String,String> entry : valuelist.entrySet()){
            result.put(entry.getKey(),entry.getValue());
        }
         movie.clear();
       starring.clear();
        director.clear();
        releasedyear.clear();
        productionhouse.clear();
       producer.clear();
        moviename.clear();
        actorname.clear();
       directorname.clear();
        producername.clear();
        releaseyear.clear();
       productionhousename.clear();

       index1=1;
       index2=1;
       index3=1;
       nodelist=new HashMap<String,String>();
        relationlist=new HashMap<String,String>();
        valuelist=new HashMap<String,String>();
        return result;
    }
}
