package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetailsEntity, String> {
}
