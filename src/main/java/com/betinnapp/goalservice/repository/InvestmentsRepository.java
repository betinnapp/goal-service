package com.betinnapp.goalservice.repository;

import com.betinnapp.goalservice.model.Investments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestmentsRepository extends JpaRepository<Investments, UUID> {
}
