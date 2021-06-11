package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<MovieEntity, Integer> {
}
