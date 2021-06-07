package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieUserRepository extends CrudRepository<MovieUser, Integer> {
}
