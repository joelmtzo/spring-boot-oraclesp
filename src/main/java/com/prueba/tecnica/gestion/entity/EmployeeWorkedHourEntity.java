package com.prueba.tecnica.gestion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeWorkedHourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Integer workedHours;

    @Temporal(TemporalType.DATE)
    private Date workedDate;

}
