package com.betinnapp.goalservice.controler;

import com.betinnapp.goalservice.exception.InvalidTokenException;
import com.betinnapp.goalservice.model.Goal;
import com.betinnapp.goalservice.model.Investments;
import com.betinnapp.goalservice.model.dto.CurrentDepositDTO;
import com.betinnapp.goalservice.service.GoalService;
import com.betinnapp.goalservice.service.InvestmentsService;
import com.betinnapp.goalservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "goal")
public class GoalControler {

    @Autowired
    private UserService userService;

    @Autowired
    private GoalService goalService;

    @Autowired
    protected InvestmentsService investmentsService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/list")
    public List<Goal> listUserGoals(@RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {
        UUID authToken = UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return goalService.findUserGoals(authToken);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/{id}")
    public Goal getGoal(@PathVariable("id") String id, @RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {
        UUID authToken = UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return goalService.findGoalById(UUID.fromString(id));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(path = "/{id}/deposit")
    public Goal updateGoal(@PathVariable("id") String id, @RequestHeader(name = "authorization") String authorization, @RequestBody CurrentDepositDTO currentDeposit) throws InvalidTokenException {
        UUID authToken = UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return goalService.updateGoalById(UUID.fromString(id), currentDeposit);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    public void deleteGoal(@PathVariable("id") String id, @RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {
        UUID authToken = UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        goalService.deleteGoalById(UUID.fromString(id));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/types")
    public List<Investments> listInvestments() {
        return investmentsService.findAll();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Goal create(@Valid @RequestBody Goal goal, @RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {
        UUID authToken = UUID.fromString(authorization);
        userService.tokenIsValid(authToken);

        return goalService.create(goal, authToken);
    }
}
