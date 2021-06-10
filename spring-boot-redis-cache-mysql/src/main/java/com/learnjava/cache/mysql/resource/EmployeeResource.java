package com.learnjava.cache.mysql.resource;

import com.learnjava.cache.mysql.entity.Employee;
import com.learnjava.cache.mysql.exception.ResouceNotFoundException;
import com.learnjava.cache.mysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
       return ResponseEntity.ok(employeeService.fetchAllEmployees());
    }

    @GetMapping("/employees/{employeeId}")
    @Cacheable(value = "employees",key = "#employeeId")
    public Employee findEmployeeById(@PathVariable(value = "employeeId") Integer employeeId) {
        return employeeService.findEmployeeById(employeeId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + employeeId));
    }


    @PutMapping("/employees/{employeeId}")
    @CachePut(value = "employees",key = "#employeeId")
    public Employee updateEmployee(@PathVariable(value = "employeeId") Integer employeeId,
                                   @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(employeeId,employeeDetails);
    }


    @DeleteMapping("/employees/{id}")
    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(@PathVariable(value = "id") Integer employeeId) {
               employeeService.deleteEmployee(employeeId);
    }
}
