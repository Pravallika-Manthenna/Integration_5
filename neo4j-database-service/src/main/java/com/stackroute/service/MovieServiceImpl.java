package com.stackroute.service;

import com.stackroute.Repository.MovieRepository;
import com.stackroute.model.Node;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;
     String[] actor= {"actor","star","hero","performer"," player", "trouper", "artist"};
     String[] writer={"author","scriptwriter"};

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }




    @Override
    public Collection<Node> getData(String nodelabel, String relation) {
        for(int i = 0; i < actor.length; i++) {
            if(nodelabel.equals(actor[i]))
            {
                nodelabel="Actor";
                break;
            }

        }
        for(int i = 0; i < writer.length; i++) {

            if(nodelabel.equals(writer[i]))
            {
                nodelabel="Writer";
            }
        }
        System.out.println(nodelabel);
        System.out.println(relation);
        System.out.println(movieRepository.findData(nodelabel,relation));
        return (Collection<Node>) movieRepository.findData(nodelabel,relation);
    }

    @Override
    public Collection<Node> getDataforDoubleNode(String nodelabel1,String nodelabel2)
    {
        return (Collection<Node>) movieRepository.findDoubleData(nodelabel1,nodelabel2);
    }

}
