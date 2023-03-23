package com.audsat.webapi.insurance;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

class InsuranceControllerTest extends EmployeeRestControllerIntegrationTest {

    @Test
    void createInsurance() throws Exception {
        Gson gson = new Gson();
        InsuranceDto insuranceDtoMock = InsuranceDto.builder()
                .customerId(1L)
                .carId(1L)
                .build();
        RequestBuilder request = post("/insurance/budget")
                .with(user("user").password("password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(insuranceDtoMock));

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(result.getResponse().getStatus(), 201);
    }

    @Test
    void getInsurance() throws Exception {
        RequestBuilder request = get("/insurance/budget/999")
                .with(user("user").password("password"));
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(result.getResponse().getStatus(), 200);
    }

    @Test
    void updateInsurance() throws Exception {
        Gson gson = new Gson();
        InsuranceDto insuranceDtoMock = InsuranceDto.builder()
                .customerId(1L)
                .carId(2L)
                .build();
        RequestBuilder request = patch("/insurance/budget/997")
                .with(user("user").password("password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(insuranceDtoMock));

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(result.getResponse().getStatus(), 200);
    }

    @Test
    void deleteInsurance() throws Exception {
        RequestBuilder request = delete("/insurance/budget/996")
                .with(user("user").password("password"));

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(result.getResponse().getStatus(), 200);
    }
}