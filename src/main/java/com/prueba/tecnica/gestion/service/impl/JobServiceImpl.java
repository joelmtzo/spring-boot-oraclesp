package com.prueba.tecnica.gestion.service.impl;

import com.prueba.tecnica.gestion.entity.GenderEntity;
import com.prueba.tecnica.gestion.entity.JobEntity;
import com.prueba.tecnica.gestion.repository.EmployeeRepository;
import com.prueba.tecnica.gestion.repository.GenderRepository;
import com.prueba.tecnica.gestion.repository.JobRepository;
import com.prueba.tecnica.gestion.service.JobService;
import com.prueba.tecnica.gestion.service.response.EmployeeByJob;
import com.prueba.tecnica.gestion.service.response.GetEmployeeByJobResponse;
import com.prueba.tecnica.gestion.service.response.GetGenderResponse;
import com.prueba.tecnica.gestion.service.response.GetJobResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final GenderRepository genderRepository;
    private final EmployeeRepository employeeRepository;

    public JobServiceImpl(JobRepository jobRepository,
                          GenderRepository genderRepository,
                          EmployeeRepository employeeRepository) {
        this.jobRepository = jobRepository;
        this.genderRepository = genderRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<GetJobResponse> getAll() {
        List<GetJobResponse> response = new ArrayList<>();

        jobRepository.findAll().forEach(jobEntity -> {
            GetJobResponse res = new GetJobResponse();
            BeanUtils.copyProperties(jobEntity, res);
            response.add(res);
        });

        return response;
    }

    @Override
    public GetEmployeeByJobResponse getAllEmployeesByJob(Long jobId) {
        GetEmployeeByJobResponse response = new GetEmployeeByJobResponse();

        employeeRepository.findAllByJobId(jobId).forEach(employeeEntity -> {
            EmployeeByJob employeeByJob = new EmployeeByJob();
            BeanUtils.copyProperties(employeeEntity, employeeByJob);

            Optional<GenderEntity> genderEntity = genderRepository.findById(employeeEntity.getGenderId());
            employeeByJob.getGenderResponse().setId(genderEntity.get().getId());
            employeeByJob.getGenderResponse().setName(genderEntity.get().getName());

            Optional<JobEntity> jobEntity = jobRepository.findById(employeeEntity.getJobId());
            employeeByJob.getGetJobResponse().setId(jobEntity.get().getId());
            employeeByJob.getGetJobResponse().setName(jobEntity.get().getName());
            employeeByJob.getGetJobResponse().setSalary(jobEntity.get().getSalary());

            response.getEmployees().add(employeeByJob);
        });

        response.setSuccess(response.getEmployees().size() > 0);

        return response;
    }

    @Override
    public GetEmployeeByJobResponse getAllEmployeesByJobSortedByLastName(Long jobId) {
        GetEmployeeByJobResponse allEmployeesByJob = getAllEmployeesByJob(jobId);

        List<EmployeeByJob> sorted = allEmployeesByJob.getEmployees().stream()
                .sorted(Comparator.comparing(EmployeeByJob::getLastName))
                .collect(Collectors.toList());

        allEmployeesByJob.setEmployees(sorted);

        return allEmployeesByJob;
    }

    @Override
    public Map<GetGenderResponse, List<EmployeeByJob>> getAllEmployeesByJobSortedByLastNameGroupedByGender(Long jobId) {
        GetEmployeeByJobResponse employeesByJobSortedByLastName = getAllEmployeesByJobSortedByLastName(jobId);

        Map<GetGenderResponse, List<EmployeeByJob>> groupedByGender =
                employeesByJobSortedByLastName.getEmployees().stream()
                        .collect(Collectors.groupingBy(EmployeeByJob::getGenderResponse));

        return groupedByGender;
    }

}
