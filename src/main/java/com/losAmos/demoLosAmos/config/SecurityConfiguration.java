package com.losAmos.demoLosAmos.config;

import com.losAmos.demoLosAmos.models.services.JWTService;
import com.losAmos.demoLosAmos.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

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
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

        //PERMISSION SETTINGS
            .antMatchers("/", "/login/**", "/register/**", "/js/**", "/css/**", "/images/**").permitAll()
            .antMatchers("/open/**", "/api/**/open/**").permitAll()
            .antMatchers("/user/**", "/api/**/user/**").hasAnyRole("USER")
            .antMatchers("/admin/**", "/api/**/admin/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()

        //UNCOMMENT THESE LINES WHEN YOU WANTED TO WORK WITH THE JPA_API
        /*
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
            .exceptionHandling().accessDeniedPage("/error_403")
         */

        //UNCOMMENT THESE LINES WHEN YOU WANTED TO WORK WITH THE RESTFULAPI
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
            .addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService))
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}
