package com.prueba.tecnica.gestion.service.request;

import lombok.Data;

import java.util.List;

@Data
public class GetEmployeesByJobAsyncRequest {

    private List<Long> ids;
    private String startDate;
    private String endDate;

}
