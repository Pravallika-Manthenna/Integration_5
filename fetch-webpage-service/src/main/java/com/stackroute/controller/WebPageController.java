package com.stackroute.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.model.Search;
import com.stackroute.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
//controller to fetch websiteData
@RestController
public class WebPageController {
    private ResponseEntity responseEntity;
    private WebPageService webPageService;
    private Search search;
    public WebPageController(WebPageService webPageService) throws IOException {
        this.webPageService = webPageService;
    }
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "Fetch_Webpage";
    public String consumedUrl;
    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consumer(String url) throws IOException {
//    Search obj = new ObjectMapper().readValue(url,Search.class);
//    obj.setUrl(url);
        this.consumedUrl=url;
        System.out.println("consumed url is:"+consumedUrl);
    }
    //getMapping to fetch the reqiured contents from the url
    @GetMapping("getContent")
    //Controller method to return the data
    public ResponseEntity<String> getAllContent() throws IOException {
        System.out.println("inside mapping");
        //System.out.println(url);

        String url=this.consumedUrl;
        System.out.println("URL"+url);
        //url = url.substring(14,url.length()-3);

//       result = webPageService.getTitle(url)+"\n\n\n";
        System.out.println("this is the url:"+url);
        String result = "";

        result = result + webPageService.getTableData(url)+"\n\n\n" ;
//        result = result + webPageService.printImages()+"\n\n\n";
//        result = result + webPageService.getSourceCodeOfWebPage(url)+"\n\n\n";
        responseEntity = new ResponseEntity<String>(result,HttpStatus.OK);
        this.kafkaTemplate.send(TOPIC,result);
        System.out.println("Data is produced");
        return responseEntity;
    }
}