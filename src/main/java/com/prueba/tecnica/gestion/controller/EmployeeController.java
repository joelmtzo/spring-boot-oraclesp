package com.prueba.tecnica.gestion.controller;

import com.prueba.tecnica.gestion.entity.EmployeeEntity;
import com.prueba.tecnica.gestion.service.EmployeeService;
import com.prueba.tecnica.gestion.service.request.CreateEmployeeRequest;
import com.prueba.tecnica.gestion.service.request.GetEmployeesByJobAsyncRequest;
import com.prueba.tecnica.gestion.service.response.CreateEmployeeResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeByIdResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/b/{date}", method = RequestMethod.GET)
    public Optional<EmployeeEntity> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return employeeService.getByDate(date);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<GetEmployeeResponse> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public CreateEmployeeResponse create(@RequestBody CreateEmployeeRequest request) {
        return employeeService.create(request);
    }

    @RequestMapping(path = "/async", method = RequestMethod.GET)
    public CompletableFuture<GetEmployeeByIdResponse> getAllEmployeesByJobAsync(@RequestBody GetEmployeesByJobAsyncRequest request) {
        return employeeService.getAllEmployeesByJobAsync(request);
    }

}
