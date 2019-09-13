package com.stackroute.controller;


import com.stackroute.core.Pipeline;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@RestController

//Creates the base url
@RequestMapping(value="/api/v1")
public class POSController {

    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;
    String input="";
    @KafkaListener(topics = "Fetch_Webpage", groupId = "group_id")
    public void consumer(String message) throws IOException
    {

        this.input=message;
        //System.out.println(input);
    }

    @Autowired
    private KafkaTemplate<String,LinkedHashMap> kafkaTemplate;
    private static final String TOPIC = "Fetch-Keyword";


    @GetMapping
    @RequestMapping(value="/pos")
    public LinkedHashMap<String,String> ner(String data)
    {
        data=input;
        //System.out.println(data);
        //String is converted to string array
        String[] nodes=data.split("%");
        nodes[0]=" ";
        LinkedHashMap<String,String> collect=new LinkedHashMap<>();
        int flag=0;
        for(int i=0;i<nodes.length;i++)
        {
            if(!nodes[i].equals(" ")&&flag==0)
            {

                //put is used to add key-value pairs in LinkedHashMap
                collect.put("Title",nodes[i]);
                flag+=1;
            }

            if(nodes[i].trim().equals("Directed by")||nodes[i].trim().equals("Produced by")||nodes[i].trim().equals("Starring"))
            {
                String activity=nodes[i].trim();
                String directors=giveDirectors(nodes,i+1);
                collect.put(activity,directors.substring(0,directors.length()-1));
            }

            if(nodes[i].trim().equals("Release date"))
            {
                String date=giveDate(nodes,i+1);
                collect.put("Release year",date.substring(date.length()-4));
            }

            if(nodes[i].trim().equals("Language"))
            {
                String lang=giveDate(nodes,i+1);
                collect.put("Language",lang);
            }

        }
        //produce map object to kafka
        this.kafkaTemplate.send(TOPIC,collect);
        //System.out.println("published");
        return collect;
    }


    //Method to extract values for each key
    public static String giveDirectors(String[] nodes, int posn)
    {
        String names="";
        for(int i=posn;i<nodes.length;i++)
        {

            if(!nodes[i].equals(" "))
            {

                if (nodes[i].trim().equals("Produced by")||nodes[i].trim().equals("Written by")||nodes[i].trim().equals("Music by"))
                {
                    break;
                }
                else
                    {
                    names += nodes[i].trim() + ",";
                }
            }
        }
        return names;
    }

    //Method to extract value for Released year
    public static String giveDate(String[] nodes, int posn)
    {

        String date="";
        for(int i=posn;i<nodes.length;i++)
        {
            if(!nodes[i].equals(" "))
            {
                date+=nodes[i];
                break;
            }
        }
        return date;
    }
}