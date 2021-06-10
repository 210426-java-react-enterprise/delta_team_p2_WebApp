package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsernameAndPassword(String username, String password);

}
