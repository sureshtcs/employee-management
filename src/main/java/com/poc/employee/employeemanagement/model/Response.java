package com.poc.employee.employeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer employeeId;
    private String employeeName;
    private Double salary;
    private Department department;
}
