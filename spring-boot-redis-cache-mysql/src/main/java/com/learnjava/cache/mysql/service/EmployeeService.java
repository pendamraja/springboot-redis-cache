package com.learnjava.cache.mysql.service;

import com.learnjava.cache.mysql.entity.Employee;
import com.learnjava.cache.mysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> fetchAllEmployees() {
        System.out.println("Employee fetching from Database::");
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Integer employeeId) {
        System.out.println("Employee fetching from database:: "+employeeId);
        return employeeRepository.findById(employeeId);

    }

    public Employee updateEmployee(Integer employeeId, Employee employeeDetails) {
        Employee employee = employeeRepository.getById(employeeId);
        employee.setName(employeeDetails.getName());
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    public void deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.getById(employeeId);
        employeeRepository.delete(employee);
    }
}
