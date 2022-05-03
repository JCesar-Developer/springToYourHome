package com.losAmos.demoLosAmos.models.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;

public interface JWTService {

    /**
     * THIS METHODE CREATES A NEW TOKEN
     * @param auth
     * @return
     */
    public String create (Authentication auth) throws IOException ;

    /**
     * THIS METHODE VALIDATES A TOKEN
     * @param token
     * @return
     */
    public boolean validate (String token);

    /**
     * THIS METHODE EXPORTS THE CLAIMS FROM A TOKEN
     * @param token
     * @return
     */
    public Claims getClaims(String token);

    /**
     * THIS METHODE GETS THE USERNAME FROM A TOKEN
     * @param token
     * @return
     */
    public String getUsername(String token);

    /**
     * THIS METHODE GETS THE ROLES FROM A TOKEN
     * @param token
     * @return
     */
    public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException;

    /**
     * THIS METHODE JUST GETS THE ENCRYPT CODE FROM THE TOKEN
     * WITHOUT THE PREFIX "BEARER".
     * @param token
     * @return
     */
    public String resolve(String token);

}
