package com.betinnapp.goalservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "investments")
public class Investments {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false)
    private UUID id;

    @Column
    private String type;

    @Column
    private String name;

    @Column
    private BigDecimal interestRate;

    @Column
    private Long minInvestmentMonthTime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "investment_id")
    private Collection<Interests> interest;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Long getMinInvestmentMonthTime() {
        return minInvestmentMonthTime;
    }

    public void setMinInvestmentMonthTime(Long minInvestmentMonthTime) {
        this.minInvestmentMonthTime = minInvestmentMonthTime;
    }

    public Collection<Interests> getInterest() {
        return interest;
    }

    public void setInterest(Collection<Interests> interest) {
        this.interest = interest;
    }
}
