package com.audsat.infrastructure.customer;

import com.audsat.infrastructure.driver.Driver;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @Column(name = "insurance_claim")
    private Boolean insuranceClaim;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
