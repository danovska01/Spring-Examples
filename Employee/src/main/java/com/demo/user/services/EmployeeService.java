package com.demo.user.services;

import com.demo.user.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);
}