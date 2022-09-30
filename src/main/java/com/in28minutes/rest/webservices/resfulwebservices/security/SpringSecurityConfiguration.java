package com.in28minutes.rest.webservices.resfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    {
        /**
         * Apply below things
         * All the request should be authenticated
         * If not authenticated a web page is shown to sign in
         * Applies CRSF for POST and PUT requests
         */

        //All the request should be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        //If not authenticated a pop up is shown to sign in
        http.httpBasic(Customizer.withDefaults());

        //Applies CRSF for POST and PUT requests
        http.csrf().disable();
        return http.build();
    }
}
