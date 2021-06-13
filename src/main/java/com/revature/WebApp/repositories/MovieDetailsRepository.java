package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Repository interface for CRUD access to the movie_cache table
 */
@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetailsEntity, String> {
    MovieDetailsEntity findByImdbId(String imdbId);

    @Query(nativeQuery = true, value = "select * from movie_cache mc inner join watchlist w on (mc.imdb_id = w.fk_movie_id)\n" +
            "where w.fk_user_id = ?1")
    public List<MovieDetailsEntity> getWatchListDetail(int userId);
}
