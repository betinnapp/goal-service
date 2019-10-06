package com.betinnapp.goalservice.service;

import com.betinnapp.goalservice.model.Investments;
import com.betinnapp.goalservice.repository.InvestmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvestmentsService {

    @Autowired
    private InvestmentsRepository investmentsRepository;

    public Investments findById(UUID id) {
        return investmentsRepository.findById(id).orElse(null);
    }

    public List<Investments> findAll() {
        return investmentsRepository.findAll();
    }
}
