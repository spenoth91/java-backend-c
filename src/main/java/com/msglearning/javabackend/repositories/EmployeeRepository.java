package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {

    List<Employee> findAll();

    @Query("SELECT u FROM Employee u WHERE u.department LIKE %:department% ")
    List<Employee> findByDepartment(@Param("department") String department);

    Optional<Employee> findById(Long id);

    /*@Query("SELECT personID from Employee where id = :id")
    Long findByPersonId(Long id);

    Optional<Employee> findByPersonID(Long id);*/

}
