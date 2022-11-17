package com.prueba.tecnica.gestion.service.impl;

import com.prueba.tecnica.gestion.entity.EmployeeWorkedHourEntity;
import com.prueba.tecnica.gestion.repository.EmployeeRepository;
import com.prueba.tecnica.gestion.repository.EmployeeWorkedHourRepository;
import com.prueba.tecnica.gestion.service.EmployeeWorkedHourService;
import com.prueba.tecnica.gestion.service.response.GetEmployeePaidHoursResponse;
import com.prueba.tecnica.gestion.service.response.GetEmployeeWorkedHoursResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeWorkedHourServiceImpl implements EmployeeWorkedHourService {

    private final EmployeeWorkedHourRepository repository;
    private final EmployeeRepository employeeRepository;

    public EmployeeWorkedHourServiceImpl(EmployeeWorkedHourRepository repository,
                                         EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public GetEmployeeWorkedHoursResponse getEmployeeWorkedHoursBetween(Long employeeId,
                                                                        String startDate,
                                                                        String endDate) {
        GetEmployeeWorkedHoursResponse response = new GetEmployeeWorkedHoursResponse();

        if (!validateEmployeeExistsAndValidRangeDates(employeeId, startDate, endDate)) {
            response.setTotalWorkedHours(null);
            response.setSuccess(false);
        }

        Integer workedHours = repository.getEmployeeWorkedHoursBetween(employeeId, startDate, endDate);

        if (workedHours == null) {
            response.setTotalWorkedHours(null);
            response.setSuccess(false);
        } else {
            response.setTotalWorkedHours(workedHours);
            response.setSuccess(true);
        }

        return response;
    }

    @Override
    public void create(Long employeeId, Date date, Integer hrs) {
        EmployeeWorkedHourEntity entity = new EmployeeWorkedHourEntity();
        entity.setEmployeeId(employeeId);
        entity.setWorkedDate(date);
        entity.setWorkedHours(hrs);

        repository.save(entity);
    }

    @Override
    public GetEmployeePaidHoursResponse getEmployeePaidWorkedHoursBetween(Long employeeId,
                                                                          String startDate,
                                                                          String endDate) {
        GetEmployeePaidHoursResponse response = new GetEmployeePaidHoursResponse();

        if (!validateEmployeeExistsAndValidRangeDates(employeeId, startDate, endDate)) {
            response.setTotalPaidHours(null);
            response.setSuccess(false);
        }

        Integer paidHours = repository.getEmployeePaidWorkedHoursBetween(employeeId, startDate, endDate);

        if (paidHours == null) {
            response.setTotalPaidHours(null);
            response.setSuccess(false);
        } else {
            response.setTotalPaidHours(paidHours);
            response.setSuccess(true);
        }

        return response;
    }

    @SneakyThrows
    public boolean validateEmployeeExistsAndValidRangeDates(Long employeeId, String startDate, String endDate) {
        Map<String, Boolean> results = new HashMap<>();

        results.put("employee", employeeRepository.findById(employeeId).isPresent());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = dateFormat.parse(startDate);
        Date date2 = dateFormat.parse(endDate);

        results.put("validRange", date1.before(date2));

        return results.get("employee") && results.get("validRange");
    }
}
