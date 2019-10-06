package com.betinnapp.goalservice.service;

import com.betinnapp.goalservice.model.Goal;
import com.betinnapp.goalservice.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserService userService;

    public Goal findGoalById(UUID id){
        return goalRepository.findById(id).orElse(null);
    }

    public List<Goal> findUserGoals(UUID token){
        UUID userId = userService.findUserIdByToken(token);
        return goalRepository.findByUserId(userId);
    }


}
