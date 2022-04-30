package com.losAmos.demoLosAmos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * THIS METHODE SHOWS THE VIEW "error_403", ANYTIME WHEN A USER
     * DOESN'T HAVE AUTHORIZATION TO GET INTO A ROUTE OR METHODE.
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error_403").setViewName("error_403");
    }

    /**
     * THIS BEAN HELPS US, TO ENCODE OUR PASSWORDS.
     * @return
     */
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
