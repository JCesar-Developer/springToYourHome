package com.losAmos.demoLosAmos.models.services;

import com.losAmos.demoLosAmos.models.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User insert(User user);

}