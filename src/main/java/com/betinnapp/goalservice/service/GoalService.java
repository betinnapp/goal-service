package com.betinnapp.goalservice.service;

import com.betinnapp.goalservice.model.Goal;
import com.betinnapp.goalservice.model.Interests;
import com.betinnapp.goalservice.model.User;
import com.betinnapp.goalservice.model.dto.CurrentDepositDTO;
import com.betinnapp.goalservice.model.type.StatusType;
import com.betinnapp.goalservice.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserService userService;

    @Autowired InvestmentsService investmentsService;

    public Goal updateGoalById(UUID id, CurrentDepositDTO currentDepositDTO){
        Goal goal = findGoalById(id);
        BigDecimal currentDeposit = new BigDecimal(currentDepositDTO.getCurrentDeposit());
        goal.setDepositTotal(goal.getDepositTotal().add(currentDeposit));
        goal.setBalance(goal.getBalance().add(currentDeposit));

        return goalRepository.save(goal);
    }

    public Goal findGoalById(UUID id){
        return goalRepository.findById(id).orElse(null);
    }

    public void deleteGoalById(UUID id){
        Goal goal = findGoalById(id);
        goalRepository.delete(goal);
    }

    public List<Goal> findUserGoals(UUID token){
        UUID userId = userService.findUserIdByToken(token);
        return goalRepository.findByUserId(userId);
    }

    public Goal create(Goal goal, UUID token){
        User user = userService.findUserByToken(token);
        goal.setInvestmentType(investmentsService.findById(goal.getInvestmentType().getId()));
        goal.setLastUpdateDate(goal.getStartDate());
        goal.setUser(user);
        goal.setStartDate(new Date());
        goal.setLastUpdateDate(new Date());
        goal.setBalance(goal.getDepositTotal());
        goal.setProfit(BigDecimal.ZERO);
        goal.setTax(BigDecimal.ZERO);
        goal.setStatus(StatusType.UNCOMPLETED);

        return goalRepository.save(goal);
    }

    public BigDecimal getTaxRating(Collection<Interests> interests, int month){
        for (Interests i : interests){
            if(i.getStartMonth() <= month && i.getFinalMonth() >= month)
                return i.getAliquot().divide(BigDecimal.valueOf(100),BigDecimal.ROUND_UP).divide(BigDecimal.valueOf(12),BigDecimal.ROUND_UP);
        }

        return BigDecimal.ZERO;
    }

}
