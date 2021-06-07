package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieUserRepository extends JpaRepository<MovieUser, Integer> {

    //@Query("select * from users u where u.username = :username and u.password :password")
    MovieUser findByUsernameAndPassword(String username, String password);

}
