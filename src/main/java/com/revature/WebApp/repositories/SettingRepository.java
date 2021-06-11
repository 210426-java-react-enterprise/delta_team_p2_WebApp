package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository  extends JpaRepository<Settings, Integer> {

}
