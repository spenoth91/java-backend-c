package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository <Person, Long> {
    // code here
}
