package com.example.transactions.service;

import com.example.transactions.module.User;

import java.util.Optional;

public interface UserService {

    // this method is to find user by username
    Optional<User> getByUsername(String username);

    User getByUsernameThrowException (String username);
}
