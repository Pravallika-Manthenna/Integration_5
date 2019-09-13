package com.stackroute.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.modals.CodeBeautify;
import com.stackroute.modals.Result;
import com.stackroute.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebSearchServiceImpl implements WebSearchService {
    @Autowired
    private SearchRepository searchRepository;

    public WebSearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }


    @Override
    public String getSearchResults(String searchString) throws URISyntaxException {
//        List<Result>  output= new ArrayList<>();
        Result output = null;
        RestTemplate restTemplate = new RestTemplate();
        //api to get links from
        String url = "https://app.zenserp.com/api/v2/search?q=wikipedia+film"+searchString+"&hl=en&gl=US&location=United%20States&search_engine=google.com&apikey=ffd367c0-cd88-11e9-9bc5-594f8022ff50";
         //        String url = "https://app.zenserp.com/api/v2/search?q=wikipedia+film"+searchString+"&hl=en&gl=US&location=United%20States&search_engine=google.com&apikey=1fb802e0-cec9-11e9-832d-db422e6db58d";

        System.out.println("In service"+url);

        URI uri = new URI(url);
        String string = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        CodeBeautify result = null;
        try {
            result = objectMapper.readValue(string, CodeBeautify.class);
            //list of links from the data
            List<Result> resultList = result.getOrganic();
            //saving the results
            output = resultList.get(0);
            System.out.println("SSSSSSSSSSSSSS "+output);
            searchRepository.save(output);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String output1=output.toString();
        System.out.println("FFFFFFFFFFFFFFFFFF "+output1);
        int len = output1.length();
        output1.substring(10,len-3);

        System.out.println("out  "+output1);
        return output1;
    }
//
//    @Override
//    public Result saveResults(Result resultList) throws URISyntaxException {
//        return searchRepository.save(resultList);
//    }
}


