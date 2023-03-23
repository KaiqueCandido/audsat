package com.audsat.webapi.insurance;

import com.audsat.domain.insurance.InsuranceDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {
    private Long customerId;
    private Long carId;
    private Boolean isActive;

    public InsuranceDomain toDomain() {
        return InsuranceDomain.builder()
                .customerId(customerId)
                .carId(carId)
                .isActive(isActive)
                .build();
    }
}
