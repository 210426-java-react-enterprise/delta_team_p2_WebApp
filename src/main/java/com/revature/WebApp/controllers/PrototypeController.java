package com.revature.WebApp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.entities.PrototypeEntity;
import com.revature.WebApp.repositories.PrototypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;

/**
 * This prototype controller can be used as a template for others. mapped to HTTP endpoints, annotated
 * with @Restcontroller. Has private fields for common objects, including the corresponding repository interface
 * autowired in constructor.
 */
@RestController
public class PrototypeController {

    private PrototypeRepository testRepo;
    private ObjectMapper json;

    @Autowired
    public PrototypeController(PrototypeRepository testRepo) {
        this.testRepo = testRepo;
        json = new ObjectMapper();
    }

    /**
     * This GET servlet forms a list of all prototype entities in the database and returns them in a json string.
     * @param response - HTTP response object
     * @return json formatted string with query results
     * @throws JsonProcessingException
     */
    @GetMapping(value="/getprototypeentities", produces = "application/json")
    public String listAllTestEntities(HttpServletResponse response) throws JsonProcessingException {
        ArrayList<PrototypeEntity> prototypeEntityList = (ArrayList<PrototypeEntity>) testRepo.findAll();
        response.setStatus(200);
        return json.writeValueAsString(prototypeEntityList);
    }

    /**
     * This POST servlet will create a new entity using the json formatted body text, and persist it in the database
     * @param prototypeEntity - autopopulated from request body
     * @param response - HTTP response object
     * @return - json formatted string of newly created object
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/createprototypeentity", consumes = "application/json", produces = "application/json")
    public String createNewTestEntity(@RequestBody PrototypeEntity prototypeEntity, HttpServletResponse response) throws JsonProcessingException {
        testRepo.save(prototypeEntity);
        response.setStatus(201);
        return json.writeValueAsString(prototypeEntity);
    }

    /**
     * This PUT mapping will load an entity from database based on Id, and will update and save the other fields
     * @param update - autopopulated from request body
     * @param response - HTTP response object
     * @return - json formatted string of newly pdated object
     * @throws JsonProcessingException
     */
    @PutMapping(value = "/updateprototypeentity", consumes = "application/json", produces = "application/json")
    public String updateEntity(@RequestBody PrototypeEntity update, HttpServletResponse response) throws JsonProcessingException {
        Optional<PrototypeEntity> testEntityOptional = testRepo.findById(update.getId());
        if(testEntityOptional.isPresent()) {
            testEntityOptional.get().setString(update.getString());
            testEntityOptional.get().setDbl(update.getDbl());
            testEntityOptional.get().setBool(update.getBool());
            testRepo.save(testEntityOptional.get());
            response.setStatus(200);
            return json.writeValueAsString(testEntityOptional.get());
        } else {
            response.setStatus(404);
            return "Object with Id = " + update.getId() + " not found.";
        }

    }
}
