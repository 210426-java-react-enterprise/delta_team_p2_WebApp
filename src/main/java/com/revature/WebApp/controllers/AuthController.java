package com.revature.WebApp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.entities.MovieUser;
import com.revature.WebApp.entities.PrototypeEntity;
import com.revature.WebApp.repositories.MovieUserRepository;
import com.revature.WebApp.repositories.PrototypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    private MovieUserRepository userRepo;
    private ObjectMapper json;

    @Autowired
    public  AuthController(MovieUserRepository userRepo){
        this.userRepo = userRepo;
        json = new ObjectMapper();
    }

    /**
     *  Registration of a new User into the database
     * @param newUser - The user that you want to register into the database
     * @param response - HTTP response object
     * @return json formatted string with query results
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
    public String registerUser(@RequestBody MovieUser newUser, HttpServletResponse response) throws JsonProcessingException {
        userRepo.save(newUser);
        response.setStatus(201);
        return json.writeValueAsString(newUser);
    }
}
