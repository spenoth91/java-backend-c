package com.msglearning.javabackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_PERSON })
public class PersonController {

    private static final String PATH_ALL = "/all";
    private static final String PATH_ID = "/id/{id}";
    private static final String PATH_NEW = "/new";


}
