package com.prueba.tecnica.gestion.controller;

import com.prueba.tecnica.gestion.service.JobService;
import com.prueba.tecnica.gestion.service.response.EmployeeByJob;
import com.prueba.tecnica.gestion.service.response.GetEmployeeByJobResponse;
import com.prueba.tecnica.gestion.service.response.GetGenderResponse;
import com.prueba.tecnica.gestion.service.response.GetJobResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/job")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<GetJobResponse> getAll() {
        return service.getAll();
    }

    @RequestMapping(path = "/{id}/employees", method = RequestMethod.GET)
    public GetEmployeeByJobResponse getAllEmployeesByJob(@PathVariable Long id) {
        return service.getAllEmployeesByJob(id);
    }

    @RequestMapping(path = "/{id}/employees/sort", method = RequestMethod.GET)
    public GetEmployeeByJobResponse getAllEmployeesByJobSortedByLastName(@PathVariable Long id) {
        return service.getAllEmployeesByJobSortedByLastName(id);
    }

    @RequestMapping(path = "/{id}/employees/group", method = RequestMethod.GET)
    public Map<GetGenderResponse, List<EmployeeByJob>> getAllEmployeesByJobSortedByLastNameGroupedByGender(@PathVariable Long id) {
        return service.getAllEmployeesByJobSortedByLastNameGroupedByGender(id);
    }

}
