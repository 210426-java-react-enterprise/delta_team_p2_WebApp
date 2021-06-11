package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.FollowsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowsListRepository extends JpaRepository<FollowsList, Integer> {
}
