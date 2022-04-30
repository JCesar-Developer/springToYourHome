package com.losAmos.demoLosAmos.models.repository;

import com.losAmos.demoLosAmos.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoAPI extends JpaRepository<User, Long>{

    public User findByEmail(String email);

}