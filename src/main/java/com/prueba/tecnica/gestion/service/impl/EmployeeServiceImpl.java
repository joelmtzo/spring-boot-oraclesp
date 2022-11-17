package com.prueba.tecnica.gestion.service.impl;

import com.prueba.tecnica.gestion.entity.EmployeeEntity;
import com.prueba.tecnica.gestion.entity.JobEntity;
import com.prueba.tecnica.gestion.repository.EmployeeRepository;
import com.prueba.tecnica.gestion.repository.JobRepository;
import com.prueba.tecnica.gestion.service.EmployeeService;
import com.prueba.tecnica.gestion.service.request.CreateEmployeeRequest;
import com.prueba.tecnica.gestion.service.request.GetEmployeesByJobAsyncRequest;
import com.prueba.tecnica.gestion.service.response.CreateEmployeeResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeByIdResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest request) {
        Optional<JobEntity> jobEntity = jobRepository.findById(request.getJobId());

        if (jobEntity.isEmpty()) {
            CreateEmployeeResponse response = new CreateEmployeeResponse();
            response.setId(null);
            response.setSuccess(false);

            return response;
        }

        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(request, entity);

        employeeRepository.save(entity);

        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setId(entity.getId());
        response.setSuccess(true);

        return response;
    }

    @Override
    public List<GetEmployeeResponse> getAll() {
        List<GetEmployeeResponse> response = new ArrayList<>();

        employeeRepository.findAll().forEach(employeeEntity -> {
            GetEmployeeResponse res = new GetEmployeeResponse();
            BeanUtils.copyProperties(employeeEntity, res);
            response.add(res);
        });

        return response;
    }

    @Override
    public Optional<EmployeeEntity> getByDate(Date date) {
        return employeeRepository.findByBirthdate(date);
    }

    @Async
    @Override
    public CompletableFuture<GetEmployeeByIdResponse> getAllEmployeesByJobAsync(GetEmployeesByJobAsyncRequest request) {
        GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();

        employeeRepository.findAllById(request.getIds()).forEach(employeeEntity -> {
            GetEmployeeResponse res = new GetEmployeeResponse();
            BeanUtils.copyProperties(employeeEntity, res);

            response.getEmployees().add(res);
        });

        response.setSuccess(response.getEmployees().size() > 0);

        return CompletableFuture.completedFuture(response);
    }

}
