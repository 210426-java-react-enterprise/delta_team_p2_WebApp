package com.revature.WebApp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PingController {
    @GetMapping(value="/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String listAllTestEntities(HttpServletResponse response) throws JsonProcessingException {
        response.setStatus(200);
        return "Pong!";
    }
}
