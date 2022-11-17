package com.prueba.tecnica.gestion.service;

import com.prueba.tecnica.gestion.service.response.EmployeeByJob;
import com.prueba.tecnica.gestion.service.response.GetEmployeeByJobResponse;
import com.prueba.tecnica.gestion.service.response.GetGenderResponse;
import com.prueba.tecnica.gestion.service.response.GetJobResponse;

import java.util.List;
import java.util.Map;

public interface JobService {
    List<GetJobResponse> getAll();

    GetEmployeeByJobResponse getAllEmployeesByJob(Long jobId);

    GetEmployeeByJobResponse getAllEmployeesByJobSortedByLastName(Long jobId);

    Map<GetGenderResponse, List<EmployeeByJob>> getAllEmployeesByJobSortedByLastNameGroupedByGender(Long jobId);
}
