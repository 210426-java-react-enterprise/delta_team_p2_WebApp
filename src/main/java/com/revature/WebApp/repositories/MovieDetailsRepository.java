package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetailsEntity, String> {
    MovieDetailsEntity findByImdbId(String imdbId);
    //MovieDetailsEntity findByImdbId(String imdbId);
}
