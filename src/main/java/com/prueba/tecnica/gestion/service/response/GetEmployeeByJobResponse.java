package com.prueba.tecnica.gestion.service.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetEmployeeByJobResponse {

    public GetEmployeeByJobResponse() {
        this.employees = new ArrayList<>();
    }

    private List<EmployeeByJob> employees;
    private boolean success;
}
