package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.MovieUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieUserRepository extends JpaRepository<MovieUser, Integer> {

    Optional<MovieUser> findByUsernameAndPassword(String username, String password);

    @Query("select case when count(u) > 0 then true else false end from MovieUser u where u.email = :email")
    boolean isEmailAvailable(String email);

    @Query("select case when count(u) > 0 then true else false end from MovieUser u where u.username = :username")
    boolean isUsernameAvailable(String username);
}
