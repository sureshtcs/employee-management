package com.poc.employee.employeemanagement.controller;

import com.poc.employee.employeemanagement.model.Employee;
import com.poc.employee.employeemanagement.model.Response;
import com.poc.employee.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    private List getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    private Response getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/")
    private ResponseEntity createEmployee(@RequestBody Employee employee) {
        try{
            employeeService.saveOrUpdate(employee);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New employee created with id: "+employee.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteById(@PathVariable("id") int id) {
        try{
            employeeService.delete(id);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id: "+id, HttpStatus.OK);
    }
}
