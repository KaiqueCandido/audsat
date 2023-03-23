package com.audsat.infrastructure.insurance;

import com.audsat.infrastructure.car.Car;
import com.audsat.infrastructure.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "insurances")
@Data
@Builder
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "creation_dt")
    private LocalDateTime creationDate;

    @Column(name = "updated_dt")
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "is_active")
    private Boolean isActive;

    @JsonIgnore
    @Transient
    private Float budgetPercent;

    @Column(name = "safe_budget")
    private Float safeBudget;

    public Insurance() {
        this.budgetPercent = 6F;
        this.safeBudget = 0F;
    }

    public Insurance(Long id, Customer customer, LocalDateTime creationDate, LocalDateTime updatedDate, Car car, Boolean isActive, Float budgetPercent, Float safeBudget) {
        this.id = id;
        this.customer = customer;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
        this.car = car;
        this.isActive = isActive;
        this.budgetPercent = 6F;
        this.safeBudget = 0F;
    }

    public Float getSafeBudget() {
        if (customer.getAge() >= 18 && customer.getAge() <= 25) {
            budgetPercent += 2;
        }
        if (customer.getInsuranceClaim()) {
            budgetPercent += 2;
        }
        if (car.getInsuranceClaim()) {
            budgetPercent += 2;
        }
        return car.getFipeValue() + (car.getFipeValue() * (budgetPercent/100F));
    }
}
