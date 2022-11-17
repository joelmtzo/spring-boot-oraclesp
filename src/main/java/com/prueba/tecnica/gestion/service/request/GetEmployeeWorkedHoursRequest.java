package com.prueba.tecnica.gestion.service.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class GetEmployeeWorkedHoursRequest {

    @JsonProperty("employee_id")
    private Long employeeId;

    @JsonProperty("start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @JsonProperty("end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
