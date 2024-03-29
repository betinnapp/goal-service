package com.betinnapp.goalservice.repository;

import com.betinnapp.goalservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByToken(UUID token);
}
