package com.prueba.tecnica.gestion.repository;

import com.prueba.tecnica.gestion.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

    Iterable<EmployeeEntity> findAllByJobId(Long jobId);

    List<EmployeeEntity> findAll();

    Optional<EmployeeEntity> findByBirthdate(Date date);

}
