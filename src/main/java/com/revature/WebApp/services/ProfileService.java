package com.revature.WebApp.services;

import com.revature.WebApp.DTO.MovieReviewDTO;
import com.revature.WebApp.entities.MovieDetailsEntity;
import com.revature.WebApp.entities.WatchHistoryEntity;
import com.revature.WebApp.exceptions.ResourceNotFoundException;
import com.revature.WebApp.repositories.WatchHistoryRepository;
import com.revature.WebApp.security.TokenParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileService {
    private WatchHistoryRepository historyRepo;

    @Autowired
    public ProfileService(WatchHistoryRepository historyRepo){
        this.historyRepo = historyRepo;
    }


    public WatchHistoryEntity getHistoryEntity(Integer userId, MovieReviewDTO reviewDTO) throws ResourceNotFoundException {
        System.out.println("DEBUG: " + userId + " " + reviewDTO.getImdbId());
        WatchHistoryEntity historyEntity = historyRepo.findByUserIdAndMovieId(userId, reviewDTO.getImdbId())
                .orElseThrow(ResourceNotFoundException::new);
        historyEntity.setScore(reviewDTO.getScore());
        historyEntity.setReview(reviewDTO.getReview());
        historyRepo.save(historyEntity);
        return historyEntity;
    }

}
