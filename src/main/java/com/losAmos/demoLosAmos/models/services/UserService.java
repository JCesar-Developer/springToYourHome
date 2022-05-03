package com.losAmos.demoLosAmos.models.services;

import com.losAmos.demoLosAmos.models.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public UserEntity insert(UserEntity userEntity);

}