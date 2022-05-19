package com.msglearning.javabackend.services;

import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        List<Person> people = personRepository.findAll();
        if (people.isEmpty()) {
            return Collections.emptyList();
        } else {
            return people;
        }
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
}
