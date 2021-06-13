package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for CRUD access to the movie_cache table
 */
@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetailsEntity, String> {
    MovieDetailsEntity findByImdbId(String imdbId);
}
