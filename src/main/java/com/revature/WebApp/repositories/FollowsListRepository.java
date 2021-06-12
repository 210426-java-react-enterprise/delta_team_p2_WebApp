package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.FollowsListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for CRUD access to the follows_list table
 */
@Repository
public interface FollowsListRepository extends JpaRepository<FollowsListEntity, Integer> {
}
