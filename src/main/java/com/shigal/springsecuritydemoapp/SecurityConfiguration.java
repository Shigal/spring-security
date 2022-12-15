package com.shigal.springsecuritydemoapp;/*
 *
 * @author Lawshiga
 *
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

//    configure(HttpSecurity http) Endpoint used in this method ignores
//    the authentication for endpoints used in antMatchers.
//    Requests will be allowed to be accessed from the Spring Security Filter Chain.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // any request that comes to this app ->permit all
        // go to localhost:8080, now you won't see the form login page
        // open access to the app
        http.authorizeRequests().anyRequest().permitAll();
    }
}
