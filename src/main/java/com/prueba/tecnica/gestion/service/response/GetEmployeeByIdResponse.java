package com.prueba.tecnica.gestion.service.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetEmployeeByIdResponse {

    public GetEmployeeByIdResponse() {
        this.employees = new ArrayList<>();
    }

    private List<GetEmployeeResponse> employees;
    private boolean success;
}
