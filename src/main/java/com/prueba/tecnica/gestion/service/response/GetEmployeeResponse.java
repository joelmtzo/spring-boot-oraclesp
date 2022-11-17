package com.prueba.tecnica.gestion.service.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GetEmployeeResponse {
    private Long id;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
}
