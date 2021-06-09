package com.revature.WebApp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.DTO.LoginDTO;
import com.revature.WebApp.entities.UserEntity;
import com.revature.WebApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class AuthController {

    private UserRepository userRepo;
    private ObjectMapper json;

    @Autowired
    public  AuthController(UserRepository userRepo){
        this.userRepo = userRepo;
        json = new ObjectMapper();
    }

    /**
     *  Registration of a new User into the database
     * @param newUser - The user that you want to register into the database
     * @param response - HTTP response object
     * @return - json formatted string with query results
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
    public String registerUser(@RequestBody UserEntity newUser, HttpServletResponse response) throws JsonProcessingException {
        userRepo.save(newUser);
        response.setStatus(201);
        return json.writeValueAsString(newUser);
    }

    /**
     * Uses inputted credentials to look for a specified user
     * @param loginDTO - A DTO representing the username and password that will be used to find a user in the database
     * @param response - HTTP response object
     * @return - json formatted string with updated object (if found)
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public String login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws JsonProcessingException {
        UserEntity foundUser = userRepo.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        Optional<UserEntity> foundUserOptional = Optional.of(userRepo.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword()));
        if(foundUserOptional.isPresent()){

            //Create JWT?

            response.setStatus(200);
            return json.writeValueAsString(foundUserOptional.get());
        } else {
            response.setStatus(404);
            return "Invalid username and/or password!";
        }

    }

}
