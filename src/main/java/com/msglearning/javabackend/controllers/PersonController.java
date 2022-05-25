package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.entity.Person;
import com.msglearning.javabackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_PERSON })
public class PersonController {

    private static final String PATH_ALL = "/all";
    private static final String PATH_ID = "/id/{id}";
    private static final String PATH_NEW = "/new";
    private static final String PATH_UPDATE = "/update/{id}";

    @Autowired
    PersonService personService;

    @GetMapping(PATH_ALL)
    public List<Person> getAll() {
        return personService.findAll();
    }

    @GetMapping(PATH_ID)
    public Optional<Person> getById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping(PATH_NEW)
    public Person newPerson (@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping(PATH_UPDATE)
    public Optional<Person> updateData (@PathVariable Long id, @RequestBody Person personDetails) {
        return personService.updateData(id, personDetails);
    }
}
