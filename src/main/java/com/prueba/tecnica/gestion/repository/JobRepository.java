package com.prueba.tecnica.gestion.repository;

import com.prueba.tecnica.gestion.entity.JobEntity;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<JobEntity, Long> {
}
