package com.stackroute.controller;
import com.stackroute.model.Dictionaryy;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/api/v1")
public class POSController {
    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;
    @Autowired
    Dictionaryy dictionary;
    ResponseEntity responseEntity;
    @Autowired
    private KafkaTemplate<String,HashMap> kafkaTemplate;
    private static final String TOPIC = "Search-nlp";

    @PostMapping
    @RequestMapping(value="/pos")
    public HashMap<String,String> ner(@RequestBody final String input)
    {
        CoreDocument coreDocument = new CoreDocument(input);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabels=coreDocument.tokens();
        LinkedList<String> listobj = new LinkedList<String>(collectionList(coreLabels));
        HashMap<String,String> response= new HashMap<String,String>(dictionary.mapvalue(listobj));
        System.out.println(response);
        this.kafkaTemplate.send(TOPIC,response);
       return response;

    }
    private List<String> collectionList(List<CoreLabel> coreLabels)
    {
        List<String> res= Arrays.asList(new String[coreLabels.size()]);
        int i=0;
        for(CoreLabel corelabel : coreLabels)
        {
            String pos=corelabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            if(pos.equals("NNP") || pos.equals("VBN") || pos.equals("VBZ") || pos.equals("CD") || pos.equals("NN") || pos.equals("NNPS") || pos.equals("JJS") || pos.equals("VBP") ||pos.equals("FW")||pos.equals("VBD"))
            {
                res.set(i, corelabel.originalText());
                i++;
            }
        }
        return res;
    }
}