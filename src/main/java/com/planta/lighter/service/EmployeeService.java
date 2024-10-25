package com.planta.lighter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planta.lighter.entity.Employee;

@Service
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
