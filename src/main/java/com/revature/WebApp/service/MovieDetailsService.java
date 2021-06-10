package com.revature.WebApp.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.APIAccess.OMDbAPI;
import com.revature.WebApp.DTO.MovieDetailsDTO;
import com.revature.WebApp.DTO.OMDbSearchResultsDTO;
import com.revature.WebApp.entities.MovieDetailsEntity;
import com.revature.WebApp.entities.UserEntity;
import com.revature.WebApp.repositories.MovieDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class MovieDetailsService {
    private MovieDetailsRepository movieRepo;
    private ObjectMapper json;
    private OMDbAPI omdbApi;

    @Autowired
    public MovieDetailsService(MovieDetailsRepository movieRepo, OMDbAPI omdbApi) {
        this.movieRepo = movieRepo;
        this.json = new ObjectMapper();
        this.omdbApi = omdbApi;
    }

    public void saveMovieDetailsCache() {

    }

    public MovieDetailsDTO getMovieDetailsByImdbId(String imdbId) throws IOException {
        MovieDetailsEntity foundMovie = movieRepo.findByImdbId(imdbId);
        if(foundMovie == null) {
            //not found, get from API
            OMDbSearchResultsDTO movieDetails = omdbApi.searchByImdbId(imdbId);
            MovieDetailsEntity entity = new MovieDetailsEntity(movieDetails);
            movieRepo.save(entity);
            return new MovieDetailsDTO(movieDetails);
        }
        return new MovieDetailsDTO(foundMovie);

    }

}
