package com.betinnapp.goalservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "interest")
public class Interests {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false)
    private UUID id;

    @Column
    private Long startMonth;

    @Column
    private Long finalMonth;

    @Column
    private BigDecimal aliquot;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Long startMonth) {
        this.startMonth = startMonth;
    }

    public Long getFinalMonth() {
        return finalMonth;
    }

    public void setFinalMonth(Long finalMonth) {
        this.finalMonth = finalMonth;
    }

    public BigDecimal getAliquot() {
        return aliquot;
    }

    public void setAliquot(BigDecimal aliquot) {
        this.aliquot = aliquot;
    }
}
