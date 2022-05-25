package com.msglearning.javabackend.services;

import com.msglearning.javabackend.converters.Helper;
import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.repositories.EmployeeRepository;
import com.msglearning.javabackend.repositories.PersonRepository;
import com.msglearning.javabackend.to.PersonEmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonEmployeeService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public PersonEmployeeTO getByPersonId(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty())
            return null;

        Optional<Employee> employee = employeeRepository.findById(person.get().getEmployeeID());
        if (employee.isEmpty())
            return null;

        return Helper.convertToPersonEmployeeTO(person.get(), employee.get());
    }

    public PersonEmployeeTO getByEmployeeId(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty())
            return null;

        Optional<Person> person = personRepository.findById(employee.get().getPersonID());
        if (person.isEmpty())
            return null;

        return Helper.convertToPersonEmployeeTO(person.get(), employee.get());
    }
}
