package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    //@Query("select * from users u where u.username = :username and u.password :password")
    UserEntity findByUsernameAndPassword(String username, String password);

}
