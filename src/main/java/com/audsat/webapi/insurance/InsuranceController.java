package com.audsat.webapi.insurance;

import com.audsat.domain.insurance.InsuranceService;
import com.audsat.infrastructure.insurance.Insurance;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/budget")
    public ResponseEntity<InsuranceResponse> createInsurance(@RequestBody InsuranceDto insuranceDto) {
        Insurance insurance = insuranceService.createInsurance(insuranceDto.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(
                InsuranceResponse
                        .builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Insurance created with success! Id:" + insurance.getId())
                        .build()
        );
    }

    @GetMapping("/budget/{insuranceId}")
    public ResponseEntity<Insurance> getInsurance(@PathVariable Long insuranceId) {
        Insurance insurance = insuranceService.getById(insuranceId);
        return ResponseEntity.ok(insurance);

    }

    @PatchMapping("/budget/{insuranceId}")
    public ResponseEntity<Insurance> updateInsurance(
            @PathVariable Long insuranceId,
            @RequestBody InsuranceDto insuranceDto
    ) {
        Insurance insurance = insuranceService.updateById(insuranceId, insuranceDto.toDomain());
        return ResponseEntity.ok(insurance);
    }

    @DeleteMapping("/budget/{insuranceId}")
    public ResponseEntity<InsuranceResponse> deleteInsurance(@PathVariable Long insuranceId) {
        insuranceService.deleteById(insuranceId);
        return ResponseEntity.ok(
                InsuranceResponse
                        .builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Insurance deleted with success!")
                        .build()
        );
    }
}
