package com.poc.employee.employeemanagement.service;

import com.poc.employee.employeemanagement.model.Department;
import com.poc.employee.employeemanagement.model.Employee;
import com.poc.employee.employeemanagement.model.Response;
import com.poc.employee.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;

    public List getAllEmployees() {
        List employees = new ArrayList();
        employees.addAll(employeeRepository.findAll());
        return employees;
    }

   /* public Response getEmployeeById(final int employeeId) {
        Response response = new Response();
        Employee employee = employeeRepository.findById(employeeId).get();
        Department department = restTemplate.getForObject("http://department-management/departments/"+employeeId, Department.class);
        response.setEmployeeId(employee.getId());
        response.setEmployeeName(employee.getName());
        response.setSalary(employee.getSalary());
        response.setDepartment(department);
        return response;
    }*/

    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}