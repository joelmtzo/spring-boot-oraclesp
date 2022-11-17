package com.prueba.tecnica.gestion.service;

import com.prueba.tecnica.gestion.entity.EmployeeEntity;
import com.prueba.tecnica.gestion.service.request.CreateEmployeeRequest;
import com.prueba.tecnica.gestion.service.request.GetEmployeesByJobAsyncRequest;
import com.prueba.tecnica.gestion.service.response.CreateEmployeeResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeByIdResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeResponse;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {

    CreateEmployeeResponse create(CreateEmployeeRequest request);

    List<GetEmployeeResponse> getAll();

    Optional<EmployeeEntity> getByDate(Date date);

    CompletableFuture<GetEmployeeByIdResponse> getAllEmployeesByJobAsync(GetEmployeesByJobAsyncRequest request);
}
