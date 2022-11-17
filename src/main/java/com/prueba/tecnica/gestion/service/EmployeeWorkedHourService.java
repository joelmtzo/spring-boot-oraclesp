package com.prueba.tecnica.gestion.service;

import com.prueba.tecnica.gestion.service.response.GetEmployeePaidHoursResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeWorkedHoursResponse;

import java.util.Date;

public interface EmployeeWorkedHourService {

    GetEmployeeWorkedHoursResponse getEmployeeWorkedHoursBetween(Long employeeId,
                                                                 String startDate,
                                                                 String endDate);

    void create(Long employeeId, Date date, Integer hrs);

    GetEmployeePaidHoursResponse getEmployeePaidWorkedHoursBetween(Long employeeId,
                                                                   String startDate,
                                                                   String endDate);
}
