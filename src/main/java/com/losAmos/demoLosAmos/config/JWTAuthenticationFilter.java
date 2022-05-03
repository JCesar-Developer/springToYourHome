package com.losAmos.demoLosAmos.config;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.losAmos.demoLosAmos.models.entity.UserEntity;
import com.losAmos.demoLosAmos.models.impl.JWTServiceImpl;
import com.losAmos.demoLosAmos.models.services.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private JWTService jwtService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));

        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
           HttpServletResponse response) throws AuthenticationException {

        String email    = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && password != null) {

            logger.info("Email desde request parameter (form-data): " + email);
            logger.info("Password desde request parameter (form-data): " + password);

        } else {
            UserEntity userEntity = null;
            try {

                userEntity = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);

                email    = userEntity.getEmail();
                password = userEntity.getPassword();

                logger.info("Email desde request InputStream (raw): " + email);
                logger.info("Password desde request InputStream (raw): " + password);

            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        email = email.trim();

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( email, password );

        return authenticationManager.authenticate(authToken);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                   FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = jwtService.create(authResult);

        response.addHeader(JWTServiceImpl.HEADER_STRING, JWTServiceImpl.TOKEN_PREFIX + token);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token", token);
        body.put("user", (User) authResult.getPrincipal());
        body.put("messaje", String.format("Hola %s, has iniciado sesión con éxito!", authResult.getName()));

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                     AuthenticationException failed) throws IOException, ServletException {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("mensaje", "Error de autenticación: username o password incorrecto!");
        body.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }

}
