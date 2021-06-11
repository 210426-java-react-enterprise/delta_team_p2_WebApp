package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    //UserEntity findByUsernameAndPassword(String username, String password);

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query("select case when count(u) > 0 then true else false end from UserEntity u where u.email = :email")
    boolean isEmailAvailable(String email);

    @Query("select case when count(u) > 0 then true else false end from UserEntity u where u.username = :username")
    boolean isUsernameAvailable(String username);

}
