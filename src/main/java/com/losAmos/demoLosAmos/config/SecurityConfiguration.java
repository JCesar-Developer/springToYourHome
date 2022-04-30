package com.losAmos.demoLosAmos.config;

import com.losAmos.demoLosAmos.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


/*    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }*/

    /**
     * THIS METHODE AUTHENTICATE THE LOGIN
     * @return
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService)
            .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                //PERMISSION SETTINGS
                .antMatchers("/", "/login/**", "/register/**", "/js/**", "/css/**", "/images/**").permitAll()
                .antMatchers("/dishManager/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()

                //LOGIN CONFIGURATION
                .and()
                    .formLogin().loginPage("/login").permitAll()
                    .defaultSuccessUrl("/?loginSuccess", true)

                //LOGOUT CONFIGURATION
                .and()
                    .logout().invalidateHttpSession(true).clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/?logoutSuccess").permitAll()

                //ERROR 403 CONFIGURATION
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");

    }

}

