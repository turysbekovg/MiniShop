package com.example.transactions.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
// this class is for authorization (and for Principal, because principal requires authorization, otherwise it will be empty)
public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // here we set client
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("galymzhan.turysbekov@gmail.com", null, null));

        // here we send request
        filterChain.doFilter(request, response);
    }

}
