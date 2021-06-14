package com.revature.WebApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.DTO.MovieDetailsDTO;
import com.revature.WebApp.DTO.Principal;
import com.revature.WebApp.entities.WatchHistoryEntity;
import com.revature.WebApp.repositories.MovieDetailsRepository;
import com.revature.WebApp.repositories.WatchHistoryRepository;
import com.revature.WebApp.security.TokenParser;
import com.revature.WebApp.services.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class WatchHistoryController {
    private final ObjectMapper json;
    private final WatchHistoryRepository watchHistoryRepo;
    private final MovieDetailsService movieService;
    private final TokenParser tokenParser;

    @Autowired
    public WatchHistoryController(WatchHistoryRepository watchHistoryRepo, TokenParser tokenParser, MovieDetailsService movieService) {
        this.watchHistoryRepo = watchHistoryRepo;
        this.tokenParser = tokenParser;
        this.movieService = movieService;
        this.json = new ObjectMapper();
    }

    @GetMapping(value="/history", produces = "application/json")
    public String titleSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        tokenParser.checkToken(request);
        if(request.getAttribute("principal") == null) {
            response.setStatus(401);
            return "Not Authorized.";
        }

        Integer userId = ((Principal)request.getAttribute("principal")).getId();
        List<MovieDetailsDTO> list =  movieService.getWatchHistoryDetails(userId);

        response.setStatus(200);
        return json.writeValueAsString(list);
    }

}
