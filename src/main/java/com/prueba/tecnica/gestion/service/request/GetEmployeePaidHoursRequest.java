package com.prueba.tecnica.gestion.service.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GetEmployeePaidHoursRequest {

    @JsonProperty("employee_id")
    private Long employeeId;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("end_date")
    private Date endDate;

}
