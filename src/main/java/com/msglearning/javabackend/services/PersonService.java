package com.msglearning.javabackend.services;

import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.repositories.EmployeeRepository;
import com.msglearning.javabackend.repositories.PersonRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    //EmployeeRepository employeeRepository;

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

    public Optional<Person> updateData(Long id, Person personDetails) {
        Optional<Person> personOpt = personRepository.findById(id);
        if (personOpt.isEmpty())
            return Optional.empty();

        Person person = personOpt.get();

        // shouldn't be able to set the person id
        person.setFullName  (personDetails.getFullName());
        person.setNationality  (personDetails.getNationality());
        person.setAddress   (personDetails.getAddress());
        person.setEmail     (personDetails.getEmail());
        person.setPhone     (personDetails.getPhone());
        person.setEmployee(personDetails.getEmployee());

        return Optional.of(person);
    }
//    public void deletePerson(Long id) throws ServiceException {
//        if(employeeRepository.findByPersonId(id)==personRepository.findById(id))
//        personRepository.deleteById(id);
//    }

    public void deletePerson(Long id) throws ServiceException {
        personRepository.deleteById(id);
    }
}
