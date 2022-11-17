package com.prueba.tecnica.gestion.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetEmployeePaidHoursResponse {
    @JsonProperty("total_paid_hours")
    private Integer totalPaidHours;
    private boolean success;
}
