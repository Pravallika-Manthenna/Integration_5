package com.stackroute.service;

import com.stackroute.repository.MoviePopulatorRepository;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

@Service
public class MoviePopulatorServiceImpl implements MoviePopulatorService{

    @Autowired
    MoviePopulatorRepository moviePopulatorRepository;

    public MoviePopulatorServiceImpl(MoviePopulatorRepository moviePopulatorRepository) {
        this.moviePopulatorRepository = moviePopulatorRepository;
    }

    @Override
    public void fetchDataFromOmdbApi() {
        ResponseEntity<String> result;
        String jsonString = "";
        JSONArray jsonArray = new JSONArray();
        JSONArray finaljsonArray = new JSONArray();
        for(int i=500;i<=600;i++) {
            final String uri = "http://www.omdbapi.com/?apikey=43866b21&i=tt0048" + i;
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForEntity(uri, String.class);
            jsonString = result.getBody();
            JSONObject output;
            try {
                output = new JSONObject(jsonString);
                jsonArray.put(output);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        System.out.println(jsonArray);
        //Iterate through the elements of the array i.
        //Get thier value.
//        Removing rating array from jsonarray
        for(int i = 0; i < jsonArray.length(); i++)
        {
            try {
                JSONObject objects = jsonArray.getJSONObject(i);
                System.out.println("here");
                objects.remove("Ratings");
                finaljsonArray.put(objects);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Get the value for the first element and the value for the last element.
        }
        System.out.println(finaljsonArray);
// Generating the csv file from json data cpming from imdb database.
        try {
            File file = new File("./moviedata.csv");
            String csv = CDL.toString(finaljsonArray);
            FileUtils.writeStringToFile(file, csv);
            System.out.println("Data has been Sucessfully Writeen to " + file);
        }  catch (JSONException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
//          e.printStackTrace();
        }
    }

    // method to save data from csv and save into neo4j
    @Override
    public void saveDataFromCsv() throws IOException {
        // call repository method to save movie data into neo4j
        moviePopulatorRepository.saveMovie();
    }

}