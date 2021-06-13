package com.revature.WebApp.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.DTO.FollowerDetailDTO;
import com.revature.WebApp.DTO.MovieDetailsDTO;
import com.revature.WebApp.entities.FollowsListEntity;
import com.revature.WebApp.services.FollowerService;
import com.revature.WebApp.services.MovieUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProfileDetailsController {

    private final FollowerService followerService;
    private final MovieUserService userService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProfileDetailsController(FollowerService followerService, MovieUserService userService){
        this.followerService = followerService;
        this.userService = userService;
        objectMapper = new ObjectMapper();
    }

    @GetMapping("/findallfollowers")
    public List<FollowsListEntity> allfollowers(){
        List<FollowsListEntity> followers = followerService.findAllFollowers();
        return followers;
    }

    @GetMapping(value = "/followerdetail/{userId}", produces = "application/json")
    public String allfollowerdetail(@PathVariable String userId, HttpServletResponse response) throws JsonProcessingException {
        List<FollowerDetailDTO> followers = followerService.getAllFollowerDetail(userId);
        response.setStatus(201);

        return objectMapper.writeValueAsString(followers);

    }

    @GetMapping(value = "/userwatchlist/{userId}", produces = "application/json")
    public String getWatchlistDetail(@PathVariable String userId, HttpServletResponse response) throws JsonProcessingException {
        List<MovieDetailsDTO> watchList = userService.getUsersWatchList(userId);
        return objectMapper.writeValueAsString(watchList);
    }

    @GetMapping(value = "/userwatchhistory/{userId}", produces = "application/json")
    public String getWatchhistoryDetail(@PathVariable String userId, HttpServletResponse response) throws JsonProcessingException {
        List<MovieDetailsDTO> watchList = userService.getUsersWatchHistory(userId);
        return objectMapper.writeValueAsString(watchList);
    }

}
