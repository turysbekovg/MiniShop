package com.example.transactions.configuration;

import com.example.transactions.security.AuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// in order to make WebConfigAdapter -> change im pom.xml java-jwt (version 3.10.0)
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthorizationFilter authorizationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().authorizeRequests().anyRequest().permitAll().
                and().addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
