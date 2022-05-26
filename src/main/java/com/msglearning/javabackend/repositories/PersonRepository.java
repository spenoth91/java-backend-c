package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository <Person, Long> {

    List<Person> findAll();

    @Query("SELECT p.id FROM Person p JOIN Employee e ON p.employeeID=e.personID WHERE p.employeeID=e.id")
    Long findByEmployeeID();
}
