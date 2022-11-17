package com.prueba.tecnica.gestion.service.response;

import lombok.Data;

@Data
public class GetJobResponse {
    private Long id;
    private String name;
    private double salary;
}
