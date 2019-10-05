package com.betinnapp.goalservice.model;

import com.betinnapp.goalservice.model.type.StatusType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private BigDecimal monthlyIncome;

    @Column
    private BigDecimal depositTotal;

    @Column
    private BigDecimal balance;

    @Column
    private BigDecimal tax;

    @Column
    private BigDecimal profit;

    @Column
    private BigDecimal goal;

    @Column
    private Long duration;

    @Column
    private Date startDate;

    @Column
    private Date lastUpdateDate;

    @ManyToOne
    @JoinColumn(name = "investment_id")
    private Investments investmentType;

    @Column
    private StatusType status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public BigDecimal getDepositTotal() {
        return depositTotal;
    }

    public void setDepositTotal(BigDecimal depositTotal) {
        this.depositTotal = depositTotal;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public void setGoal(BigDecimal goal) {
        this.goal = goal;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Investments getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(Investments investmentType) {
        this.investmentType = investmentType;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
