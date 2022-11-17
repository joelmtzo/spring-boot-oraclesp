package com.prueba.tecnica.gestion.repository;

import com.prueba.tecnica.gestion.entity.EmployeeWorkedHourEntity;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeWorkedHourRepository extends CrudRepository<EmployeeWorkedHourEntity, Long> {

    @Procedure(procedureName = "GET_EMPLOYEE_WORKED_HOURS_BETWEEN", outputParameterName = "worked_hours")
    Integer getEmployeeWorkedHoursBetween(Long employee_id, String start_date, String end_date);

    @Procedure(procedureName = "GET_EMPLOYEE_PAID_WORKED_HOURS_BETWEEN", outputParameterName = "paid_hours")
    Integer getEmployeePaidWorkedHoursBetween(Long employee_id, String start_date, String end_date);

}
