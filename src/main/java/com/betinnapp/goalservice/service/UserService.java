package com.betinnapp.goalservice.service;


import com.betinnapp.goalservice.exception.InvalidTokenException;
import com.betinnapp.goalservice.model.User;
import com.betinnapp.goalservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByToken(UUID token) {
        return userRepository.findByToken(token);
    }

    public UUID findUserIdByToken(UUID token) {
        return userRepository.findByToken(token).getId();
    }

    public void tokenIsValid(UUID token) throws InvalidTokenException {
        if (userRepository.findByToken(token) == null)
            throw new InvalidTokenException();
    }
}
