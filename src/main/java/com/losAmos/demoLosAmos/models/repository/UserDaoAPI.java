package com.losAmos.demoLosAmos.models.repository;

import com.losAmos.demoLosAmos.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoAPI extends JpaRepository<UserEntity, Long>{

    public UserEntity findByEmail(String email);

}