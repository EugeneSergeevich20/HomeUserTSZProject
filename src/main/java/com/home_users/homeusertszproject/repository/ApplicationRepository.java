package com.home_users.homeusertszproject.repository;

import com.home_users.homeusertszproject.model.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Integer> {
}
