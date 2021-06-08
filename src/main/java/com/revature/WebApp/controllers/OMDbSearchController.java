package com.revature.WebApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.APIAccess.OMDbAPI;
import com.revature.WebApp.DTO.OMDbSearchResultsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class OMDbSearchController {
    private final ObjectMapper json;

    //@Autowired
    public OMDbSearchController() {
        json = new ObjectMapper();
    }

    @GetMapping(value="/omdb/{movieTitle}", produces = "application/json")
    public String titleSearch(@PathVariable String movieTitle, HttpServletResponse response) throws IOException {
        OMDbSearchResultsDTO searchResultObject = OMDbAPI.getAPIAccess().searchByTitle(movieTitle);

        if(searchResultObject.getResponse().equals("False")) {
            response.setStatus(404);
            return "Title not found in Internet Movie Database.";
        }
        response.setStatus(200);
        return json.writeValueAsString(searchResultObject);

    }
}
