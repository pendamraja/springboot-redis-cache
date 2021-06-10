package com.learnjava.cache.mysql.repository;

import com.learnjava.cache.mysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
