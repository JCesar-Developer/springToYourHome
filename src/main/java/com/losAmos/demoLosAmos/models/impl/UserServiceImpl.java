package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.entity.Role;
import com.losAmos.demoLosAmos.models.entity.UserEntity;
import com.losAmos.demoLosAmos.models.repository.UserDaoAPI;

import com.losAmos.demoLosAmos.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoAPI userDaoAPI;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;


/*  TODO: ELIMINAR SI LA APP FUNCIONA SIN ESTÁ FUNCIÓN
    // Constructor
    public UserServiceImpl(UserDaoAPI userDaoAPI) {
        super();
        this.userDaoAPI = userDaoAPI;
    }
*/

    /**
     * CREATE METHODE TO USER.
     * @param newUserEntity
     * @return boolean
     */
    @Override
    public UserEntity insert(UserEntity newUserEntity){

        //PULLING ROLE_USER FROM THE DATABASE
        Role roleUser = roleService.getOne(2L);
        Collection<Role> roles = new ArrayList<Role>();
        roles.add(roleUser);

        //INSERTING THE NEW USER ON THE DATABASE
        UserEntity userEntity = new UserEntity(newUserEntity.getName(), newUserEntity.getSurname(), newUserEntity.getEmail(),
                passwordEncoder.encode(newUserEntity.getPassword()), roles);

        return userDaoAPI.save(userEntity);

    }

    /**
     * GETONE METHODE TO USER.
     * @param email
     * @return user logged by Email.
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userDaoAPI.findByEmail(email);

        if(userEntity == null){
            throw new UsernameNotFoundException("El email o la contraseña no son correctos");
        }

        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(),
                userEntity.getPassword(), mapAuthoritiesToRoles(userEntity.getRoles()));

    }

    /**
     * TRANSFORM THE JPA ROLES FROM THE USER IN SPRINGBOOT AUTHORITIES
     * @param roles
     * @return AUTHORITIES
     */
    private Collection<? extends GrantedAuthority> mapAuthoritiesToRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
