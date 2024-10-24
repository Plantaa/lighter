package com.planta.lighter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planta.lighter.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
