package com.betinnapp.goalservice.controler;

import com.betinnapp.goalservice.exception.InvalidTokenException;
import com.betinnapp.goalservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path = "goal")
public class GoalControler {

    @Autowired
    private UserService userService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/list")
    public List<Module> listModules(@RequestHeader(name = "authorization") String authorization) throws InvalidTokenException {
        UUID authToken =  UUID.fromString(authorization);
        userService.tokenIsValid(authToken);
        return null;
    }
}
