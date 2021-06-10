package com.revature.WebApp.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.DTO.MovieDetailsDTO;
import com.revature.WebApp.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MovieDetailsController {
    private final ObjectMapper json;
    //private final OMDbAPI apiAccess;
    private final MovieDetailsService movieDetailsService;

    @Autowired
    public MovieDetailsController(MovieDetailsService movieDetailsService) {
        //apiAccess = api;
        this.movieDetailsService = movieDetailsService;
        json = new ObjectMapper();
    }

    @GetMapping(value="/movieDetails/{imdbId}", produces="application/json")
    public String imdbIdSearch(@PathVariable String imdbId, HttpServletResponse response) throws IOException {
        //OMDbSearchResultsDTO searchResultsObject = apiAccess.searchByImdbId(imdbId);
        MovieDetailsDTO detailsObject = movieDetailsService.getMovieDetailsByImdbId(imdbId);

        if(detailsObject == null) {
            response.setStatus(503);
            return "No more calls to OMDb API are allowed in this time period.";
        }
//        if(searchResultsObject.getResponse().equals("False")) {
//            response.setStatus(404);
//            return "ID not found in OMDb Database.";
//        }
        response.setStatus(200);
        return json.writeValueAsString(detailsObject);
    }
}
