package com.prueba.tecnica.gestion.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeByJob extends GetEmployeeResponse {

    public EmployeeByJob() {
        this.genderResponse = new GetGenderResponse();
        this.getJobResponse = new GetJobResponse();
    }

    @JsonProperty("gender")
    private GetGenderResponse genderResponse;
    @JsonProperty("job")
    private GetJobResponse getJobResponse;
}