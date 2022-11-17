package com.prueba.tecnica.gestion.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetEmployeeWorkedHoursResponse {
    @JsonProperty("total_worked_hours")
    private Integer totalWorkedHours;
    private boolean success;
}
