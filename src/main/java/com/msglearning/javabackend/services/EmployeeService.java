package com.msglearning.javabackend.services;

import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            return Collections.emptyList();
        } else {
            return employees;
        }
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
}
