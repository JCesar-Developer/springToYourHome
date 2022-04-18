package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.dto.UserRegisterDTO;
import com.losAmos.demoLosAmos.models.entity.Rol;
import com.losAmos.demoLosAmos.models.entity.User;
import com.losAmos.demoLosAmos.models.repository.UserRepository;
import com.losAmos.demoLosAmos.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegisterDTO registerDTO){
        User user = new User(registerDTO.getName(), registerDTO.getSurname(), registerDTO.getEmail(),
                registerDTO.getPassword(), registerDTO.getAvatar(), Arrays.asList(new Rol("ROLE_USER")));

        return userRepository.save(user);
    }

}
