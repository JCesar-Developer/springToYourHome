package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.dto.UserRegisterDTO;
import com.losAmos.demoLosAmos.models.entity.Rol;
import com.losAmos.demoLosAmos.models.entity.User;
import com.losAmos.demoLosAmos.models.repository.UserRepository;

import com.losAmos.demoLosAmos.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;


    // Constructor
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegisterDTO registerDTO){
        User user = new User(registerDTO.getName(), registerDTO.getSurname(), registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()), registerDTO.getAvatar(), Arrays.asList(new Rol("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("El email o la contraseña no son correctos");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapAuthoritiesToRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapAuthoritiesToRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
