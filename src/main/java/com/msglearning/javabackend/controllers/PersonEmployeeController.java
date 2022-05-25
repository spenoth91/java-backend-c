package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.converters.Helper;
import com.msglearning.javabackend.entity.Employee;
import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.services.EmployeeService;
import com.msglearning.javabackend.services.PersonService;
import com.msglearning.javabackend.to.PersonEmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_PERSON_EMPLOYEE })
public class PersonEmployeeController {

    private static final String PATH_PERSON_ID = "/person-id/{id}";
    private static final String PATH_EMPLOYEE_ID = "/employee-id/{id}";

    @Autowired
    PersonService personService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(PATH_PERSON_ID)
    public PersonEmployeeTO getByPersonId(@PathVariable Long id) {
        Optional<Person> person = personService.findById(id);
        if (person.isEmpty())
            return null;

        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isEmpty())
            return null;

        return Helper.convertToPersonEmployeeTO(person.get(), employee.get());
    }
}
