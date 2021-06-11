package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository  extends JpaRepository<WatchlistEntity, Integer> {
}
