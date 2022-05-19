package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {

    List<Employee> findAll();
}
