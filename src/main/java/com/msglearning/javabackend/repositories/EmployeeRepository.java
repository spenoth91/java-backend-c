package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {
    // code here
}
