package com.revature.WebApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.entities.PrototypeEntity;
import com.revature.WebApp.repositories.PrototypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private PrototypeRepository testRepo;
    private ObjectMapper json;

    @Autowired
    public  AuthController(PrototypeRepository testRepo){
        this.testRepo = testRepo;
        json = new ObjectMapper();
    }

    /*
        Registration of a new User
     */
    @PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
    public String registerUser(@RequestBody PrototypeEntity){

    }
}
