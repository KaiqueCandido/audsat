package com.audsat.domain.insurance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceDomain {

    private Long customerId;
    private Long carId;
    private Boolean isActive;
}
