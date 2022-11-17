package com.prueba.tecnica.gestion.controller;

import com.prueba.tecnica.gestion.service.EmployeeWorkedHourService;
import com.prueba.tecnica.gestion.service.response.GetEmployeePaidHoursResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeWorkedHoursResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "/empwh")
public class EmployeeWorkedHoursController {

    private final EmployeeWorkedHourService service;

    public EmployeeWorkedHoursController(EmployeeWorkedHourService service) {
        this.service = service;
    }

    @RequestMapping(path = "/employee/{employeeId}/startDate/{startDate}/endDate/{endDate}", method = RequestMethod.GET)
    public GetEmployeeWorkedHoursResponse getWorkedHours(@PathVariable Long employeeId,
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {
        return service.getEmployeeWorkedHoursBetween(employeeId, startDate, endDate);
    }

    @RequestMapping(path = "/employee/{employeeId}/startDate/{startDate}/endDate/{endDate}/paid", method = RequestMethod.GET)
    public GetEmployeePaidHoursResponse getPaidWorkedHours(@PathVariable Long employeeId,
                                                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
                                                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {
        return service.getEmployeePaidWorkedHoursBetween(employeeId, startDate, endDate);
    }

    @RequestMapping(path = "/employee/{employeeId}/workedDate/{date}/hours/{hrs}", method = RequestMethod.POST)
    public void create(@PathVariable Long employeeId,
                       @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                       @PathVariable Integer hrs) {

        service.create(employeeId, date, hrs);
    }

}
