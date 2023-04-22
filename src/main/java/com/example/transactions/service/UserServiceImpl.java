package com.example.transactions.service;

import com.example.transactions.module.User;
import com.example.transactions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByUsernameThrowException(String username) {
        return this.getByUsername(username).orElseThrow(() -> new RuntimeException("No such username."));
    }
}
