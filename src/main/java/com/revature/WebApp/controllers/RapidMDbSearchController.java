package com.revature.WebApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.APIAccess.RapidMDbAPI;
import com.revature.WebApp.DTO.RapidMDbSearchResultsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class RapidMDbSearchController {
    private final ObjectMapper json;
    private RapidMDbAPI apiAccess;

    @Autowired
    public RapidMDbSearchController(RapidMDbAPI api) {
        apiAccess = api;
        json = new ObjectMapper();
    }

    @GetMapping(value="/rapidSearch/{movieTitle}", produces = "application/json")
    public String titleSearch(@PathVariable String movieTitle, HttpServletResponse response) throws IOException {
        RapidMDbSearchResultsDTO searchResultObject = apiAccess.searchByTitle(movieTitle);

        if(searchResultObject.getResponse().equals("False")) {
            response.setStatus(404);
            return "Title not found in Internet MovieDetailsEntity Database.";
        }
        response.setStatus(200);
        return json.writeValueAsString(searchResultObject);

    }
}
