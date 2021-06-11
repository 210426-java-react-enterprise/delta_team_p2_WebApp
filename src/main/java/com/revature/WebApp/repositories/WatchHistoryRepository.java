package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.WatchHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchHistoryRepository  extends JpaRepository<WatchHistoryEntity, Integer> {
}
