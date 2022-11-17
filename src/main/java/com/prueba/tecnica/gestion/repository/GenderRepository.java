package com.prueba.tecnica.gestion.repository;

import com.prueba.tecnica.gestion.entity.GenderEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<GenderEntity, Long> {
}
