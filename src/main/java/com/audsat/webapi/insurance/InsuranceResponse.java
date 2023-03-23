package com.audsat.webapi.insurance;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InsuranceResponse {

    private Integer statusCode;
    private String message;
}
