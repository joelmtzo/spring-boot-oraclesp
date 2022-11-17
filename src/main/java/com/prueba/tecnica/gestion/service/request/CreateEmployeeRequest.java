package com.prueba.tecnica.gestion.service.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateEmployeeRequest {
    private String name;
    private String lastName;
    private Date birthdate;
    private Long genderId;
    private Long jobId;
}
