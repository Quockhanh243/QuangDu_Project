package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);
}
