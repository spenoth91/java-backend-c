package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.services.PersonEmployeeService;
import com.msglearning.javabackend.to.PersonEmployeeTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_PERSON_EMPLOYEE })
public class PersonEmployeeController {

    private static final String PATH_PERSON_ID = "/person-id/{id}";
    private static final String PATH_EMPLOYEE_ID = "/employee-id/{id}";

    @Autowired
    PersonEmployeeService service;

    @GetMapping(PATH_PERSON_ID)
    public PersonEmployeeTO getByPersonId(@PathVariable Long id) {
        return service.getByPersonId(id);
    }

    @GetMapping(PATH_EMPLOYEE_ID)
    public PersonEmployeeTO getByEmployeeId(@PathVariable Long id) {
        return service.getByEmployeeId(id);
    }
}
