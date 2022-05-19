package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository <Person, Long> {

    List<Person> findAll();
}
